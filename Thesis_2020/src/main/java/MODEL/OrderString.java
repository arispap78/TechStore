package MODEL;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Entity
@Table(name = "ORDER_PRODUCT")
public class OrderString implements Serializable 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)        
    int id;
    @Column(name = "PRODUCT", unique = false, nullable = false,length = 50)
    String proin=null;
    @ManyToOne
    @JoinColumn(name="ORDER", unique = false, nullable = false)
    Order orderProin=null;


    public OrderString() {
    }

    public OrderString(String proin) {
        this.proin = proin;
    }
    
    public OrderString(String proin, Order orderProin) {
        this.proin = proin;
        this.orderProin = orderProin;
    }


    public String getProin() {
        return proin;
    }

    public void setProin(String proin) {
        this.proin = proin;
    }

    public Order getOrderProin() {
        return orderProin;
    }

    public void setOrderProin(Order orderProin) {
        this.orderProin = orderProin;
    }
    
    //save the product of an order in the database
    public boolean saveOrdString()
    {
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

    @Override
    public String toString() {
        return "ProductString{" + "id=" + id + ", proin=" + proin + '}';
    }  
}