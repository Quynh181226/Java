package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.interfaces;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface CouponProductDAO {
    Set<Integer> getProductIdsByCoupon(int couponId) throws SQLException;
    Set<String> getBrandsByCoupon(int couponId) throws SQLException;
}