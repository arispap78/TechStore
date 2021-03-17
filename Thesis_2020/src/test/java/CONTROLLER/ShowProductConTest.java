package CONTROLLER;

import MODEL.Camera;
import MODEL.Product;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShowProductConTest 
{
     //instance for its methods
    ShowProductCon showproductcon = new ShowProductCon();
 
    public ShowProductConTest() {
    }
    //test the second element of the list of the camera table
    @Test
    public void testGetListaCam() {
        System.out.println("getListaCam");
        String table = "Camera";
        String expResult = "CANON:EOS 250D";
        ArrayList<String> result = showproductcon.getListaCam(table);
        assertEquals(expResult, result.get(1));
    }
    //test the search for the table in the database
    @Test
    public void testGetTheTable() {
        System.out.println("getTheTable");
        String a = "TELEVISION";
        String expResult = "Television";
        String result = showproductcon.getTheTable(a);
        assertEquals(expResult, result);
    }
    //test the search of the model camera in the database 
    @Test
    public void testGetChoosenModelCam() {
        System.out.println("getChoosenModelCam");
        String a = "D3500";
        String b = "Camera";
        String expResult = "ND1";
        Product result = showproductcon.getChoosenModelCam(a, b);
        assertEquals(expResult, result.getSerialNumber());
    }
    //test the first element of the suggestion list of a camera model 
    @Test
    public void testGetSuggestionsCam() {
        System.out.println("getSuggestionsCam");
        Camera a = (Camera) showproductcon.getChoosenModelCam("EOS 90D", "Camera");
        String expResult = "CANON:EOS 2000D";
        ArrayList<String> result = showproductcon.getSuggestionsCam(a);
        assertEquals(expResult, result.get(0));
    }

}
