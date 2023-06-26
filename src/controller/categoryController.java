package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import model.categoryModel;
import model.categoryDAO;
import view.categoryView;

public class categoryController {
    private categoryModel model;
    private categoryView view;
    private categoryDAO dao;
    
    public categoryController(categoryView view) {
        this.view = view;
        this.dao = new categoryDAO();
        
        view.addcategoryListener(new categoryListener());
        view.adddeleteListener(new deleteListener());
        view.addupdateListener(new updateListener());
        view.addviewListener(new viewListener());
    }
    
    class categoryListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                model = view.getUser();
                if (addcategory(model)) {
                    view.setMessage("Success");
                } else {
                    view.setMessage("Error");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        public boolean addcategory(categoryModel category) throws Exception {
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "binumaka008!");
                 PreparedStatement pst = conn.prepareStatement("INSERT INTO category (categoryId, categoryName, description) VALUES (?, ?, ?)")) {

                pst.setInt(1, category.getCategoryId());
                pst.setString(2, category.getCategoryName());
                pst.setString(3, category.getDescription());

                int rowsAffected = pst.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException e) {
                throw e;
            }
        }
    }
    
    class deleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                model = view.getUser();
                if (deleteCategory(model)) {
                    view.setMessage("Success to delete");
                } else {
                    view.setMessage("Error");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        public boolean deleteCategory(categoryModel category) throws Exception {
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "binumaka008!");
                 PreparedStatement pst = conn.prepareStatement("DELETE FROM category WHERE categoryId = ?")) {

                pst.setInt(1, category.getCategoryId());

                int rowsAffected = pst.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException e) {
                throw e;
            }
        }
    }
    
    class updateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                model = view.getUser();
                if (updateCategory(model)) {
                    view.setMessage("Success to update");
                } else {
                    view.setMessage("Error");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        public boolean updateCategory(categoryModel category) throws Exception {
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "binumaka008!");
                 PreparedStatement pst = conn.prepareStatement("UPDATE category SET categoryName = ?, description = ? WHERE categoryId = ?")) {

                pst.setString(1, category.getCategoryName());
                pst.setString(2, category.getDescription());
                pst.setInt(3, category.getCategoryId());

                int rowsAffected = pst.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException e) {
                throw e;
            }
        }
    }
    
    class viewListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                viewCategories();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        public void viewCategories() throws Exception {
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "binumaka008!");
         PreparedStatement pst = conn.prepareStatement("SELECT * FROM category");
         ResultSet rs = pst.executeQuery()) {
        
        // Create a table model to hold the category data
        DefaultTableModel tableModel = new DefaultTableModel();
        
        // Add column names to the table model
        tableModel.addColumn("Category ID");
        tableModel.addColumn("Category Name");
        tableModel.addColumn("Description");
        
        // Process the result set and add the data to the table model
        while (rs.next()) {
            int categoryId = rs.getInt("categoryId");
            String categoryName = rs.getString("categoryName");
            String description = rs.getString("description");
            
            // Add the category data to the table model as a new row
            tableModel.addRow(new Object[] {categoryId, categoryName, description});
        }
        
        // Set the table model to the view's table
        view.setTableModel(tableModel);
    } catch (SQLException e) {
        throw e;
    }
}

        }
    }

