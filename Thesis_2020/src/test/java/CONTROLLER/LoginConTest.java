package CONTROLLER;

import MODEL.Employee;
import MODEL.Main;
import MODEL.ProductManager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginConTest 
{
    //δημιουργία των απαραίτητων αναφορών αντικειμένων
    private static LoginCon logincon;
    private static LoginConTest logincontest;
    //αρχικοποίηση μεταβλητής που περιέχει το κλειδί του προϊσταμένου
    private static String inputR="";
    
    public LoginConTest() {
    }
    
    //για να διαγραφεί ο υπάλληλος που αποθηκεύτηκε στην βάση με το test
    public void deleteEmployee(String a)
    {
        int result=0;
        SessionFactory factory = Main.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        try
        { 
            Query query =session.createQuery("delete Employee where email=:mail");
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
    
    //για να διαγραφεί ο προϊστάμενος που αποθηκεύτηκε στην βάση με το test
    public void deleteProductManager(String a)
    {
        int result=0;
        SessionFactory factory = Main.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        try
        { 
            Query query =session.createQuery("delete ProductManager where email=:mail");
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
        //δημιουργία αντικειμένων για την κλήση μεθόδων
        logincon = new LoginCon();
        logincontest=new LoginConTest();
    }
    //θα γίνουν μετά τις κλήσεις των test μεθόδων 
    @AfterClass
    public static void tearDownClass() 
    {
        //διαγραφή υπαλλήλου ή προϊσταμένου από τη βάση που αποθηκεύτηκε κατά την διάρκεια των test
        if(inputR.isEmpty())
            logincontest.deleteEmployee("ilias@gmail.gr");
        else
            logincontest.deleteProductManager("ilias@gmail.gr");
    }
    //επαλήθευση της εγγραφής χρήστη
    @Test
    public void testRegistration() 
    {
        System.out.println("registration");
        String name = "ilias";
        String surname = "dobris";
        String username = "ilias";
        String password = "77";
        String phone = "2551039034";
        String email = "ilias@gmail.gr";
        inputR ="345";
        boolean result = logincon.registration(name, surname, username, password, phone, email, inputR);
        assertTrue(result);
    }
    //επαλήθευση ότι οι μεταβλητές String δεν είναι κενές κατά την εγγραφή του χρήστη
    @Test
    public void testNullMessageReg() 
    {
        System.out.println("nullMessageReg");
        String name = "a";
        String surname = "b";
        String username = "c";
        String password = "d";
        String phone = "e";
        String email = "f";
        boolean result = logincon.nullMessageReg(name, surname, username, password, phone, email);
        assertFalse(result);
    }
    //επαλήθευση ότι οι μεταβλητές String δεν είναι κενές κατά την σύνδεση του χρήστη
    @Test
    public void testNullMessageLog() 
    {
        System.out.println("nullMessageLog");
        String username = "h";
        String password = "g";
        boolean result = logincon.nullMessageLog(username, password);
        assertFalse(result);
    }
    //επαλήθευση στοιχείων για την σύνδεση του υπαλλήλου στην εφαρμογή
    @Test
    public void testLoginControlEmp()
    {
        System.out.println("loginControlEmp");
        String username = "ARIS";
        String password = "1234";
        String expResult = "PAPANASTASIOU";
        Employee result = logincon.loginControlEmp(username, password);
        assertEquals(expResult, result.getSurname());
    }
    //επαλήθευση στοιχείων για την σύνδεση του προϊσταμένου στην εφαρμογή
    @Test
    public void testLoginControlPro() 
    {
        System.out.println("loginControlPro");
        String username = "IRAKLIS";
        String password = "IRAKLIS";
        String expResult = "PIATIDIS";
        ProductManager result = logincon.loginControlPro(username, password);
        assertEquals(expResult, result.getSurname());
    }
    
}
