/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Acer
 */
import database.DbConnection;
import java.sql.Connection;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.List;
import javax.swing.table.DefaultTableModel;
public class categoryDAO extends DbConnection {
    
    public boolean add(categoryModel mod) {
        PreparedStatement ps = null;
        Connection conn = dbConnect();

        try {
            String sql = "INSERT INTO category(categoryId, categoryName, description) VALUES (?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, mod.getCategoryId());
            ps.setString(2, mod.getCategoryName());
            ps.setString(3, mod.getDescription());
//            ps.setString(3, mod.getDescription());
            
            ps.execute();
            return true;

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        
        return false; // Added a default return statement outside the try-catch block
    }
    
    
    
    public boolean update(categoryModel mod) {
        PreparedStatement ps = null;
        Connection conn = dbConnect();

        String sql = "UPDATE category Set categoryId= ? , categoryName = ? WHERE description=?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, mod.getCategoryId());
            ps.setString(2, mod.getCategoryName());
            ps.setString(3, mod.getDescription());
            
            ps.execute();
            return true;

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        
        return false; // Added a default return statement outside the try-catch block
    }
    public boolean showData(categoryModel mod){
        DefaultTableModel dtm=null;
        Connection conn = dbConnect();
        PreparedStatement ps = null;
        String sql = "select * from category";
        try{
            ps = conn.prepareStatement(sql);
            
            dtm.setRowCount(0);
            ResultSet rs = ps.executeQuery(sql);
            while(rs.next())
            {
                dtm.addRow(new Object[]{rs.getInt("categoryId"),rs.getString("categoryName"),rs.getString("description")});
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false; // Added a default return statement outside the try-catch block
    }
    
    public boolean delete(categoryModel mod) {
        PreparedStatement ps = null;
        Connection conn = dbConnect();

        String sql = "DELETE FROM category WHERE categoryId=?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,mod.getCategoryId());
            ps.execute();
            return true;

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        
        return false; // Added a default return statement outside the try-catch block
    }

    public List<categoryModel> getAllcategory() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

