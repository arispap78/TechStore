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
    //δημιουργία των απαραίτητων αναφορών αντικειμένων
    private static Laptop laptop;
    private static Laptop laptopSave;
    private static LaptopTest laptoptest;
    
    public LaptopTest() {
    }
    
    //για να διαγραφεί το αντικείμενο που αποθηκεύτηκε στην βάση με το test
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
    //θα γίνουν πριν τις κλήσεις των test μεθόδων
    @BeforeClass
    public static void setUpClass()
    {
        //δημιουργία αντικειμένων για την κλήση μεθόδων
        laptop = new Laptop();
        laptoptest=new LaptopTest();
        //δημιουργία αντικειμένου που θα αποθηκευτεί
        laptopSave=new Laptop("DB67ER",15.6, 8, 1.4, 500, "I5", "UBUNTU", 565.0, "ASUS", 2020,6);
    }
    //θα γίνουν μετά τις κλήσεις των test μεθόδων 
    @AfterClass
    public static void tearDownClass() 
    {
        //διαγραφή του αντικειμένου που αποθηκεύτηκε κατά την διάρκεια των test 
        laptoptest.deleteLaptop("DB67ER");
        //αρχικοποίηση μεταβλητής
        laptopSave=null;
    }
    //επαλήθευση αποθήκευσης αντικειμένου στη βάση
    @Test
    public void testSaveData() 
    {
        System.out.println("saveData");
        boolean result = laptopSave.saveData();
        assertTrue(result);
    }
    //επαλήθευση του μοντέλου που βρίσκεται πρώτο στη λίστα των Laptop
    @Test
    public void testGetModelListLap() {
        System.out.println("getModelListLap");
        ArrayList<Laptop> result = laptop.getModelListLap();
        assertEquals("ACCOLDBOOK 1116", result.get(0).getSerialNumber());
    }
    //επαλήθευση αφαίρεσης τεμαχίων συγκεκριμένου μοντέλου
    @Test
    public void testUpdateData() {
        System.out.println("updateData");
        String a = "ASPIRE 3";
        String b = "1";
        boolean result = laptop.updateData(a, b);
        assertTrue(result);
    }
    //επαλήθευση προσθήκης τεμαχίων συγκεκριμένου μοντέλου
    @Test
    public void testUpdateAddData() {
        System.out.println("updateAddData");
        String a = "ASPIRE 3";
        String b = "1";
        boolean result = laptop.updateAddData(a, b);
        assertTrue(result);
    }

}
