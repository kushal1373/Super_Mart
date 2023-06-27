package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import model.categoryModel;
import DAO.categoryDAO;
import view.categoryView;

public class categorycontroller {
    private categoryModel model;
    private categoryView view;
    private categoryDAO dao;
    
    public categorycontroller(categoryView view) {
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
                addCategory(model);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        public void addCategory(categoryModel model) {
            boolean success = dao.add(model);
            if (success) {
                System.out.println("Category added successfully.");
            } else {
                System.out.println("Failed to add category.");
            }
        }
    }
        
    class deleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
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
                } else {
                    System.out.println("Failed to delete category.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    class updateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
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
            } else {
                System.out.println("Failed to update category.");
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
