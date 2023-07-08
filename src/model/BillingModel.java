/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public class BillingModel {
    String  productname,category;

    int productid,quantity, Billno;
    double price;
    public BillingModel (int Billno,int productid, String productname, String category, int quantity, double price)
    {
        this.Billno=Billno;
        this.productid=productid;
        this.productname=productname;
        this.category=category;  
        this.quantity=quantity;
        this.price=price;
    } 

    public int getBillno() {
        return Billno;
    }

    public void setBillno(int Billno) {
        this.Billno = Billno;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity =quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

