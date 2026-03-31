package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FlashSale {
    private int id;
    private int productId;
    private String productName;
    private BigDecimal flashPrice;
    private int flashQuantity;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public FlashSale() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public BigDecimal getFlashPrice() { return flashPrice; }
    public void setFlashPrice(BigDecimal flashPrice) { this.flashPrice = flashPrice; }

    public int getFlashQuantity() { return flashQuantity; }
    public void setFlashQuantity(int flashQuantity) { this.flashQuantity = flashQuantity; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }

    public boolean isActive() {
        LocalDateTime now = LocalDateTime.now();
        return !now.isBefore(startTime) && !now.isAfter(endTime) && flashQuantity > 0;
    }
}