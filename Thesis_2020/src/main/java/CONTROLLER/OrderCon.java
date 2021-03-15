package CONTROLLER;

import MODEL.Order;
import MODEL.ProductManager;
import java.util.List;

public class OrderCon 
{
    private Order order=new Order();

    //return the product manager with this id 
    public ProductManager confirmPro(int id)
    {
        ProductManager employeeCon=ProductManager.searchPro(id);    
        return employeeCon;      
    }
    
    //the choice of the user corresponds to the table in the database
    public String getTheTableOrder(String a)
    {
        String b=null;
        if(a=="TELEVISION")
        {
            b="Television";
            return b;
        }
        else if(a=="CAMERA")
        {
            b="Camera";
            return b; 
        }
        else if(a=="LAPTOP")
        {
            b="Laptop";
            return b; 
        }    
        else if(a=="MOBILE")
        {
            b="Mobile";
            return b; 
        }
        else
            return null;
    }
    
    //order list with the models
    public List<String> getListaOrderCon(String table)
    {
        //creation of the list with the models of the database
        List<String> models = order.getListaOrder(table);
        return models;
    }
    
    //confirm that the order has saved in the database
    public boolean saveOrder(Order a)
    {
        return a.saveOrd();
    }
    
    //search of an order from the database
    public Order findOrd(String a)
    {
        Order ord=new Order();
        return ord.searchOrd(a);
    }

}
