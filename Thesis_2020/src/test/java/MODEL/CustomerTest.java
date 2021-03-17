package MODEL;

import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerTest 
{
    //instances for their methods
    private static Customer customer;
    private static Customer giannis;
    private static CustomerTest customertest;
    
    public CustomerTest() {
    }
    
    //delete the customer from the database
    public void deleteCustomer(String a)
    {
        int result=0;
        SessionFactory factory = Main.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        try
        { 
            Query query =session.createQuery("delete Customer where email=:mail");
            query.setParameter("mail", a);
            result=query.executeUpdate();
            if(result>0)
                System.out.println("the database has been updated");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        session.close();
    }
    //before the call of the test methods
    @BeforeClass
    public static void setUpClass() 
    {
        customertest=new CustomerTest();
        customer = new Customer();
        giannis=new Customer("GIANNIS", "BARIAMIDIS", "GIANNIS@HOTMAIL.COM", "THOUKIDIDI 34");
    }
    //after the call of the test methods
    @AfterClass
    public static void tearDownClass() 
    {
        //delete the customer in the database after the test 
        customertest.deleteCustomer("GIANNIS@HOTMAIL.COM");
        giannis=null;
    }
    //test the save of the customer in the database
    @Test
    public void testSaveCus() 
    {
        System.out.println("saveCus");
        boolean result = giannis.saveCus();
        assertTrue(result);
    }
    //confirmation of the customer who is the second place in the customer list
    @Test
    public void testGetListaCustomer() 
    {
        System.out.println("getListaCustomer");
        String expResult = "PIATIDIS FANIS FANIS@GMAIL.COM";
        ArrayList<String> result = customer.getListaCustomer();
        assertEquals(expResult, result.get(1));
    }
    //test the search of the customer in the database
    @Test
    public void testGetCustomer() {
        System.out.println("getCustomer");
        String a = "MIXAIL@GMAIL.COM";
        String expResult = "MIXALIS";
        Customer result = customer.getCustomer(a);
        assertEquals(expResult, result.getName());
    }
}
