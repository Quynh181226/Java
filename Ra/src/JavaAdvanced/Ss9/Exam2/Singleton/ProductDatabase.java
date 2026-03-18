package JavaAdvanced.Ss9.Exam2.Singleton;

import JavaAdvanced.Ss9.Exam2.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDatabase {
    private static ProductDatabase instance;
    private List<Product> products = new ArrayList<>();

    private ProductDatabase() {}

    public static ProductDatabase getInstance() {
        if (instance == null) {
            instance = new ProductDatabase();
        }
        return instance;
    }

    public void addProduct(Product p) {
        products.add(p);
        System.out.println("Product added");
    }

    public void updateProduct(String id, Product p) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)) {
               products.set(i, p);
                System.out.println("Product updated");
                return;
            }
        }
        System.out.println("Product not found");
    }

    //del by id -> full
   public boolean deleteProduct(String id) {
        return products.removeIf(p->p.getId().equals(id));
   }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product findById(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }
}