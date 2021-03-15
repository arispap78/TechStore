package MODEL;

import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Entity
@Table(name = "LAPTOP")
public class Laptop extends Product
{
    @Column(name = "MODEL", unique = true, nullable = false,length = 15)
    private String model;
    @Column(name = "SCREEN", unique = false, nullable = false,length = 3)
    private double screen;
    @Column(name = "RAM", unique = false, nullable = false,length = 2)
    private int ram;
    @Column(name = "WEIGHT", unique = false, nullable = false,length = 2)
    private double weight;
    @Column(name = "MEMORY", unique = false, nullable = false,length = 3)
    private int memory;
    @Column(name = "CPU", unique = false, nullable = false,length = 15)
    private String cpu;
    @Column(name = "OS", unique = false, nullable = false,length = 15)
    private String os;
    

    public Laptop(String model,double screen, int ram, double weight, int memory, String cpu, String os, double price, String brand, int year,int quantity) 
    {
        super(price, brand,year,quantity);
        this.model=model;
        this.screen = screen;
        this.ram = ram;
        this.weight = weight;
        this.memory = memory;
        this.cpu = cpu;
        this.os = os;
        this.serialNumber = brand.substring(0,2)+model+year%100;
    }

    public Laptop() {
    }


    @Override
    public String getModel() 
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }
    
    public double getScreen() 
    {
        return screen;
    }

    public void setScreen(float screen) 
    {
        this.screen = screen;
    }

    public int getRam() 
    {
        return ram;
    }

    public void setRam(int ram) 
    {
        this.ram = ram;
    }

    public double getWeight() 
    {
        return weight;
    }

    public void setWeight(double weight) 
    {
        this.weight = weight;
    }

    public int getMemory() 
    {
        return memory;
    }

    public void setMemory(int memory) 
    {
        this.memory = memory;
    }

    public String getCpu() 
    {
        return cpu;
    }

    public void setCpu(String cpu)
    {
        this.cpu = cpu;
    }

    public String getOs()
    {
        return os;
    }

    public void setOs(String os) 
    {
        this.os = os;
    }
    
    //save the data in the database
    @Override
    public boolean saveData()
    {
        //create and start of the session
        SessionFactory factory = Main.getSessionFactory();
        Session session = factory.openSession();
        try
        {                
            session.beginTransaction();
            //the instance of the laptop for the check
            Laptop laptopFromData=new Laptop();
            Query query =session.createQuery("from Laptop where serialNumber=:model1");
            query.setParameter("model1",serialNumber);
            laptopFromData=(Laptop)query.uniqueResult();
            //if there is the model in the database
            if(laptopFromData!=null)                  
                //increase the quantity as it has been declared from the input
                laptopFromData.setQuantity(laptopFromData.getQuantity()+this.getQuantity());
            else
                //else if there s no such model,save the model
                session.save(this);
            session.getTransaction().commit();
        }
        catch(Exception ex)
        {
            session.getTransaction().rollback();
            ex.printStackTrace();
            return false;
        }finally{
            session.close();
        }
        return true;
    }
    
    //list of the models of laptop
    public ArrayList<Laptop> getModelListLap()
    {
        //the list with the models
        ArrayList <Laptop> lista =new ArrayList <Laptop>();
        //create and start the session
        SessionFactory factory = Main.getSessionFactory();
        Session session = factory.openSession();
        try
        {                
            session.beginTransaction();
            //the name of the table(category)
            Query query =session.createQuery("from Laptop");
            lista = (ArrayList) query.list();  
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
        return lista;
    }
    
    //update the database
    @Override
    public boolean updateData(String a,String b)
    {
        //the quantity from the input
        int quantity=Integer.parseInt(b);
        //create and start the session
        SessionFactory factory = Main.getSessionFactory();
        Session session = factory.openSession();
        try
        {                
            session.beginTransaction();
            //the instance of the laptop for the check
            Laptop lpFromData=new Laptop();
            //if there is the model in the database
            Query query =session.createQuery("from Laptop where model=:model1");
            query.setParameter("model1", a);
            lpFromData=(Laptop)query.uniqueResult();
            try
            {
                //if there is the model with the required quantity
                if((lpFromData!=null)&&(lpFromData.getQuantity()>=quantity))                  
                    //decrease the quantity of the model from the database with the amount of the input
                    lpFromData.setQuantity(lpFromData.getQuantity()-quantity);
                else
                    return false;
            session.getTransaction().commit();
            }
            catch(Exception ex)
            {
                session.getTransaction().rollback();
                ex.printStackTrace();
                return false;
            }
        }
        catch(Exception ex)
        {
            session.getTransaction().rollback();
            ex.printStackTrace();
            return false;
        }
        finally
        {
            session.close();
        }
        return true;
    }

    //update the database for addition
    public boolean updateAddData(String a,String b)
    {
        //the quantity from the input
        int quantity=Integer.parseInt(b);
        //create and start the session
        SessionFactory factory = Main.getSessionFactory();
        Session session = factory.openSession();
        try
        {                
            session.beginTransaction();
            //the instance of the laptop for the check
            Laptop lpFromData=new Laptop();
            Query query =session.createQuery("from Laptop where model=:model1");
            query.setParameter("model1", a);
            lpFromData=(Laptop)query.uniqueResult();
            try
            {
                //if there is the model
                if(lpFromData!=null)                  
                    //increase the quantity with the input
                    lpFromData.setQuantity(lpFromData.getQuantity()+quantity);
                else
                    return false;
            session.getTransaction().commit();
            }
            catch(Exception ex)
            {
                session.getTransaction().rollback();
                ex.printStackTrace();
                return false;
            }
        }
        catch(Exception ex)
        {
            session.getTransaction().rollback();
            ex.printStackTrace();
            return false;
        }
        finally
        {
            session.close();
        }
        return true;
    }
    @Override
    public String toString() 
    {
        return "Laptop{" + "price=" + price + ", brand=" + brand + ", serialNumber=" + serialNumber + ", year=" + year + ", quantity=" + quantity + "model=" + model + ", screen=" + screen + ", ram=" + ram + ", weight=" + weight + ", memory=" + memory + ", cpu=" + cpu + ", os=" + os + '}';
    }  
}
 