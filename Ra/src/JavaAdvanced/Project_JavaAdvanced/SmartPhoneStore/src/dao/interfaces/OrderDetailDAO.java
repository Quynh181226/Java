package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.interfaces;

import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.entity.OrderDetail;
import java.sql.SQLException;
import java.util.List;

public interface OrderDetailDAO {
    List<OrderDetail> findByOrderId(int orderId) throws SQLException;
    boolean save(OrderDetail orderDetail) throws SQLException;
    boolean saveBatch(List<OrderDetail> orderDetails) throws SQLException;
    boolean deleteByOrderId(int orderId) throws SQLException;
}