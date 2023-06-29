package DAO;

import database.DbConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import model.categoryModel;


public class categoryDAO extends DbConnection {

    public boolean add(categoryModel mod) {
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "9808640305@Sr");
                 PreparedStatement pst = conn.prepareStatement("INSERT INTO category (categoryId, categoryName, description) VALUES (?, ?, ?)")) {

                pst.setInt(1, mod.getCategoryId());
                pst.setString(2, mod.getCategoryName());
                pst.setString(3, mod.getDescription());

                int rowsAffected = pst.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException e) {
                 System.err.println(e);
        }

        return false;
    } 
    
    public boolean delete(categoryModel mod)  {
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "9808640305@Sr");
                 PreparedStatement pst = conn.prepareStatement("DELETE FROM category WHERE categoryId = ?")) {

                pst.setInt(1, mod.getCategoryId());

                int rowsAffected = pst.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException e) {
                System.err.println(e);
        }

        return false;
    }
    
     public boolean update(categoryModel mod)  {
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "9808640305@Sr");
                 PreparedStatement pst = conn.prepareStatement("UPDATE category SET categoryName = ?, description = ? WHERE categoryId = ?")) {

                pst.setString(1, mod.getCategoryName());
                pst.setString(2, mod.getDescription());
                pst.setInt(3, mod.getCategoryId());

                int rowsAffected = pst.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException e) {
               System.err.println(e);
        }

        return false;
    }

    

  public DefaultTableModel getCategoryTableModel() throws SQLException {
        DefaultTableModel tableModel = new DefaultTableModel();
        
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "9808640305@Sr");

             PreparedStatement ps = conn.prepareStatement("SELECT * FROM category");
             ResultSet rs = ps.executeQuery()) {
            
            
            tableModel.addColumn("Category ID");
            tableModel.addColumn("Category Name");
            tableModel.addColumn("Description");
            
      
            while (rs.next()) {
                int categoryId = rs.getInt("categoryId");
                String categoryName = rs.getString("categoryName");
                String description = rs.getString("description");
                
           
                tableModel.addRow(new Object[] {categoryId, categoryName, description});
            }
        } catch (SQLException e) {
            throw e;
        }
        
        return tableModel;
    }
}
