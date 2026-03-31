package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.imps;

import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.interfaces.FlashSaleDAO;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.entity.FlashSale;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlashSaleDAOImpl implements FlashSaleDAO {

    @Override
    public List<FlashSale> findAll() throws SQLException {
        List<FlashSale> flashSales = new ArrayList<>();
        String sql = "SELECT * FROM flash_sales ORDER BY id DESC";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                flashSales.add(mapResultSetToFlashSale(rs));
            }
        }
        return flashSales;
    }

    @Override
    public List<FlashSale> findActiveFlashSales() throws SQLException {
        List<FlashSale> flashSales = new ArrayList<>();
        String sql = "SELECT * FROM flash_sales WHERE start_time <= NOW() AND end_time >= NOW() AND flash_quantity > 0";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                flashSales.add(mapResultSetToFlashSale(rs));
            }
        }
        return flashSales;
    }

    @Override
    public FlashSale findByProductId(int productId) throws SQLException {
        String sql = "SELECT * FROM flash_sales WHERE product_id = ? AND start_time <= NOW() AND end_time >= NOW() AND flash_quantity > 0";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, productId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToFlashSale(rs);
            }
        }
        return null;
    }

    @Override
    public FlashSale findById(int id) throws SQLException {
        String sql = "SELECT * FROM flash_sales WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToFlashSale(rs);
            }
        }
        return null;
    }

    @Override
    public boolean save(FlashSale flashSale) throws SQLException {
        String sql = "INSERT INTO flash_sales (product_id, flash_price, flash_quantity, start_time, end_time) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, flashSale.getProductId());
            stmt.setBigDecimal(2, flashSale.getFlashPrice());
            stmt.setInt(3, flashSale.getFlashQuantity());
            stmt.setTimestamp(4, Timestamp.valueOf(flashSale.getStartTime()));
            stmt.setTimestamp(5, Timestamp.valueOf(flashSale.getEndTime()));

            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    flashSale.setId(rs.getInt(1));
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean update(FlashSale flashSale) throws SQLException {
        String sql = "UPDATE flash_sales SET product_id = ?, flash_price = ?, flash_quantity = ?, start_time = ?, end_time = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, flashSale.getProductId());
            stmt.setBigDecimal(2, flashSale.getFlashPrice());
            stmt.setInt(3, flashSale.getFlashQuantity());
            stmt.setTimestamp(4, Timestamp.valueOf(flashSale.getStartTime()));
            stmt.setTimestamp(5, Timestamp.valueOf(flashSale.getEndTime()));
            stmt.setInt(6, flashSale.getId());
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM flash_sales WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean updateFlashQuantity(int id, int quantity) throws SQLException {
        String sql = "UPDATE flash_sales SET flash_quantity = flash_quantity - ? WHERE id = ? AND flash_quantity >= ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, quantity);
            stmt.setInt(2, id);
            stmt.setInt(3, quantity);
            return stmt.executeUpdate() > 0;
        }
    }

    private FlashSale mapResultSetToFlashSale(ResultSet rs) throws SQLException {
        FlashSale flashSale = new FlashSale();
        flashSale.setId(rs.getInt("id"));
        flashSale.setProductId(rs.getInt("product_id"));
        flashSale.setFlashPrice(rs.getBigDecimal("flash_price"));
        flashSale.setFlashQuantity(rs.getInt("flash_quantity"));
        flashSale.setStartTime(rs.getTimestamp("start_time").toLocalDateTime());
        flashSale.setEndTime(rs.getTimestamp("end_time").toLocalDateTime());
        return flashSale;
    }
}