package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.interfaces;

import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.Coupon;
import java.sql.SQLException;
import java.util.List;

public interface CouponDAO {
    List<Coupon> findAll() throws SQLException;
    List<Coupon> findActiveCoupons() throws SQLException;
    Coupon findByCode(String code) throws SQLException;
    Coupon findById(int id) throws SQLException;
    boolean save(Coupon coupon) throws SQLException;
    boolean update(Coupon coupon) throws SQLException;
    boolean delete(int id) throws SQLException;
    boolean incrementUsedCount(String code) throws SQLException;
}