package JavaAdvanced.Ss9.Exam2.Main;

import JavaAdvanced.Ss9.Exam2.Factory.ProductFactory;
import JavaAdvanced.Ss9.Exam2.Singleton.ProductDatabase;
import JavaAdvanced.Ss9.Exam2.entity.DigitalProduct;
import JavaAdvanced.Ss9.Exam2.entity.PhysicalProduct;
import JavaAdvanced.Ss9.Exam2.entity.Product;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final ProductDatabase db = ProductDatabase.getInstance();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========== QUẢN LÝ SẢN PHẨM ==========");
            System.out.println("1. Thêm mới sản phẩm");
            System.out.println("2. Xem danh sách sản phẩm");
            System.out.println("3. Cập nhật thông tin sản phẩm");
            System.out.println("4. Xoá sản phẩm");
            System.out.println("5. Thoát");
            System.out.println("========================================");
            int choice = getIntInput("Lựa chọn của bạn: ");

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    viewAllProducts();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                    System.out.println("Exit program");
                    exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void addProduct() {
        System.out.println("\n--- Thêm ms sp ---");
        System.out.println("Chọn loại sp:");
        System.out.println("1. Physical Product");
        System.out.println("2. Digital Product");

        int type = getIntInput("Nhập loại (1-2): ");

        if (type < 1 || type > 2) {
            System.out.println("Invalid input");
            return;
        }

        String id = getStringInput("Nhập id: ");

        if (db.findById(id) != null) {
            System.out.println("Duplicate id");
            return;
        }

        String name = getStringInput("Nhập name: ");
        double price = getDoubleInput("Nhập price: ");

//        Product p;
        double specificVal;
        if (type == 1) {
//            double weight = getDoubleInput("Nhập weight: ");
//            p = new PhysicalProduct(id, name, price, weight);

            specificVal = getDoubleInput("Nhập weight: ");
        } else {
            specificVal = getDoubleInput("Nhập size(Mb): ");
        }

//        db.addProduct(p);
        Product p = ProductFactory.createProduct(type, id, name, price, specificVal);
        db.addProduct(p);
    }

    private static void viewAllProducts() {
        System.out.println("\n--- DANH SÁCH SẢN PHẨM ---");
        List<Product> products = db.getAllProducts();

        if (products.isEmpty()) {
            System.out.println("Empty list");
            return;
        }

        for (Product p : products) {
            p.displayInfo();
        }
    }

    private static void updateProduct() {
        System.out.println("\n--- CẬP NHẬT SẢN PHẨM ---");
        String id = getStringInput("Nhập id: ");

        Product exits = db.findById(id);
        if (exits == null) {
            System.out.println("Not found product");
            return;
        }
        System.out.print("Nhập new name: ");
        String name = sc.nextLine().trim();

        double price=getDoubleInput("Nhập new price: ");


        Product p;
        if (exits instanceof PhysicalProduct) {
           double weight=getDoubleInput("Nhập new weight: ");

//            p = new PhysicalProduct(id, name, price, weight);
            p = ProductFactory.createProduct(1, id, name, price, weight);
        } else {
            double size=getDoubleInput("Nhập size(Mb): ");

            p = ProductFactory.createProduct(2, id, name, price, size);
        }
        db.updateProduct(id, p);
    }

    private static void deleteProduct() {
        System.out.println("\n--- XOÁ SẢN PHẨM ---");
        String id = getStringInput("Nhập id: ");

        if(db.deleteProduct(id)){
            System.out.println("Product deleted");
        }else{
            System.out.println("Product not deleted");
        }
    }

    // Not crasssh
    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Num invalid");
            }
        }
    }

    private static double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Num invalid");
            }
        }
    }

    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }
}