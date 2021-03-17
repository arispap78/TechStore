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
    //instances for their methods
    private static LoginCon logincon;
    private static LoginConTest logincontest;
    //initialization of the variable that includes the key of the product manager
    private static String inputR="";
    
    public LoginConTest() {
    }
    
    //delete the employee from the database
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
    
    //delete the product manager from the database
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
    //before the call of the test methods
    @BeforeClass
    public static void setUpClass() 
    {
        //instances for their methods
        logincon = new LoginCon();
        logincontest=new LoginConTest();
    }
    //after the call of the test methods
    @AfterClass
    public static void tearDownClass() 
    {
        //delete the user from the database after the test
        if(inputR.isEmpty())
            logincontest.deleteEmployee("ilias@gmail.gr");
        else
            logincontest.deleteProductManager("ilias@gmail.gr");
    }
    //test the registration of a user
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
    //test if the values are not null for registration
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
    //test if the values are not null for login
    @Test
    public void testNullMessageLog() 
    {
        System.out.println("nullMessageLog");
        String username = "h";
        String password = "g";
        boolean result = logincon.nullMessageLog(username, password);
        assertFalse(result);
    }
    //test the confirmation of the employee for the connection
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
    //test the confirmation of the product manager for the connection
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
