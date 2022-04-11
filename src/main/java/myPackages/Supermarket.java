/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myPackages;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author CHIN
 */
public class Supermarket {
    ArrayList<String> Name = new ArrayList<>();
    ArrayList<Integer> tierNumber = new ArrayList<>();

    Supermarket(){
    }
    
    public void loadSupermarket(String supermarketFile) throws ParseException{                
        try{
            Scanner fScan = new Scanner(new File(supermarketFile));
            while(fScan.hasNextLine()){
                String [] nextLine = fScan.nextLine().split(";");
                String name = nextLine[0];
                Integer tierNumber = Integer.parseInt(nextLine[1]);
                
                this.Name.add(name);
                this.tierNumber.add(tierNumber);
            }
            
        }catch(IOException e){}
    }  
    
    public void setName(String supermarketName, int pos){
        this.Name.set(pos, supermarketName);
    }
    
    public void settierNumber(Integer tierNumber, int pos){
        this.tierNumber.set(pos, tierNumber);
    }
    
    public String getName(int pos){
        return this.Name.get(pos);
    }
    
    public Integer getTierNumber(int pos){
        return this.tierNumber.get(pos);
    }
}