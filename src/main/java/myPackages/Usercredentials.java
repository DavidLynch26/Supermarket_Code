/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myPackages;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author David
 */
public class Usercredentials {
    ArrayList<String> employeeUsername = new ArrayList<>();
    ArrayList<String> employeePassword = new ArrayList<>();
    ArrayList<String> managerUsername = new ArrayList<>();
    ArrayList<String> managerPassword = new ArrayList<>();
    
    Usercredentials() {
    }
    
    public void loadCredentials(String employeeFile, String managerFile){
        try{
            Scanner eScan = new Scanner(new File(employeeFile));
            while(eScan.hasNextLine()){
                String [] nextLine = eScan.nextLine().split(";");
                String employeeusername = nextLine[0];
                String employeepassword = nextLine[1];
                
                this.employeeUsername.add(employeeusername);
                this.employeePassword.add(employeepassword);
            }
            
        }catch(IOException e){}
        
        try{
            Scanner mScan = new Scanner(new File(managerFile));
            while(mScan.hasNextLine()){
                String [] nextLine = mScan.nextLine().split(";");
                String managerusername = nextLine[0];
                String managerpassword = nextLine[1];
                                
                this.managerUsername.add(managerusername);
                this.managerPassword.add(managerpassword);
                
            }  
        }catch(IOException e){}    
    }
    
    public String getEmployeeUsername(Integer pos){
        return this.employeeUsername.get(pos);
    }
    
    public String getEmployeePassword(Integer pos){
        return this.employeeUsername.get(pos);
    }
    
    public String getManagerUsername(Integer pos){
        return this.employeeUsername.get(pos);
    }
    
    public String getManagerPassword(Integer pos){
        return this.employeeUsername.get(pos);
    }
}
