package CONTROLLER;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticConTest 
{
    //instance for its methods
    StatisticCon statisticon = new StatisticCon();
    
    public StatisticConTest() {
    }
    
    //test the confirmation of the highest total price of the second element of the sale
    @Test
    public void testStatisticControl() throws ParseException {
        System.out.println("statisticControlEmp");
        Date a = new SimpleDateFormat("yyyy-MM-dd").parse("2020-4-5");
        Date b = new SimpleDateFormat("yyyy-MM-dd").parse("2020-4-8");
        String expResult = "1798.9";
        ArrayList <Object[]> result = statisticon.statisticControl(a, b);
        assertEquals(expResult, result.get(1)[3].toString());
    }
    //test the confirmation of the highest total price of the first element of the sale from an employee
    @Test
    public void testStatisticControlEmp() throws ParseException {
        System.out.println("statisticControlEmp");
        Date a = new SimpleDateFormat("yyyy-MM-dd").parse("2020-4-5");
        Date b = new SimpleDateFormat("yyyy-MM-dd").parse("2020-4-8");
        int c = 1234;
        String expResult = "954.9";
        ArrayList <Object[]> result = statisticon.statisticControlEmp(a, b, c);
        assertEquals(expResult, result.get(0)[3].toString());
    }
    //test the confirmation of the third element of the list of the employees has the right name
    @Test
    public void testListaEmployeeStatistics() {
        System.out.println("listaEmployeeStatistics");
        StatisticCon instance = new StatisticCon();
        String expResult ="PIATIDIS MIXAIL 4139";
        ArrayList<String> result = statisticon.listaEmployeeStatistics();
        assertEquals(expResult, result.get(2));
    }
    
}
