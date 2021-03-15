package MODEL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Entity
@Table(name = "PRODUCT_MANAGER")
public class ProductManager extends User
{
    //it is not a column in the table in the database
    @Transient
    private boolean isProistamenos=true;    
    @Column(name = "KEY", unique = true, nullable = false,length = 15)
    private String key;
    

    public ProductManager(String key, String name, String surname, String username, String password, String phone,String email) 
    {
        super(name, surname, username, password, phone, email);
        this.key = key;
    }
   
    public ProductManager() {
    }
    

    @Override
    public boolean isIsProistamenos() {
        return isProistamenos;
    }

    public void setIsProistamenos(boolean isProistamenos) {
        this.isProistamenos = isProistamenos;
    }

    public String getKey() 
    {
        return key;
    }

    public void setKey(String key) 
    {
        this.key = key;
    }

    //save the product manager in the database
    @Override
    public boolean saveUser()
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
    
    //check if there is a product manager with these username and password
    public static ProductManager loginPro( String username, String password)
    {
        //the product manager
        ProductManager productManager =new ProductManager();
        //create and start the session
        SessionFactory factory = Main.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        try
        {
            //find a product manager with this username
            Query query =session.createQuery("from ProductManager where username=:username" );
            query.setParameter("username", username);
            productManager = (ProductManager) query.uniqueResult();           
        }
        catch(Exception ex)
        {
            session.getTransaction().rollback();
            ex.printStackTrace();
            return null;
        }
        //if there is a product manager
        if(productManager!=null)
        {
            //if this product manager has the same password
            if(productManager.getPassword().equals(password))
            {
                session.getTransaction().commit();
                session.close();
                return productManager;
            }
            else
            {
                session.getTransaction().commit();
                session.close();
                return null; 
            }
        }
        else
        {
            session.getTransaction().commit();
            session.close();
            return null; 
        }
    }
    
    //search for a product manager with the id
    public static ProductManager searchPro( int id)
    {
        //the product manager
        ProductManager productManager =new ProductManager();
        //create and start the session
        SessionFactory factory = Main.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        try
        {
            //search for a product manager with this id
            Query query =session.createQuery("from ProductManager where id=:id");
            query.setParameter("id", id);
            productManager = (ProductManager) query.uniqueResult();            
        }
        catch(Exception ex)
        {
            session.getTransaction().rollback();
            ex.printStackTrace();
        }                
        session.getTransaction().commit();
        session.close(); 
        return productManager;
    }
    
    @Override
    public String toString() 
    {
        return "PRODUCT_MANAGER{" + "key=" + key + "name=" + name + ", surname=" + surname + ", registryNumber=" + registryNumber + ", username=" + username + ", password=" + password + ", phone=" + phone + ", email=" + email +  '}';
    }       
}
