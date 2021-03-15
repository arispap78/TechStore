package MODEL;

import java.io.Serializable;
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
@Table(name = "SALE")
public class Sale implements Serializable
{
    @Id
    @Column(name = "SERIAL_NUMBER", unique = true, nullable = false, length = 30)
    private String serialNumber;
    @Column(name = "TOTAL_PRICE", unique = false, nullable = false,length = 2)
    private double totalPrice;
    @Column(name = "DATE", unique = false, nullable = false,length = 20)
    private Date date;
    @Column(name = "QUANTITY", unique = false, nullable = false,length = 3)
    private int posotita;
    @OneToOne
    @JoinColumn(name = "EMPLOYEE",unique = false, nullable = false)
    private Employee user;
    @OneToOne
    @JoinColumn(name = "CUSTOMER",unique = false, nullable = false)
    private Customer customer;
    //it is not a column in the table in the database
    @Transient
    private ArrayList<ProductString> SaleList = new ArrayList<>();


    public Sale() {
    }

    public Sale(double totalPrice, User user, Customer customer,int posotita,ArrayList<ProductString> SaleList) 
    {
        SimpleDateFormat frm=new SimpleDateFormat();
        this.serialNumber =frm.format(new Date());
        this.totalPrice = totalPrice;
        SimpleDateFormat frm1=new SimpleDateFormat("dd/MM/yyyy");
        this.date = new Date();
        this.user = (Employee)user;
        this.customer = customer;
        this.posotita=posotita;
        this.SaleList = SaleList;
    }
    

    public int getPosotita() 
    {
        return posotita;
    }

    public void setPosotita(int posotita) {
        this.posotita = posotita;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) 
    {
        SimpleDateFormat frm=new SimpleDateFormat();
        this.serialNumber = frm.format(new Date());
    }
    
    public double getTotalPrice() 
    {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) 
    {
        this.totalPrice = totalPrice;
    }

    public Date getDate() 
    {
        return date;
    }

    public void setDate(String date) 
    {
        SimpleDateFormat frm1=new SimpleDateFormat("dd/MM/yyyy");
        this.date = new Date();
    }

    public User getUser() 
    {
        return user;
    }

    public void setUser(Employee user) 
    {
        this.user =user;
    }

    public Customer getCustomer() 
    {
        return customer;
    }

    public void setCustomer(Customer customer) 
    {
        this.customer = customer;
    }

    public ArrayList<ProductString> getSaleList()
    {
        return SaleList;
    }

    public void setSaleList(ArrayList<ProductString> SaleList) 
    {
        this.SaleList = SaleList;
    }
    
    public void AddToSaleList(ProductString product) 
    {
        this.SaleList.add(product);
    }
    
    public void DeleteFromSaleList(ProductString product) 
    {
        this.SaleList.remove(product);
    }
    
    //save a sale in the database
    public boolean saveSal()
    {
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
    
    /*find the product in the database, the first argument
    is the model and the second is the table(category)*/
    public static Product getChoosenModelSale2(String a,String b)
    {
        //the product
        Product chosenModel;
        //create and start the session
        SessionFactory factory = Main.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        try
        {                            
            //find the product
            Query query =session.createQuery("from "+b+" where model=:model1");
            query.setParameter("model1", a);
            chosenModel=(Product)query.uniqueResult();
        }
        catch(Exception ex)
        {
            session.getTransaction().rollback();
            ex.printStackTrace();
            return null;
        }
        finally
        {
            session.getTransaction().commit();
            session.close();
        }
        return chosenModel;       
    }

    //list of the products of a sale
    public List<String> getListaSale(String table)
    {
        //the list of the products
        List <Product> lista =new ArrayList <Product>();
        //list of the strings of the products of the sale
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
        //the ist of the strings for the JList
        for(Product a:lista)
            models.add(a.getBrand()+":"+a.getModel());
        session.getTransaction().commit();
        session.close();
        return models;
    }
    
    //the list of the sales from a specific time period
    public ArrayList <Sale> searchSaleList(Date a,Date b)
    {
        //the list of the sales
        ArrayList <Sale> lista =new ArrayList <Sale>();
        //create and start the session
        SessionFactory factory = Main.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        try
        {
            //find the sales in a period of time
            Query query =session.createQuery("select sale from Sale sale where sale.date >=:dateA and sale.date <:dateB");
            query.setParameter("dateA", a);
            query.setParameter("dateB", b);
            lista = (ArrayList)query.list();
            if(lista.isEmpty())
                return null;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
        session.getTransaction().commit();
        session.close();
        return lista;  
    }
    
    //the statistics of the sales in a specific time period
    public ArrayList <Object[]> statisticSale(Date a,Date b)
    {
        //the list of the statistics 
        ArrayList <Object[]> lista =new ArrayList <Object[]>();
        //create and start the session
        SessionFactory factory = Main.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        try
        {
            //search the sales to calculate the statistics
            Query query =session.createQuery("select sale.date,sum(sale.posotita), avg(sale.totalPrice),"
                    + "  max(sale.totalPrice),sum(sale.totalPrice) from Sale sale "
                    + " where sale.date >=:dateA and sale.date <=:dateB group by sale.date");
            query.setParameter("dateA", a);
            query.setParameter("dateB", b);
            //list of the statistics
            lista = (ArrayList<Object[]>)query.list();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
        session.getTransaction().commit();
        session.close();
        return lista;  
    }
    
    //the statistics of the sales in a specific time period from a customer
    public ArrayList <Object[]> statisticSaleEmp(Date a,Date b,int c)
    {
        //list of the statistics
        ArrayList <Object[]> lista =new ArrayList <Object[]>();
        //create and start the session
        SessionFactory factory = Main.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        try
        {
            //find the sales and calculate the statistics in the period of time from a customer
            Query query =session.createQuery("select sale.date, count(*), avg(sale.totalPrice),"
                    + "  max(sale.totalPrice),sum(sale.totalPrice) from Sale sale where sale.date >=:dateA"
                    + "  and sale.date <=:dateB and sale.user.registryNumber=:name group by sale.date");
            query.setParameter("dateA", a);
            query.setParameter("dateB", b);
            query.setParameter("name", c);
            //the list of the statistics
            lista = (ArrayList<Object[]>)query.list();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
        session.getTransaction().commit();
        session.close();
        return lista;  
    }
    
    //the sale of a specific date
    public Sale searchSale(String a)
    {
        //the sale
        Sale polisi =new Sale();
        //create and start the session
        SessionFactory factory = Main.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        try
        {
            //find the sale in this date(without the time)
            Query query =session.createQuery("select sale from Sale sale where sale.serialNumber=:dateA");
            query.setParameter("dateA", a);
            polisi= (Sale)query.uniqueResult();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
        session.getTransaction().commit();
        session.close();
        return polisi;  
    }

    @Override
    public String toString() {
        return "Sale{" + "serialNumber=" + serialNumber + ", totalPrice=" + totalPrice + ", date=" + date + ", posotita=" + posotita + ", user=" + user + ", customer=" + customer + ", SaleList=" + SaleList + '}';
    }
    
}
