package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.interfaces;

import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.entity.Order;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.entity.OrderDetail;
import java.sql.SQLException;
import java.util.List;

public interface OrderDAO {
    List<Order> findAll() throws SQLException;
    List<Order> findByStatus(String status) throws SQLException;
    List<Order> findByUserId(int userId) throws SQLException;
    Order findById(int id) throws SQLException;
    boolean save(Order order, List<OrderDetail> details) throws SQLException;
    boolean updateStatus(int orderId, String status) throws SQLException;
    List<OrderDetail> getOrderDetails(int orderId) throws SQLException;
}