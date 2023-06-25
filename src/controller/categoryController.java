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
import model.categoryDAO;
import model.categoryModel;
import view.categoryView;

/**
 *
 * author User
 */
public class categoryController implements ActionListener {
    private categoryModel mod;
    private categoryDAO modDAO;
    private categoryView stupage;
    private JTable jTable;
    private JButton addBtn;
    private JButton deleteBtn;
    private JButton updateBtn;
    private JButton viewbtn;
    private JButton refreshBtn;
    
    
    

    
    public categoryController(categoryModel mod, categoryDAO modDAO, categoryView stupage)
    {
        this.mod = mod;
        this.modDAO = modDAO;
        this.stupage = stupage;
        this.addBtn = addBtn;
        this.txtcategoryId=txtcategoryId;
       
        
        
        this.btnPrint.addActionListener(this);
        
        
        this.stupage.addBtn.addActionListener(this);
        this.stupage.updateBtn.addActionListener(this);
        this.stupage.deleteBtn.addActionListener(this);
        this.stupage.viewbtn.addActionListener(this);
        

        this.jTable = stupage.jTable;

    }
    
    public void start()
    {
        stupage.setTitle("Student Registration Page");
        stupage.setLocationRelativeTo(null);
        stupage.txtcategoryId.setVisible(true);
        refreshTable();
    }
    
    @Override
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == addbtn)
        {
            if (validateFields()) {
//                mod.setCategoryId(stupage.txtcategoryId.getText());
                mod.setCategoryName(stupage.txtcategoryName.getText());
                mod.setDescription(stupage.txtdescription.getText());
                
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
        
        if(e.getSource() == stupage.updateBtn)
        {
            if (validateFields()) {
                mod.setCategoryId(Integer.parseInt(stupage.txtcategoryId.getText()));
                mod.setCategoryName(stupage.txtcategoryName.getText());
                mod.setDescription(stupage.txtdescription.getText());
                
                
                
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
        
        if(e.getSource() == stupage.deleteBtn)
        {
            if (validateIDField()) {
                mod.setCategoryId(Integer.parseInt(stupage.txtcategoryId.getText()));
                
                
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
        
        if(e.getSource() == stupage.btnClear){
            clear();
        }
        
        if (e.getSource() == stupage.btnRefresh) {
            refreshTable();
        }
    }
    
    public void clear()
    {
        stupage.txtcategoryId.setText(null);
        stupage.txtcategoryName.setText(null);
        stupage.txtdescription.setText(null);
        
    }        
    
    private void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0); // Clear existing table data

        // Retrieve all students from the database
        categoryDAO studentDAO = new categoryDAO();
        List<categoryModel> students = studentDAO.getAllcategory(); 

        // Iterate through the students and add them to the table
        for (categoryModel student : students) {
            Object[] row = {student.getCategoryId(), student.getCategoryName(), student.getDescription()};
            model.addRow(row);
        }
    }    
    
    private boolean validateFields() {
        if (stupage.txtcategoryName.getText().isEmpty() || stupage.txtdescription.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all the fields.");
            return false;
        }
        
        try {
            Integer.parseInt(stupage.txtcategoryId.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "categoryId must be an integer.");
            return false;
        }
        
        
        return true;
    }
    
    private boolean validateIDField() {
        if (stupage.txtcategoryId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a category ID.");
            return false;
        }
        
        return true;
    }
}