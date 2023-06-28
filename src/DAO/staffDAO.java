package model;

import database.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class staffDAO extends DbConnection {

    public boolean add(StaffModel mod) {
        try (Connection conn = dbConnect();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO staff(staffid, staffname, position, gender) VALUES (?, ?, ?, ?)")) {

            ps.setInt(1, mod.getstaffid());
            ps.setString(2, mod.getstaffname());
            ps.setString(3, mod.getposition());
            ps.setString(4,mod.getgender());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println(e);
        }

        return false;
    }

    public boolean update(StaffModel mod) {
        try (Connection conn = dbConnect();
             PreparedStatement ps = conn.prepareStatement("UPDATE staff SET staffname = ? WHERE staffid = ?")) {

            ps.setString(1, mod.getstaffname());
            ps.setInt(2, mod.getstaffid());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println(e);
        }

        return false;
    }

    public boolean delete(StaffModel mod) {
        try (Connection conn = dbConnect();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM staff WHERE staffid = ?")) {

            ps.setInt(1, mod.getstaffid());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println(e);
        }

        return false;
    }
}