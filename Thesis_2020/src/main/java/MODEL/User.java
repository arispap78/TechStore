package MODEL;

import java.io.Serializable;
import java.util.Random;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class User implements Serializable
{
    @Column(name = "NAME", unique = false, nullable = false,length = 15)
    String name;
    @Column(name = "SURNAME", unique = false, nullable = false,length = 15)
    String surname;   
    @Id
    @Column(name = "REGISTRATION_NUMBER", unique = true, nullable = false,length = 15)
    int registryNumber;
    @Column(name = "USERNAME", unique = true, nullable = false,length = 15)
    String username;
    @Column(name = "PASSWORD", unique = true, nullable = false,length = 15)
    String password;
    @Column(name = "TELEPHONE", unique = true, nullable = false,length = 15)
    String phone;
    @Column(name = "EMAIL", unique = true, nullable = false,length = 50)
    String email;
    //it is not a column in the table in the database
    @Transient
    Random rand = new Random(); 
    

    public User(String name, String surname, String username, String password, String phone, String email) 
    {
        this.name = name;
        this.surname = surname;  
        //ο αριθμός θα είναι τετραψήφιος
        this.registryNumber = rand.nextInt(8999)+1000;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }
    public User()
    {
        //the number will have 4 digits
        this.registryNumber = rand.nextInt(8999)+1000;
    }


    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getSurname() 
    {
        return surname;
    }

    public void setSurname(String surname) 
    {
        this.surname = surname;
    }

    public int getRegistryNumber() 
    {
        return registryNumber;
    }

    public void setRegistryNumber(int registryNumber) 
    {
        this.registryNumber = registryNumber;
    }

    public String getUsername() 
    {
        return username;
    }

    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPhone() 
    {
        return phone;
    }

    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    //save the user
    public abstract boolean saveUser();
    //check if he/she is a product manager
    public abstract boolean isIsProistamenos();
    
    
    @Override
    public String toString() 
    {
        return "User{" + "name=" + name + ", surname=" + surname + ", registryNumber=" + registryNumber + ", username=" + username + ", password=" + password + ", phone=" + phone + ", email=" + email + '}';
    }

}
