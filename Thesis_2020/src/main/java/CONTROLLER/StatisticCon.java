package CONTROLLER;

import MODEL.Employee;
import MODEL.Sale;
import java.util.ArrayList;
import java.util.Date;


public class StatisticCon 
{
    
    private Sale statistic=new Sale();
    private Employee employee=new Employee();
    
    //the sales of a specific time period
    public ArrayList <Object[]> statisticControl(Date a,Date b)
    {
        ArrayList <Object[]> lista=statistic.statisticSale(a, b);
        return lista;
    }
    
    //the sales of a specific period from an employee
    public ArrayList <Object[]> statisticControlEmp(Date a,Date b,int c)
    {
        ArrayList <Object[]> lista=statistic.statisticSaleEmp(a, b,c);
        return lista;
    }
    
    //list of the employees
    public ArrayList<String> listaEmployeeStatistics()
    {
         ArrayList <String> lista=employee.listaEmployee();
        return lista;
    }
}
