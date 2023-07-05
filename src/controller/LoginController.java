/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package controller;

 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import model.*;
import view.*;
import java.sql.*;
import javax.swing.JOptionPane;
public class LoginController {
    LoginModel model;
    LoginView view;
    ResultSet rs;
    Statement stmt;
    public LoginController(LoginView view)
    {
        this.view=view;

       new LoginListener().actionPerformed();



    }
    class LoginListener 
    {

 

       
        public void actionPerformed() {
            try
            {
                model=view.getUser();

                if(model.getUsername().isEmpty() || model.getPassword().isEmpty()){
                  JOptionPane.showMessageDialog(null,"This Box are Empty.", "ERROR",JOptionPane.ERROR_MESSAGE);
        }
                else if(model.getRole().equals("Manager"))
                {
                    view.setMessage("Login Successfully");
                    ManagerView MV = new ManagerView();
                    MV.show();       
                }
//                else
//                {
//                    view.setMessage("Invalid Username or Password or Role");  
//                }
//                
                else if(model.getRole().equals("Seller"))
                {
                    view.setMessage("Login Successfully");
                    billingform BF = new billingform();
                    BF.show();       
                }
                else
                {
                    view.setMessage("Invalid Username or Password or Role");  
                }
            }
            catch(Exception e1)
            {

            }

 

        }
        public boolean checkUser(LoginModel user) throws Exception
        {
             Class.forName("com.mysql.cj.jdbc.Driver");
               Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","9808640305@Sr");
          String sql="select * from register where username='"+user.getUsername()+"' AND password='"+user.getPassword()+"' AND role ='"+user.getRole()+"'";
          try
          {
            stmt=conn.createStatement();
             rs=stmt.executeQuery(sql);
             if(rs.next())
             {
                 return true;
             }
             conn.close();


          }
          catch(SQLException e2)
          {
              System.out.println(e2.getMessage());
          }         

            return false;
        }



    }

}