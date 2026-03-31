package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.view;

import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.User;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.Product;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.Order;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.OrderDetail;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.Coupon;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.FlashSale;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.service.ProductService;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.service.OrderService;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.service.CartService;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.service.CouponService;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.service.FlashSaleService;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.service.ReportService;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.service.AuthService;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.util.Console;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class CustomerView {
    private ProductService productService;
    private OrderService orderService;
    private CartService cartService;
    private CouponService couponService;
    private FlashSaleService flashSaleService;
    private ReportService reportService;
    private AuthService authService;
    private User currentUser;

    public CustomerView() {
        this.productService = new ProductService();
        this.orderService = new OrderService();
        this.cartService = new CartService();
        this.couponService = new CouponService();
        this.flashSaleService = new FlashSaleService();
        this.reportService = new ReportService();
        this.authService = new AuthService();
    }

    public void showMenu(User customer) {
        this.currentUser = customer;

        while (true) {
            System.out.println("\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.printf("|   Hello , %-28s |\n", customer.getFullName() + " !!");
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━ SHOPPING ━━━━━━┳━━━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("|                             |                        |                       |                       |");
            System.out.println("|  1. XEM DANH SACH SAN PHAM  |  2. TIM KIEM SAN PHAM  |  3. QUAN LY GIO HANG  |  4. LICH SU DON HANG  |");
            System.out.println("|                             |                        |                       |                       |");
            System.out.println("|━━━━━━━━━━━━━━━━━━━━━━━━━━━┳━┻━━━━━━━━━━━━━━━━━━━━━━━━┻━━┳━━━━━━━━━━━━━━━━━━━━┻━┳━━━━━━━━━━━━━━━━━━━━━|");
            System.out.println("|                           |                             |                      |                     |");
            System.out.println("|    5. THONG TIN CA NHAN   |    6. SU DUNG MA GIAM GIA   |    7. FLASH SALE     |     0. DANG XUAT    |");
            System.out.println("|                           |                             |                      |                     |");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━┛");
//            System.out.println();
            int choice = Console.inputInt("Lua chon cua ban: ");

            try {
                switch (choice) {
                    case 1:
                        viewAllProducts();
                        break;
                    case 2:
                        searchProducts();
                        break;
                    case 3:
                        manageCart();
                        break;
                    case 4:
                        viewOrderHistory();
                        break;
                    case 5:
                        viewProfile();
                        break;
                    case 6:
                        useCoupon();
                        break;
                    case 7:
                        viewFlashSales();
                        break;
                    case 0:
                        Console.printSuccess("Dang xuat thanh cong!");
                        return;
                    default:
                        Console.printError("Lua chon khong hop le");
                }
            } catch (SQLException e) {
                Console.printError("Loi ket noi database: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                Console.printError(e.getMessage());
            }
        }
    }

private void viewAllProducts() throws SQLException {
    List<Product> products = productService.getAllProducts();

    if (products.isEmpty()) {
        Console.printInfo("Chua co san pham nao");
    } else {
        System.out.println("┌─── Danh Sách Sản Phẩm ────┐");
        System.out.println("┌────────────┬──────────────────────────────┬──────────────────────┬──────────────────────┬──────────────┐");
        System.out.printf ("│ %-10s │ %-28s │ %-20s │ %-20s │ %-12s │\n", "ID", "TEN SAN PHAM", "HANG", "GIA", "TON KHO");
        System.out.println("├────────────┼──────────────────────────────┼──────────────────────┼──────────────────────┼──────────────┤");

        for (Product p : products) {
            String name = p.getName().length() > 28
                    ? p.getName().substring(0, 25) + "..."
                    : p.getName();

            System.out.printf ("│ %-10s │ %-28s │ %-20s │ %-20s │ %-12s │\n",
                    p.getId(),
                    name,
                    p.getBrand(),
                    p.getPrice() + " VND",
                    p.getStock());
        }

        System.out.println("└────────────┴──────────────────────────────┴──────────────────────┴──────────────────────┴──────────────┘");
    }

    System.out.println();
    int productId = Console.inputInt("Nhap ID san pham de xem chi tiet (0 de quay lai): ");
    if (productId > 0) {
        viewProductDetail(productId);
    }
}

    private void viewProductDetail(int productId) throws SQLException {
        Product product = productService.getProductById(productId);
        if (product == null) {
            Console.printError("Khong tim thay san pham");
            return;
        }

        System.out.println("CHI TIET SAN PHAM");

        Console.printSeparator();
        System.out.println("ID: " + product.getId());
        System.out.println("Ten: " + product.getName());
        System.out.println("Hang: " + product.getBrand());
        System.out.println("Dung luong: " + product.getCapacity());
        System.out.println("Mau sac: " + product.getColor());
        System.out.println("Gia: " + product.getPrice() + " VND");
        System.out.println("Ton kho: " + product.getStock());
        System.out.println("Mo ta: " + product.getDescription());
        Console.printSeparator();

        int quantity = Console.inputInt("Nhap so luong muon mua (0 de quay lai): ");
        if (quantity > 0) {
            cartService.addToCart(product, quantity);
            Console.printSuccess("Da them " + quantity + " san pham vao gio hang");
        }
    }

    private void searchProducts() throws SQLException {
        System.out.println("TIM KIEM SAN PHAM");

        String keyword = Console.inputString("Nhap tu khoa tim kiem: ");
        List<Product> products = productService.searchProducts(keyword);

        if (products.isEmpty()) {
            Console.printInfo("Khong tim thay san pham nao");
        } else {
            System.out.println("┌─── Danh Sách Sản Phẩm ────┐");
            System.out.println("├────────────┬──────────────────────────────┬──────────────────────┬──────────────────────┬──────────────┤");
            System.out.printf ("│ %-10s │ %-28s │ %-20s │ %-20s │ %-12s │\n", "ID", "TEN SAN PHAM", "HANG", "GIA", "TON KHO");
            System.out.println("├────────────┼──────────────────────────────┼──────────────────────┼──────────────────────┼──────────────┤");

            for (Product p : products) {
                String name = p.getName().length() > 28
                        ? p.getName().substring(0, 25) + "..."
                        : p.getName();

                System.out.printf ("│ %-10s │ %-28s │ %-20s │ %-20s │ %-12s │\n", p.getId(), name, p.getBrand(), p.getPrice() + " VND", p.getStock());
            }

            System.out.println("└────────────┴──────────────────────────────┴──────────────────────┴──────────────────────┴──────────────┘");
        }
    }

    private void manageCart() throws SQLException {
        while (true) {
            System.out.println("GIO HANG CUA BAN");

            if (cartService.isEmpty()) {
                Console.printInfo("Gio hang trong");
                return;
            }

            System.out.println("┌─── Giỏ hàng ────┐");
            System.out.println("├────────────┬──────────────────────────────┬──────────────────────┬──────────────────────┬──────────────┤");
            System.out.printf ("│ %-10s │ %-28s │ %-20s │ %-20s │ %-12s │\n", "ID", "SAN PHAM", "SO LUONG", "DON GIA", "THANH TIEN");
            System.out.println("├────────────┼──────────────────────────────┼──────────────────────┼──────────────────────┼──────────────┤");

            for (Map.Entry<Integer, CartService.CartItem> entry : cartService.getCart().entrySet()) {
                CartService.CartItem item = entry.getValue();

                String name = item.getProduct().getName().length() > 28
                        ? item.getProduct().getName().substring(0, 25) + "..."
                        : item.getProduct().getName();

                System.out.printf ("│ %-10s │ %-28s │ %-20s │ %-20s │ %-12s │\n", item.getProduct().getId(), name, item.getQuantity(), item.getProduct().getPrice() + " VND", item.getSubtotal() + " VND");
            }

            System.out.println("└────────────┴──────────────────────────────┴──────────────────────┴──────────────────────┴──────────────┘");


            System.out.println("Tong cong: " + cartService.getTotalAmount() + " VND");
            Console.printSeparator();

            System.out.println("1. Cap nhat so luong");
            System.out.println("2. Xoa san pham");
            System.out.println("3. Thanh toan");
            System.out.println("0. Quay lai");

            int choice = Console.inputInt("Lua chon: ");

            if (choice == 0) {
                break;
            } else if (choice == 1) {
                int productId = Console.inputInt("Nhap ID san pham: ");
                int quantity = Console.inputInt("Nhap so luong moi: ");
                cartService.updateQuantity(productId, quantity);
                Console.printSuccess("Da cap nhat gio hang");
            } else if (choice == 2) {
                int productId = Console.inputInt("Nhap ID san pham can xoa: ");
                cartService.removeFromCart(productId);
                Console.printSuccess("Da xoa san pham khoi gio hang");
            } else if (choice == 3) {
                checkout();
                break;
            }
        }
    }

    private void checkout() throws SQLException {
        System.out.println("THANH TOAN DON HANG");

        Console.printInfo("Thong tin giao hang");
        Console.printSeparator();
        System.out.println("Ho ten: " + currentUser.getFullName());
        System.out.println("So dien thoai: " + currentUser.getPhone());
        System.out.println("Dia chi: " + currentUser.getAddress());
        Console.printSeparator();

        String couponCode = Console.inputString("Nhap ma giam gia (bo trong neu khong co): ");
        BigDecimal totalAmount = cartService.getTotalAmount();
        BigDecimal discount = BigDecimal.ZERO;

        if (!couponCode.isEmpty()) {
            try {
                Coupon coupon = couponService.getCouponByCode(couponCode);
                if (coupon != null && coupon.isValid()) {
                    discount = couponService.applyCoupon(couponCode, totalAmount);
                    Console.printSuccess("Ap dung ma giam gia thanh cong! Giam: " + discount + " VND");
                }
            } catch (Exception e) {
                Console.printError(e.getMessage());
            }
        }

        BigDecimal finalAmount = totalAmount.subtract(discount);
        System.out.println("Tong tien: " + totalAmount + " VND");
        System.out.println("Giam gia: " + discount + " VND");
        System.out.println("Thanh toan: " + finalAmount + " VND");

        System.out.println("1. Xac nhan dat hang");
        System.out.println("0. Huy");

        int choice = Console.inputInt("Lua chon: ");

        if (choice == 1) {
            Order order = new Order();
            order.setUserId(currentUser.getId());
            order.setTotalAmount(finalAmount);
            order.setStatus("Pending");
            order.setShippingAddress(currentUser.getAddress());
            order.setShippingPhone(currentUser.getPhone());
            order.setCouponCode(couponCode.isEmpty() ? null : couponCode);
            order.setDiscountAmount(discount);

            List<OrderDetail> details = new java.util.ArrayList<>();
            for (Map.Entry<Integer, CartService.CartItem> entry : cartService.getCart().entrySet()) {
                CartService.CartItem item = entry.getValue();
                OrderDetail detail = new OrderDetail();
                detail.setProductId(item.getProduct().getId());
                detail.setQuantity(item.getQuantity());
                detail.setPrice(item.getProduct().getPrice());
                details.add(detail);
            }

            OrderService orderService = new OrderService();
            if (orderService.createOrder(order, details)) {
                Console.printSuccess("Dat hang thanh cong!");
                if (!couponCode.isEmpty()) {
                    couponService.useCoupon(couponCode);
                }
                cartService.clearCart();
            } else {
                Console.printError("Dat hang that bai");
            }
        }
    }

    private void viewOrderHistory() throws SQLException {
        System.out.println("LICH SU DON HANG");

        List<Order> orders = orderService.getOrdersByUser(currentUser.getId());

        if (orders.isEmpty()) {
            Console.printInfo("Chua co don hang nao");
        } else {
            System.out.println("┌─── Lich Su Don Hang ────┐");
            System.out.println("├────────────┬──────────────────────┬────────────────────────┬─────────────────┤");
            System.out.printf ("│ %-10s │ %-20s │ %-22s │ %-15s │\n", "ID", "NGAY DAT", "TONG TIEN", "TRANG THAI");
            System.out.println("├────────────┼──────────────────────┼────────────────────────┼─────────────────┤");

            for (Order o : orders) {
                System.out.printf ("│ %-10s │ %-20s │ %-22s │ %-15s │\n", o.getId(), o.getOrderDate(), o.getTotalAmount() + " VND", getStatusText(o.getStatus()));
            }

            System.out.println("└────────────┴──────────────────────┴────────────────────────┴─────────────────┘");
        }

        int orderId = Console.inputInt("Nhap ID don hang de xem chi tiet (0 de quay lai): ");
        if (orderId > 0) {
            viewOrderDetail(orderId);
        }
    }

    private void viewOrderDetail(int orderId) throws SQLException {
        Order order = orderService.getOrderById(orderId);
        if (order == null || order.getUserId() != currentUser.getId()) {
            Console.printError("Khong tim thay don hang");
            return;
        }

        System.out.println("CHI TIET DON HANG");

        Console.printSeparator();
        System.out.println("Ma don hang: " + order.getId());
        System.out.println("Ngay dat: " + order.getOrderDate());
        System.out.println("Trang thai: " + getStatusText(order.getStatus()));
        System.out.println("Dia chi giao: " + order.getShippingAddress());
        System.out.println("So dien thoai: " + order.getShippingPhone());
        System.out.println("Tong tien: " + order.getTotalAmount() + " VND");
        if (order.getCouponCode() != null) {
            System.out.println("Ma giam gia: " + order.getCouponCode());
            System.out.println("Giam gia: " + order.getDiscountAmount() + " VND");
        }
        Console.printSeparator();

        List<OrderDetail> details = orderService.getOrderDetails(orderId);
        if (!details.isEmpty()) {
            System.out.println("┌─── Chi Tiet Don Hang ────┐");
            System.out.println("├──────────────────────────────┬──────────────┬──────────────────────┬──────────────────────┤");
            System.out.printf ("│ %-28s │ %-12s │ %-20s │ %-20s │\n", "SAN PHAM", "SO LUONG", "DON GIA", "THANH TIEN");
            System.out.println("├──────────────────────────────┼──────────────┼──────────────────────┼──────────────────────┤");

            for (OrderDetail d : details) {
                String name = d.getProductName().length() > 28
                        ? d.getProductName().substring(0, 25) + "..."
                        : d.getProductName();

                BigDecimal subtotal = d.getPrice().multiply(BigDecimal.valueOf(d.getQuantity()));

                System.out.printf ("│ %-28s │ %-12s │ %-20s │ %-20s │\n", name, d.getQuantity(), d.getPrice() + " VND", subtotal + " VND");
            }

            System.out.println("└──────────────────────────────┴──────────────┴──────────────────────┴──────────────────────┘");
        }
    }

    private void viewProfile() throws SQLException {
        while (true) {
            System.out.println("THONG TIN CA NHAN");

            Console.printSeparator();
            System.out.println("Ho ten: " + currentUser.getFullName());
            System.out.println("Email: " + currentUser.getEmail());
            System.out.println("So dien thoai: " + currentUser.getPhone());
            System.out.println("Dia chi: " + currentUser.getAddress());
            Console.printSeparator();

            System.out.println("1. Chinh sua thong tin");
            System.out.println("2. Doi mat khau");
            System.out.println("0. Quay lai");

            int choice = Console.inputInt("Lua chon: ");

            if (choice == 0) {
                break;
            } else if (choice == 1) {
                updateProfile();
            } else if (choice == 2) {
                changePassword();
            }
        }
    }

    private void updateProfile() throws SQLException {
        System.out.println("- - - - Chỉnh sửa thông tin:");

        String fullName = Console.inputString("Ho ten moi (bo trong neu khong doi): ");
        String phone = Console.inputString("So dien thoai moi (bo trong neu khong doi): ");
        String address = Console.inputString("Dia chi moi (bo trong neu khong doi): ");

        if (fullName.isEmpty()) fullName = currentUser.getFullName();
        if (phone.isEmpty()) phone = currentUser.getPhone();
        if (address.isEmpty()) address = currentUser.getAddress();

        if (authService.updateProfile(currentUser.getId(), fullName, phone, address)) {
            currentUser.setFullName(fullName);
            currentUser.setPhone(phone);
            currentUser.setAddress(address);
            Console.printSuccess("Cap nhat thong tin thanh cong");
        } else {
            Console.printError("Cap nhat that bai");
        }
    }

    private void changePassword() throws SQLException {
        System.out.println("DOI MAT KHAU");

        String oldPassword = Console.inputString("Mat khau cu: ");
        String newPassword = Console.inputString("Mat khau moi: ");
        String confirmPassword = Console.inputString("Xac nhan mat khau moi: ");

        if (!newPassword.equals(confirmPassword)) {
            Console.printError("Mat khau xac nhan khong khop");
            return;
        }

        if (authService.changePassword(currentUser.getId(), oldPassword, newPassword)) {
            Console.printSuccess("Doi mat khau thanh cong");
        } else {
            Console.printError("Doi mat khau that bai");
        }
    }

    private void useCoupon() throws SQLException {
        System.out.println("- - - - Mã giảm giá:");
        List<Coupon> coupons = couponService.getActiveCoupons();

        if (coupons.isEmpty()) {
            Console.printInfo("Hien khong co ma giam gia nao");
        } else {
            System.out.println("┌─── Ma Giam Gia ────┐");
            System.out.println("├──────────────────────┬──────────────┬──────────────────────┬──────────────────────┤");
            System.out.printf ("│ %-20s │ %-12s │ %-20s │ %-20s │\n", "MA", "GIAM", "TOI THIEU", "HAN SU DUNG");
            System.out.println("├──────────────────────┼──────────────┼──────────────────────┼──────────────────────┤");

            for (Coupon c : coupons) {
                System.out.printf ("│ %-20s │ %-12s │ %-20s │ %-20s │\n", c.getCode(), c.getDiscountPercent() + "%", c.getMinOrderAmount() + " VND", c.getValidTo());
            }

            System.out.println("└──────────────────────┴──────────────┴──────────────────────┴──────────────────────┘");
        }
    }

    private void viewFlashSales() throws SQLException {
        System.out.println("FLASH SALE");

        List<FlashSale> flashSales = flashSaleService.getActiveFlashSales();

        if (flashSales.isEmpty()) {
            Console.printInfo("Hien khong co chuong trinh flash sale nao");
        } else {
            System.out.println("┌─── Flash Sale ────┐");
            System.out.println("├────────────┬──────────────────────────────┬──────────────────────┬──────────────┬──────────────────────┤");
            System.out.printf ("│ %-10s │ %-28s │ %-20s │ %-12s │ %-20s │\n", "ID", "SAN PHAM", "GIA FLASH", "SO LUONG", "HAN DEN");
            System.out.println("├────────────┼──────────────────────────────┼──────────────────────┼──────────────┼──────────────────────┤");

            for (FlashSale fs : flashSales) {
                String name = fs.getProductName().length() > 28
                        ? fs.getProductName().substring(0, 25) + "..."
                        : fs.getProductName();

                System.out.printf ("│ %-10s │ %-28s │ %-20s │ %-12s │ %-20s │\n", fs.getId(), name, fs.getFlashPrice() + " VND", fs.getFlashQuantity(), fs.getEndTime());
            }

            System.out.println("└────────────┴──────────────────────────────┴──────────────────────┴──────────────┴──────────────────────┘");

            int choice = Console.inputInt("Nhap ID de mua ngay (0 de quay lai): ");
            if (choice > 0) {
                buyFlashSale(choice);
            }
        }
    }

    private void buyFlashSale(int flashSaleId) throws SQLException {
        FlashSale flashSale = flashSaleService.getFlashSaleById(flashSaleId);
        if (flashSale == null || !flashSale.isActive()) {
            Console.printError("Chuong trinh flash sale khong con hieu luc");
            return;
        }

        Console.printSeparator();
        System.out.println("San pham: " + flashSale.getProductName());
        System.out.println("Gia flash: " + flashSale.getFlashPrice() + " VND");
        System.out.println("So luong con: " + flashSale.getFlashQuantity());

        int quantity = Console.inputInt("Nhap so luong muon mua: ");

        if (quantity > 0 && quantity <= flashSale.getFlashQuantity()) {
            Product product = productService.getProductById(flashSale.getProductId());
            product.setPrice(flashSale.getFlashPrice());
            cartService.addToCart(product, quantity);
            flashSaleService.purchaseFlashSale(flashSaleId, quantity);
            Console.printSuccess("Da them vao gio hang voi gia flash sale");
        } else {
            Console.printError("So luong khong hop le");
        }
    }

    private String getStatusText(String status) {
        switch (status.toLowerCase()) {
            case "pending": return "Chờ xử lý";
            case "shipping": return "Đang giao";
            case "delivered": return "Đã giao";
            case "cancelled": return "Đã hủy";
            default: return status;
        }
    }
}