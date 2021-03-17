package CONTROLLER;

import MODEL.Main;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AddProductConTest 
{
    //instances for their methods
    private static AddProductCon addproductcon;
    private static AddProductConTest testTelevision;
    
    //delete a record from table television in the database
    public void deleteTelevision(String a)
    {
        int result=0;
        SessionFactory factory = Main.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        try
        { 
            Query query =session.createQuery("delete Television where model=:mail");
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
    
    public AddProductConTest(){
    }
    
    //before the call of the test methods
    @BeforeClass
    public static void setUpClass() 
    {
        //instances for their methods
        addproductcon=new AddProductCon() ;
        testTelevision=new AddProductConTest();
    }
    
    //after the call of the test methods
    @AfterClass
    public static void tearDownClass() 
    {
        //delete the model of television after the test
        testTelevision.deleteTelevision("ER90RE");
    }
    
    //test if the values are not null
    @Test
    public void testNullMessageTel()
    {
        System.out.println("nullMessageTel");
        String model = "a";
        String brand = "b";
        String sharpness = "c";
        String price = "d";
        String screen = "e";
        String frequency = "f";
        String smart = "g";
        String year = "h";
        String quantity = "i";
        boolean result = addproductcon.nullMessageTel(model, brand, sharpness, price, screen, frequency, smart, year, quantity);
        assertFalse(result);
    }
    //test the save of a television model with random values
    @Test
    public void testAddTelevisionCon() 
    {
        System.out.println("addTelevisionCon");
        String model = "ER90RE";
        String brand = "SONY";
        String sharpness = "4K";
        String price = "100.0";
        String screen = "43";
        String frequency = "60";
        String smart = "1";
        String year = "2020";
        String quantity = "4";
        boolean result = addproductcon.addTelevisionCon(model, brand, sharpness, price, screen, frequency, smart, year, quantity);
        assertTrue( result);
    }
    //tset the deletion of a model in the database
    @Test
    public void testUpdateTelevisionCon() 
    {
        System.out.println("updateTelevisionCon");
        String model = "32HE2000";
        String quantity = "1";
        boolean result = addproductcon.updateTelevisionCon(model, quantity);
        assertTrue(result);
    }
    //test the addition of a model in the database
    @Test
    public void testUpdateAddTelevisionCon() 
    {
        System.out.println("updateAddTelevisionCon");
        String model = "32HE2000";
        String quantity = "1";
        boolean result = addproductcon.updateAddTelevisionCon(model, quantity);
        assertTrue(result);
    }

}
