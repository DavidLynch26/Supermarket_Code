/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package myPackages;

import myPackages.Inventory;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lynch
 */
public class ReportPage extends javax.swing.JFrame {

    public ReportPage(){
        initComponents();
        try {
            initReportLists();
        } catch (ParseException ex) {
            Logger.getLogger(ReportPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initReportLists() throws ParseException{
        loadElements();
    }
    
    public void loadElements() throws ParseException{
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for(int count = 0;count <= ZALCOMerchandisingSystem.inventory.Name.size()-1; count++){
            String name = ZALCOMerchandisingSystem.inventory.getName(count);
            String date = dateFormat.format(ZALCOMerchandisingSystem.inventory.getExpiryDate(count));
            
            addRow(name, date);
            addComboItem(name);
        }        
    }
    
    public void deleteArrayList(int pos) throws IOException{
        ZALCOMerchandisingSystem.inventory.Name.remove(pos);
         
        DefaultTableModel model = (DefaultTableModel) ExpiryInformationTable.getModel();
        model.removeRow(pos);        
        
        addToFile();
    }
    
    public void addToFile() throws IOException{
        FileWriter writer = new FileWriter(ZALCOMerchandisingSystem.invFile);//making new filewritter to override file content
        writer.close();
        writer = new FileWriter(ZALCOMerchandisingSystem.invFile, true);         
        
        for(int count  = 0; count <= ZALCOMerchandisingSystem.inventory.Name.size()-1; count ++){
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String [] Items = {ZALCOMerchandisingSystem.inventory.getName(count), dateFormat.format(ZALCOMerchandisingSystem.inventory.getExpiryDate(count))};
            
            writer.write(Items[0] + ";" + Items[1] + "\n");
        }
        writer.close();
    }
    
    public void addElement(String name, String date) throws ParseException, IOException{
        addRow(name, date);
        addComboItem(name);
        addArrayList(name, date);
        ProductNameTextField.setText("");
        ExpiryDateTextField.setText("");
    }
    
    public void addArrayList(String name, String date) throws ParseException, IOException{
        ZALCOMerchandisingSystem.inventory.Name.add(name);
        ZALCOMerchandisingSystem.inventory.expiryDate.add(new SimpleDateFormat("dd/MM/yyyy").parse(date));
        
        addToFile();
    }
    
    public void addRow(String name, String date) throws ParseException{
        DefaultTableModel model = (DefaultTableModel) ExpiryInformationTable.getModel();
        model.addRow(new Object[]{name, date});
    }
    
    public void addComboItem(String name){
        ItemChooser.addItem(name);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        BackButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        ExpiryDateTextField = new javax.swing.JTextField();
        SaveButton = new javax.swing.JButton();
        ProductExpiryDateTextField = new javax.swing.JLabel();
        ProductNameTextField = new javax.swing.JTextField();
        ProductNameLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ExpiryInformationTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        DeleteButton = new javax.swing.JButton();
        ItemChooser = new javax.swing.JComboBox<>();
        ChooseDeleteLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Expiry eport");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("frame 1"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        BackButton.setText("Back");
        BackButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Update Expiry Information"));

        SaveButton.setText("Save");
        SaveButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        SaveButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        ProductExpiryDateTextField.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ProductExpiryDateTextField.setText("Product Expiry Date:");

        ProductNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ProductNameLabel.setText("Product Name:");

        ExpiryInformationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [] [] {},
            new String [] {
                "Name", "Expiry Date"
            }
        ));
        jScrollPane2.setViewportView(ExpiryInformationTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ProductExpiryDateTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ProductNameLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ProductNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ExpiryDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(SaveButton)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ProductNameLabel)
                            .addComponent(ProductNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ProductExpiryDateTextField)
                            .addComponent(ExpiryDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SaveButton))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Delete Expiry Information"));

        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        ItemChooser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        ItemChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemChooserActionPerformed(evt);
            }
        });

        ChooseDeleteLabel.setText("Choose an item to delete");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ChooseDeleteLabel)
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(DeleteButton)
                    .addComponent(ItemChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ChooseDeleteLabel)
                    .addComponent(ItemChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(DeleteButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(190, Short.MAX_VALUE)
                .addComponent(BackButton)
                .addGap(189, 189, 189))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BackButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new ManagerMenu().setVisible(true);
    }//GEN-LAST:event_BackButtonActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        // TODO add your handling code here:
        if (ProductNameTextField.getText().equals("") || ExpiryDateTextField.getText().equals("")){
            JOptionPane.showMessageDialog(jOptionPane1, "Please ensure that all text fields are filed", "Invalid Input", JOptionPane.WARNING_MESSAGE);
        }else if(Inventory.isDate(ExpiryDateTextField.getText()) == false){
            JOptionPane.showMessageDialog(jOptionPane1, "Please ensure that the date is in the correct format", "Invalid Date", JOptionPane.WARNING_MESSAGE);
        }else{
            try {
                try {
                    addElement(ProductNameTextField.getText(), ExpiryDateTextField.getText());
                } catch (IOException ex) {
                    Logger.getLogger(ReportPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ParseException ex) {
                Logger.getLogger(ReportPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        // TODO add your handling code here:
        if(ItemChooser.getSelectedItem() == null){
            JOptionPane.showMessageDialog(jOptionPane1, "Please select an item from the list", "No selected Item", JOptionPane.WARNING_MESSAGE);
        }else{
            try {
                deleteArrayList(ItemChooser.getSelectedIndex());
            } catch (IOException ex) {
                Logger.getLogger(ReportPage.class.getName()).log(Level.SEVERE, null, ex);
            }
            ItemChooser.getSelectedItem();
            ItemChooser.removeItem(ItemChooser.getSelectedItem());            
        }
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void ItemChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemChooserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ItemChooserActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReportPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JLabel ChooseDeleteLabel;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JTextField ExpiryDateTextField;
    private javax.swing.JTable ExpiryInformationTable;
    private javax.swing.JComboBox<String> ItemChooser;
    private javax.swing.JLabel ProductExpiryDateTextField;
    private javax.swing.JLabel ProductNameLabel;
    private javax.swing.JTextField ProductNameTextField;
    private javax.swing.JButton SaveButton;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}