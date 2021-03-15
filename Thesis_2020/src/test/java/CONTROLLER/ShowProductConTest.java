package CONTROLLER;

import MODEL.Camera;
import MODEL.Product;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShowProductConTest 
{
     //αντικείμενο που θα χρειαστεί για την κλήση μεθόδων
    ShowProductCon showproductcon = new ShowProductCon();
 
    public ShowProductConTest() {
    }
    //επαλήθευση μοντέλου που βρίσκεται στην δεύτερη θέση της λίστας με τις φωτογραφικές
    @Test
    public void testGetListaCam() {
        System.out.println("getListaCam");
        String table = "Camera";
        String expResult = "CANON:EOS 250D";
        ArrayList<String> result = showproductcon.getListaCam(table);
        assertEquals(expResult, result.get(1));
    }
    //επαλήθευση ότι επιστρέφει το όνομα του αντίστοιχου πίνακα
    @Test
    public void testGetTheTable() {
        System.out.println("getTheTable");
        String a = "TELEVISION";
        String expResult = "Television";
        String result = showproductcon.getTheTable(a);
        assertEquals(expResult, result);
    }
    //επαλήθευση του μοντέλου φωτογραφικής μηχανής που υπαρχει στη βάση δεδομένων 
    @Test
    public void testGetChoosenModelCam() {
        System.out.println("getChoosenModelCam");
        String a = "D3500";
        String b = "Camera";
        String expResult = "ND1";
        Product result = showproductcon.getChoosenModelCam(a, b);
        assertEquals(expResult, result.getSerialNumber());
    }
    //επαλήθευση του μοντέλου που βρίσκεται στην πρώτη θέση με τα προτεινόμενα μοντέλα
    @Test
    public void testGetSuggestionsCam() {
        System.out.println("getSuggestionsCam");
        Camera a = (Camera) showproductcon.getChoosenModelCam("EOS 90D", "Camera");
        String expResult = "CANON:EOS 2000D";
        ArrayList<String> result = showproductcon.getSuggestionsCam(a);
        assertEquals(expResult, result.get(0));
    }

}
