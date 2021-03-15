package MODEL;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@MappedSuperclass
public  abstract class Product implements Serializable
{
    @Column(name = "PRICE", unique = false, nullable = false,length = 8)
    double price;
    @Column(name = "BRAND", unique = false, nullable = false,length = 15)
    String brand;
    @Id
    @Column(name = "SERIAL_NUMBER", unique = true, nullable = false,length = 15)
    String serialNumber;
    @Column(name = "YEAR", unique = false, nullable = false,length = 5)
    int year;
    @Column(name = "QUANTITY", unique = false, nullable = true,length = 3)
    int quantity;


    public Product(double price, String brand, int year, int quantity) 
    {
        this.price = price;
        this.brand = brand;
        this.year = year;
        this.quantity=quantity;
    }

    public Product() {
    }

    
    public double getPrice() 
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public String getBrand() 
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public String getSerialNumber() 
    {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) 
    {
        this.serialNumber = serialNumber;
    }

    public int getYear() 
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public int getQuantity() 
    {
        return quantity;
    }

    public void setQuantity(int quantity) 
    {
        this.quantity = quantity;      
    }
    
    //update database
    public abstract boolean updateData(String a,String b);
    //method that return the name of the model
    public abstract String getModel();
    //save the data in the database
    public abstract boolean saveData();
    /*find the chosen model in the database, the first argument
     is the name of the model and the second argument is the name of the table(category)*/
    public static Product getChoosenModel(String a,String b)
    {
        //the model that the method returns
        Product chosenModel;
        //create and start of a session
        SessionFactory factory = Main.getSessionFactory();
        Session session = factory.openSession();
        try
        {                
            session.beginTransaction();
            //search of the model
            Query query =session.createQuery("from "+b+" where model=:model1");
            query.setParameter("model1", a);
            //save the model in the variable
            chosenModel=(Product)query.uniqueResult();
            session.getTransaction().commit();
        }
        catch(Exception ex)
        {
            session.getTransaction().rollback();
            ex.printStackTrace();
            return null;
        }
        finally
        {
            session.close();
        }
        return chosenModel;       
    }
   
    //the list with the models of a table(category)
    public ArrayList<String> getLista(String table)
    {
        //list of the instances of the models
        ArrayList <Product> lista =new ArrayList <Product>();
        //the list of the names of the models
        ArrayList<String> models = new ArrayList<>();
        //search the models from the database
        SessionFactory factory = Main.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        try
        {
            //get the models from the table which is declared as an argument inthe method 
            Query query =session.createQuery("from "+table);
            //the final list with the models
            lista = (ArrayList) query.list();            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
        //the final list with the names of the models for the JList
        for(Product a:lista)
            models.add(a.getBrand()+":"+a.getModel());
        session.getTransaction().commit();
        session.close();
        return models;
    }
    
    
    @Override
    public String toString() 
    {
        return "PRODUCT{" + "price=" + price + ", brand=" + brand + ", serialNumber=" + serialNumber + ", year=" + year + ", quantity=" + quantity + '}';
    }

}
