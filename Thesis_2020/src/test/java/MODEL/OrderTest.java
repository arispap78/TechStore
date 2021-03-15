package MODEL;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class OrderTest 
{
    
    public OrderTest() {
    }
    //δημιουργία των απαραίτητων αναφορών αντικειμένων
    private static Order order;
    private static Order ordersave;
    private static OrderTest ordertest;   
    private static ProductManager user=ProductManager.loginPro( "GEORGE", "4567");
    //δημιουργία λίστας OrderString που έχει μια παραγγελία
    private static ArrayList<OrderString> orderListest = new ArrayList<>();
    
    //για να διαγραφεί η παραγγελία που αποθηκεύτηκε στην βάση με το test
    public void deleteOrder(String a)
    {
        int result=0;
        SessionFactory factory = Main.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        try
        { 
            Query query =session.createQuery("delete Order where date LIKE :date");
            query.setParameter("date",a+"%");
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
        ordertest=new OrderTest(); 
        //δημιουργία παραγγελίας για την κλήση μεθόδων
        order=new Order();
        //δημιουργία παραγγελίας που θα αποθηκευτεί
        ordersave=new Order(user, orderListest);
    }
    //θα γίνουν μετά τις κλήσεις των test μεθόδων 
    @AfterClass
    public static void tearDownClass()
    {
        //διαγραφή του αντικειμένου που αποθηκεύτηκε κατά την διάρκεια των test
        ordertest.deleteOrder("2/5/2020");
        //αρχικοποίηση μεταβλητών
        user=null;
        ordersave=null;
    }
    //επαλήθευση αποθήκευσης μιας παραγγελίας
    @Test
    public void testSaveOrd() 
    {
        System.out.println("saveOrd");
        boolean result = ordersave.saveOrd();
        assertTrue(result);
    }
    //επαλήθευση μοντέλου που θα εμφανίζεται πρώτο στη λίστα
    @Test
    public void testGetListaOrder() 
    {
        System.out.println("getListaOrder");
        String table = "Television";
        String expResult = "F&U:FLA4320UH";
        List<String> result = order.getListaOrder(table);
        assertEquals(expResult, result.get(0));
    }
    //επαλήθευση αναζήτησης παραγγελίας μιας συγκεκριμένης ημερομηνίας
    @Test
    public void testSearchOrd() {
        System.out.println("searchOrd");
        String a = "1/4/2020 6:01 μμ";
        int expResult = 4567;
        Order result = order.searchOrd(a);
        assertEquals(expResult, result.getUser().getRegistryNumber());
    }
    
}
