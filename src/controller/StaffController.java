package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.sql.*;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.StaffDAO;
import model.categoryModel;
import view.categoryView;

/**
 *
 * author User
 */
public class StaffController implements ActionListener {
    private StaffModel mod;
    private StaffDAO modDAO;
    private newstaffView stupage;
    private JTable jTable;
    private JButton bttnadd;
    private JButton bttndelete;
    private JButton bttnsearch;
    private JButton bttnview;
//    private JButton refreshBtn;
    
    
    

    
    public StaffController(StaffModel mod, StaffDAO modDAO, newstaff stupage)
    {
        this.mod = mod;
        this.modDAO = modDAO;
        this.stupage = stupage;
        this.bttnadd = bttnadd;
        this.txtstaffid=txtstaffid;
       
        
        
        this.btnPrint.addActionListener(this);
        
        
        this.stupage.bttnadd.addActionListener(this);
        this.stupage.bttnupdate.addActionListener(this);
        this.stupage.bttndelete.addActionListener(this);
        this.stupage.bttnview.addActionListener(this);
        

        this.jTable = stupage.jTable;

    }
    
    public void start()
    {
        stupage.setTitle("Student Registration Page");
        stupage.setLocationRelativeTo(null);
        stupage.txtstaffid.setVisible(true);
        refreshTable();
    }
    
    @Override
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == bttnadd)
        {
            if (validateFields()) {
//                mod.setCategoryId(stupage.txtcategoryId.getText());
                mod.setstaffname(stupage.txtstaffname.getText());
                mod.setposition(stupage.txtposition.getText());
                
                if(modDAO.add(mod))
                {
                    JOptionPane.showMessageDialog(null, "Added Successfully");
                    clear();
                    refreshTable();
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot be Added");
                    clear();
                }   
            }
            
        }
        
        if(e.getSource() == stupage.bttnupdate)
        {
            if (validateFields()) {
                mod.setstaffid(Integer.parseInt(stupage.txtstaffid.getText()));
                mod.setstaffname(stupage.txtstaffname.getText());
                mod.setposition(stupage.txtstaffposition.getText());
                
                
                
                if(modDAO.update(mod))
                {
                    JOptionPane.showMessageDialog(null, "Updated Successfully");
                    clear();
                    refreshTable();
                } else {
                    JOptionPane.showMessageDialog(null, "Error in Updating");
                    clear();
                }   
            }
            
        }
        
        if(e.getSource() == stupage.bttndelete)
        {
            if (validateIDField()) {
                mod.setstaffid(Integer.parseInt(stupage.txtstaffid.getText()));
                
                
                if(modDAO.delete(mod))
                {
                    JOptionPane.showMessageDialog(null, "Deleted Successfully");
                    clear();
                    refreshTable();
                } else {
                    JOptionPane.showMessageDialog(null, "Error in Deleting");
                    clear();
                    
                }   
            }
            
        }
        
        if(e.getSource() == stupage.btnSearch)
        {
            if (validateIDField()) {
                mod.setStudent_id(Integer.parseInt(stupage.txtID.getText())); 
                
                if(modDAO.search(mod))
                {
                    stupage.txtID.setText(String.valueOf(mod.getStudent_id()));
                    stupage.txtAddress.setText(mod.getAddress());
                    stupage.txtAge.setText(String.valueOf(mod.getAge()));
                    stupage.txtEmail.setText(mod.getEmail());
                    stupage.txtFirstName.setText(mod.getFirst_name());
                    stupage.txtLastName.setText(mod.getLast_name());
                    stupage.txtPhoneNumber.setText(mod.getPhone_number());
                   
                } else {
                    JOptionPane.showMessageDialog(null, "No Record Found");
                    clear();
                }   
            }
            
        }

        if (e.getSource() == btnPrint) {
            MessageFormat header = new MessageFormat("Students Information");
            MessageFormat footer = new MessageFormat("Page {0,number,integer}");

            try {
                jTable.print(JTable.PrintMode.NORMAL, header, footer);
            } catch (PrinterException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        if(e.getSource() == stupage.bttndelete){
            clear();
        }
        
        if (e.getSource() == stupage.btnRefresh) {
            refreshTable();
        }
    }
    
    public void clear()
    {
        stupage.txtstaffid.setText(null);
        stupage.txtstaffname.setText(null);
        stupage.txtpositon.setText(null);
        
    }        
    
    private void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0); // Clear existing table data

        // Retrieve all students from the database
        StaffDAO studentDAO = new StaffDAO();
        List<StaffModel> students = studentDAO.getAllStaff(); 

        // Iterate through the students and add them to the table
        for (StaffModel student : students) {
            Object[] row = {student.getstaffid(), student.getstaffname(), student.getposition()};
            model.addRow(row);
        }
    }    
    
    private boolean validateFields() {
        if (stupage.txtstaffname.getText().isEmpty() || stupage.txtposition.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all the fields.");
            return false;
        }
        
        try {
            Integer.parseInt(stupage.txtstaffid.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "StaffId must be an integer.");
            return false;
        }
        
        
        return true;
    }
    
    private boolean validateIDField() {
        if (stupage.txtstaffid.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a Staff ID.");
            return false;
        }
        
        return true;
    }
}