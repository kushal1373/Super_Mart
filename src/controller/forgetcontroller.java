package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.forgetmodel;
import view.forgetpassword;

public class forgetcontroller {
    private forgetmodel model;
    private forgetpassword view;

    public forgetcontroller(forgetpassword view) {
        this.view = view;
        new forgetListener().actionPerformed();
    }

    class forgetListener  {
       
        public void actionPerformed() {
            
            try {
                model = view.getUser();
                if(model.getUsername().isEmpty() || model.getNewpassword().isEmpty()){
                  JOptionPane.showMessageDialog(null,"This Box are Empty.", "ERROR",JOptionPane.ERROR_MESSAGE);
        }     else if (!model.getNewpassword().equals(model.getConfirmpassword())) {
            JOptionPane.showMessageDialog(null, "Password Mismatch.", "Error", JOptionPane.ERROR_MESSAGE);
               } else {
            if (checkUser(model)) {
                view.setMessage("reset Successfully");
            } else {
                view.setMessage("Error");
            }
        }
    } catch (Exception e1) {
    }      
            }

    public boolean checkUser(forgetmodel user) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root",
                    "9808640305@Sr");

            String sql = "SELECT * FROM register WHERE username=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String updateSql = "UPDATE register SET password=? WHERE username=?";
                PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                updateStmt.setString(1, user.getNewpassword());
                updateStmt.setString(2, user.getUsername());
                updateStmt.executeUpdate();
                updateStmt.close();
                conn.close();
                return true;
            }

            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    }
}
