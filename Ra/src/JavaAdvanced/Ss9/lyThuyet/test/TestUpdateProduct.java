package JavaAdvanced.Ss9.lyThuyet.test;

import Session11.lyThuyet.entity.Product;
import Session11.lyThuyet.repository.impl.ProductRepositoryImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class TestUpdateProduct {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Product productUpdate = new Product("Bánh mì", "Hữu Nghị", 2026, sdf.parse("21/02/2027"), 18000.0D);
        ProductRepositoryImpl repo = new ProductRepositoryImpl();

        int productId = 1;
        if (args.length > 0) {
            productId = Integer.parseInt(args[0]);
        }

        boolean resultUpdate = repo.updateProduct(productId, productUpdate);

        if(resultUpdate){
            System.out.println("Cập nhật sản phẩm thành công");
            List<Product> products = repo.getAllProducts();
            for (Product product : products) {
                if (product.getProId() == productId) {
                    System.out.println("Sau cập nhật: " + product);
                    break;
                }
            }
        } else {
            System.out.println("Cập nhật sản phẩm thất bại (không tìm thấy product_id = " + productId + ")");
        }
    }
}
