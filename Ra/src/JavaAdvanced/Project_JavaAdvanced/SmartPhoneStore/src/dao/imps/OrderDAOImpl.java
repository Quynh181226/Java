package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.imps;

import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.interfaces.OrderDAO;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.interfaces.ProductDAO;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.Order;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.OrderDetail;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    private ProductDAO productDAO = new ProductDAOImpl();

    @Override
    public List<Order> findAll() throws SQLException {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT o.*, u.full_name as user_name FROM orders o " +
                "LEFT JOIN users u ON o.user_id = u.id ORDER BY o.order_date DESC";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                orders.add(mapResultSetToOrder(rs));
            }
        }
        return orders;
    }

    @Override
    public List<Order> findByStatus(String status) throws SQLException {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT o.*, u.full_name as user_name FROM orders o " +
                "LEFT JOIN users u ON o.user_id = u.id WHERE o.status = ? ORDER BY o.order_date DESC";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, status);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                orders.add(mapResultSetToOrder(rs));
            }
        }
        return orders;
    }

    @Override
    public List<Order> findByUserId(int userId) throws SQLException {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT o.*, u.full_name as user_name FROM orders o " +
                "LEFT JOIN users u ON o.user_id = u.id WHERE o.user_id = ? ORDER BY o.order_date DESC";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                orders.add(mapResultSetToOrder(rs));
            }
        }
        return orders;
    }

    @Override
    public Order findById(int id) throws SQLException {
        String sql = "SELECT o.*, u.full_name as user_name FROM orders o " +
                "LEFT JOIN users u ON o.user_id = u.id WHERE o.id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToOrder(rs);
            }
        }
        return null;
    }

    @Override
    public boolean save(Order order, List<OrderDetail> details) throws SQLException {
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            conn.setAutoCommit(false);

            String sql = "INSERT INTO orders (user_id, total_amount, status, shipping_address, shipping_phone, coupon_code, discount_amount) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, order.getUserId());
            stmt.setBigDecimal(2, order.getTotalAmount());
            stmt.setString(3, order.getStatus());
            stmt.setString(4, order.getShippingAddress());
            stmt.setString(5, order.getShippingPhone());
            stmt.setString(6, order.getCouponCode());
            stmt.setBigDecimal(7, order.getDiscountAmount());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                conn.rollback();
                return false;
            }

            ResultSet rs = stmt.getGeneratedKeys();
            int orderId = 0;
            if (rs.next()) {
                orderId = rs.getInt(1);
                order.setId(orderId);
            }
            stmt.close();

            String detailSql = "INSERT INTO order_details (order_id, product_id, quantity, price) VALUES (?, ?, ?, ?)";
            PreparedStatement detailStmt = conn.prepareStatement(detailSql);

            for (OrderDetail detail : details) {
                detailStmt.setInt(1, orderId);
                detailStmt.setInt(2, detail.getProductId());
                detailStmt.setInt(3, detail.getQuantity());
                detailStmt.setBigDecimal(4, detail.getPrice());
                detailStmt.addBatch();

                productDAO.updateStock(detail.getProductId(), detail.getQuantity());
            }

            detailStmt.executeBatch();
            detailStmt.close();

            conn.commit();
            return true;

        } catch (SQLException e) {
            if (conn != null) {
                conn.rollback();
            }
            throw e;
        } finally {
            if (conn != null) {
                conn.setAutoCommit(true);
                conn.close();
            }
        }
    }

    @Override
    public boolean updateStatus(int orderId, String status) throws SQLException {
        String sql = "UPDATE orders SET status = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, status);
            stmt.setInt(2, orderId);
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public List<OrderDetail> getOrderDetails(int orderId) throws SQLException {
        List<OrderDetail> details = new ArrayList<>();
        String sql = "SELECT od.*, p.name as product_name FROM order_details od " +
                "LEFT JOIN products p ON od.product_id = p.id WHERE od.order_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                OrderDetail detail = new OrderDetail();
                detail.setId(rs.getInt("id"));
                detail.setOrderId(rs.getInt("order_id"));
                detail.setProductId(rs.getInt("product_id"));
                detail.setProductName(rs.getString("product_name"));
                detail.setQuantity(rs.getInt("quantity"));
                detail.setPrice(rs.getBigDecimal("price"));
                details.add(detail);
            }
        }
        return details;
    }

    private Order mapResultSetToOrder(ResultSet rs) throws SQLException {
        Order order = new Order();
        order.setId(rs.getInt("id"));
        order.setUserId(rs.getInt("user_id"));
        order.setUserFullName(rs.getString("user_name"));
        order.setOrderDate(rs.getTimestamp("order_date"));
        order.setTotalAmount(rs.getBigDecimal("total_amount"));
        order.setStatus(rs.getString("status"));
        order.setShippingAddress(rs.getString("shipping_address"));
        order.setShippingPhone(rs.getString("shipping_phone"));
        order.setCouponCode(rs.getString("coupon_code"));
        order.setDiscountAmount(rs.getBigDecimal("discount_amount"));
        return order;
    }
}