package CONTROLLER;

import MODEL.Mobile;
import MODEL.Television;
import MODEL.Laptop;
import MODEL.Camera;

public class AddProductCon 
{

    public AddProductCon() {
    }

    //check if the user has filled in all the required fields from the television menu
    public boolean nullMessageTel(String model, String brand, String sharpness, String price, String screen, String frequency, String smart, String year,String quantity)
    {        
        if(model.trim().isEmpty())
            return true;
        else if(brand.trim().isEmpty())
            return true;
        else if(sharpness.trim().isEmpty())
            return true;
        else if(price.trim().isEmpty())
            return true;
        else if(screen.trim().isEmpty())
            return true;
        else if(frequency.trim().isEmpty())
            return true;
        else if(smart.trim().isEmpty())
            return true;
        else if(year.trim().isEmpty())
            return true;
        else if(quantity.trim().isEmpty())
            return true;
        else
            return false;
    }
    
    //save the instance of television class from the input data of the user
    public boolean addTelevisionCon(String model, String brand, String sharpness, String price, String screen, String frequency, String smart, String year,String quantity)
    {
        //convert the inputs to integers
        double priceI= Double.parseDouble(price);
        double screenI= Double.parseDouble(screen);
        int frequencyI=Integer.parseInt(frequency);
        int yearI= Integer.parseInt(year);
        int smartT=Integer.parseInt(smart);
        int quantityI=Integer.parseInt(quantity);
        //convert to boolean 
        boolean smartTB=false;
        if(smartT>0)
            smartTB=true;
        //create an instance television from the input data
        Television television=new Television(model,  screenI,  frequencyI, smartTB, sharpness, priceI, brand, yearI,quantityI);
        //check if the data has saved in the database
        return television.saveData();         
    }
    
    //check if the user has filled in all the required fields from the Camera menu
    public boolean nullMessageCam(String model, String brand, String megapixel, String price, String screen, String memorytype, String image, String year,String quantity)
    {
        if(model.trim().isEmpty())
            return true;
        else if(brand.trim().isEmpty())
            return true;
        else if(megapixel.trim().isEmpty())
            return true;
        else if(price.trim().isEmpty())
            return true;
        else if(screen.trim().isEmpty())
            return true;
        else if(memorytype.trim().isEmpty())
            return true;
        else if(image.trim().isEmpty())
            return true;
        else if(year.trim().isEmpty())
            return true;
        else if(quantity.trim().isEmpty())
            return true;
        else
            return false;
    }
    
    //save the instance of camera class from the input data of the user
    public boolean addCameraCon(String model, String brand, String megapixel, String price, String screen, String memorytype, String image, String year,String quantity)
    {
        //convert the inputs to integers
        double priceI= Double.parseDouble(price);
        double screenI= Double.parseDouble(screen);
        double megapixelI= Double.parseDouble(megapixel);
        int yearI= Integer.parseInt(year);
        int quantityI=Integer.parseInt(quantity);
        //create an instance camera from the input data
        Camera camera=new Camera(model, screenI,  megapixelI, image, memorytype, priceI, brand, yearI,quantityI);
        //check if the data has saved in the database
        return camera.saveData();       
    }
    
    //check if the user has filled in all the required fields from the mobile menu
    public boolean nullMessageMob(String model, String brand, String memory, String price, String screen, String battery, String ram, String year, String os, String cpu,String quantity)
    {
        if(model.trim().isEmpty())
            return true;
        else if(brand.trim().isEmpty())
            return true;
        else if(memory.trim().isEmpty())
            return true;
        else if(price.trim().isEmpty())
            return true;
        else if(screen.trim().isEmpty())
            return true;
        else if(battery.trim().isEmpty())
            return true;
        else if(ram.trim().isEmpty())
            return true;
        else if(year.trim().isEmpty())
            return true;
         else if(os.trim().isEmpty())
            return true;
        else if(cpu.trim().isEmpty())
            return true;
        else if(quantity.trim().isEmpty())
            return true;
        else
            return false;
    }
    
