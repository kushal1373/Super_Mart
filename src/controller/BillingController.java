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
    
    public BillingController(billingform view) {
        this.view = view;
        this.dao = new BillingDAO();
        
        view.addBillingListener(new BillingListener());
        view.addDeleteListener(new DeleteListener());
        view.addUpdateListener(new UpdateListener());
        view.addViewListener(new ViewListener());
    }
    
    class BillingListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
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
        
    class DeleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
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
    
    class UpdateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
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
    
    class ViewListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
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
