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
    //δημιουργία των απαραίτητων αναφορών αντικειμένων
    private static Employee employee;
    private static Employee papanastasiou;
    private static EmployeeTest employeetest;
    
    public EmployeeTest() {
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
    //θα γίνουν πριν τις κλήσεις των test μεθόδων
    @BeforeClass
    public static void setUpClass() 
    {
        employeetest=new EmployeeTest();
        //δημιουργία υπαλλήλου που θα καλεί τις μεθόδους
        employee=new Employee();
        //δημιουργία υπαλλήλου που θα αποθηκευτεί 
        papanastasiou=new Employee("NEKTARIOS","PAPANASTASIOU","ARI","123","694769986","PAPANASTASIOUARIS@GMAIL.gr");
    }
    //θα γίνουν μετά τις κλήσεις των test μεθόδων 
    @AfterClass
    public static void tearDownClass()
    {
        //διαγραφή του υπαλλήλου που αποθηκέυτηκε στη βάση κατά την διάρκεια των test
        employeetest.deleteEmployee("ARI");
        //αρχικοποίηση μεταβλητής
        papanastasiou=null;
    }
    //επαλήθευση ότι ο υπάλληλος δεν είναι προϊστάμενος
    @Test
    public void testIsIsProistamenos() {
        System.out.println("isIsProistamenos");
        assertFalse(papanastasiou.isIsProistamenos());
    }
    //επαλήθευση αποθήκευσης υπαλλήλου
    @Test
    public void testSaveUser() 
    {
        System.out.println("saveUser");
        assertTrue(papanastasiou.saveUser());
    }
    //επαλήθευση της έγκρισης εισόδου ενός χρήστη στην εφαρμογή
    @Test
    public void testLoginEmp() {
        System.out.println("loginEmp");
        Employee papanas=employee.loginEmp("ARIS", "1234");
        assertEquals("PAPANASTASIOU",papanas.surname);
    }
    //επαλήθευση αναζήτησης ενός υπαλλήλου από την βάση
    @Test
    public void testSearchEmp() {
        System.out.println("searchEmp");
        Employee papanas=employee.searchEmp(1234);
        assertEquals("PAPANASTASIOU",papanas.surname);
    }
    //επαλήθευση του υπαλλήλου που βρίσκεται πρώτος στη λίστα των υπαλλήλων
    @Test
    public void testListaEmployee() {
        System.out.println("listaEmployee");
        String expResult ="PAPANASTASIOU NEKTARIOS 1234";
        ArrayList<String> result = employee.listaEmployee();
        assertEquals(expResult, result.get(0));
    }

}
