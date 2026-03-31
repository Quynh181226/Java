package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.imps;

import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.interfaces.UserDAO;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.User;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public User findByEmail(String email) throws SQLException {
        String sql = "SELECT id, full_name, email, password, phone, address, role, is_active FROM users WHERE email = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToUser(rs);
            }
        }
        return null;
    }

    @Override
    public User findById(int id) throws SQLException {
        String sql = "SELECT id, full_name, email, password, phone, address, role, is_active FROM users WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToUser(rs);
            }
        }
        return null;
    }

    @Override
    public boolean save(User user) throws SQLException {
        String sql = "INSERT INTO users (full_name, email, password, phone, address, role, is_active) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, user.getFullName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getPhone());
            stmt.setString(5, user.getAddress());
            stmt.setString(6, user.getRole());
            stmt.setBoolean(7, user.isActive());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    user.setId(rs.getInt(1));
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean update(User user) throws SQLException {
        String sql = "UPDATE users SET full_name = ?, phone = ?, address = ?, is_active = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getFullName());
            stmt.setString(2, user.getPhone());
            stmt.setString(3, user.getAddress());
            stmt.setBoolean(4, user.isActive());
            stmt.setInt(5, user.getId());
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public List<User> findAll() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT id, full_name, email, password, phone, address, role, is_active FROM users ORDER BY id DESC";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                users.add(mapResultSetToUser(rs));
            }
        }
        return users;
    }

//    @Override
//    public List<User> findByRole(String role) throws SQLException {
//        List<User> users = new ArrayList<>();
//        String sql = "SELECT id, full_name, email, password, phone, address, role, is_active FROM users WHERE role = ?";
//        try (Connection conn = DBConnection.getConnection();
//             PreparedStatement stmt = conn.prepareStatement(sql)) {
//            stmt.setString(1, role);
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                users.add(mapResultSetToUser(rs));
//            }
//        }
//        return users;
//    }

    private User mapResultSetToUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setFullName(rs.getString("full_name"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setPhone(rs.getString("phone"));
        user.setAddress(rs.getString("address"));
        user.setRole(rs.getString("role"));
        user.setActive(rs.getBoolean("is_active"));
        return user;
    }
}