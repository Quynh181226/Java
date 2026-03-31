//package SmartPhoneStore.src.view;
//
//import SmartPhoneStore.src.model.entity.Product;
//import SmartPhoneStore.src.model.entity.Order;
//import SmartPhoneStore.src.model.entity.OrderDetail;
//import SmartPhoneStore.src.service.CartService;
//import SmartPhoneStore.src.service.OrderService;
//import SmartPhoneStore.src.service.CouponService;
//import SmartPhoneStore.src.service.ProductService;
//import SmartPhoneStore.src.util.Console;
//import java.math.BigDecimal;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//public class CartView {
//    private CartService cartService;
//    private OrderService orderService;
//    private CouponService couponService;
//    private ProductService productService;
//    private int userId;
//    private String userAddress;
//    private String userPhone;
//    private String userName;
//
//    public CartView(int userId, String userName, String userPhone, String userAddress) {
//        this.cartService = new CartService();
//        this.orderService = new OrderService();
//        this.couponService = new CouponService();
//        this.productService = new ProductService();
//        this.userId = userId;
//        this.userName = userName;
//        this.userPhone = userPhone;
//        this.userAddress = userAddress;
//    }
//
//    public void showCart() throws SQLException {
//        while (true) {
//            System.out.println("GIO HANG CUA BAN");
//
//            if (cartService.isEmpty()) {
//                Console.printInfo("Gio hang trong");
//                return;
//            }
//
////            Console.printTableHeader("ID", "SAN PHAM", "SO LUONG", "DON GIA", "THANH TIEN");
////            for (Map.Entry<Integer, CartService.CartItem> entry : cartService.getCart().entrySet()) {
////                CartService.CartItem item = entry.getValue();
////                Console.printTableRow(
////                        item.getProduct().getId(),
////                        item.getProduct().getName().length() > 18 ?
////                                item.getProduct().getName().substring(0, 15) + "..." :
////                                item.getProduct().getName(),
////                        item.getQuantity(),
////                        item.getProduct().getPrice() + " VND",
////                        item.getSubtotal() + " VND");
////            }
////            Console.printTableFooter();
//            System.out.println("┌────┬──────────────────────────────┬──────────────┬──────────────────────┬──────────────────────┐");
//            System.out.printf("│ %-4s │ %-28s │ %-12s │ %-20s │ %-20s │\n",
//                    "ID", "SAN PHAM", "SO LUONG", "DON GIA", "THANH TIEN");
//            System.out.println("├────┼──────────────────────────────┼──────────────┼──────────────────────┼──────────────────────┤");
//
//            for (Map.Entry<Integer, CartService.CartItem> entry : cartService.getCart().entrySet()) {
//                CartService.CartItem item = entry.getValue();
//                String productName = item.getProduct().getName().length() > 25 ?
//                        item.getProduct().getName().substring(0, 22) + "..." :
//                        item.getProduct().getName();
//
//                System.out.printf("│ %-4d │ %-28s │ %-12d │ %-20s │ %-20s │\n",
//                        item.getProduct().getId(),
//                        productName,
//                        item.getQuantity(),
//                        item.getProduct().getPrice() + " VND",
//                        item.getSubtotal() + " VND");
//            }
//
//            System.out.println("└────┴──────────────────────────────┴──────────────┴──────────────────────┴──────────────────────┘");
//
//            System.out.println("Tong cong: " + cartService.getTotalAmount() + " VND");
//            Console.printSeparator();
//
//            System.out.println("1. Cap nhat so luong");
//            System.out.println("2. Xoa san pham");
//            System.out.println("3. Thanh toan");
//            System.out.println("0. Quay lai");
//
//            int choice = Console.inputInt("Lua chon: ");
//
//            if (choice == 0) {
//                break;
//            } else if (choice == 1) {
//                updateQuantity();
//            } else if (choice == 2) {
//                removeItem();
//            } else if (choice == 3) {
//                checkout();
//                break;
//            }
//        }
//    }
//
//    private void updateQuantity() {
//        int productId = Console.inputInt("Nhap ID san pham: ");
//        int quantity = Console.inputInt("Nhap so luong moi: ");
//
//        try {
//            cartService.updateQuantity(productId, quantity);
//            Console.printSuccess("Da cap nhat gio hang");
//        } catch (IllegalArgumentException e) {
//            Console.printError(e.getMessage());
//        }
//    }
//
//    private void removeItem() {
//        int productId = Console.inputInt("Nhap ID san pham can xoa: ");
//        cartService.removeFromCart(productId);
//        Console.printSuccess("Da xoa san pham khoi gio hang");
//    }
//
//    private void checkout() throws SQLException {
//        System.out.println("THANH TOAN DON HANG");
//
//        Console.printInfo("Thong tin giao hang");
//        Console.printSeparator();
//        System.out.println("Ho ten: " + userName);
//        System.out.println("So dien thoai: " + userPhone);
//        System.out.println("Dia chi: " + userAddress);
//        Console.printSeparator();
//
//        String changeAddress = Console.inputString("Ban muon doi dia chi giao hang? (y/n): ");
//        String shippingAddress = userAddress;
//        String shippingPhone = userPhone;
//
//        if (changeAddress.equalsIgnoreCase("y")) {
//            shippingAddress = Console.inputString("Nhap dia chi giao hang moi: ");
//            shippingPhone = Console.inputString("Nhap so dien thoai moi: ");
//        }
//
//        String couponCode = Console.inputString("Nhap ma giam gia (bo trong neu khong co): ");
//        BigDecimal totalAmount = cartService.getTotalAmount();
//        BigDecimal discount = BigDecimal.ZERO;
//
//        if (!couponCode.isEmpty()) {
//            try {
//                discount = couponService.applyCoupon(couponCode, totalAmount);
//                Console.printSuccess("Ap dung ma giam gia thanh cong");
//                System.out.println("Giam: " + discount + " VND");
//            } catch (Exception e) {
//                Console.printError(e.getMessage());
//                couponCode = "";
//            }
//        }
//
//        BigDecimal finalAmount = totalAmount.subtract(discount);
//        System.out.println();
//        Console.printSeparator();
//        System.out.println("Tong tien: " + totalAmount + " VND");
//        System.out.println("Giam gia: " + discount + " VND");
//        System.out.println("Thanh toan: " + finalAmount + " VND");
//        Console.printSeparator();
//
//        System.out.println("1. Xac nhan dat hang");
//        System.out.println("0. Huy");
//
//        int choice = Console.inputInt("Lua chon: ");
//
//        if (choice == 1) {
//            Order order = new Order();
//            order.setUserId(userId);
//            order.setTotalAmount(finalAmount);
//            order.setStatus("Pending");
//            order.setShippingAddress(shippingAddress);
//            order.setShippingPhone(shippingPhone);
//            order.setCouponCode(couponCode.isEmpty() ? null : couponCode);
//            order.setDiscountAmount(discount);
//
//            List<OrderDetail> details = new ArrayList<>();
//            for (Map.Entry<Integer, CartService.CartItem> entry : cartService.getCart().entrySet()) {
//                CartService.CartItem item = entry.getValue();
//                OrderDetail detail = new OrderDetail();
//                detail.setProductId(item.getProduct().getId());
//                detail.setQuantity(item.getQuantity());
//                detail.setPrice(item.getProduct().getPrice());
//                details.add(detail);
//            }
//
//            if (orderService.createOrder(order, details)) {
//                Console.printSuccess("Dat hang thanh cong");
//                if (!couponCode.isEmpty()) {
//                    couponService.useCoupon(couponCode);
//                }
//                cartService.clearCart();
//            } else {
//                Console.printError("Dat hang that bai");
//            }
//        }
//    }
//
//    public void addToCart(Product product, int quantity) {
//        try {
//            cartService.addToCart(product, quantity);
//            Console.printSuccess("Da them " + quantity + " san pham vao gio hang");
//        } catch (IllegalArgumentException e) {
//            Console.printError(e.getMessage());
//        }
//    }
//
//    public int getCartItemCount() {
//        return cartService.getTotalItems();
//    }
//
//    public boolean isCartEmpty() {
//        return cartService.isEmpty();
//    }
//}