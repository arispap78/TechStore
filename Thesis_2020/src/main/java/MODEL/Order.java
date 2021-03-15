package MODEL;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Entity
@Table(name = "ORDER")
public class Order 
{
    @Id
    @Column(name = "DATE", unique = false, nullable = false,length = 20)
    private String date;
    @OneToOne
    @JoinColumn(name = "EMPLOYEE",unique = false, nullable = false)
    private ProductManager user;
    //it is not a column in the table of the database
    @Transient
    private ArrayList<OrderString> OrderList = new ArrayList<>();


    public Order(ProductManager user, ArrayList<OrderString> OrderList)
    {
        SimpleDateFormat frm1=new SimpleDateFormat();
        this.date = frm1.format(new Date());
        this.user = user;
        this.OrderList = OrderList;
    }

    public Order() {
    }

    
    public String getDate() 
    {
        return date;
    }

    public void setDate(String date) 
    {
        SimpleDateFormat frm1=new SimpleDateFormat();
        this.date = frm1.format(new Date());
    }

    public ProductManager getUser() 
    {
        return user;
    }

    public void setUser(ProductManager user)
    {
        this.user = user;
    }

    public ArrayList<OrderString> getOrderList()
    {
        return OrderList;
    }

    public void setOrderList(ArrayList<OrderString> OrderList) 
    {
        this.OrderList = OrderList;
    }
    
    //add a product in the order list
    public void AddToOrderList(OrderString product) 
    {
        this.OrderList.add(product);
    }
    
    //pop a product from the order list
    public void DeleteFromOrderList(OrderString product) 
    {
        this.OrderList.remove(product);
    }
    
    //save the order in the database
    public boolean saveOrd()
    {
        //create and start the session
        SessionFactory factory = Main.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        try
        {    
            session.save(this);
        }
        catch(Exception ex)
        {
            session.getTransaction().rollback();
            ex.printStackTrace();
            return false;
        }
        session.getTransaction().commit();
        session.close();
        return true;    
    }

    //get the list of the models for an order(argument the category)
    public List<String> getListaOrder(String table)
    {
        //the list of the models
        List <Product> lista =new ArrayList <Product>();
        //the list of the strings of the models
        List<String> models = new ArrayList<>();
        //create and start the session
        SessionFactory factory = Main.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        try
        {
            //the list of models from the database
            Query query =session.createQuery("from "+table);
            lista = (List) query.list();            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
        //the list of the strings for the JList
        for(Product a:lista)
            models.add(a.getBrand()+":"+a.getModel()); 
        session.getTransaction().commit();
        session.close();
        return models;
    }
    
    //search for an order of a specfic date
    public Order searchOrd(String a)
    {
        //list of the strings of the models of the order 
        ArrayList<OrderString> listOrder = new ArrayList<>();
        //the order
        Order order=new Order();
        //the date of the order
        String date=null;
        //create and start the session
        SessionFactory factory = Main.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        try
        {
            //search the order in a specific date(without the time)
            Query query =session.createQuery("select order from Order order where order.date LIKE :dateA");
            query.setParameter("dateA", a+"%");
            order = (Order) query.uniqueResult();
            //if there is not an order in that date
            if(order==null)
            {
                session.getTransaction().commit();
                session.close();
                return null;
            }
            else
            {
                //the date of the order (with the time)
                date=order.getDate();
                //the list of the models of this order
                Query query1=session.createQuery("from OrderString where orderProin.date =:dateb");
                query1.setParameter("dateb", date);
                listOrder = (ArrayList)query1.list();
                order.setOrderList(listOrder);
            }   
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
        session.getTransaction().commit();
        session.close();
        return order;  
    }
    
    @Override
    public String toString() 
    {
        return "Order{" + "date=" + date + ", user=" + user + ", OrderList=" + OrderList + '}';
    }
       
}
