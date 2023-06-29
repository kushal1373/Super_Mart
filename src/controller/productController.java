package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ProductModel;
import DAO.productDAO;
import view.ManageProduct;

public class productController {
    private ProductModel model;
    private ManageProduct view;
    private productDAO dao;
    
    public productController(ManageProduct view) {
        this.view = view;
        this.dao = new productDAO();
        
        view.addcategoryListener(new productListener());
        view.adddeleteListener(new deleteListener());
        view.addupdateListener(new updateListener());
        view.addviewListener(new viewListener());
    }
    
    class productListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                model = view.getUser();
                addproduct(model);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        public void addproduct(ProductModel model) {
            boolean success = dao.add(model);
            if (success) {
                System.out.println("product added successfully.");
                JOptionPane.showMessageDialog(null, "product added successfully.");
            } else {
                System.out.println("Failed to add product.");
                JOptionPane.showMessageDialog(null, "Failed to add product.");
            }
        }
    }
        
    class deleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                model = view.getUser();
                deleteproduct(model);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        public void deleteproduct(ProductModel model) {
            try {
                boolean success = dao.delete(model);
                if (success) {
                    System.out.println("delete Successfully");
                    JOptionPane.showMessageDialog(null, "delete Successfully");
                } else {
                    System.out.println("Failed to delete product.");
                    JOptionPane.showMessageDialog(null, " Failed to delete product ");
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
                updateproduct(model);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        public void updateproduct(ProductModel model) {
            boolean success = dao.update(model);
            if (success) {
                System.out.println("product updated successfully.");
                JOptionPane.showMessageDialog(null, " product update ");
            } else {
                System.out.println("Failed to update product.");
                JOptionPane.showMessageDialog(null, " Failed to update product ");
            }
        }
    }
    
    class viewListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                viewproduct();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        public void viewproduct() {
            try {
                DefaultTableModel tableModel = dao.getproductTableModel();
                view.setTableModel(tableModel);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
