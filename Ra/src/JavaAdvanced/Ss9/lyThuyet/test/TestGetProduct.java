package JavaAdvanced.Ss9.lyThuyet.test;

import Session11.lyThuyet.entity.Product;
import Session11.lyThuyet.repository.ProductRepository;
import Session11.lyThuyet.repository.impl.ProductRepositoryImpl;

import java.util.List;

public class TestGetProduct {
    public static void main(String[] args) {
        ProductRepository repo = new ProductRepositoryImpl();

        List<Product> products = repo.getAllProducts();
        for(Product p : products){
            System.out.println(p);
        }
    }
}
