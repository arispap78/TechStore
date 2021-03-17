package MODEL;

import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class EmployeeTest 
{
    //instances for their methods
    private static Employee employee;
    private static Employee papanastasiou;
    private static EmployeeTest employeetest;
    
    public EmployeeTest() {
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
            Query query =session.createQuery("delete Employee where username=:mail");
            query.setParameter("mail", a);
            result=query.executeUpdate();
            if(result>0)
                System.out.println("the database has been updated");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            session.getTransaction().rollback();
            System.out.println("there is a problem");
        }
        session.getTransaction().commit();
        session.close();
    }
    //before the call of the test methods
    @BeforeClass
    public static void setUpClass() 
    {
        employeetest=new EmployeeTest();
        employee=new Employee();
        papanastasiou=new Employee("NEKTARIOS","PAPANASTASIOU","ARI","123","694769986","PAPANASTASIOUARIS@GMAIL.gr");
    }
    //after the call of the test methods 
    @AfterClass
    public static void tearDownClass()
    {
        employeetest.deleteEmployee("ARI");
        papanastasiou=null;
    }
    //confirmation that the user is not product manager
    @Test
    public void testIsIsProistamenos() {
        System.out.println("isIsProistamenos");
        assertFalse(papanastasiou.isIsProistamenos());
    }
    //the the save of the user
    @Test
    public void testSaveUser() 
    {
        System.out.println("saveUser");
        assertTrue(papanastasiou.saveUser());
    }
    //test the confirmation of the login of a user
    @Test
    public void testLoginEmp() {
        System.out.println("loginEmp");
        Employee papanas=employee.loginEmp("ARIS", "1234");
        assertEquals("PAPANASTASIOU",papanas.surname);
    }
    //test the search of an employee in the database
    @Test
    public void testSearchEmp() {
        System.out.println("searchEmp");
        Employee papanas=employee.searchEmp(1234);
        assertEquals("PAPANASTASIOU",papanas.surname);
    }
    //test that the employee is in the first place of the employee s list
    @Test
    public void testListaEmployee() {
        System.out.println("listaEmployee");
        String expResult ="PAPANASTASIOU NEKTARIOS 1234";
        ArrayList<String> result = employee.listaEmployee();
        assertEquals(expResult, result.get(0));
    }

}
