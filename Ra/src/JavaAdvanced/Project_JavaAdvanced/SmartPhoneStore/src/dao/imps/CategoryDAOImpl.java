package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.imps;

import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.interfaces.CategoryDAO;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.Category;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {

    @Override
    public List<Category> findAll() throws SQLException {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT id, name, description FROM categories WHERE is_deleted = false ORDER BY id";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                categories.add(mapResultSetToCategory(rs));
            }
        }
        return categories;
    }

    @Override
    public Category findById(int id) throws SQLException {
        String sql = "SELECT id, name, description FROM categories WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToCategory(rs);
            }
        }
        return null;
    }

    @Override
    public Category findByName(String name) throws SQLException {
        String sql = "SELECT id, name, description FROM categories WHERE name = ? AND is_deleted = false";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToCategory(rs);
            }
        }
        return null;
    }

    @Override
    public boolean save(Category category) throws SQLException {
        String sql = "INSERT INTO categories (name, description) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, category.getName());
            stmt.setString(2, category.getDescription());
            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    category.setId(rs.getInt(1));
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean update(Category category) throws SQLException {
        String sql = "UPDATE categories SET name = ?, description = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, category.getName());
            stmt.setString(2, category.getDescription());
            stmt.setInt(3, category.getId());
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String sql = "UPDATE categories SET is_deleted = true WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean hasProducts(int categoryId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM products WHERE category_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, categoryId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        return false;
    }

    private Category mapResultSetToCategory(ResultSet rs) throws SQLException {
        Category category = new Category();
        category.setId(rs.getInt("id"));
        category.setName(rs.getString("name"));
        category.setDescription(rs.getString("description"));
        return category;
    }
}