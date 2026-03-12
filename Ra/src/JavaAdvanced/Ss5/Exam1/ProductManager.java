package JavaAdvanced.Ss5.Exam1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductManager {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        boolean exists = products.stream()
                .anyMatch(p -> p.getId() == product.getId());

        if (exists) {
            throw new InvalidProductException("Sp cs ID " + product.getId() + " da ton tai");
        }

        products.add(product);
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Hien ko cs sp nao (.) kho");
            return;
        }

        System.out.println("==========================================================================");
        System.out.printf("| %-5s | %-20s | %-10s | %-8s | %-15s |\n", "ID", "TÊN SẢN PHẨM", "GIÁ", "SL", "DANH MỤC");
        System.out.println("--------------------------------------------------------------------------");

        products.forEach(System.out::println);

        System.out.println("==========================================================================");
    }

    public void updateQuantity(int id, int newQuantity) {
        Optional<Product> optionalProduct = products.stream()
                .filter(p -> p.getId() == id)
                .findFirst();

        Product product = optionalProduct.orElseThrow(() ->
                new InvalidProductException("Ko tim thay sp cs ID: " + id));

        product.setQuantity(newQuantity);
    }

    public void removeStock() {
        long count = products.stream().filter(p -> p.getQuantity() == 0).count();

        if (count == 0) {
            System.out.println("Ko cs sp nao het hang");
            return;
        }

        products.removeIf(p -> p.getQuantity() == 0);
    }
}