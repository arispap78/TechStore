package MODEL;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Entity
@Table(name = "SALE_PRODUCT")
public class ProductString implements Serializable 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)        
    int id;
    @Column(name = "PRODUCT", unique = false, nullable = false,length = 50)
    String proin;
    @ManyToOne
    @JoinColumn(name="SALE", unique = true, nullable = false)
    Sale saleProin;


    public ProductString() {
    }

    public ProductString(String proin) {
        this.proin = proin;
    }
    
    public ProductString(String proin, Sale saleProin) {
        this.proin = proin;
        this.saleProin = saleProin;
    }


    public String getProin() {
        return proin;
    }

    public void setProin(String proin) {
        this.proin = proin;
    }

    public Sale getSaleProin() {
        return saleProin;
    }

    public void setSaleProin(Sale saleProin) {
        this.saleProin = saleProin;
    }
    
    //save the product of a sale
    public boolean savePro()
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
    
    //list of the products of a sale
    public ArrayList <ProductString> searchProducts(String a)
    {
        //list of the products
        ArrayList <ProductString> listaPro =new ArrayList <ProductString>();
        //create and start the session
        SessionFactory factory = Main.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        try
        {
            //the list of the products of a sale
            Query query =session.createQuery("from ProductString where saleProin.serialNumber =:dateA");
            query.setParameter("dateA", a);
            listaPro = (ArrayList)query.list();

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
        session.getTransaction().commit();
        session.close();
        return listaPro;  
    }

    @Override
    public String toString() {
        return "ProductString{" + "id=" + id + ", proin=" + proin + '}';
    }   
}
