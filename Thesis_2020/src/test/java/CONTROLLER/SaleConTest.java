package CONTROLLER;

import MODEL.Employee;
import MODEL.Product;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class SaleConTest 
{
    //instance for its methods
    private static SaleCon salecon = new SaleCon();
    
    public SaleConTest() {
    }
    //test the search of an employee from the database
    @Test
    public void testConfirmEmp() {
        System.out.println("confirmEmp");
        int id = 1234;
        String expResult = "NEKTARIOS";
        Employee result = salecon.confirmEmp(id);
        assertEquals(expResult, result.getName());
    }
    //test if the values are not null
    @Test
    public void testNullMessageSale() {
        System.out.println("nullMessageSale");
        String name = "a";
        String surname = "b";
        String email = "c";
        String address = "d";
        String product = "e";
        String model = "f";
        boolean result = salecon.nullMessageSale(name, surname, email, address, product, model);
        assertFalse(result);
    }
    //test the search of a table in the database
    @Test
    public void testGetTheTableSale() {
        System.out.println("getTheTableSale");
        String a = "LAPTOP";
        String expResult = "Laptop";
        String result =salecon.getTheTableSale(a);
        assertEquals(expResult, result);
    }
    //test the first element of the list of the television table
    @Test
    public void testGetListaSaleCon() {
        System.out.println("getListaSaleCon");
        String table = "Television";
        String expResult = "F&U:FLA4320UH";
        List<String> result = salecon.getListaSaleCon(table);
        assertEquals(expResult, result.get(0));
    }
    //test the confirmation of a model in the database
    @Test
    public void testGetChoosenModelSaleCon() {
        System.out.println("getChoosenModelSaleCon");
        String a = "MACBOOK AIR 13";
        String b = "Laptop";
        String expResult = "APAIR3";
        Product result = salecon.getChoosenModelSaleCon(a, b);
        assertEquals(expResult, result.getSerialNumber());
    }

}
