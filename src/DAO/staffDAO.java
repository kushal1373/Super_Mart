package DAO;

 

import database.DbConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import model.StaffModel;

 

 

public class staffDAO extends DbConnection {

 

    public boolean add(StaffModel mod) {
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "ajina kaya8860");
                 PreparedStatement pst = conn.prepareStatement("INSERT INTO staff (staffid, staffname, position, gender) VALUES (?, ?, ?, ?)")) {

 

                pst.setInt(1, mod.getstaffid());
                pst.setString(2, mod.getstaffname());
                pst.setString(3, mod.getposition());
                pst.setString(4, mod.getgender());


 

                int rowsAffected = pst.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException e) {
                 System.err.println(e);
        }

 

        return false;
    } 

    public boolean delete(StaffModel mod)  {
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "ajina kaya8860");
                 PreparedStatement pst = conn.prepareStatement("DELETE FROM staff WHERE staffid = ?")) {

 

                pst.setInt(1, mod.getstaffid());

 

                int rowsAffected = pst.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException e) {
                System.err.println(e);
        }

 

        return false;
    }

     public boolean update(StaffModel mod)  {
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "ajina kaya8860");
                 PreparedStatement pst = conn.prepareStatement("UPDATE staff SET staffname = ?, gender = ?, position = ? WHERE staffid = ?")) {

 

                pst.setString(1, mod.getstaffname());
                pst.setString(2, mod.getposition());
                pst.setInt(3, mod.getstaffid());
                pst.setString(4, mod.getgender());

 

                int rowsAffected = pst.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException e) {
               System.err.println(e);
        }

 

        return false;
    }

 

    

 

  public DefaultTableModel getstaffTableModel() throws SQLException {
        DefaultTableModel tableModel = new DefaultTableModel();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "ajina kaya8860");
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM staff");
             ResultSet rs = ps.executeQuery()) {


            tableModel.addColumn("Staff ID");
            tableModel.addColumn("Staff Name");
            tableModel.addColumn("Position");
            tableModel.addColumn("Gender");


            while (rs.next()) {
                int staffid = rs.getInt("staffid");
                String staffname = rs.getString("staffname");
                String position = rs.getString("position");
                String gender = rs.getString("gender");

                tableModel.addRow(new Object[] {staffid, staffname, position, gender});
            }
        } catch (SQLException e) {
            throw e;
        }

        return tableModel;
    }
}