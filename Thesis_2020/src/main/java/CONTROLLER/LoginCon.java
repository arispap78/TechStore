package CONTROLLER;

import MODEL.Employee;
import MODEL.ProductManager;

public class LoginCon 
{

    public LoginCon(){
    }

    //registration of a user
    public boolean registration(String name, String surname, String username, String password, String phone, String email,String inputR) 
    {
        //if the user input a key then he/she is a manager
        if(!inputR.isEmpty())
        {
            //create an instance of manager from the inputs
            ProductManager proistamenos=new ProductManager(inputR, name, surname, username, password, phone, email);
            return proistamenos.saveUser();           
        }       
        //else he/she is an employee
        else 
        {
            //create an instance of employee from the inputs
            Employee ipallilos=new Employee(name, surname, username, password, phone, email);
            return ipallilos.saveUser();
        }
    }
    
    //check if all the fields are filled for the registration
    public boolean nullMessageReg(String name, String surname, String username, String password, String phone, String email)
    {
        if(name.trim().isEmpty())
            return true;
        else if(surname.trim().isEmpty())
            return true;
        else if(username.trim().isEmpty())
            return true;
        else if(password.trim().isEmpty())
            return true;
        else if(email.trim().isEmpty())
            return true;
        else if(phone.trim().isEmpty())
            return true;
        else
            return false;
    }
    
    //check if all the fields are filled for the connection
    public boolean nullMessageLog(String username, String password)
    {  
        if(username.trim().isEmpty())
            return true;
        else if(password.trim().isEmpty())
            return true;
        else
            return false;
    }
    
    //check if there is an employee with these username and password and return the instance or null
    public Employee loginControlEmp( String username,String password)
    {
        Employee exist=Employee.loginEmp( username, password);
        return exist;
    }
    
    //check if there is a manager with these username and password and return the instance or null
    public ProductManager loginControlPro( String username, String password)
    {
        ProductManager exist=ProductManager.loginPro( username, password);
        return exist;
    }   
}
