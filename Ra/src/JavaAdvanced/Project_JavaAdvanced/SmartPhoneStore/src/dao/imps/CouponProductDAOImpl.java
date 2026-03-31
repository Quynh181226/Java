package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.imps;

import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.interfaces.CouponProductDAO;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.util.DBConnection;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class CouponProductDAOImpl implements CouponProductDAO {
    @Override
    public Set<Integer> getProductIdsByCoupon(int couponId) throws SQLException {
        Set<Integer> productIds = new HashSet<>();
        String sql = "SELECT product_id FROM coupon_products WHERE coupon_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, couponId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                productIds.add(rs.getInt("product_id"));
            }
        }
        return productIds;
    }

    @Override
    public Set<String> getBrandsByCoupon(int couponId) throws SQLException {
        Set<String> brands = new HashSet<>();
        String sql = "SELECT brand FROM coupon_brands WHERE coupon_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, couponId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                brands.add(rs.getString("brand"));
            }
        }
        return brands;
    }
}