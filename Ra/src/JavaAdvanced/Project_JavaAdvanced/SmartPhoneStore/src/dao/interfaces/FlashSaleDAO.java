package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.interfaces;

import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.entity.FlashSale;
import java.sql.SQLException;
import java.util.List;

public interface FlashSaleDAO {
    List<FlashSale> findAll() throws SQLException;
    List<FlashSale> findActiveFlashSales() throws SQLException;
    FlashSale findByProductId(int productId) throws SQLException;
    FlashSale findById(int id) throws SQLException;
    boolean save(FlashSale flashSale) throws SQLException;
    boolean update(FlashSale flashSale) throws SQLException;
    boolean delete(int id) throws SQLException;
    boolean updateFlashQuantity(int id, int quantity) throws SQLException;
}