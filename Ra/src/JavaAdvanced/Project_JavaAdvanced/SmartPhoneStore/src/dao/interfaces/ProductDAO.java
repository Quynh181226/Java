package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.interfaces;

import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.Product;
import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {
    List<Product> findAll() throws SQLException;
    List<Product> findByCategory(int categoryId) throws SQLException;
    List<Product> searchByName(String keyword) throws SQLException;
    Product findById(int id) throws SQLException;
    boolean save(Product product) throws SQLException;
    boolean update(Product product) throws SQLException;
    boolean delete(int id) throws SQLException;
    boolean updateStock(int productId, int quantity) throws SQLException;
}