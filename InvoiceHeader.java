
package SIG.model;

import java.util.ArrayList;
import java.util.Date;


public class InvoiceHeader {
    
    private int num;
    private String customer;
    private String  date;
    private ArrayList <InvoiceLine> lines;

    public InvoiceHeader(int num, String customer, String date) {
        this.num = num;
        this.customer = customer;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public ArrayList <InvoiceLine> getLines() {
        return lines;
    }

    public void setLines(ArrayList <InvoiceLine> lines) {
        this.lines = lines;
    }
    
    
    
}
