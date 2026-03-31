package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.interfaces;

import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.OrderDetail;
import java.sql.SQLException;
import java.util.List;

public interface OrderDetailDAO {
    List<OrderDetail> findByOrderId(int orderId) throws SQLException;
    boolean save(OrderDetail orderDetail) throws SQLException;
}