package MODEL;

import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Entity
@Table(name = "TELEVISION")
public class Television extends Product
{
    @Column(name = "MODEL", unique = true, nullable = false,length = 15)
    private String model;
    @Column(name = "SCREEN", unique = false, nullable = false,length = 3)
    private double screen;
    @Column(name = "FREQUENCY", unique = false, nullable = false,length = 3)
    private int frequency;
    @Column(name = "SMART", unique = false, nullable = false)
    private boolean smart;
    @Column(name = "SHARPNESS", unique = false, nullable = false,length = 10)
    private String sharpness;


    public Television(String model,double screen, int frequency, boolean smart, String sharpness, double price, String brand, int year,int quantity) 
    {
        super(price, brand, year,quantity);
        this.model=model;
        this.screen = screen;
        this.frequency = frequency;
        this.smart = smart;
        this.sharpness = sharpness;
        this.serialNumber = brand.substring(0,2)+model+year%100;
    }

    public Television() {
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

    public int getFrequency() 
    {
        return frequency;
    }

    public void setFrequency(int frequency) 
    {
        this.frequency = frequency;
    }

    public boolean isSmart() 
    {
        return smart;
    }

    public void setSmart(boolean smart) 
    {
        this.smart = smart;
    }

    public String getSharpness() 
    {
        return sharpness;
    }

    public void setSharpness(String sharpness) 
    {
        this.sharpness = sharpness;
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
            //the instance of the television for the check
            Television tvFromData=new Television();
            Query query =session.createQuery("from Television where serialNumber=:model1");
            query.setParameter("model1", serialNumber);
            tvFromData=(Television)query.uniqueResult();
            //if there is the model in the database
            if(tvFromData!=null)                  
                //increase the quantity as it has been declared from the input
                tvFromData.setQuantity(tvFromData.getQuantity()+this.getQuantity());
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
        }
        finally
        {
            session.close();
        }
        return true;
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
            //the instance of the television for the check
            Television tvFromData=new Television();
            //if there is the model in the database
            Query query =session.createQuery("from Television where model=:model1");
            query.setParameter("model1", a);
            tvFromData=(Television)query.uniqueResult();
            try
            {
                //if there is the model with the required quantity
                if((tvFromData!=null)&&(tvFromData.getQuantity()>=quantity))                  
                    //decrease the quantity of the model from the database with the amount of the input
                    tvFromData.setQuantity(tvFromData.getQuantity()-quantity);
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
            //the instance of the television for the check
            Television tvFromData=new Television();
            Query query =session.createQuery("from Television where model=:model1");
            query.setParameter("model1", a);
            tvFromData=(Television)query.uniqueResult();
            try
            {
                //if there is the model
                if(tvFromData!=null)                  
                    //increase the quantity with the input
                    tvFromData.setQuantity(tvFromData.getQuantity()+quantity);
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
    
    //list of the models of television
    public ArrayList<Television> getModelListTel()
    {
        //the list with the models
        ArrayList <Television> lista =new ArrayList <Television>();
        //create and start the session
        SessionFactory factory = Main.getSessionFactory();
        Session session = factory.openSession();
        try
        {                
            session.beginTransaction();
            //the name of the table(category)
            Query query =session.createQuery("from Television");
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
    
    @Override
    public String toString()
    {
        return "Television{" + "price=" + price + ", brand=" + brand + ", serialNumber=" + serialNumber + ", year=" + year + ", quantity=" + quantity + "model=" + model + ", screen=" + screen + ", frequency=" + frequency + ", smart=" + smart + ", sharpness=" + sharpness + '}';
    }    
}


