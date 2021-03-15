
package CONTROLLER;

import MODEL.Camera;
import MODEL.Customer;
import MODEL.Employee;
import MODEL.Laptop;
import MODEL.Mobile;
import MODEL.Product;
import MODEL.ProductString;
import MODEL.Sale;
import MODEL.Television;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SaleCon 
{    
    private Sale sale=new Sale();
    private ProductString product=new ProductString();
    
    //return the employee with this id 
    public Employee confirmEmp(int id)
    {
        Employee employeeCon=Employee.searchEmp(id);    
        return employeeCon;      
    }
    
    //check if all the fields are filled
    public boolean nullMessageSale(String name, String surname, String email, String address, String product, String model)
    {
        if(name.trim().isEmpty())
            return true;
        else if(surname.trim().isEmpty())
            return true;
        else if(email.trim().isEmpty())
            return true;
        else if(address.trim().isEmpty())
            return true;
        else if(email.trim().isEmpty())
            return true;
        else if(product==null)
            return true;
        else if(model==null)
            return true;
        else
            return false;
    }
    
    //the choice of the user corresponds to the table in the database
    public String getTheTableSale(String a)
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
    
    //sale list with the models
    public List<String> getListaSaleCon(String table)
    {
        //creation of the list with the models of the database
        List<String> models =sale.getListaSale(table);
        return models;
    }

    //confirm the customer is saved in the database
    public boolean saveCustomer(Customer a)
    {
        return a.saveCus();
    }
    
    //confirm the sale is saved in the database
    public boolean saveSale(Sale a)
    {
        return a.saveSal();
    }
    
    //confirm the ProductString is saved in the database
    public boolean saveString(ProductString a)
    {
        boolean success=a.savePro();
        return success;
    }
    
    /*find the chosen model from the database
    first argument the name of the model and second argument the name of the table*/
    public Product getChoosenModelSaleCon(String a,String b)
    {
        //the chosen model
        Product chosenModel= Product.getChoosenModel(a,b);
        if(chosenModel!=null)
            return chosenModel;
        return null;     
    }   
    
    //update the database for an existing television model(reduction) 
    public boolean updateTelevisionCon(String model, String quantity)
    {
        Television television=new Television();
        return television.updateData(model, quantity);
    }
    
    //update the database for an existing camera model(reduction)
    public boolean updateCameraCon(String model, String quantity)
    {
        Camera camera=new Camera();
        return camera.updateData(model, quantity);
    }
    
    //update the database for an existing laptop model(reduction)
    public boolean updateLaptopCon(String model, String quantity)
    {
        Laptop laptop=new Laptop();
        return laptop.updateData(model, quantity);
    }
    
    //update the database for an existing mobile model(reduction)
    public boolean updateMobileCon(String model, String quantity)
    {
        Mobile mobile=new Mobile();
        return mobile.updateData(model, quantity);
    }
    
    //the sale lists of a specific date
    public ArrayList <Sale> findSaleList(Date a,Date b)
    {
        return sale.searchSaleList(a,b);
    }
    
    //find the models of a sale
    public ArrayList <ProductString> findProducts(String a)
    {
        return product.searchProducts(a);
    }
    
    //find the sale
    public Sale findSale(String a)
    {
        return sale.searchSale(a);
    }
    //list with the customers that made a sale
    public ArrayList<String> getListaCustomerSale()
    {
        Customer customer=new Customer();
        return customer.getListaCustomer();       
    }
    //the name of the customer that made the sale
    public Customer getCustomerSale(String a)
    {
        Customer customer=new Customer();
        return customer.getCustomer(a);
    }
}
