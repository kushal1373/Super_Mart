package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import model.StaffModel;
import model.staffDAO;
import view.newstaff;

public class StaffController {
    private StaffModel model;
    private newstaff view;
    private staffDAO dao;
  
    
    public StaffController(newstaff view) {
        this.view = view;
        this.dao = new staffDAO();
        
        view.addstaffListener(new StaffController.staffListener());
        view.adddeleteListener(new StaffController.deleteListener());
        view.addupdateListener(new StaffController.updateListener());
        view.addviewListener(new StaffController.viewListener());
        
    }
      
    
        class staffListener implements ActionListener {
             @Override
        public void actionPerformed(ActionEvent e) {
            try {
                model =view.getUser();
                if (addstaff(model)) {
                    view.setMessage("Success");
                } else {
                    view.setMessage("Error");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        public boolean addstaff(StaffModel staff) throws Exception {
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "9808640305@Sr");
                 PreparedStatement pst = conn.prepareStatement("INSERT INTO staff (staffid, staffname, position, gender) VALUES (?, ?, ?, ?)")) {

                pst.setInt(1, staff.getstaffid());
                pst.setString(2, staff.getstaffname());
                pst.setString(3, staff.getposition());
                pst.setString(4, staff.getgender());

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
                if (deletestaff(model)) {
                    view.setMessage("Success to delete");
                } else {
                    view.setMessage("Error");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        public boolean deletestaff(StaffModel staff) throws Exception {
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "9808640305@Sr");
                 PreparedStatement pst = conn.prepareStatement("DELETE FROM staff WHERE staffid = ?")) {

                pst.setInt(1, staff.getstaffid());

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
                if (updatestaff(model)) {
                    view.setMessage("Success to update");
                } else {
                    view.setMessage("Error");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        public boolean updatestaff(StaffModel staff) throws Exception {
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "908640305@Sr");
                 PreparedStatement pst = conn.prepareStatement("UPDATE staff SET staffame = ?, position = ?, gender = ?, WHERE staffid = ?")) {

                pst.setString(1, staff.getstaffname());
                pst.setString(2, staff.getposition());
                pst.setInt(3, staff.getstaffid());
                pst.setString(4,staff.getgender());

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
                viewStaff();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
            
        public void viewStaff() throws Exception {
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "9808640305@Sr");
         PreparedStatement pst = conn.prepareStatement("SELECT * FROM staff");
         ResultSet rs = pst.executeQuery()) {
        
        // Create a table model to hold the category data
        DefaultTableModel tableModel = new DefaultTableModel();
        
        // Add column names to the table model
        tableModel.addColumn("Staff ID");
        tableModel.addColumn("Staff Name");
        tableModel.addColumn("Position");
        tableModel.addColumn("Gender");
        
        // Process the result set and add the data to the table model
        while (rs.next()) {
            int staffid = rs.getInt("staffid");
            String staffname = rs.getString("staffname");
            String position = rs.getString("position");
            String gender = rs.getString("gender");
            
            // Add the category data to the table model as a new row
            tableModel.addRow(new Object[] {staffid, staffname, position, gender});
        }
        
        // Set the table model to the view's table
        view.setTableModel(tableModel);
    } catch (SQLException e) {
        throw e;
    }
}

        }
    }