    //save the instance of mobile class from the input data of the user
    public boolean addMobileCon(String model, String brand, String memory, String price, String screen, String battery, String ram, String year, String os, String cpu,String quantity)
    {
        //convert the inputs to integers
        double priceI= Double.parseDouble(price);
        double screenI= Double.parseDouble(screen);
        int yearI= Integer.parseInt(year);
        int ramI= Integer.parseInt(ram);
        int batteryI= Integer.parseInt(battery);
        int memoryI= Integer.parseInt(memory);
        int quantityI=Integer.parseInt(quantity);
        //create an instance mobile from the input data
        Mobile mobile=new Mobile(model, screenI, ramI, batteryI, memoryI, cpu, os, priceI, brand, yearI,quantityI);
        //check if the data has saved in the database
        return mobile.saveData();     
    }
    
    //check if the user has filled in all the required fields from the laptop menu
    public boolean nullMessageLap(String model, String brand, String memory, String price, String screen, String weight, String ram, String year, String os, String cpu,String quantity)
    {
        if(model.trim().isEmpty())
            return true;
        else if(brand.trim().isEmpty())
            return true;
        else if(memory.trim().isEmpty())
            return true;
        else if(price.trim().isEmpty())
            return true;
        else if(screen.trim().isEmpty())
            return true;
        else if(weight.trim().isEmpty())
            return true;
        else if(ram.trim().isEmpty())
            return true;
        else if(year.trim().isEmpty())
            return true;
         else if(os.trim().isEmpty())
            return true;
        else if(cpu.trim().isEmpty())
            return true;
        else if(quantity.trim().isEmpty())
            return true;
        else
            return false;
    }
    
    //save the instance of laptop class from the input data of the user
    public boolean addLaptopCon(String model, String brand, String memory, String price, String screen, String weight, String ram, String year, String os, String cpu, String quantity)
    {
        //convert the inputs to integers
        double priceI= Double.parseDouble(price);
        double screenI= Double.parseDouble(screen);
        int yearI= Integer.parseInt(year);
        int ramI= Integer.parseInt(ram);
        int quantityI=Integer.parseInt(quantity);
        double weightI= Double.parseDouble(weight);
        int memoryI= Integer.parseInt(memory);
        //create an instance laptop from the input data
        Laptop laptop=new Laptop(model, screenI, ramI, weightI, memoryI, cpu, os, priceI, brand, yearI,quantityI);
        //check if the data has saved in the database
        return laptop.saveData();
    }
    
    //update the database for an existing television model(reduction)
    public boolean updateTelevisionCon(String model, String quantity)
    {
        Television television=new Television();
        return television.updateData(model, quantity);
    }
    
    //update the database for an existing television model(addition)
    public boolean updateAddTelevisionCon(String model, String quantity)
    {
        Television television=new Television();
        return television.updateAddData(model, quantity);
    }
    
    //update the database for an existing camera model(reduction)
    public boolean updateCameraCon(String model, String quantity)
    {
        Camera camera=new Camera();
        return camera.updateData(model, quantity);
    }
    
    //update the database for an existing camera model(addition) 
    public boolean updateAddCameraCon(String model, String quantity)
    {
        Camera camera=new Camera();
        return camera.updateAddData(model, quantity);
    }
    
    //update the database for an existing laptop model(reduction)
    public boolean updateLaptopCon(String model, String quantity)
    {
        Laptop laptop=new Laptop();
        return laptop.updateData(model, quantity);
    }
    
    //update the database for an existing laptop model(addition)
    public boolean updateAddLaptopCon(String model, String quantity)
    {
        Laptop laptop=new Laptop();
        return laptop.updateAddData(model, quantity);
    }
    
    //update the database for an existing mobile model(reduction)
    public boolean updateMobileCon(String model, String quantity)
    {
        Mobile mobile=new Mobile();
        return mobile.updateData(model, quantity);
    }
    
    //update the database for an existing mobile model(addition) 
    public boolean updateAddMobileCon(String model, String quantity)
    {
        Mobile mobile=new Mobile();
        return mobile.updateAddData(model, quantity);
    }
}
