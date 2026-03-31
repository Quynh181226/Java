package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.service;

import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.interfaces.CouponDAO;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.imps.CouponDAOImpl;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.Coupon;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class CouponService {
    private CouponDAO couponDAO;

    public CouponService() {
        this.couponDAO = new CouponDAOImpl();
    }

    public List<Coupon> getAllCoupons() throws SQLException {
        return couponDAO.findAll();
    }

    public List<Coupon> getActiveCoupons() throws SQLException {
        return couponDAO.findActiveCoupons();
    }

    public Coupon getCouponByCode(String code) throws SQLException {
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("Ma giam gia khong duoc de trong");
        }
        return couponDAO.findByCode(code);
    }

    public BigDecimal applyCoupon(String code, BigDecimal orderAmount) throws SQLException {
        Coupon coupon = couponDAO.findByCode(code);

        if (coupon == null) {
            throw new IllegalArgumentException("Ma giam gia khong ton tai");
        }

        if (!coupon.isValid()) {
            throw new IllegalArgumentException("Ma giam gia khong con hieu luc");
        }

        if (orderAmount.compareTo(coupon.getMinOrderAmount()) < 0) {
            throw new IllegalArgumentException("Don hang toi thieu " + coupon.getMinOrderAmount() + " VND moi duoc ap dung ma nay");
        }

        BigDecimal discount = orderAmount.multiply(BigDecimal.valueOf(coupon.getDiscountPercent()))
                .divide(BigDecimal.valueOf(100));

        return discount;
    }

    public boolean addCoupon(String code, int discountPercent, LocalDate validFrom, LocalDate validTo, int maxUsage, BigDecimal minOrderAmount) throws SQLException {
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("Ma giam gia khong duoc de trong");
        }
        if (discountPercent <= 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Phan tram giam phai tu 1 den 100");
        }
        if (validFrom == null || validTo == null) {
            throw new IllegalArgumentException("Ngay hieu luc khong hop le");
        }
        if (validFrom.isAfter(validTo)) {
            throw new IllegalArgumentException("Ngay bat dau phai truoc ngay ket thuc");
        }
        if (maxUsage <= 0) {
            throw new IllegalArgumentException("So luong su dung phai lon hon 0");
        }
        if (minOrderAmount == null || minOrderAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Gia tri don hang toi thieu khong hop le");
        }

        if (couponDAO.findByCode(code) != null) {
            throw new IllegalArgumentException("Ma giam gia da ton tai");
        }

        Coupon coupon = new Coupon();
        coupon.setCode(code.toUpperCase());
        coupon.setDiscountPercent(discountPercent);
        coupon.setValidFrom(validFrom);
        coupon.setValidTo(validTo);
        coupon.setMaxUsage(maxUsage);
        coupon.setMinOrderAmount(minOrderAmount);
        coupon.setActive(true);

        return couponDAO.save(coupon);
    }

    public boolean updateCoupon(int id, String code, int discountPercent, LocalDate validFrom, LocalDate validTo, int maxUsage, BigDecimal minOrderAmount, boolean isActive) throws SQLException {
        Coupon coupon = couponDAO.findById(id);
        if (coupon == null) {
            throw new IllegalArgumentException("Khong tim thay ma giam gia");
        }

        coupon.setCode(code.toUpperCase());
        coupon.setDiscountPercent(discountPercent);
        coupon.setValidFrom(validFrom);
        coupon.setValidTo(validTo);
        coupon.setMaxUsage(maxUsage);
        coupon.setMinOrderAmount(minOrderAmount);
        coupon.setActive(isActive);

        return couponDAO.update(coupon);
    }

    public boolean deleteCoupon(int id) throws SQLException {
        Coupon coupon = couponDAO.findById(id);
        if (coupon == null) {
            throw new IllegalArgumentException("Khong tim thay ma giam gia");
        }
        return couponDAO.delete(id);
    }

    public boolean useCoupon(String code) throws SQLException {
        return couponDAO.incrementUsedCount(code);
    }
}