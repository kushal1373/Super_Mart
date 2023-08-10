
package model;
import javax.swing.event.TableModelEvent;
import javax.swing.table.TableModel;

public class ProductModel {
    String  productname,category;

    int productid,quantity;
    double price;
    public ProductModel(int productid, String productname, String category, int quantity, double price)
    {
        this.productid=productid;
        this.productname=productname;
        this.category=category;  
        this.quantity=quantity;
        this.price=price;
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
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    } 

}

