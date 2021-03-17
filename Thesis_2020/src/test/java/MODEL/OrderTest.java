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
    //instances for their methods
    private static Order order;
    private static Order ordersave;
    private static OrderTest ordertest;   
    private static ProductManager user=ProductManager.loginPro( "GEORGE", "4567");
    //the product list of an order
    private static ArrayList<OrderString> orderListest = new ArrayList<>();
    
    //delete an order from the database
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
    //before the call of the test methods
    @BeforeClass
    public static void setUpClass() 
    {
        ordertest=new OrderTest(); 
        order=new Order();
        ordersave=new Order(user, orderListest);
    }
    //after the call of the test methods 
    @AfterClass
    public static void tearDownClass()
    {
        ordertest.deleteOrder("2/5/2020");
        user=null;
        ordersave=null;
    }
    //test the save of an order
    @Test
    public void testSaveOrd() 
    {
        System.out.println("saveOrd");
        boolean result = ordersave.saveOrd();
        assertTrue(result);
    }
    //test the first product of the list from an order
    @Test
    public void testGetListaOrder() 
    {
        System.out.println("getListaOrder");
        String table = "Television";
        String expResult = "F&U:FLA4320UH";
        List<String> result = order.getListaOrder(table);
        assertEquals(expResult, result.get(0));
    }
    //test the search of an order in a specific date
    @Test
    public void testSearchOrd() {
        System.out.println("searchOrd");
        String a = "1/4/2020 6:01 μμ";
        int expResult = 4567;
        Order result = order.searchOrd(a);
        assertEquals(expResult, result.getUser().getRegistryNumber());
    }
    
}
