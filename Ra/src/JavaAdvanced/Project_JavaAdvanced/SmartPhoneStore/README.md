```markdown
# SmartPhoneStore - Hệ thống quản lý bán điện thoại

## Giới thiệu

SmartPhoneStore là ứng dụng quản lý bán điện thoại được viết bằng Java thuần túy (Core Java) với giao diện console. Hệ thống hỗ trợ đầy đủ các chức năng cho hai đối tượng người dùng: Admin và Customer.

### Mục tiêu dự án
- Xây dựng hệ thống quản lý bán hàng hoàn chỉnh
- Áp dụng các kỹ thuật lập trình Java: OOP, JDBC, Transaction, Exception Handling
- Đảm bảo an toàn dữ liệu với PreparedStatement và BCrypt
- Tối ưu trải nghiệm người dùng với giao diện console đẹp mắt

---

## Công nghệ sử dụng

| Công nghệ | Phiên bản | Mục đích |
|-----------|-----------|----------|
| Java | 17 | Ngôn ngữ lập trình chính |
| MySQL | 8.0+ | Cơ sở dữ liệu |
| JDBC | - | Kết nối và thao tác với database |
| BCrypt | - | Mã hóa mật khẩu |

---

## Cài đặt và chạy dự án

### 1. Yêu cầu hệ thống
- Java JDK 17 trở lên
- MySQL Server 8.0 trở lên
- IDE (IntelliJ IDEA, Eclipse, hoặc NetBeans) hoặc Terminal

### 2. Cài đặt Database

**Bước 1:** Tạo database
```sql
CREATE DATABASE smartphone_store;
USE smartphone_store;
```

**Bước 2:** Chạy file script `sql/db.sql` để tạo bảng và dữ liệu mẫu

Hoặc copy nội dung file `db.sql` và chạy trực tiếp trong MySQL Workbench.

### 3. Cấu hình kết nối
Mở file `util/DBConnection.java` và sửa thông tin kết nối:

```java
private static final String URL = "jdbc:mysql://localhost:3306/smartphone_store";
private static final String USER = "root";           // Tên đăng nhập MySQL
private static final String PASSWORD = "your_password"; // Mật khẩu MySQL
```

### 4. Chạy ứng dụng

#### Cách 1: Chạy bằng IDE
- Mở project trong IntelliJ/Eclipse/NetBeans
- Chạy file `Main.java`

--- 
***Cấu trúc thư mục dự án:*** 

    SmartPhoneStore/
        └── src/
            |── Main.java                                      # Điểm khởi chạy ứng dụng
            ├── dao/                                           # Data Access Object Layer
            │   ├── interfaces/                                # Interface cho các DAO
            │   │   ├── CategoryDAO.java
            │   │   ├── CouponDAO.java
            │   │   ├── CouponProductDAO.java
            │   │   ├── FlashSaleDAO.java
            │   │   ├── OrderDAO.java
            │   │   ├── OrderDetailDAO.java
            │   │   ├── ProductDAO.java
            │   │   └── UserDAO.java
            │   │
            │   └── imps/                                      # Implementation của các DAO
            │       ├── CategoryDAOImpl.java
            │       ├── CouponDAOImpl.java
            │       ├── CouponProductDAOImpl.java
            │       ├── FlashSaleDAOImpl.java
            │       ├── OrderDAOImpl.java
            │       ├── OrderDetailDAOImpl.java
            │       ├── ProductDAOImpl.java
            │       └── UserDAOImpl.java
            
            ├── model/                                         # Entity classes (DTO)
            │   ├── Category.java
            │   ├── Coupon.java
            │   ├── FlashSale.java
            │   ├── Order.java
            │   ├── OrderDetail.java
            │   ├── Product.java
            │   └── User.java
            
            ├── service/                                       # Business Logic Layer
            │   ├── AuthService.java                           # Xác thực người dùng
            │   ├── CartService.java                           # Quản lý giỏ hàng
            │   ├── CategoryService.java                       # Quản lý danh mục
            │   ├── CouponService.java                         # Quản lý mã giảm giá
            │   ├── FlashSaleService.java                      # Quản lý flash sale
            │   ├── OrderService.java                          # Quản lý đơn hàng
            │   ├── ProductService.java                        # Quản lý sản phẩm
            │   └── ReportService.java                         # Thống kê báo cáo
            
            ├── view/                                          # Presentation Layer (UI)
            │   ├── AdminView.java                             # Giao diện Admin
            │   ├── CustomerView.java                          # Giao diện Customer
            │   ├── LoginView.java                             # Đăng nhập
            │   ├── RegisterView.java                          # Đăng ký
            │   ├── ForgetPasswordView.java                    # Quên mật khẩu
            │   └── Home.java                                  # Màn hình chính
            
            ├── util/                                          # Tiện ích
            │   ├── BCrypt.java                                # Mã hóa mật khẩu
            │   ├── Color.java                                 # Màu sắc console
            │   ├── Console.java                               # Nhập/xuất console
            │   ├── DBConnection.java                          # Kết nối database
            │   └── Validator.java                             # Validation dữ liệu
            
            ├── exception/                                     # Custom exceptions
            │   ├── CouponExpiredException.java
            │   ├── DataAccessException.java
            │   ├── InsufficientStockException.java
            │   └── InvalidInputException.java
            
            └── sql/                                           # Script database
                └── db.sql                                     # Tạo bảng và dữ liệu mẫu

---
### _Chức năng chi tiết_

### Admin

| STT | Chức năng                    | Mô tả |
|-----|------------------------------|-------|
| 1   | Quản lý danh mục             | Thêm, sửa, xóa, xem danh sách hãng điện thoại |
| 2   | Quản lý sản phẩm             | CRUD sản phẩm, tìm kiếm, sắp xếp theo giá, phân trang |
| 3   | Quản lý đơn hàng             | Xem tất cả đơn hàng, cập nhật trạng thái (Pending → Shipping → Delivered) |
| 4   | Thống kê & báo cáo           | Doanh thu, top 5 sản phẩm bán chạy (theo tháng), thống kê đơn hàng |
| 5   | Quản lý khách hàng           | Xem danh sách khách hàng (đang phát triển) |
| 6   | Cập nhật thông tin cá nhân   | Thay đổi thông tin admin |

### Customer

| STT | Chức năng              | Mô tả |
|-----|------------------------|-------|
| 1   | Xem danh sách sản phẩm | Chỉ hiển thị sản phẩm còn hàng, có sắp xếp theo giá |
| 2   | Tìm kiếm sản phẩm      | Tìm kiếm tương đối theo tên sản phẩm |
| 3   | Quản lý giỏ hàng       | Thêm, sửa số lượng, xóa sản phẩm |
| 4   | Đặt hàng               | Xác nhận đơn hàng, áp dụng mã giảm giá, tự động trừ tồn kho |
| 5   | Lịch sử đơn hàng       | Xem danh sách đơn hàng đã đặt, chi tiết từng đơn |
| 6   | Flash Sale             | Xem và mua sản phẩm giảm giá theo khung giờ |
| 7   | Mã giảm giá            | Xem danh sách mã giảm giá đang có hiệu lực |
| 8   | Thông tin cá nhân      | Cập nhật thông tin, đổi mật khẩu |

### Tính năng bảo mật

| Tính năng                | Mô tả |
|--------------------------|-------|
| Mã hóa mật khẩu          | Sử dụng BCrypt, không lưu mật khẩu dạng plain text |
| Chống SQL Injection      | Sử dụng 100% PreparedStatement, không ghép chuỗi SQL |
| Phân quyền               | Admin và Customer có menu riêng biệt |
| Transaction              | Đặt hàng được bọc trong transaction, đảm bảo toàn vẹn dữ liệu |

### Validation đã được kiểm tra

| Trường hợp                        | Xử lý |
|-----------------------------------|-------|
| Email sai định dạng               | Bắt lỗi, yêu cầu nhập lại |
| Số điện thoại sai định dạng       | Kiểm tra regex, nhập lại |
| Nhập chữ vào ô số (giá, số lượng) | Bắt NumberFormatException |
| Đặt hàng khi kho = 0              | Kiểm tra tồn kho, không cho thêm vào giỏ |
| Mã giảm giá hết hạn               | Thông báo lỗi, không áp dụng |
| Flash sale hết số lượng           | Thông báo lỗi, không cho mua |

### Cấu trúc bảng dữ liệu (Database Schema)

| Bảng              | Mô tả |
|-------------------|-------|
| `users`           | Người dùng (admin, customer) |
| `categories`      | Danh mục sản phẩm (Apple, Samsung, Xiaomi...) |
| `products`        | Sản phẩm điện thoại |
| `orders`          | Đơn hàng |
| `order_details`   | Chi tiết đơn hàng |
| `coupons`         | Mã giảm giá |
| `coupon_products` | Sản phẩm áp dụng mã giảm giá |
| `coupon_brands`   | Hãng áp dụng mã giảm giá |
| `flash_sales`     | Chương trình flash sale |

### _Lưu ý khi chạy_

1. **MySQL phải đang chạy** trước khi khởi động ứng dụng
2. Đảm bảo **JDBC driver** (`mysql-connector-java-8.0.33.jar`) đã được thêm vào classpath
3. Nếu gặp lỗi kết nối, kiểm tra lại `USER` và `PASSWORD` trong `DBConnection.java`
4. Dữ liệu mẫu đã được insert sẵn qua file `db.sql`

### Xử lý lỗi thường gặp

| Lỗi                              | Nguyên nhân                          | Cách khắc phục |
|----------------------------------|--------------------------------------|----------------|
| `ClassNotFoundException`         | Thiếu JDBC driver                    | Thêm file `mysql-connector-java-8.0.33.jar` vào classpath |
| `SQLException: Access denied`    | Sai tài khoản MySQL                  | Kiểm tra lại USER và PASSWORD |
| `SQLException: Unknown database` | Database chưa được tạo               | Tạo database `smartphone_store` |
| Lỗi font chữ console             | Encoding không đúng                  | Chạy với `-Dfile.encoding=UTF-8` |

### Người thực hiện

| Họ tên  |
|---------|
| [Quỳnh] |

### _License_

Dự án được phát triển cho mục đích học tập.
