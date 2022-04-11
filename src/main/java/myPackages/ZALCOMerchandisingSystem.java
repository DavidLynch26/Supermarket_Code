/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myPackages;

import java.io.File;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lynch
 */
public class ZALCOMerchandisingSystem extends javax.swing.JFrame{
    
    static Inventory inventory = new Inventory();
    static Supermarket supermarket = new Supermarket();
    static File invFile = new File("Inventory File.txt");
    static File managerCred = new File("Manager Credentials.txt");
    static File employeeCred = new File("Employee Credentials.txt");
    
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                try {
                    inventory.loadInventory(invFile.getName());
                } catch (ParseException ex) {
                    Logger.getLogger(ZALCOMerchandisingSystem.class.getName()).log(Level.SEVERE, null, ex);
                }
                new StartScreen().setVisible(true);
            }
        });
    }
}