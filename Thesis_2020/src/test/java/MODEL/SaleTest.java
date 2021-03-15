package MODEL;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SaleTest 
{
    //δημιουργία των απαραίτητων αναφορών αντικειμένων
    private static Sale sale;
    private static Sale salesave;
    private static SaleTest saletest=new SaleTest();
    //δημιουργία των απαραίτητων αντικειμένων υπαλλήλου και πελάτη 
    private static Employee user=Employee.loginEmp( "ARIS", "1234");
    private static Customer customer=Customer.getCustomer("FANIS@GMAIL.COM");
    //δημιουργία λίστας ProductString που έχει μια πώληση
    private static ArrayList<ProductString> productListest = new ArrayList<>();
    
    //για να διαγραφεί η πώληση που αποθηκεύτηκε στην βάση με το test
    public void deleteSale(String a)
    {
        int result=0;
        SessionFactory factory = Main.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        try
        { 
            Query query =session.createQuery("delete Sale where serialNumber LIKE :date");
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
    
    public SaleTest() {
    }
    //θα γίνουν πριν τις κλήσεις των test μεθόδων 
    @BeforeClass
    public static void setUpClass() 
    {
        //δημιουργία μιας πώλησης για την κλήση μεθόδων
        sale=new Sale();
        //δημιουργία πώλησης που θα αποθηκευτεί
        salesave=new Sale(1400.0, user, customer,8,productListest);       
    }
    //θα γίνουν μετά τις κλήσεις των test μεθόδων 
    @AfterClass
    public static void tearDownClass() 
    {
        //διαγραφή του αντικειμένου που αποθηκεύτηκε κατά την διάρκεια των test 
        saletest.deleteSale("2/5/2020");
        //αρχικοποίηση μεταβλητών
        user=null;
        customer=null;
        salesave=null;
    }

    //επαλήθευση αποθήκευσης μιας πώλησης
    @Test
    public void testSaveSal() {
        System.out.println("saveSal");
        boolean result = salesave.saveSal();
        assertTrue(result);
    }
    //επαλήθευση του μοντέλου που αναζητήθηκε
    @Test
    public void testGetChoosenModelSale2() {
        System.out.println("getChoosenModelSale2");
        String a = "COLDBOOK 11";
        String b = "Laptop";
        String expResult = "ACCOLDBOOK 1116";
        Product result = Sale.getChoosenModelSale2(a, b);
        assertEquals(expResult, result.getSerialNumber());
    }
    //επαλήθευση αποτελέσματος του τρίτου μοντέλου της λίστας
    @Test
    public void testGetListaSale() {
        System.out.println("getListaSale");
        String table = "Mobile";
        String expResult = "APPLE:IPHONE 8 PLUS";
        List<String> result = sale.getListaSale(table);
        assertEquals(expResult, result.get(2));
    }
    //επαλήθευση αποτελέσματος του συνολικού ποσού της πρώτης πώλησης 
    @Test
    public void testSearchSaleList() throws ParseException {
        System.out.println("searchSaleList");
        Date a = new SimpleDateFormat("yyyy-MM-dd").parse("2020-4-5");
        Date b = new SimpleDateFormat("yyyy-MM-dd").parse("2020-4-7");
        double expResult = 954.9;
        ArrayList <Sale> result =new ArrayList <Sale>();
        result=sale.searchSaleList(a, b);
        assertEquals(expResult, result.get(0).getTotalPrice(),0.1);
    }
    //επαλήθευση αποτελέσματος της μεγαλύτερης τιμής συνολικού ποσού της δεύτερης πώλησης της λίστας
    @Test
    public void testStatisticSale() throws ParseException {
        System.out.println("statisticSale");
        Date a = new SimpleDateFormat("yyyy-MM-dd").parse("2020-4-5");
        Date b = new SimpleDateFormat("yyyy-MM-dd").parse("2020-4-8");
        String expResult = "1798.9";
        ArrayList <Object[]> result =sale.statisticSale(a, b);
        assertEquals(expResult, result.get(1)[3].toString());
    }
    //επαλήθευση αποτελέσματος της μεγαλύτερης τιμής συνολικού ποσού δεύτερης πώλησης της λίστας από έναν υπάλληλο
    @Test
    public void testStatisticSaleEmp() throws ParseException {
        System.out.println("statisticSaleEmp");
        Date a = new SimpleDateFormat("yyyy-MM-dd").parse("2020-4-5");
        Date b = new SimpleDateFormat("yyyy-MM-dd").parse("2020-4-8");
        int c=1235;
        String expResult = "1798.9";
        ArrayList <Object[]> result =sale.statisticSaleEmp(a, b,c);
        assertEquals(expResult, result.get(1)[3].toString());
    }
    //επαλήθευση του συνολικού ποσού της πώλησης μιας συγκεκριμένης ημερομηνίας
    @Test
    public void testSearchSale() {
        System.out.println("searchSale");
        String a = "21/4/2020 10:45 μμ";
        double expResult = 280.7;
        Sale result = sale.searchSale(a);
        assertEquals(expResult, result.getTotalPrice(),0.1);
    }

}
