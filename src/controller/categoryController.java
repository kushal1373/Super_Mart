package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import model.categoryModel;
import DAO.categoryDAO;
import javax.swing.JOptionPane;
import view.categoryView;

public class categoryController {
    private categoryModel model;
    private categoryView view;
    private categoryDAO dao;
    
    public categoryController(categoryView view, String button) {
        this.view = view;
        this.dao = new categoryDAO();
        
                if (button.equals("add")){
            new categoryController.categoryListener().actionPerformed();
        }else if (button.equals("delete")){
            new categoryController.deleteListener().actionPerformed();
        }
        else if (button.equals("update")){
            new categoryController.updateListener().actionPerformed();
        }
        else if (button.equals("view")){
            new categoryController.viewListener().actionPerformed();
        }
        
    }
    
    class categoryListener {
        public void actionPerformed() {
            try {
                model = view.getUser();
                addCategory(model);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        public void addCategory(categoryModel model) {
            boolean success = dao.add(model);
            if (success) {
                System.out.println("Category added successfully.");
                JOptionPane.showMessageDialog(null, "Category added Successfully.");
            } else {
                System.out.println("Failed to add category.");
                JOptionPane.showMessageDialog(null, "Failed to add category.");
            }
        }
    }
        
    class deleteListener{
        public void actionPerformed() {
            try {
                model = view.getUser();
                deleteCategory(model);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        public void deleteCategory(categoryModel model) {
            try {
                boolean success = dao.delete(model);
                if (success) {
                    System.out.println("Category deleted successfully.");
                    JOptionPane.showMessageDialog(null, "Category deleted successfully.");
                } else {
                    System.out.println("Failed to delete category.");
                    JOptionPane.showMessageDialog(null, "Failed to delete category.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    class updateListener{
        public void actionPerformed() {
            try {
                model = view.getUser();
                updateCategory(model);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        public void updateCategory(categoryModel model) {
            boolean success = dao.update(model);
            if (success) {
                System.out.println("Category updated successfully.");
                JOptionPane.showMessageDialog(null, "Category updated successfully.");
            } else {
                System.out.println("Failed to update category.");
                JOptionPane.showMessageDialog(null, "Failed to update category.");
            }
        }
    }
    
    class viewListener{
        public void actionPerformed() {
            try {
                viewCategories();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        public void viewCategories() {
            try {
                DefaultTableModel tableModel = dao.getCategoryTableModel();
                view.setTableModel(tableModel);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
