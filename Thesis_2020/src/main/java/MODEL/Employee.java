package MODEL;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Entity
@Table(name = "EMPLOYEE")
public class Employee extends User
{
    //it is not a column in the table in the database
    @Transient
    private boolean isProistamenos=false;
 

    public Employee(String name, String surname, String username, String password, String phone, String email)
    {
        super(name, surname, username, password, phone, email);
    }
    public Employee(){
    }

    
    @Override
    public boolean isIsProistamenos() {
        return isProistamenos;
    }

    public void setIsProistamenos(boolean isProistamenos) {
        this.isProistamenos = isProistamenos;
    }

    
    //save the employee
    @Override
    public boolean saveUser()
    {
        //create and start the session
        SessionFactory factory = Main.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        try
        {    
            session.save(this);
        }
        catch(Exception ex)
        {
            session.getTransaction().rollback();
            ex.printStackTrace();
            return false;
        }
        session.getTransaction().commit();
        session.close();
        return true;    
    }
    
    //check if there is an employee with these username and password
    public static Employee loginEmp( String username, String password)
    {
        //the employee
        Employee employee =new Employee();
        //start and create the session
        SessionFactory factory = Main.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        try
        {
            //if there is an employee with this username
            Query query =session.createQuery("from Employee where username=:username");
            query.setParameter("username", username);
            employee = (Employee) query.uniqueResult();            
        }
        catch(Exception ex)
        {
            session.getTransaction().rollback();
            ex.printStackTrace();
            return null;
        }       
        //if there is an employee
        if(employee!=null)
        {
            //if the employee has the same password
            if(employee.getPassword().equals(password))
            {
                session.getTransaction().commit();
                session.close();
                return employee;
            }
            else
            {
                session.getTransaction().commit();
                session.close();
                return null; 
            }
        }
        else
        {
            session.getTransaction().commit();
            session.close();
            return null; 
        }
    }
    
    //search an employee with the id
    public static Employee searchEmp( int id)
    {
        //the employee
        Employee employee =new Employee();
        //start and create the session
        SessionFactory factory = Main.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        try
        {
            //if there is an employee in the database with this id
            Query query =session.createQuery("from Employee where id=:id");
            query.setParameter("id", id);
            employee = (Employee) query.uniqueResult();            
        }
        catch(Exception ex)
        {
            session.getTransaction().rollback();
            ex.printStackTrace();
        }         
        session.getTransaction().commit();
        session.close();
        return employee;
    }
    
    //the list of the employees
    public ArrayList<String> listaEmployee()
    {
        //list of the employees
        ArrayList<Employee> lista =new ArrayList<Employee>();
        //list with the string of the employees
        ArrayList<String> models = new ArrayList<>();
        //create and start the session
        SessionFactory factory = Main.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        try
        {
            //the list of the employees from the database
            Query query =session.createQuery("from Employee");
            lista = (ArrayList<Employee>) query.list();
        }
        catch(Exception ex)
        {
            session.getTransaction().rollback();
            ex.printStackTrace();
        }       
        //the list of the string for the JCombobox
        for(Employee a:lista)
            models.add(a.surname+" "+a.name+" "+a.registryNumber); 
        session.getTransaction().commit();
        session.close();
        return models;
    }
    
    @Override
    public String toString() 
    {
        return "EMPLOYEE{" + "name=" + name + ", surname=" + surname + ", registryNumber=" + registryNumber + ", username=" + username + ", password=" + password + ", phone=" + phone + ", email=" + email +  '}';
    }
    
    
}
