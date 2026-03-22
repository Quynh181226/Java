package JavaAdvanced.Ss9.lyThuyet.test;

import Session11.lyThuyet.repository.impl.ProductRepositoryImpl;

public class TestDeleteProduct {
    public static void main(String[] args) {
        int proId = 1;
        boolean resultDelete = new ProductRepositoryImpl().deleteProduct(proId);

        if(resultDelete){
            System.out.println("Xóa sản phẩm thành công");
        } else {
            System.out.println("Xóa sản phẩm thất bại");
        }
    }
}
