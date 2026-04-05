package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.view;

import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.User;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.Category;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.Product;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.Order;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.OrderDetail;
import static JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.util.Console.getStatusText;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.service.CategoryService;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.service.ProductService;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.service.OrderService;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.service.ReportService;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.util.Console;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class AdminView {
    private CategoryService categoryService;
    private ProductService productService;
    private OrderService orderService;
    private ReportService reportService;

    public AdminView() {
        this.categoryService = new CategoryService();
        this.productService = new ProductService();
        this.orderService = new OrderService();
        this.reportService = new ReportService();
    }

    public void showMenu(User admin) {
        while (true) {
            System.out.println("\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.printf("|   Hello , %-28s |\n", admin.getFullName() + " !!");
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━ Management ━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("|                                          |                                                 |");
            System.out.println("|     1. Quan Ly Danh Muc                  |                2. Quan Ly San Pham              |");
            System.out.println("|                                          |                                                 |");
            System.out.println("|━━━━━━━━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━|");
            System.out.println("|                            |                               |                               |");
            System.out.println("|    3. Quan Ly Don Hang     |    4. Thong Ke & Bao Cao      |         0. Logout             |");
            System.out.println("|                            |                               |                               |");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

            int choice = Console.inputInt("Lua chon cua ban: ");

            switch (choice) {
                case 1 -> manageCategories();
                case 2 -> manageProducts();
                case 3 -> manageOrders();
                case 4 -> showReports();
                case 0 -> {
                    Console.printSuccess("Dang xuat thanh cong !!");
                    return;
                }
                default -> Console.printError("Lua chon khong hop le !!");
            }
        }
    }

    private void manageCategories() {
        while (true) {
            System.out.println("""
                ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
                |                               Quan Ly Danh Muc                            |
                ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
                ┃                                                                           ┃
                ┃    1. Them Danh Muc Moi                                                   ┃
                ┃    2. Sua Danh Muc                                                        ┃
                ┃    3. Xoa Danh Muc                                                        ┃
                ┃    4. Xem Danh Sach Danh Muc                                              ┃
                ┃    0. Quay Lai                                                            ┃
                ┃                                                                           ┃
                ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
            """);

            int choice = Console.inputInt("Lua chon cua ban: ");

            try {
                switch (choice) {
                    case 1 -> addCategory();
                    case 2 -> updateCategory();
                    case 3 -> deleteCategory();
                    case 4 -> viewAllCategories();
                    case 0 -> {
                        return;
                    }
                    default -> Console.printError("Lua chon khong hop le !!");
                }
            } catch (SQLException e) {
                Console.printError("Loi ket noi database: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                Console.printError(e.getMessage());
            }
        }
    }

    private void addCategory() throws SQLException {
        System.out.println("\n- - - - Them danh muc moi:");

        String name = Console.inputString("Ten danh muc: ");
        String description = Console.inputString("Mo ta: ");

        if (categoryService.addCategory(name, description)) {
            System.out.println("Them danh muc thanh cong !!");
        } else {
            Console.printError("Them danh muc that bai !!");
        }
    }

    private void deleteCategory() throws SQLException {
        System.out.println("\n- - - - Xoa danh muc");

        viewAllCategories();

        int id = Console.inputInt("Nhap ID danh muc can xoa: ");

        if (categoryService.deleteCategory(id)) {
            Console.printSuccess("Xoa danh muc thanh cong!");
        }
    }

    private void updateCategory() throws SQLException {
        System.out.println("\n- - - - Sua danh muc");

        viewAllCategories();

        int id = Console.inputInt("Nhap ID danh muc: ");

        Category category = categoryService.getCategoryById(id);

        if (category == null) {
            Console.printError("Khong tim thay danh muc !!");
            return;
        }

        Console.printInfo("Thong tin hien tai:");
        Console.printSeparator();
        System.out.println("Ten: " + category.getName());
        System.out.println("Mo ta: " + (category.getDescription() != null ? category.getDescription() : ""));
        Console.printSeparator();

        //Bo trong neu khong doi
        String name = Console.inputStringAllowEmpty("Ten moi: ");
        String description = Console.inputStringAllowEmpty("Mo ta moi: ");

        if (name.isEmpty()) {
            name = category.getName();
        }
        if (description.isEmpty()) {
            description = category.getDescription() != null ? category.getDescription() : "";
        }

        if (categoryService.updateCategory(id, name, description)) {
            Console.printSuccess("Cap nhat thanh cong !!");
        } else {
            Console.printError("Cap nhat that bai !!");
        }
    }

    private void viewAllCategories() throws SQLException {
        List<Category> categories = categoryService.getAllCategories();

        if (categories.isEmpty()) {
            Console.printInfo("Chua co danh muc nao !!");
        } else {
            System.out.println("\n┌─── Danh sach danh muc ────┐");
            System.out.println("┌──────┬──────────────────────────────┬────────────────────────────────────────────┐");
            System.out.printf("│ %-4s │ %-28s │ %-42s │\n", "ID", "Ten Danh Muc", "Mo Ta");
            System.out.println("├──────┼──────────────────────────────┼────────────────────────────────────────────┤");
            for (Category c : categories) {
                System.out.printf("│ %-4s │ %-28s │ %-42s │\n", c.getId(), c.getName(), c.getDescription() != null ? c.getDescription() : "");
            }
            System.out.println("└──────┴──────────────────────────────┴────────────────────────────────────────────┘");
        }
    }

    private void manageProducts() {
        while (true) {
            System.out.println();
            System.out.println("""
            ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
            |                               Quan Ly San Pham                           |
            ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
            ┃                                                                          ┃
            ┃    1. Them San Pham Moi                                                  ┃
            ┃    2. Sua Thong Tin San Pham                                             ┃
            ┃    3. Xoa San Pham                                                       ┃
            ┃    4. Xem Tat Ca San Pham                                                ┃
            ┃    5. Tim Kiem San Pham                                                  ┃
            ┃    6. Sap Xep Theo Gia                                                   ┃
            ┃    0. Quay Lai                                                           ┃
            ┃                                                                          ┃
            ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛""");

            int choice = Console.inputInt("Lua chon cua ban: ");

            try {
                switch (choice) {
                    case 1 -> addProduct();
                    case 2 -> updateProduct();
                    case 3 -> deleteProduct();
                    case 4 -> viewAllProducts();
                    case 5 -> searchProducts();
                    case 6 -> sortProducts();
                    case 0 -> {
                        return;
                    }
                    default -> Console.printError("Lua chon khong hop le !!");
                }
            } catch (SQLException e) {
                Console.printError("Loi ket noi database: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                Console.printError(e.getMessage());
            }
        }
    }

    private void addProduct() throws SQLException {
        System.out.println("\n- - - - Thêm sản phẩm mới:");
        String name = Console.inputString("Ten san pham: ");
        String brand = Console.inputString("Hang san xuat: ");
        String capacity = Console.inputCapacity("Dung luong (VD: 128, 256, 512...)MB: ", 1, 2048);
        String color = Console.inputString("Mau sac: ");
        double price = Console.inputDouble("Gia ban: ");
        int stock = Console.inputInt("So luong ton kho: ");
        String description = Console.inputString("Mo ta: ");
        viewAllCategories();
        int categoryId = Console.inputInt("ID danh muc: ");



        if (productService.addProduct(name, brand, capacity, color, price, stock, description, categoryId)) {
            Console.printSuccess("Them san pham thanh cong !!");
        } else {
            Console.printError("Them san pham that bai !!");
        }
    }

    private void updateProduct() throws SQLException {
        System.out.println("\n- - - - Sửa sản phẩm:");

        viewAllProducts();
        System.out.println();

        int id = Console.inputInt("Nhap ID san pham: ");

        Product product = productService.getProductById(id);

        if (product == null) {
            Console.printError("Khong tim thay san pham !!");
            return;
        }

        System.out.println();
        Console.printInfo("Thong tin hien tai:");
        Console.printSeparator();
        System.out.println("Ten: " + product.getName());
        System.out.println("Hang: " + product.getBrand());
        System.out.println("Dung luong: " + product.getCapacity());
        System.out.println("Mau: " + product.getColor());
        System.out.println("Gia: " + product.getPrice());
        System.out.println("Ton kho: " + product.getStock());
        System.out.println("Mo ta: " + product.getDescription());
        System.out.println("Danh muc ID: " + product.getCategoryId());
        Console.printSeparator();

        //bo trong neu khong doi
        String name = Console.inputString("Ten moi : ");
        String brand = Console.inputString("Hang moi: ");
        String capacityStr = Console.inputString("Dung luong moi: ");


        String color = Console.inputString("Mau moi: ");
        String priceStr = Console.inputString("Gia moi: ");
        String stockStr = Console.inputString("Ton kho moi: ");
        String description = Console.inputString("Mo ta moi: ");
        String categoryIdStr = Console.inputString("ID danh muc moi: ");

        if (name.isEmpty()) name = product.getName();
        if (brand.isEmpty()) brand = product.getBrand();
        //if (capacity.isEmpty()) capacity = product.getCapacity();
        String capacity = capacityStr.isEmpty() ? product.getCapacity() : parseCapacity(capacityStr, product.getCapacity());
        if (color.isEmpty()) color = product.getColor();
        double price = priceStr.isEmpty() ? product.getPrice().doubleValue() : Double.parseDouble(priceStr);
        int stock = stockStr.isEmpty() ? product.getStock() : Integer.parseInt(stockStr);
        if (description.isEmpty()) description = product.getDescription();
        int categoryId = categoryIdStr.isEmpty() ? product.getCategoryId() : Integer.parseInt(categoryIdStr);

        if (productService.updateProduct(id, name, brand, capacity, color, price, stock, description, categoryId)) {
            Console.printSuccess("Cap nhat san pham thanh cong!");
        } else {
            Console.printError("Cap nhat that bai!");
        }
    }

    private void deleteProduct() throws SQLException {
        System.out.println("\n- - - - Xóa sản phẩm:");

        viewAllProducts();
        System.out.println();

        int id = Console.inputInt("Nhap ID san pham: ");

        Product product = productService.getProductById(id);
        if (product == null) {
            Console.printError("Khong tim thay san pham !!");
            return;
        }

        boolean confirm = Console.inputBoolean("Ban co chac chan muon xoa san pham nay? (y/n): ");
        if (confirm) {
            if (productService.deleteProduct(id)) {
                Console.printSuccess("Xoa san pham thanh cong !!");
            } else {
                Console.printError("Xoa san pham that bai !!");
            }
        } else {
            Console.printInfo("Da huy xoa san pham");
        }
    }

    private void viewAllProducts() throws SQLException {
        int currentPage = 1;
        int totalPages = productService.getTotalPages();

        if (totalPages == 0) {
            Console.printInfo("Chua co san pham nao !!");
            return;
        }

        while (true) {
            List<Product> products = productService.getProductsByPage(currentPage);

            System.out.println("\n┌─── Danh sach san pham ────┐");
            System.out.println("┌─────┬──────────────────────────────┬──────────────────────┬────────────┬──────────────┬──────────────────────┬──────────────┐");
            System.out.printf("│ %-4s│ %-28s │ %-20s │ %-10s │ %-12s │ %-20s │ %-12s │\n", "ID", "Ten San Pham", "Hang", "Dung Luong", "Mau Sac", "Gia", "Ton Kho");
            System.out.println("├─────┼──────────────────────────────┼──────────────────────┼────────────┼──────────────┼──────────────────────┼──────────────┤");

            for (Product p : products) {
                String nameDisplay = p.getName().length() > 25 ? p.getName().substring(0, 22) + "..." : p.getName();
                String capacityDisplay = p.getCapacity() != null ? p.getCapacity() : "N/A";
                String colorDisplay = p.getColor() != null ? p.getColor() : "N/A";

                System.out.printf("│ %-4s│ %-28s │ %-20s │ %-10s │ %-12s │ %-20s │ %-12d │\n", p.getId(), nameDisplay, p.getBrand(), capacityDisplay, colorDisplay, p.getPrice() + " VND", p.getStock());
            }
            System.out.println("└─────┴──────────────────────────────┴──────────────────────┴────────────┴──────────────┴──────────────────────┴──────────────┘");

            int startPage = Math.max(1, currentPage - 2);
            int endPage = Math.min(totalPages, currentPage + 2);

            System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
            for (int i = startPage; i <= endPage; i++) {
                if (i == currentPage) {
                    System.out.print(" [" + i + "] ");
                } else {
                    System.out.print(" " + i + " ");
                }
            }
            System.out.print("\t\t\t\t\t\t\t\t");
            System.out.print("[So] Trang | [0] Thoat\n");

            String input = Console.inputString("Lua chon: ");

            if (input.equals("0")) {
                break;
            }

            try {
                int pageNumber = Integer.parseInt(input);
                if (pageNumber >= 1 && pageNumber <= totalPages) {
                    currentPage = pageNumber;
                } else {
                    Console.printError("Trang khong hop le! (1-" + totalPages + ")");
                }
            } catch (NumberFormatException e) {
                Console.printError("Vui long nhap so!");
            }
        }
    }

    private void sortProducts() throws SQLException {
        System.out.println("1. Sap xep theo gia tang dan (a->z)");
        System.out.println("2. Sap xep theo gia giam dan (z->a)");
        System.out.println("0. Quay lai");

        int choice = Console.inputInt("Lua chon: ");

        List<Product> products;
        if (choice == 1) {
            products = productService.getAllProductsSortedByPrice("ASC");
            Console.printInfo("Sap xep theo gia tang dan:");
        } else if (choice == 2) {
            products = productService.getAllProductsSortedByPrice("DESC");
            Console.printInfo("Sap xep theo gia giam dan:");
        } else {
            return;
        }

        if (products.isEmpty()) {
            Console.printInfo("Chua co san pham nao !!");
        } else {
            System.out.println("\n┌─── Danh sach san pham ────┐");
            System.out.println("┌─────┬──────────────────────────────┬──────────────────────┬────────────┬──────────────┬──────────────────────┬──────────────┐");
            System.out.printf("│ %-4s│ %-28s │ %-20s │ %-10s │ %-12s │ %-20s │ %-12s │\n", "ID", "Ten San Pham", "Hang", "Dung Luong", "Mau Sac", "Gia", "Ton Kho");
            System.out.println("├─────┼──────────────────────────────┼──────────────────────┼────────────┼──────────────┼──────────────────────┼──────────────┤");

            for (Product p : products) {
                String nameDisplay = p.getName().length() > 25 ? p.getName().substring(0, 22) + "..." : p.getName();
                String capacityDisplay = p.getCapacity() != null ? p.getCapacity() : "N/A";
                String colorDisplay = p.getColor() != null ? p.getColor() : "N/A";

                System.out.printf("│ %-4s│ %-28s │ %-20s │ %-10s │ %-12s │ %-20s │ %-12d │\n", p.getId(), nameDisplay, p.getBrand(), capacityDisplay, colorDisplay, p.getPrice() + " VND", p.getStock());
            }
            System.out.println("└─────┴──────────────────────────────┴──────────────────────┴────────────┴──────────────┴──────────────────────┴──────────────┘");
        }
    }

    private void searchProducts() throws SQLException {
        String keyword = Console.inputString("Nhap tu khoa tim kiem: ");

        int currentPage = 1;
        int totalPages = productService.getSearchTotalPages(keyword);

        if (totalPages == 0) {
            Console.printInfo("Khong tim thay san pham nao !!");
            return;
        }

        while (true) {
            List<Product> products = productService.searchProductsByPage(keyword, currentPage);

            System.out.println("\n┌─── Tim kiem San Pham ────┐");
            System.out.println("┌─────┬──────────────────────────────┬──────────────────────┬────────────┬──────────────┬──────────────────────┬──────────────┐");
            System.out.printf("│ %-4s│ %-28s │ %-20s │ %-10s │ %-12s │ %-20s │ %-12s │\n", "ID", "Ten San Pham", "Hang", "Dung Luong", "Mau Sac", "Gia", "Ton Kho");
            System.out.println("├─────┼──────────────────────────────┼──────────────────────┼────────────┼──────────────┼──────────────────────┼──────────────┤");

            for (Product p : products) {
                String nameDisplay = p.getName().length() > 25 ? p.getName().substring(0, 22) + "..." : p.getName();
                String capacityDisplay = p.getCapacity() != null ? p.getCapacity() : "N/A";
                String colorDisplay = p.getColor() != null ? p.getColor() : "N/A";

                System.out.printf("│ %-4s│ %-28s │ %-20s │ %-10s │ %-12s │ %-20s │ %-12d │\n", p.getId(), nameDisplay, p.getBrand(), capacityDisplay, colorDisplay, p.getPrice() + " VND", p.getStock());
            }
            System.out.println("└─────┴──────────────────────────────┴──────────────────────┴────────────┴──────────────┴──────────────────────┴──────────────┘");

            int startPage = Math.max(1, currentPage - 2);
            int endPage = Math.min(totalPages, currentPage + 2);

            System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
            for (int i = startPage; i <= endPage; i++) {
                if (i == currentPage) {
                    System.out.print(" [" + i + "] ");
                } else {
                    System.out.print(" " + i + " ");
                }
            }
            System.out.print("\t\t\t\t\t\t\t\t");
            System.out.print("[So] Trang | [0] Thoat\n");

            String input = Console.inputString("Lua chon: ");

            if (input.equals("0")) {
                break;
            }

            try {
                int pageNumber = Integer.parseInt(input);
                if (pageNumber >= 1 && pageNumber <= totalPages) {
                    currentPage = pageNumber;
                } else {
                    Console.printError("Trang khong hop le! (1-" + totalPages + ")");
                }
            } catch (NumberFormatException e) {
                Console.printError("Vui long nhap so !!");
            }
        }
    }

    private void manageOrders() {
        while (true) {
            System.out.println();
            System.out.println("""
            ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
            |                                    Quan Ly Don Hang                                  |
            ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
            ┃                                                                                      ┃
            ┃    1. Xem Danh Sach Don Hang                                                         ┃
            ┃    2. Xem Don Hang Theo Trang Thai                                                   ┃
            ┃    3. Cap Nhat Trang Thai Don Hang                                                   ┃
            ┃    4. Xem Chi Tiet Don Hang                                                          ┃
            ┃    0. Quay Lai                                                                       ┃
            ┃                                                                                      ┃
            ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛""");

            int choice = Console.inputInt("Lua chon cua ban: ");

            try {
                switch (choice) {
                    case 1 -> viewAllOrders();
                    case 2 -> viewOrdersByStatus();
                    case 3 -> updateOrderStatus();
                    case 4 -> viewOrderDetail();
                    case 0 -> { return; }
                    default -> Console.printError("Lua chon khong hop le !!");
                }
            } catch (SQLException e) {
                Console.printError("Loi ket noi database: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                Console.printError(e.getMessage());
            }
        }
    }

    private void viewAllOrders() throws SQLException {
        List<Order> orders = orderService.getAllOrders();

        if (orders.isEmpty()) {
            Console.printInfo("Chua co don hang nao !!");
        } else {
            System.out.println("\n┌─── Danh sach đon hang ────┐");
            System.out.println("┌──────┬────────────────────────┬───────────────────────┬──────────────────────┬──────────────────────┐");
            System.out.printf("│ %-4s │ %-22s │ %-21s │ %-20s │ %-20s │\n", "ID", "Khach Hang", "Ngay Dat", "Tong Tien", "Trang Thai");
            System.out.println("├──────┼────────────────────────┼───────────────────────┼──────────────────────┼──────────────────────┤");
            for (Order o : orders) {
                System.out.printf("│ %-4s │ %-22s │ %-20s │ %-20s │ %-20s │\n", o.getId(), o.getUserFullName(), o.getOrderDate(), o.getTotalAmount() + " VND", getStatusText(o.getStatus()));
            }
            System.out.println("└──────┴────────────────────────┴───────────────────────┴──────────────────────┴──────────────────────┘");
        }
        System.out.println("- - - -");
    }

    private void viewOrdersByStatus() throws SQLException {
        System.out.println("\nCac trang thai: Pending, Shipping, Delivered, Cancelled");
        String status = Console.inputString("Nhap trang thai: ");

        List<Order> orders = orderService.getOrdersByStatus(status);

        if (orders.isEmpty()) {
            Console.printInfo("Khong co don hang nao voi trang thai: " + status.substring(0, 1).toUpperCase()
                    + status.substring(1).toLowerCase()
            );
        } else {
            System.out.println("\n┌─── Xem đon hang theo trang thai ────┐");
            System.out.println("┌──────┬──────────────────────────┬──────────────────────┬──────────────────────┬──────────────────────┐");
            System.out.printf("│ %-4s │ %-22s │ %-21s │ %-20s │ %-20s │\n", "ID", "Khach Hang", "Ngay Dat", "Tong Tien", "Trang Thai");
            System.out.println("├──────┼──────────────────────────┼──────────────────────┼──────────────────────┼──────────────────────┤");
            for (Order o : orders) {
                System.out.printf("│ %-4s │ %-22s │ %-21s │ %-20s │ %-20s │\n", o.getId(), o.getUserFullName(), o.getOrderDate(), o.getTotalAmount() + " VND", getStatusText(o.getStatus()));
            }
            System.out.println("└──────┴─────────────────────────┴──────────────────────┴──────────────────────┴──────────────────────┘");
        }
    }

    private void updateOrderStatus() throws SQLException {
        System.out.println("\n- - - - Cap nhat trang thai đon hang :");

        viewAllOrders();
        System.out.println();

        int orderId = Console.inputInt("Nhap ID don hang: ");

        Order order = orderService.getOrderById(orderId);
        if (order == null) {
            Console.printError("Khong tim thay don hang !!");
            return;
        }

        System.out.println();
        Console.printInfo("Trang thai hien tai: " + getStatusText(order.getStatus()));

        System.out.println("Cac trang thai co the: Pending, Shipping, Delivered, Cancelled");
        String newStatus = Console.inputString("Nhap trang thai moi: ");

        if (orderService.updateOrderStatus(orderId, newStatus)) {
            Console.printSuccess("Cap nhat thanh cong !!");
        } else {
            Console.printError("Cap nhat that bai !!");
        }
    }

    private void viewOrderDetail() throws SQLException {
        System.out.println("\n- - - - Chi tiet đon hang :");

        viewAllOrders();
        System.out.println();

        int orderId = Console.inputInt("Nhap ID don hang: ");

        Order order = orderService.getOrderById(orderId);

        if (order == null) {
            Console.printError("Khong tim thay don hang !!");
            return;
        }

//        System.out.println();
        Console.printInfo("\n- - - - Thong tin đon hang :");
        Console.printSeparator();

        System.out.println("Ma don hang: " + order.getId());
        System.out.println("Khach hang: " + order.getUserFullName());
        System.out.println("Ngay dat: " + order.getOrderDate());
        System.out.println("Dia chi giao: " + order.getShippingAddress());
        System.out.println("So dien thoai: " + order.getShippingPhone());
        System.out.println("Trang thai: " + getStatusText(order.getStatus()));
        System.out.println("Tong tien: " + order.getTotalAmount() + " VND");
        if (order.getCouponCode() != null) {
            System.out.println("Ma giam gia: " + order.getCouponCode());
            System.out.println("Giam gia: " + order.getDiscountAmount() + " VND");
        }

        Console.printSeparator();
        System.out.println();

        List<OrderDetail> details = orderService.getOrderDetails(orderId);

        if (details.isEmpty()) {
            Console.printInfo("Khong co san pham nao !!");
        } else {
            System.out.println("┌─── Chi tiet san pham ────┐");
            System.out.println("┌───────────────────────────┬──────────┬──────────────────┬────────────────────┐");
            System.out.printf("│ %-25s │ %-7s │ %-15s  │ %-17s  │\n", "San Pham", "So Luong", "Don Gia", "Thanh Tien");
            System.out.println("├───────────────────────────┼──────────┼──────────────────┼────────────────────┤");
            for (OrderDetail d : details) {
                BigDecimal subtotal = d.getPrice().multiply(BigDecimal.valueOf(d.getQuantity()));
                System.out.printf("│ %-25s │ %-7d  │ %-15s  │ %-17s  │\n", d.getProductName().length() > 25 ? d.getProductName().substring(0, 22) + "..." : d.getProductName(), d.getQuantity(), d.getPrice() + " VND", subtotal + " VND");
            }
            System.out.println("└───────────────────────────┴──────────┴──────────────────┴────────────────────┘");
        }
    }

    private void showReports() {
        while (true) {
            System.out.println();
            System.out.println("""
            ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
            |                             Thong Ke & Bao Cao                               |
            ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
            ┃                                                                              ┃
            ┃    1. Tong Doanh Thu                                                         ┃
            ┃    2. Top 5 San Pham Ban Chay                                                ┃
            ┃    3. Thong Ke Don Hang Theo Trang Thai                                      ┃
            ┃    0. Quay Lai                                                               ┃
            ┃                                                                              ┃
            ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛""");

            int choice = Console.inputInt("Lua chon cua ban: ");

            try {
                switch (choice) {
                    case 1 -> showTotalRevenue();
                    case 2 -> showTopProducts();
                    case 3 -> showOrderStatistics();
                    case 0 -> {
                        return;
                    }
                    default -> Console.printError("Lua chon khong hop le !!");
                }
            } catch (SQLException e) {
                Console.printError("Loi ket noi database: " + e.getMessage());
            }
        }
    }

    private void showTotalRevenue() throws SQLException {
        System.out.println("\n- - - - Tong Doanh Thu:");

        BigDecimal revenue = reportService.getTotalRevenue();

        Console.printBox("Tong doanh thu tu cac don hang da giao: " + revenue + " VND");
    }

    private void showTopProducts() throws SQLException {
        java.util.Calendar now = java.util.Calendar.getInstance();
        int currentMonth = now.get(java.util.Calendar.MONTH) + 1;
        int currentYear = now.get(java.util.Calendar.YEAR);

        Map<String, Integer> topProducts = reportService.getTopSellingProducts(5);

        if (topProducts.isEmpty()) {
            Console.printInfo("Chua co du lieu thong ke cho thang " + currentMonth + "/" + currentYear + "!!");
        } else {
            System.out.println("┌─ Top 5 san pham ban chay nhat thang " + currentMonth + "/" + currentYear + " ─┐");
            System.out.println("┌─────┬───────────────────────────┬─────────────────┐");
            System.out.printf("│ %-3s │ %-25s │ %-14s │\n", "STT", "San Pham", "So Luong Da Ban");
            System.out.println("├─────┼───────────────────────────┼─────────────────┤");
            int stt = 1;
            for (Map.Entry<String, Integer> entry : topProducts.entrySet()) {
                System.out.printf("│ %-3d │ %-25s │ %-14d  │\n", stt++, entry.getKey(), entry.getValue());
            }
            System.out.println("└─────┴───────────────────────────┴─────────────────┘");
        }
    }

    private void showOrderStatistics() throws SQLException {
        Map<String, Integer> stats = reportService.getOrderStatistics();

        System.out.println("┌ Thong Ke Don Hang Theo Trang Thai ┐");
        System.out.println("┌──────────────────────┬────────────┐");
        System.out.printf("│ %-20s │ %-10s │\n", "Trang Thai", "So Luong");
        System.out.println("├──────────────────────┼────────────┤");
        for (Map.Entry<String, Integer> entry : stats.entrySet()) {
            System.out.printf("│ %-20s │ %-10d │\n", getStatusText(entry.getKey()), entry.getValue());
        }
        System.out.println("└──────────────────────┴────────────┘");
    }

    private String parseCapacity(String input, String defaultValue) {
        try {
            int value = Integer.parseInt(input.trim());
            if (value >= 1 && value <= 2048) {
                return value + "GB";
            } else {
                Console.printError("Dung luong phai tu 1GB den 2048GB !!");
                return defaultValue;
            }
        } catch (NumberFormatException e) {
            Console.printError("Dung luong nhap khong hop le !!");
            return defaultValue;
        }
    }
}