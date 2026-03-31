package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.imps;

import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.interfaces.OrderDetailDAO;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.entity.OrderDetail;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO {

    @Override
    public List<OrderDetail> findByOrderId(int orderId) throws SQLException {
        List<OrderDetail> details = new ArrayList<>();
        String sql = "SELECT od.*, p.name as product_name FROM order_details od " +
                "LEFT JOIN products p ON od.product_id = p.id WHERE od.order_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                details.add(mapResultSetToOrderDetail(rs));
            }
        }
        return details;
    }

    @Override
    public boolean save(OrderDetail orderDetail) throws SQLException {
        String sql = "INSERT INTO order_details (order_id, product_id, quantity, price) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, orderDetail.getOrderId());
            stmt.setInt(2, orderDetail.getProductId());
            stmt.setInt(3, orderDetail.getQuantity());
            stmt.setBigDecimal(4, orderDetail.getPrice());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    orderDetail.setId(rs.getInt(1));
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean saveBatch(List<OrderDetail> orderDetails) throws SQLException {
        String sql = "INSERT INTO order_details (order_id, product_id, quantity, price) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            conn.setAutoCommit(false);

            for (OrderDetail detail : orderDetails) {
                stmt.setInt(1, detail.getOrderId());
                stmt.setInt(2, detail.getProductId());
                stmt.setInt(3, detail.getQuantity());
                stmt.setBigDecimal(4, detail.getPrice());
                stmt.addBatch();
            }

            int[] results = stmt.executeBatch();
            conn.commit();

            for (int result : results) {
                if (result == 0) return false;
            }
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean deleteByOrderId(int orderId) throws SQLException {
        String sql = "DELETE FROM order_details WHERE order_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, orderId);
            return stmt.executeUpdate() > 0;
        }
    }

    private OrderDetail mapResultSetToOrderDetail(ResultSet rs) throws SQLException {
        OrderDetail detail = new OrderDetail();
        detail.setId(rs.getInt("id"));
        detail.setOrderId(rs.getInt("order_id"));
        detail.setProductId(rs.getInt("product_id"));
        detail.setProductName(rs.getString("product_name"));
        detail.setQuantity(rs.getInt("quantity"));
        detail.setPrice(rs.getBigDecimal("price"));
        return detail;
    }
}