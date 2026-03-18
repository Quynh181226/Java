package JavaAdvanced.Ss9.Exam2.Factory;

import JavaAdvanced.Ss9.Exam2.entity.DigitalProduct;
import JavaAdvanced.Ss9.Exam2.entity.PhysicalProduct;
import JavaAdvanced.Ss9.Exam2.entity.Product;

public class ProductFactory {
    public static Product createProduct(int type, String id, String name, double price, double specificVal) {
        switch (type) {
            case 1:
                return new PhysicalProduct(id, name, price, specificVal);
            case 2:
                return new DigitalProduct(id, name, price, specificVal);
            default:
//                return null;
                throw new IllegalArgumentException("Invalid product type");
        }
    }
}