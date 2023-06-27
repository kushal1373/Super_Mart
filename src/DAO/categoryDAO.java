package DAO;

import database.DbConnection;
import model.categoryModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class categoryDAO extends DbConnection {

    public boolean add(categoryModel mod) {
        try (Connection conn = dbConnect();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO category(categoryId, categoryName, description) VALUES (?, ?, ?)")) {

            ps.setInt(1, mod.getCategoryId());
            ps.setString(2, mod.getCategoryName());
            ps.setString(3, mod.getDescription());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println(e);
        }

        return false;
    }

    public boolean update(categoryModel mod) {
        try (Connection conn = dbConnect();
             PreparedStatement ps = conn.prepareStatement("UPDATE category SET categoryName = ? WHERE categoryId = ?")) {

            ps.setString(1, mod.getCategoryName());
            ps.setInt(2, mod.getCategoryId());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println(e);
        }

        return false;
    }

    public boolean delete(categoryModel mod) {
        try (Connection conn = dbConnect();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM category WHERE categoryId = ?")) {

            ps.setInt(1, mod.getCategoryId());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println(e);
        }

        return false;
    }
}
