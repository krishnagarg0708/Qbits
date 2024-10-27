package dao;

import java.sql.*;
import model.Admin;

public class AdminDAO {
    public void addAdmin(Admin admin) throws SQLException {
        String query = "INSERT INTO admins (username, password) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, admin.getUsername());
            stmt.setString(2, admin.getPassword());
            stmt.executeUpdate();
        }
    }

    public Admin getAdminById(int id) throws SQLException {
        String query = "SELECT * FROM admins WHERE admin_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Admin(rs.getInt("admin_id"), rs.getString("username"), rs.getString("password"));
            }
        }
        return null;
    }

    public void deleteAdmin(int id) throws SQLException {
        String query = "DELETE FROM admins WHERE admin_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
