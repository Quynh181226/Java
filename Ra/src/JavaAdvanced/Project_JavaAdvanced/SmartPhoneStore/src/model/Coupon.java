package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public class Coupon {
    private int id;
    private String code;
    private int discountPercent;
    private LocalDate validFrom;
    private LocalDate validTo;
    private int maxUsage;
    private int usedCount;
    private BigDecimal minOrderAmount;
    private boolean isActive;
    private String applicableType; // "All", "Brand", "Product"
    private Set<String> applicableBrands;
    private Set<Integer> applicableProductIds;

    public Coupon() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public int getDiscountPercent() { return discountPercent; }
    public void setDiscountPercent(int discountPercent) { this.discountPercent = discountPercent; }

    public LocalDate getValidFrom() { return validFrom; }
    public void setValidFrom(LocalDate validFrom) { this.validFrom = validFrom; }

    public LocalDate getValidTo() { return validTo; }
    public void setValidTo(LocalDate validTo) { this.validTo = validTo; }

    public int getMaxUsage() { return maxUsage; }
    public void setMaxUsage(int maxUsage) { this.maxUsage = maxUsage; }

    public int getUsedCount() { return usedCount; }
    public void setUsedCount(int usedCount) { this.usedCount = usedCount; }

    public BigDecimal getMinOrderAmount() { return minOrderAmount; }
    public void setMinOrderAmount(BigDecimal minOrderAmount) { this.minOrderAmount = minOrderAmount; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }

    public String getApplicableType() { return applicableType; }
    public void setApplicableType(String applicableType) { this.applicableType = applicableType; }

    public boolean isValid() {
        LocalDate now = LocalDate.now();
        return isActive && !now.isBefore(validFrom) && !now.isAfter(validTo) && usedCount < maxUsage;
    }
}