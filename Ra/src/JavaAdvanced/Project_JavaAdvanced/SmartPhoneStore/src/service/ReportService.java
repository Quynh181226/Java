package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.service;

import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.interfaces.OrderDAO;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.imps.OrderDAOImpl;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.interfaces.ProductDAO;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.imps.ProductDAOImpl;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.Order;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.OrderDetail;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.*;

public class ReportService {
    private OrderDAO orderDAO;
    private ProductDAO productDAO;

    public ReportService() {
        this.orderDAO = new OrderDAOImpl();
        this.productDAO = new ProductDAOImpl();
    }

    public BigDecimal getTotalRevenue() throws SQLException {
        List<Order> orders = orderDAO.findAll();
        BigDecimal total = BigDecimal.ZERO;
        for (Order order : orders) {
            if (order.getStatus().equalsIgnoreCase("Delivered")) {
                total = total.add(order.getTotalAmount());
            }
        }
        return total;
    }

    public BigDecimal getRevenueByMonth(int month, int year) throws SQLException {
        List<Order> orders = orderDAO.findAll();
        BigDecimal total = BigDecimal.ZERO;
        for (Order order : orders) {
            if (order.getStatus().equalsIgnoreCase("Delivered")) {
                java.sql.Timestamp ts = order.getOrderDate();
                java.util.Calendar cal = java.util.Calendar.getInstance();
                cal.setTimeInMillis(ts.getTime());
                int orderMonth = cal.get(java.util.Calendar.MONTH) + 1;
                int orderYear = cal.get(java.util.Calendar.YEAR);
                if (orderMonth == month && orderYear == year) {
                    total = total.add(order.getTotalAmount());
                }
            }
        }
        return total;
    }

    public Map<String, Integer> getTopSellingProducts(int limit) throws SQLException {
        List<Order> orders = orderDAO.findAll();
        Map<Integer, Integer> productSales = new HashMap<>();

        for (Order order : orders) {
            if (order.getStatus().equalsIgnoreCase("Delivered")) {
                List<OrderDetail> details = orderDAO.getOrderDetails(order.getId());
                for (OrderDetail detail : details) {
                    productSales.put(detail.getProductId(),
                            productSales.getOrDefault(detail.getProductId(), 0) + detail.getQuantity());
                }
            }
        }

        Map<String, Integer> topProducts = new LinkedHashMap<>();
        productSales.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .limit(limit)
                .forEach(entry -> {
                    try {
                        String productName = productDAO.findById(entry.getKey()).getName();
                        topProducts.put(productName, entry.getValue());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                });

        return topProducts;
    }

    public Map<String, Integer> getOrderStatistics() throws SQLException {
        List<Order> orders = orderDAO.findAll();
        Map<String, Integer> stats = new HashMap<>();
        stats.put("Pending", 0);
        stats.put("Shipping", 0);
        stats.put("Delivered", 0);
        stats.put("Cancelled", 0);

        for (Order order : orders) {
            String status = order.getStatus();
            stats.put(status, stats.getOrDefault(status, 0) + 1);
        }

        return stats;
    }
}