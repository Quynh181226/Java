package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.service;

import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.interfaces.OrderDAO;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.imps.OrderDAOImpl;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.interfaces.OrderDetailDAO;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.imps.OrderDetailDAOImpl;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.interfaces.FlashSaleDAO;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.imps.FlashSaleDAOImpl;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.entity.Order;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.entity.OrderDetail;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.entity.FlashSale;
import java.sql.SQLException;
import java.util.List;

public class OrderService {
    private OrderDAO orderDAO;
    private OrderDetailDAO orderDetailDAO;
    private FlashSaleDAO flashSaleDAO;

    public OrderService() {
        this.orderDAO = new OrderDAOImpl();
        this.orderDetailDAO = new OrderDetailDAOImpl();
        this.flashSaleDAO = new FlashSaleDAOImpl();
    }

    public List<Order> getAllOrders() throws SQLException {
        return orderDAO.findAll();
    }

    public List<Order> getOrdersByStatus(String status) throws SQLException {
        if (status == null || status.trim().isEmpty()) {
            throw new IllegalArgumentException("Trang thai don hang khong hop le");
        }
        return orderDAO.findByStatus(status);
    }

    public List<Order> getOrdersByUser(int userId) throws SQLException {
        if (userId <= 0) {
            throw new IllegalArgumentException("ID nguoi dung khong hop le");
        }
        return orderDAO.findByUserId(userId);
    }

    public Order getOrderById(int id) throws SQLException {
        if (id <= 0) {
            throw new IllegalArgumentException("ID don hang khong hop le");
        }
        return orderDAO.findById(id);
    }

    public boolean updateOrderStatus(int orderId, String status) throws SQLException {
        if (orderId <= 0) {
            throw new IllegalArgumentException("ID don hang khong hop le");
        }
        if (status == null || status.trim().isEmpty()) {
            throw new IllegalArgumentException("Trang thai don hang khong hop le");
        }

        Order order = orderDAO.findById(orderId);
        if (order == null) {
            throw new IllegalArgumentException("Khong tim thay don hang");
        }

        return orderDAO.updateStatus(orderId, status);
    }

    public List<OrderDetail> getOrderDetails(int orderId) throws SQLException {
        if (orderId <= 0) {
            throw new IllegalArgumentException("ID don hang khong hop le");
        }
        return orderDetailDAO.findByOrderId(orderId);
    }

    public boolean createOrder(Order order, List<OrderDetail> details) throws SQLException {
        if (order == null) {
            throw new IllegalArgumentException("Thong tin don hang khong hop le");
        }
        if (details == null || details.isEmpty()) {
            throw new IllegalArgumentException("Don hang phai co it nhat mot san pham");
        }

        return orderDAO.save(order, details);
    }

    public FlashSale getFlashSaleById(int id) throws SQLException {
        if (id <= 0) {
            throw new IllegalArgumentException("ID flash sale khong hop le");
        }
        return flashSaleDAO.findById(id);
    }
}