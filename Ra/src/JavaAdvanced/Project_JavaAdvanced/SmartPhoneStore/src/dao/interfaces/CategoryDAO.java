package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.interfaces;

import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.Category;
import java.sql.SQLException;
import java.util.List;

public interface CategoryDAO {
    List<Category> findAll() throws SQLException;
    Category findById(int id) throws SQLException;
    Category findByName(String name) throws SQLException;
    boolean save(Category category) throws SQLException;
    boolean update(Category category) throws SQLException;
    boolean delete(int id) throws SQLException;
    boolean hasProducts(int categoryId) throws SQLException;
}