/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myPackages;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;  

/**
 *
 * @author lynch
 */
public class Inventory {
    ArrayList<String> Name = new ArrayList<>();
    ArrayList<Date> expiryDate = new ArrayList<>();
    
    Inventory() {
    }
    
    public void loadInventory(String inventoryFile) throws ParseException{                
        try{
            Scanner fScan = new Scanner(new File(inventoryFile));
            while(fScan.hasNextLine()){
                String [] nextLine = fScan.nextLine().split(";");
                String name = nextLine[0];
                Date expirydate = new SimpleDateFormat("dd/MM/yyyy").parse(nextLine[1]);
                
                this.Name.add(name);
                this.expiryDate.add(expirydate);
            }
            
        }catch(IOException e){}
    }  
    
    public void setName(String name, int pos){
        this.Name.set(pos, name);
    }
    
    public void setExpiryDate(Date expirydate, int pos){
        this.expiryDate.set(pos, expirydate);
    }
    
    public String getName(int pos){
        return Name.get(pos);
    }
    
    public Date getExpiryDate(int pos){
        return expiryDate.get(pos);
    } 
    
    public static boolean isDate(String date){
        SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
        sdfrmt.setLenient(false);
        /* Create Date object
         * parse the string into date 
         */
        try
        {
            Date javaDate = sdfrmt.parse(date); 
            System.out.println(date+" is valid date format");
        }
        /* Date format is invalid */
        catch (ParseException e)
        {
            System.out.println(date+" is Invalid Date format");
            return false;
        }
        /* Return true if date format is valid */
        return true;       
    }
}