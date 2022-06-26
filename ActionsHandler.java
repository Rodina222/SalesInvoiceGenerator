
package SIG.controller;

import SIG.model.InvoiceHeader;
import SIG.model.InvoiceLine;
import SIG.view.InvoiceFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class ActionsHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
       System.out.println("Action Handelling Called");
       switch (e.getActionCommand()){
           case "New Invoice":
           System.out.println("New Invoice");
           New_Invoice();
           break;
           
           case "Delete Invoice":
           System.out.println("Delete Invoice");
           Delete_Invoice();
           break;
           
           case "New Item":
           System.out.println("New Item");
           New_Item();
           break;
                   
           case "Delete Item":
           System.out.println("Delete Item");
           Delete_Item();
           break;
           
           case "Load File":
           System.out.println("Load File");
           {
               try {
                   Load_File();
               } catch (IOException ex) {
                   Logger.getLogger(ActionsHandler.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
           break;

           
           case "Save File":
           System.out.println("Save File");
           Save_File();
           break;
       }
    }

    private void New_Invoice() {
      
    }

    private void Delete_Invoice() {
        int invoice_index= HeadersTable.getSelectedRow();
        InvoiceHeader header = invoiceHeaderTabelMode1.getInvoiceList().get(invoice_index);
        invoiceHeaderTabelMode1.getInvoicesList().remove(invoice_index);
        invoiceHeaderTabelMode1.fireTableDataChanged();
        invoiceHeaderTabelMode1 = new invoiceHeaderTabelMode1(new ArrayList<InvoiceLine>())
        invLinesTable.setMode1(invoiceHeaderTabelMode1);
        invoiceHeaderTabelMode1.fireTableDataChanged();
        
       
   }
     private void Delete_Item() {
      int Line_index= HeadersTable.getSelectedRow();
      InvoiceHeader header = invoiceLineTabelMode1.getInvoiceLines().get(Line_index);
      invoiceLineTabelMode1.getInvoicesList().remove(Line_index);
        invoiceLineTabelMode1.fireTableDataChanged();
        invoiceHeaderTabelMode1.fireTableDataChanged();
        invoiceLineTabelMode1 = new invoiceLineTabelMode1(new ArrayList<InvoiceLine>())
        invLinesTable.setMode1(invoiceLineTabelMode1);
        invoiceHeaderTabelMode1.fireTableDataChanged();
        
        
    }


    private void New_Item() {
       
    }

   
    private void Load_File() throws FileNotFoundException, IOException {
    
       InvoiceFrame frame= new InvoiceFrame();
        JOptionPane.showMessageDialog(frame, "Please! select a headerFile!","Atenntion",JOptionPane.WARNING_MESSAGE);
         JFileChooser openFile= new JFileChooser();
         int Open_result= openFile.showOpenDialog(frame);
         if(Open_result == JFileChooser.APPROVE_OPTION)
         {
             File headerFile = openFile.getSelectedFile();
             try {
                 FileReader header= new FileReader(headerFile);
                 BufferedReader headerBr = new BufferedReader(header);
                 String Headerline= null;
                 
                 while((Headerline = headerBr.readLine())!= null )
                 {
                     String [] headerParts = Headerline.split(",");
                     String InvNumStr = headerParts[0];
                     String InvDateStr = headerParts[1];
                     String InvCustName = headerParts[2];
                     
                     int invNum =Integer.parseInt(InvNumStr);
                      
                     InvoiceHeader invoice = new InvoiceHeader(invNum,InvCustName,InvDateStr) ;
                     InvoicesList.add(invoice);
                     
                 }
                 
             } 
             catch(Exception ex){
                 ex.printStackTrace();
             }
              
         }
    }
    

    private void Save_File() {
        
        
        
        
    }
    
}
