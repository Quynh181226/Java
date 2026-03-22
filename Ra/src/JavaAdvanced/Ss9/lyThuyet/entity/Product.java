package JavaAdvanced.Ss9.lyThuyet.entity;

import java.util.Date;

public class Product {
    private int proId;
    private String proName;
    private String producer;
    private int yearMaking;
    private Date expiryDate;
    private Double price;

    public Product() {
    }

    public Product(String proName, String producer, int yearMaking, Date expiryDate, Double price) {
        this.proName = proName;
        this.producer = producer;
        this.yearMaking = yearMaking;
        this.expiryDate = expiryDate;
        this.price = price;
    }

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getYearMaking() {
        return yearMaking;
    }

    public void setYearMaking(int yearMaking) {
        this.yearMaking = yearMaking;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(java.sql.Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "proId=" + proId +
                ", proName='" + proName + '\'' +
                ", producer='" + producer + '\'' +
                ", yearMaking=" + yearMaking +
                ", expiryDate=" + expiryDate +
                ", price=" + price +
                '}';
    }
}
