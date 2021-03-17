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
    //instances for their methods
    private static Sale sale;
    private static Sale salesave;
    private static SaleTest saletest=new SaleTest();
    //instances of an employee and a customer for the tests
    private static Employee user=Employee.loginEmp( "ARIS", "1234");
    private static Customer customer=Customer.getCustomer("FANIS@GMAIL.COM");
    //the list of the products of a sale
    private static ArrayList<ProductString> productListest = new ArrayList<>();
    
    //delete a sale from the database
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
    
    //before the call of the test methods 
    @BeforeClass
    public static void setUpClass() 
    {
        sale=new Sale();
        salesave=new Sale(1400.0, user, customer,8,productListest);       
    }
    
    //after the call of the test methods 
    @AfterClass
    public static void tearDownClass() 
    { 
        saletest.deleteSale("2/5/2020");
        user=null;
        customer=null;
        salesave=null;
    }

    //test the save of a sale
    @Test
    public void testSaveSal() {
        System.out.println("saveSal");
        boolean result = salesave.saveSal();
        assertTrue(result);
    }
    //confirmation of the model in the database
    @Test
    public void testGetChoosenModelSale2() {
        System.out.println("getChoosenModelSale2");
        String a = "COLDBOOK 11";
        String b = "Laptop";
        String expResult = "ACCOLDBOOK 1116";
        Product result = Sale.getChoosenModelSale2(a, b);
        assertEquals(expResult, result.getSerialNumber());
    }
    //test the third model of the sale list
    @Test
    public void testGetListaSale() {
        System.out.println("getListaSale");
        String table = "Mobile";
        String expResult = "APPLE:IPHONE 8 PLUS";
        List<String> result = sale.getListaSale(table);
        assertEquals(expResult, result.get(2));
    }
    //confirmation of the result of the total pice of the first sale 
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
    //test the highest total price of the second sale of the sale list
    @Test
    public void testStatisticSale() throws ParseException {
        System.out.println("statisticSale");
        Date a = new SimpleDateFormat("yyyy-MM-dd").parse("2020-4-5");
        Date b = new SimpleDateFormat("yyyy-MM-dd").parse("2020-4-8");
        String expResult = "1798.9";
        ArrayList <Object[]> result =sale.statisticSale(a, b);
        assertEquals(expResult, result.get(1)[3].toString());
    }
    //test the highest total price of the second sale of the sale list from a specific employee
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
    //test of the total price of a sale of a specific date
    @Test
    public void testSearchSale() {
        System.out.println("searchSale");
        String a = "21/4/2020 10:45 μμ";
        double expResult = 280.7;
        Sale result = sale.searchSale(a);
        assertEquals(expResult, result.getTotalPrice(),0.1);
    }

}
