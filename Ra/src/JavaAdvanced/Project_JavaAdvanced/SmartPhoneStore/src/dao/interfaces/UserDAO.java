package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.interfaces;

import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.entity.User;
import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    User findByEmail(String email) throws SQLException;
    User findById(int id) throws SQLException;
    boolean save(User user) throws SQLException;
    boolean update(User user) throws SQLException;
    boolean delete(int id) throws SQLException;
    List<User> findAll() throws SQLException;
    List<User> findByRole(String role) throws SQLException;
}