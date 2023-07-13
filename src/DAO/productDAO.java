package DAO;

import database.DbConnection;
import model.ProductModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class productDAO extends DbConnection {

    public boolean add(ProductModel mod) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "binumaka008!");
             PreparedStatement pst = conn.prepareStatement("INSERT INTO product (productid, productname, category, quantity, price) VALUES (?, ?, ?, ?, ?)")) {

            pst.setInt(1, mod.getProductid());
            pst.setString(2, mod.getProductname());
            pst.setString(3, mod.getCategory());
            pst.setInt(4, mod.getQuantity());
            pst.setDouble(5, mod.getPrice());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println(e);
        }

        return false;
    }

    public boolean delete(ProductModel mod) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "binumaka008!");
             PreparedStatement pst = conn.prepareStatement("DELETE FROM product WHERE productid = ?")) {

            pst.setInt(1, mod.getProductid());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println(e);
        }

        return false;
    }

    public boolean update(ProductModel mod) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "binumaka008!");
             PreparedStatement pst = conn.prepareStatement("UPDATE product SET productname = ?, category = ?, quantity = ?, price = ? WHERE productid = ?")) {

            pst.setString(1, mod.getProductname());
            pst.setString(2, mod.getCategory());
            pst.setInt(3, mod.getQuantity());
            pst.setDouble(4, mod.getPrice());
            pst.setInt(5, mod.getProductid());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println(e);
        }

        return false;
    }

    public DefaultTableModel getproductTableModel() throws SQLException {
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
     public ProductModel getProductById(int productId) {
    ProductModel product = null;

    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "binumaka008!");
         PreparedStatement pst = conn.prepareStatement("SELECT * FROM product WHERE productid = ?")) {

        pst.setInt(1, productId);

        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                int productid = rs.getInt("productid");
                String productname = rs.getString("productname");
                String category = rs.getString("category");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");

                product = new ProductModel(productid, productname, category, quantity, price);
            }
        }
    } catch (SQLException e) {
        System.err.println(e);
    }

    return product;
}
}
