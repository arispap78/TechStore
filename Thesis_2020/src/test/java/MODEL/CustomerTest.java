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
    //δημιουργία των απαραίτητων αναφορών αντικειμένων
    private static Customer customer;
    private static Customer giannis;
    private static CustomerTest customertest;
    
    public CustomerTest() {
    }
    
    //για να διαγραφεί ο πελάτης που αποθηκεύτηκε στην βάση με το test
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
    //θα γίνουν πριν τις κλήσεις των test μεθόδων
    @BeforeClass
    public static void setUpClass() 
    {
        customertest=new CustomerTest();
        //δημιουργία πελάτη για την κλήση μεθόδων
        customer = new Customer();
        //δημιουργία πελάτη για την αποθήκευση στην βάση
        giannis=new Customer("GIANNIS", "BARIAMIDIS", "GIANNIS@HOTMAIL.COM", "THOUKIDIDI 34");
    }
    //θα γίνουν μετά τις κλήσεις των test μεθόδων 
    @AfterClass
    public static void tearDownClass() 
    {
        //διαγραφή του πελάτη που αποθηκεύτηκε κατά την διάρκεια των test 
        customertest.deleteCustomer("GIANNIS@HOTMAIL.COM");
        //αρχικοποίηση μεταβλητής
        giannis=null;
    }
    //επαλήθευση αποθήκευσης πελάτη στην βάση
    @Test
    public void testSaveCus() 
    {
        System.out.println("saveCus");
        boolean result = giannis.saveCus();
        assertTrue(result);
    }
    //επαλήθευση πελάτη που βρίσκεται στην δεύτερη θέση της λίστας πελατών
    @Test
    public void testGetListaCustomer() 
    {
        System.out.println("getListaCustomer");
        String expResult = "PIATIDIS FANIS FANIS@GMAIL.COM";
        ArrayList<String> result = customer.getListaCustomer();
        assertEquals(expResult, result.get(1));
    }
    //επαλήθευση πελάτη που βρίσκεται στην βάση
    @Test
    public void testGetCustomer() {
        System.out.println("getCustomer");
        String a = "MIXAIL@GMAIL.COM";
        String expResult = "MIXALIS";
        Customer result = customer.getCustomer(a);
        assertEquals(expResult, result.getName());
    }
}
