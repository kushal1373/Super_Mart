package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.BillingModel;
import DAO.BillingDAO;
import view.billingform;

public class BillingController {
    private BillingModel model;
    private billingform view;
    private BillingDAO dao;
    
    public BillingController(billingform view, String button) {
        this.view = view;
        this.dao = new BillingDAO();
        
        if (button.equals("add")){
            new BillingController.billListener().actionPerformed();
        }
        else if (button.equals("delete")){
            new BillingController.deleteListener().actionPerformed();
        }
        else if (button.equals("update")){
            new BillingController.updateListener().actionPerformed();
        }
        else if (button.equals("view")){
            new BillingController.viewListener().actionPerformed();
        }
        
    }
    
    class billListener{
        public void actionPerformed() {
            try {
                model = view.getUser();
                addBilling(model);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        public void addBilling(BillingModel model) {
            boolean success = dao.add(model);
            if (success) {
                System.out.println("Billing added successfully.");
                JOptionPane.showMessageDialog(null, "Billing added successfully.");
            } else {
                System.out.println("Failed to add Billing.");
                JOptionPane.showMessageDialog(null, "Failed to add Billing.");
            }
        }
    }
        
    class deleteListener{
        public void actionPerformed() {
            try {
                model = view.getUser();
                deleteBilling(model);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        public void deleteBilling(BillingModel model) {
            try {
                boolean success = dao.delete(model);
                if (success) {
                    System.out.println("Delete successful");
                    JOptionPane.showMessageDialog(null, "Delete successful");
                } else {
                    System.out.println("Failed to delete Billing.");
                    JOptionPane.showMessageDialog(null, "Failed to delete Billing.");
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
                updateBilling(model);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        public void updateBilling(BillingModel model) {
            boolean success = dao.update(model);
            if (success) {
                System.out.println("Billing updated successfully.");
                JOptionPane.showMessageDialog(null, "Billing updated successfully.");
            } else {
                System.out.println("Failed to update Billing.");
                JOptionPane.showMessageDialog(null, "Failed to update Billing.");
            }
        }
    }
    
    class viewListener{
        public void actionPerformed() {
            try {
                viewBilling();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        public void viewBilling() {
            try {
                DefaultTableModel tableModel = dao.getBillingTableModel();
                view.setTableModel(tableModel);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
