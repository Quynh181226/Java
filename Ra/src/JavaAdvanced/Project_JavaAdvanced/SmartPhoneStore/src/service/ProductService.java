package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.service;

import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.interfaces.ProductDAO;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.imps.ProductDAOImpl;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.entity.Product;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.util.Validator;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class ProductService {
    private ProductDAO productDAO;

    public ProductService() {
        this.productDAO = new ProductDAOImpl();
    }

    public List<Product> getAllProducts() throws SQLException {
        return productDAO.findAll();
    }

    public List<Product> getProductsByCategory(int categoryId) throws SQLException {
        if (categoryId <= 0) {
            throw new IllegalArgumentException("ID danh muc khong hop le");
        }
        return productDAO.findByCategory(categoryId);
    }

    public List<Product> searchProducts(String keyword) throws SQLException {
        if (keyword == null || keyword.trim().isEmpty()) {
            throw new IllegalArgumentException("Tu khoa tim kiem khong duoc de trong");
        }
        return productDAO.searchByName(keyword);
    }

    public Product getProductById(int id) throws SQLException {
        if (id <= 0) {
            throw new IllegalArgumentException("ID san pham khong hop le");
        }
        return productDAO.findById(id);
    }

    public boolean addProduct(String name, String brand, String capacity, String color,
                              double price, int stock, String description, int categoryId) throws SQLException {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Ten san pham khong duoc de trong");
        }
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Hang san xuat khong duoc de trong");
        }
        if (!Validator.isValidPrice(price)) {
            throw new IllegalArgumentException("Gia san pham phai lon hon hoac bang 0");
        }
        if (!Validator.isValidStock(stock)) {
            throw new IllegalArgumentException("So luong ton kho phai lon hon hoac bang 0");
        }
        if (categoryId <= 0) {
            throw new IllegalArgumentException("Vui long chon danh muc");
        }

        Product product = new Product(name, brand, capacity, color,
                BigDecimal.valueOf(price), stock, description, categoryId);
        return productDAO.save(product);
    }

    public boolean updateProduct(int id, String name, String brand, String capacity, String color, double price, int stock, String description, int categoryId) throws SQLException {
        if (id <= 0) {
            throw new IllegalArgumentException("ID san pham khong hop le");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Ten san pham khong duoc de trong");
        }
        if (!Validator.isValidPrice(price)) {
            throw new IllegalArgumentException("Gia san pham phai lon hon hoac bang 0");
        }
        if (!Validator.isValidStock(stock)) {
            throw new IllegalArgumentException("So luong ton kho phai lon hon hoac bang 0");
        }

        Product product = productDAO.findById(id);
        if (product == null) {
            throw new IllegalArgumentException("Khong tim thay san pham");
        }

        product.setName(name);
        product.setBrand(brand);
        product.setCapacity(capacity);
        product.setColor(color);
        product.setPrice(BigDecimal.valueOf(price));
        product.setStock(stock);
        product.setDescription(description);
        product.setCategoryId(categoryId);

        return productDAO.update(product);
    }

    public boolean deleteProduct(int id) throws SQLException {
        if (id <= 0) {
            throw new IllegalArgumentException("ID san pham khong hop le");
        }

        Product product = productDAO.findById(id);
        if (product == null) {
            throw new IllegalArgumentException("Khong tim thay san pham");
        }

        return productDAO.delete(id);
    }
}