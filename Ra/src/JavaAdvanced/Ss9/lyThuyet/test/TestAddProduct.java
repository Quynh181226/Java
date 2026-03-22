package JavaAdvanced.Ss9.lyThuyet.test;

import Session11.lyThuyet.entity.Product;
import Session11.lyThuyet.repository.impl.ProductRepositoryImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestAddProduct {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Product newProduct = new Product("Bánh mì", "Hữu Nghị", 2005, sdf.parse("21/02/2026"), 15000.0D);
        boolean resultAdd = new ProductRepositoryImpl().addProduct(newProduct);

        if(resultAdd){
            System.out.println("Thêm sản phẩm thành công");
        } else {
            System.out.println("Thêm sản phẩm thất bại");
        }
    }
}
