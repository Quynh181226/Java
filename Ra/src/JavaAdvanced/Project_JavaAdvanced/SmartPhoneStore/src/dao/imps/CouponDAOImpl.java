package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.imps;

import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.interfaces.CouponDAO;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.Coupon;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CouponDAOImpl implements CouponDAO {

    @Override
    public List<Coupon> findAll() throws SQLException {
        List<Coupon> coupons = new ArrayList<>();
        String sql = "SELECT * FROM coupons ORDER BY id DESC";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                coupons.add(mapResultSetToCoupon(rs));
            }
        }
        return coupons;
    }

    @Override
    public List<Coupon> findActiveCoupons() throws SQLException {
        List<Coupon> coupons = new ArrayList<>();
        String sql = "SELECT * FROM coupons WHERE is_active = true AND valid_from <= CURDATE() AND valid_to >= CURDATE() AND used_count < max_usage";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                coupons.add(mapResultSetToCoupon(rs));
            }
        }
        return coupons;
    }

    @Override
    public Coupon findByCode(String code) throws SQLException {
        String sql = "SELECT * FROM coupons WHERE code = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, code);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToCoupon(rs);
            }
        }
        return null;
    }

    @Override
    public Coupon findById(int id) throws SQLException {
        String sql = "SELECT * FROM coupons WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToCoupon(rs);
            }
        }
        return null;
    }

    @Override
    public boolean save(Coupon coupon) throws SQLException {
        String sql = "INSERT INTO coupons (code, discount_percent, valid_from, valid_to, max_usage, min_order_amount, is_active) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, coupon.getCode());
            stmt.setInt(2, coupon.getDiscountPercent());
            stmt.setDate(3, Date.valueOf(coupon.getValidFrom()));
            stmt.setDate(4, Date.valueOf(coupon.getValidTo()));
            stmt.setInt(5, coupon.getMaxUsage());
            stmt.setBigDecimal(6, coupon.getMinOrderAmount());
            stmt.setBoolean(7, coupon.isActive());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    coupon.setId(rs.getInt(1));
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean update(Coupon coupon) throws SQLException {
        String sql = "UPDATE coupons SET code = ?, discount_percent = ?, valid_from = ?, valid_to = ?, max_usage = ?, min_order_amount = ?, is_active = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, coupon.getCode());
            stmt.setInt(2, coupon.getDiscountPercent());
            stmt.setDate(3, Date.valueOf(coupon.getValidFrom()));
            stmt.setDate(4, Date.valueOf(coupon.getValidTo()));
            stmt.setInt(5, coupon.getMaxUsage());
            stmt.setBigDecimal(6, coupon.getMinOrderAmount());
            stmt.setBoolean(7, coupon.isActive());
            stmt.setInt(8, coupon.getId());
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM coupons WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean incrementUsedCount(String code) throws SQLException {
        String sql = "UPDATE coupons SET used_count = used_count + 1 WHERE code = ? AND used_count < max_usage";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, code);
            return stmt.executeUpdate() > 0;
        }
    }

    private Coupon mapResultSetToCoupon(ResultSet rs) throws SQLException {
        Coupon coupon = new Coupon();
        coupon.setId(rs.getInt("id"));
        coupon.setCode(rs.getString("code"));
        coupon.setDiscountPercent(rs.getInt("discount_percent"));
        coupon.setValidFrom(rs.getDate("valid_from").toLocalDate());
        coupon.setValidTo(rs.getDate("valid_to").toLocalDate());
        coupon.setMaxUsage(rs.getInt("max_usage"));
        coupon.setUsedCount(rs.getInt("used_count"));
        coupon.setMinOrderAmount(rs.getBigDecimal("min_order_amount"));
        coupon.setActive(rs.getBoolean("is_active"));
        coupon.setApplicableType(rs.getString("applicable_type") != null ? rs.getString("applicable_type") : "ALL");
        return coupon;
    }
}