package DAO;

import database.DbConnection;
import model.StaffModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class staffDAO extends DbConnection {

    public boolean add(StaffModel mod) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "9808640305@Sr");
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

    public boolean delete(StaffModel mod) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "9808640305@Sr");
             PreparedStatement pst = conn.prepareStatement("DELETE FROM staff WHERE staffid = ?")) {

            pst.setInt(1, mod.getstaffid());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println(e);
        }

        return false;
    }

    public boolean update(StaffModel mod) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "9808640305@Sr");
             PreparedStatement pst = conn.prepareStatement("UPDATE staff SET staffname = ?, position = ?, gender = ? WHERE staffid = ?")) {
            
            pst.setString(1, mod.getstaffname());
            pst.setString(2, mod.getposition());
            pst.setString(3, mod.getgender());
            pst.setInt(4, mod.getstaffid());
       
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println(e);
        }
        System.out.println("Updated");
        return false;
    }

    public DefaultTableModel getstaffTableModel() throws SQLException {
        DefaultTableModel tableModel = new DefaultTableModel();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "9808640305@Sr");
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM staff");
             ResultSet rs = ps.executeQuery()) {

            tableModel.addColumn("staffid");
            tableModel.addColumn("staffname");
            tableModel.addColumn("position");
            tableModel.addColumn("gender");

            while (rs.next()) {
                int staffid = rs.getInt("staffid");
                String staffname = rs.getString("staffname");
                String position = rs.getString("position");
                String gender = rs.getString("gender");
               

                tableModel.addRow(new Object[]{staffid, staffname, position, gender});
            }
        } catch (SQLException e) {
            throw e;
        }

        return tableModel;
    }
}
