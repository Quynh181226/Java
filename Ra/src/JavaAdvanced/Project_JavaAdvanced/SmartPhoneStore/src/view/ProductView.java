//package SmartPhoneStore.src.view;
//
//import SmartPhoneStore.src.model.entity.Product;
//import SmartPhoneStore.src.model.entity.Category;
//import SmartPhoneStore.src.service.ProductService;
//import SmartPhoneStore.src.service.CategoryService;
//import SmartPhoneStore.src.util.Console;
//import java.sql.SQLException;
//import java.util.List;
//
//public class ProductView {
//    private ProductService productService;
//    private CategoryService categoryService;
//
//    public ProductView() {
//        this.productService = new ProductService();
//        this.categoryService = new CategoryService();
//    }
//
//    public void viewAllProducts() throws SQLException {
//        System.out.println("DANH SACH SAN PHAM");
//
//        List<Product> products = productService.getAllProducts();
//
//        if (products.isEmpty()) {
//            Console.printInfo("Chua co san pham nao");
//        } else {
//            Console.printTableHeader("ID", "TEN SAN PHAM", "HANG", "GIA", "TON KHO", "DANH MUC");
//            for (Product p : products) {
//                Console.printTableRow(p.getId(),
//                        p.getName().length() > 18 ? p.getName().substring(0, 15) + "..." : p.getName(),
//                        p.getBrand(),
//                        p.getPrice() + " VND",
//                        p.getStock(),
//                        p.getCategoryName() != null ? p.getCategoryName() : "");
//            }
//            Console.printTableFooter();
//        }
//    }
//
//    public void searchProducts() throws SQLException {
////        ConsoleUtils.clearScreen();
//        System.out.println("- - - - Tìm kiếm sản phẩm:");
//
//        String keyword = Console.inputString("Nhap tu khoa tim kiem: ");
//        List<Product> products = productService.searchProducts(keyword);
//
//        if (products.isEmpty()) {
//            Console.printInfo("Khong tim thay san pham nao");
//        } else {
//            Console.printTableHeader("ID", "TEN SAN PHAM", "HANG", "GIA", "TON KHO");
//            for (Product p : products) {
//                Console.printTableRow(p.getId(),
//                        p.getName().length() > 18 ? p.getName().substring(0, 15) + "..." : p.getName(),
//                        p.getBrand(),
//                        p.getPrice() + " VND",
//                        p.getStock());
//            }
//            Console.printTableFooter();
//        }
//    }
//
//    public void viewProductDetail() throws SQLException {
//        int productId = Console.inputInt("Nhap ID san pham: ");
//        Product product = productService.getProductById(productId);
//
//        if (product == null) {
//            Console.printError("Khong tim thay san pham");
//            return;
//        }
//
//        System.out.println("CHI TIET SAN PHAM");
//
//        Console.printSeparator();
//        System.out.println("ID: " + product.getId());
//        System.out.println("Ten: " + product.getName());
//        System.out.println("Hang: " + product.getBrand());
//        System.out.println("Dung luong: " + (product.getCapacity() != null ? product.getCapacity() : ""));
//        System.out.println("Mau sac: " + (product.getColor() != null ? product.getColor() : ""));
//        System.out.println("Gia: " + product.getPrice() + " VND");
//        System.out.println("Ton kho: " + product.getStock());
//        System.out.println("Danh muc: " + (product.getCategoryName() != null ? product.getCategoryName() : ""));
//        System.out.println("Mo ta: " + (product.getDescription() != null ? product.getDescription() : ""));
//        Console.printSeparator();
//    }
//
//    public void viewProductsByCategory() throws SQLException {
//        System.out.println("SAN PHAM THEO DANH MUC");
//
//        List<Category> categories = categoryService.getAllCategories();
//
//        if (categories.isEmpty()) {
//            Console.printInfo("Chua co danh muc nao");
//            return;
//        }
//
//        Console.printTableHeader("ID", "TEN DANH MUC");
//        for (Category c : categories) {
//            Console.printTableRow(c.getId(), c.getName());
//        }
//        Console.printTableFooter();
//
//        int categoryId = Console.inputInt("Nhap ID danh muc: ");
//        List<Product> products = productService.getProductsByCategory(categoryId);
//
//        if (products.isEmpty()) {
//            Console.printInfo("Khong co san pham trong danh muc nay");
//        } else {
//            Console.printTableHeader("ID", "TEN SAN PHAM", "GIA", "TON KHO");
//            for (Product p : products) {
//                Console.printTableRow(p.getId(),
//                        p.getName().length() > 25 ? p.getName().substring(0, 22) + "..." : p.getName(),
//                        p.getPrice() + " VND",
//                        p.getStock());
//            }
//            Console.printTableFooter();
//        }
//    }
//}