package MODEL;

import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LaptopTest
{
    //instances for their methods
    private static Laptop laptop;
    private static Laptop laptopSave;
    private static LaptopTest laptoptest;
    
    public LaptopTest() {
    }
    
    //delete the laptop model from the database
    public void deleteLaptop(String a)
    {
        int result=0;
        SessionFactory factory = Main.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        try
        { 
            Query query =session.createQuery("delete Laptop where model=:mail");
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
        laptop = new Laptop();
        laptoptest=new LaptopTest();
        laptopSave=new Laptop("DB67ER",15.6, 8, 1.4, 500, "I5", "UBUNTU", 565.0, "ASUS", 2020,6);
    }
    //after the call of the test methods 
    @AfterClass
    public static void tearDownClass() 
    {
        laptoptest.deleteLaptop("DB67ER");
        laptopSave=null;
    }
    //test the save of the model in the database
    @Test
    public void testSaveData() 
    {
        System.out.println("saveData");
        boolean result = laptopSave.saveData();
        assertTrue(result);
    }
    //test if the model is the first in the laptop list
    @Test
    public void testGetModelListLap() {
        System.out.println("getModelListLap");
        ArrayList<Laptop> result = laptop.getModelListLap();
        assertEquals("ACCOLDBOOK 1116", result.get(0).getSerialNumber());
    }
    //test the substraction of items of a model in the database
    @Test
    public void testUpdateData() {
        System.out.println("updateData");
        String a = "ASPIRE 3";
        String b = "1";
        boolean result = laptop.updateData(a, b);
        assertTrue(result);
    }
    //test the addition of items of a model in the database
    @Test
    public void testUpdateAddData() {
        System.out.println("updateAddData");
        String a = "ASPIRE 3";
        String b = "1";
        boolean result = laptop.updateAddData(a, b);
        assertTrue(result);
    }

}
