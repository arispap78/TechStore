
package CONTROLLER;

import MODEL.Camera;
import MODEL.Laptop;
import MODEL.Mobile;
import MODEL.Product;
import MODEL.Television;
import java.util.ArrayList;

public class ShowProductCon 
{  
    private Camera camera=new Camera();
    private Television television=new Television();
    private Mobile mobile=new Mobile();
    private Laptop laptop=new Laptop();
    
    //ist of the camera models
    public ArrayList<String> getListaCam(String table)
    {
        ArrayList<String> models =camera.getLista(table);       
        return models;
    }
    
    //list of the television models
    public ArrayList<String> getListaTel(String table)
    {
        ArrayList<String> models =television.getLista(table);       
        return models;
    }
    
    //list of the mobile models
    public ArrayList<String> getListaMob(String table)
    {
        ArrayList<String> models =mobile.getLista(table);       
        return models;
    }
    
    //list of the laptop models
    public ArrayList<String> getListaLap(String table)
    {
        ArrayList<String> models =laptop.getLista(table);       
        return models;
    }
    
    //the choice of the user corresponds to the table in the database
    public String getTheTable(String a)
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
    
    /*find the chosen camera model from the database
    first argument the name of the model and second argument the name of the table*/
    public Product getChoosenModelCam(String a,String b)
    {
        return camera.getChoosenModel(a, b);       
    }
    
    /*find the chosen television model from the database
    first argument the name of the model and second argument the name of the table*/
    public Product getChoosenModelTel(String a,String b)
    {
        return television.getChoosenModel(a, b);      
    }
    
    /*find the chosen mobile model from the database
    first argument the name of the model and second argument the name of the table*/
    public Product getChoosenModelMob(String a,String b)
    {
        return mobile.getChoosenModel(a, b);      
    }
    
    /*find the chosen laptop model from the database
    first argument the name of the model and second argument the name of the table*/
    public Product getChoosenModelLap(String a,String b)
    {
        return laptop.getChoosenModel(a, b);    
    }
    
    //suggestion list of Television models
    public ArrayList<String> getSuggestionsTel(Television a)
    {
        //list of all the models
        ArrayList <Television> lista =a.getModelListTel();
        //list with the names of the models
        ArrayList<String> models = new ArrayList<>();
        //copy the lit of models to the list of the name of the models so they can be saved to the JList
        for(Television p:lista)
        {
            //copy the television models with screen  size bigger or smaller 10 inches from the chosen model
            if(((a.getScreen()-10)<p.getScreen())&&(!p.getModel().equals(a.getModel())))
                if(p.getScreen()<(a.getScreen()+10))
                    models.add(p.getBrand()+":"+p.getModel());          
        }
        return models;       
    }
    
    //suggestion list of Camera models
    public ArrayList<String> getSuggestionsCam(Camera a)
    {
        //list of all the models
        ArrayList <Camera> lista =a.getModelListCam();
        //list with the names of the models
        ArrayList<String> models = new ArrayList<>();
        //copy the lit of models to the list of the name of the models so they can be saved to the JList
        for(Camera p:lista)
        {
            //copy the camera models with the same screen size as the chosen model
            if((a.getScreen()==p.getScreen())&&(!p.getModel().equals(a.getModel())))
                models.add(p.getBrand()+":"+p.getModel());          
        }
        return models;       
    }
    
    //suggestion list of Mobile models
    public ArrayList<String> getSuggestionsMob(Mobile a)
    {
        //list of all the models
        ArrayList <Mobile> lista =a.getModelListMob();
        //list with the names of the models
        ArrayList<String> models = new ArrayList<>();
        //copy the lit of models to the list of the name of the models so they can be saved to the JList
        for(Mobile p:lista)
        {
            //copy the mobile models with the same RAM or same memory as the chosen model
            if(((a.getMemory()==p.getMemory()))||((a.getRam()==p.getRam())))
                if((!p.getModel().equals(a.getModel())))
                    models.add(p.getBrand()+":"+p.getModel());          
        }
        return models;       
    }
    
    //suggestion list of Laptop models
    public ArrayList<String> getSuggestionsLap(Laptop a)
    {
        //list of all the models
        ArrayList <Laptop> lista =a.getModelListLap();
        //list with the names of the models
        ArrayList<String> models = new ArrayList<>();
        //copy the lit of models to the list of the name of the models so they can be saved to the JList
        for(Laptop p:lista)
        {
            ////copy the laptop models with the same screen size as the chosen model
            if(((a.getScreen()==p.getScreen())))
                if((!p.getModel().equals(a.getModel())))
                    models.add(p.getBrand()+":"+p.getModel());          
        }
        return models;       
    }
}
