package JavaAdvanced.Ss9.lyThuyet.repository;

import Session11.lyThuyet.entity.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getAllProducts();
    boolean addProduct(Product product);
    boolean updateProduct(Integer proId ,Product product);
    boolean deleteProduct(Integer proId);
}
