package MODEL;

import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


@Entity
@Table(name = "CAMERA")
public class Camera extends Product
{
    @Column(name = "MODEL", unique = true, nullable = false,length = 15)
    private String model;
    @Column(name = "SCREEN", unique = false, nullable = false,length = 3)
    private double screen;
    @Column(name = "SHARPNESS", unique = false, nullable = false,length = 3)
    private double megapixel;
    @Column(name = "IMAGE", unique = false, nullable = false,length = 15)
    private String image;
    @Column(name = "MEMORY_TYPE", unique = false, nullable = false,length = 10)
    private String memoryType;
    

    public Camera(String model,double screen, double megapixel, String image, String memoryType, double price, String brand, int year,int quantity) 
    {
        super(price, brand,year,quantity);
        this.model=model;
        this.screen = screen;
        this.megapixel = megapixel;
        this.image = image;
        this.memoryType = memoryType;
        this.serialNumber = brand.substring(0,2)+model+year%100;
    }

    public Camera() {
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

    public void setScreen(double screen) 
    {
        this.screen = screen;
    }

    public double getMegapixel() 
    {
        return megapixel;
    }

    public void setMegapixel(double megapixel) 
    {
        this.megapixel = megapixel;
    }

    public String getImage() 
    {
        return image;
    }

    public void setImage(String image) 
    {
        this.image = image;
    }

    public String getMemoryType() 
    {
        return memoryType;
    }

    public void setMemoryType(String memoryType) 
    {
        this.memoryType = memoryType;
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
            ///the instance of the camera for the check
            Camera cameraFromData=new Camera();
            Query query =session.createQuery("from Camera where serialNumber=:model1");
            query.setParameter("model1", serialNumber);
            cameraFromData=(Camera)query.uniqueResult();
            //if there is the model in the database
            if(cameraFromData!=null)                  
                //increase the quantity as it has been declared from the input
                cameraFromData.setQuantity(cameraFromData.getQuantity()+this.getQuantity());
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

    //list of the models of camera
    public ArrayList<Camera> getModelListCam()
    {
        //the list with the models
        ArrayList <Camera> lista =new ArrayList <Camera>();
        //create and start the session
        SessionFactory factory = Main.getSessionFactory();
        Session session = factory.openSession();
        try
        {                
            session.beginTransaction();
            //the name of the table(category)
            Query query =session.createQuery("from Camera");
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
            //the instance of the camera for the check
            Camera cmFromData=new Camera();
            //if there is the model in the database
            Query query =session.createQuery("from Camera where model=:model1");
            query.setParameter("model1", a);
            cmFromData=(Camera)query.uniqueResult();
            try
            {
                //if there is the model with the required quantity
                if((cmFromData!=null)&&(cmFromData.getQuantity()>=quantity))                  
                    //decrease the quantity of the model from the database with the amount of the input
                    cmFromData.setQuantity(cmFromData.getQuantity()-quantity);
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
            //the instance of the camera for the check
            Camera cmFromData=new Camera();
            Query query =session.createQuery("from Camera where model=:model1");
            query.setParameter("model1", a);
            cmFromData=(Camera)query.uniqueResult();
            try
            {
                //if there is the model 
                if(cmFromData!=null)                  
                    //increase the quantity with the input
                    cmFromData.setQuantity(cmFromData.getQuantity()+quantity);
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
        return "Camera{" + "price=" + price + ", brand=" + brand + ", serialNumber=" + serialNumber + ", year=" + year + ", quantity=" + quantity + "model=" + model + ", screen=" + screen + ", megapixel=" + megapixel + ", image=" + image + ", memoryType=" + memoryType + '}';
    }

}
