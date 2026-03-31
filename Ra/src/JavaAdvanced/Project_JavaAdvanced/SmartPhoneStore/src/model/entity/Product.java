package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.entity;

import java.math.BigDecimal;

public class Product {
    private int id;
    private String name;
    private String brand;
    private String capacity;
    private String color;
    private BigDecimal price;
    private int stock;
    private String description;
    private int categoryId;
    private String categoryName;

    public Product() {}

    public Product(String name, String brand, String capacity, String color,
                   BigDecimal price, int stock, String description, int categoryId) {
        this.name = name;
        this.brand = brand;
        this.capacity = capacity;
        this.color = color;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.categoryId = categoryId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getCapacity() { return capacity; }
    public void setCapacity(String capacity) { this.capacity = capacity; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
}