package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.StaffModel;
import DAO.staffDAO;
import view.newstaff;

public class StaffController {
    private StaffModel model;
    private newstaff view;
    private staffDAO dao;
    
    public StaffController(newstaff view, String button) {
        this.view = view;
        this.dao = new staffDAO();

        if (button.equals("add")){
            new staffListener().actionPerformed();
        }else if (button.equals("delete")){
            new deleteListener().actionPerformed();
        }
        else if (button.equals("update")){
            new updateListener().actionPerformed();
        }
        else if (button.equals("view")){
            new viewListener().actionPerformed();
        }
    }
    
    class staffListener{
        
        public void actionPerformed() {
            try {
                model = view.getUser();
                addstaff(model);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        public void addstaff(StaffModel model) {
            boolean success = dao.add(model);
            if (success) {
                System.out.println("Staff added successfully.");
                JOptionPane.showMessageDialog(null, "Staff added successfully.");}
            else {
                    System.out.println("Failed to add staff.");
                    JOptionPane.showMessageDialog(null, "Failed to add staff.");
            }
        }
    }
        
    class deleteListener{
       
        public void actionPerformed() {
            try {
                model = view.getUser();
                deletestaff(model);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        public void deletestaff(StaffModel model) {
            try {
                boolean success = dao.delete(model);
                if (success) {
                    System.out.println("delete Successfully");
                    JOptionPane.showMessageDialog(null, "Staff delete Successfully");
                    } else {
                        System.out.println("Failed to delete staff.");
                        JOptionPane.showMessageDialog(null, " Failed to delete staff ");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    class updateListener {
        
        public void actionPerformed() {
            try {
                model = view.getUser();
                updatestaff(model);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        public void updatestaff(StaffModel model) {
            boolean success = dao.update(model);
            if (success) {
                System.out.println("Staff updated successfully.");
                JOptionPane.showMessageDialog(null, " Updated staff ");
                } else {
                    System.out.println("Failed to update staff.");
                    JOptionPane.showMessageDialog(null, " Failed to update staff ");
            }
        }
    }
    
    class viewListener  {
        
        public void actionPerformed() {
            try {
                viewstaff();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        public void viewstaff() {
            try {
                DefaultTableModel tableModel = dao.getstaffTableModel();
                view.setTableModel(tableModel);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
