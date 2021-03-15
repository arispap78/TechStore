package MODEL;

import VIEW.Login;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main 
{
    //greate an instance of sessionFactory
    private static final SessionFactory sessionFactory = buildSessionFactory();
	 
    private static SessionFactory buildSessionFactory() 
    {
        try 
        {
             //build SessionFactory from hibernate.cfg.xml
            return new AnnotationConfiguration().configure("/hibernate.cfg.xml").buildSessionFactory();
            
        }
        catch (Throwable ex) 
        {
            //if the connection failed
            System.err.println("Initial SessionFactory creation failed." + ex);
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);           
        }
    }
 
    //getter
    public static SessionFactory getSessionFactory() 
    {
        return sessionFactory;
    }
    
    //stop the connection 
    public static void shutdown()
    {
    	getSessionFactory().close();
    }
    //display the sceen of the login
    public static void main(String[] args) 
    {    
        new Login().setVisible(true);
    }
}
