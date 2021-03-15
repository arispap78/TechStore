package MODEL;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable 
{
    @Column(name = "NAME", unique = false, nullable = false,length = 15)
    private String name;
    @Column(name = "SURNAME", unique = false, nullable = false,length = 15)
    private String surname;
    @Id
    @Column(name = "EMAIL", unique = true, nullable = false, length = 50)
    private String email;
    @Column(name = "ADDRESS", unique = false, nullable = false,length = 20)
    private String address;


    public Customer() {
    }

    public Customer(String name, String surname, String email, String address) 
    {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
    }


    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getSurname() 
    {
        return surname;
    }

    public void setSurname(String surname) 
    {
        this.surname = surname;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getAddress() 
    {
        return address;
    }

    public void setAddress(String address) 
    {
        this.address = address;
    }

    //save the instance in the database
    public boolean saveCus()
    {
        //create and start athe session
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
    
    //list of the customers
    public ArrayList<String> getListaCustomer()
    {
        //list of the customers
        ArrayList <Customer> lista =new ArrayList <Customer>();
        //list of the names of the customers
        ArrayList<String> models = new ArrayList<>();
        //create and start athe session
        SessionFactory factory = Main.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        try
        {
            //fill the list with the customers of the database 
            Query query =session.createQuery("from Customer");
            lista = (ArrayList) query.list();            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
        //the list with the string of the customers for the JCombobox
        for(Customer a:lista)
            models.add(a.surname+" "+a.name+" "+a.email); 
        session.getTransaction().commit();
        session.close();
        return models;
    }
    
    //find a customer by his/hers email
    public static Customer getCustomer(String a)
    {
        //the customer
        Customer cos=new Customer();
        //create and start the session
        SessionFactory factory = Main.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        try
        {
            //find the customer from the database
            Query query =session.createQuery("from Customer where email=:mail");
            query.setParameter("mail", a);
            //return the customer
            cos=(Customer) query.uniqueResult();            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
        session.getTransaction().commit();
        session.close();
        return cos;
    }
    
    @Override
    public String toString() 
    {
        return "CUSTOMER{" + "name=" + name + ", surname=" + surname + ", email=" + email + ", address=" + address + '}';
    }
    
              
}
