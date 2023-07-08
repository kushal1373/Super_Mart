package DAO;

import database.DbConnection;
import model.BillingModel;
import view.billingform;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class BillingDAO extends DbConnection {
billingform view;
DefaultTableModel mode;
    int rowcount;
    private int selectedRow;
    
    public boolean add(BillingModel mod) {
        DefaultTableModel tablemodel = new DefaultTableModel();
        view.setTableModel(tablemodel);
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "binumaka008!");
             PreparedStatement pst = conn.prepareStatement("INSERT INTO product (billno, productid, productname, category, quantity, price) VALUES (?, ?, ?, ?, ?,?)")) {

            pst.setInt(1, mod.getBillno());
            pst.setInt(1, mod.getProductid());
            pst.setString(2, mod.getProductname());
            pst.setString(3, mod.getCategory());
            pst.setInt(4, mod.getQuantity());
            pst.setDouble(5, mod.getPrice());
           

//            int rowsAffected = pst.executeUpdate();
//            return rowsAffected > 0;
            mode.setRowCount(rowcount);
            rowcount++;
            Object[] rowData = {mod.getBillno(), mod.getProductid(), mod.getProductname(), mod.getQuantity(), mod.getCategory(), mod.getPrice()};
            mode.addRow(rowData); 
        } catch (SQLException e) {
            System.err.println(e);
        }

        return false;

//        String productId = productid.getText();
//        String productName = txtproductname.getText();
//        String quantity = txtquantity.getText();
//        String category = txtcategory.getSelectedItem().toString();
//        Double price = txtprice.getDouble();
//        
//
//        
    }

    public boolean delete(BillingModel mod) {
        DefaultTableModel tablemodel = new DefaultTableModel();
        view.setTableModel(tablemodel);
//        int selectedRow = billingTable.getSelectedRow();
//        mode.removeRow(selectedRow);
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "binumaka008!");
             PreparedStatement pst = conn.prepareStatement("DELETE FROM product WHERE productid = ?")) {

            pst.setInt(1, mod.getProductid());

//            int rowsAffected = pst.executeUpdate();
//            return rowsAffected > 0;
            mode.setRowCount(rowcount);
            rowcount--;
            Object[] rowData = {mod.getBillno(), mod.getProductid(), mod.getProductname(), mod.getQuantity(), mod.getCategory(), mod.getPrice()};
            
            mode.removeRow(selectedRow);
        } catch (SQLException e) {
            System.err.println(e);
        }

        return false;
    }

    public boolean update(BillingModel mod) {
        DefaultTableModel tablemodel = new DefaultTableModel();
        view.setTableModel(tablemodel);
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "binumaka008!");
             PreparedStatement pst = conn.prepareStatement("UPDATE product SET productname = ?, category = ?, quantity = ?, price = ? WHERE productid = ?")) {

            pst.setString(1, mod.getProductname());
            pst.setString(2, mod.getCategory());
            pst.setInt(3, mod.getQuantity());
            pst.setDouble(4, mod.getPrice());
            pst.setInt(5, mod.getProductid());

//            int rowsAffected = pst.executeUpdate();
//            return rowsAffected > 0;
              mode.setValueAt(mod.getProductid(), selectedRow, 0);
              mode.setValueAt(mod.getProductname(), selectedRow, 1);
              mode.setValueAt(mod.getQuantity(), selectedRow, 2);
              mode.setValueAt(mod.getCategory(), selectedRow, 3);
              mode.setValueAt(mod.getPrice(), selectedRow, 4);
              
        } catch (SQLException e) {
            System.err.println(e);
        }

        return false;
    }

    public DefaultTableModel getBillingTableModel() throws SQLException {
        DefaultTableModel tableModel = new DefaultTableModel();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "binumaka008!");
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM product");
             ResultSet rs = ps.executeQuery()) {

            tableModel.addColumn("productid");
            tableModel.addColumn("productname");
            tableModel.addColumn("category");
            tableModel.addColumn("quantity");
            tableModel.addColumn("price");

            while (rs.next()) {
                int productid = rs.getInt("productid");
                String productname = rs.getString("productname");
                String category = rs.getString("category");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");

                tableModel.addRow(new Object[]{productid, productname, category, quantity, price});
            }
        } catch (SQLException e) {
            throw e;
        }

        return tableModel;
    }
}
