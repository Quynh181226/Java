#### 1.
users: chứa thông tin tài khoản, bao gồm cả admin và customer, phân quyền qua role. Lưu thông tin họ tên, email, số điện thoại, địa chỉ, mật khẩu mã hóa.
categories: danh mục sản phẩm (iPhone, Samsung, Xiaomi...)
products: sản phẩm điện thoại, với các thuộc tính: tên, hãng, dung lượng, màu sắc, giá, số lượng tồn kho, mô tả, danh mục.
flash_sales: (nâng cao) lưu thông tin sản phẩm tham gia flash sale: giá flash, số lượng flash, thời gian bắt đầu/kết thúc.
coupons: (nâng cao) mã giảm giá: code, % giảm, hạn sử dụng, số lượng tối đa sử dụng, điều kiện đơn hàng tối thiểu.
orders: đơn hàng: user_id, ngày tạo, tổng tiền, trạng thái, địa chỉ giao hàng, số điện thoại, mã coupon đã áp dụng (nếu có).
order_details: chi tiết đơn hàng: order_id, product_id, số lượng, giá tại thời điểm mua (giá gốc hoặc giá flash đã áp dụng).
order_status_log: (tùy chọn) ghi lại lịch sử thay đổi trạng thái đơn hàng (theo yêu cầu có thể thêm để theo dõi).







#### 2.
Quản lý hàng tồn kho/Đơn hàng: 
Khi khách hàng đặt hàng, hệ thống cần: 
Tạo đơn hàng -> Trừ số lượng trong bảng kho -> Cập nhật trạng thái thanh toán. 
Nếu một bước lỗi, toàn bộ đơn hàng phải hủy bỏ để tránh lệch dữ liệu kho.


# Dùng xóa mềm
Ngày	Quy chế	Nhiệm vụ	Tiến độ	Nhận xét
Buổi 1
Không vi phạm

Ngày 1: Thiết lập cấu trúc & Quản lý danh mục (Foundation)

Xây dựng Database MySQL: Tạo các bảng users, categories, products, orders, order_details.

Thiết lập cấu trúc Project Java theo mô hình 4 lớp: model, dao, service, presentation, util.

Hoàn thành lớp kết nối MyDatabase và các thực thể (Entity).

Thực hiện trọn gói chức năng Quản lý Danh mục (Category): Xem, Thêm, Sửa, Xóa (Admin).

Mục tiêu: Thông suốt kết nối DB và hiểu luồng CRUD cơ bản.

Đã hoàn thành
hoàn thành
Buổi 2
Không vi phạm

Ngày 2: Quản lý Sản phẩm & Xác thực (Inventory & Auth)

Thực hiện trọn gói chức năng Quản lý Sản phẩm (Product): Admin có thể Thêm, Sửa, Xóa, Tìm kiếm điện thoại (Validate giá, số lượng kho).

Xây dựng chức năng Đăng ký/Đăng nhập:

Mã hóa mật khẩu bằng BCrypt.

Phân quyền Menu dựa trên Role (Admin thấy menu quản lý, Customer thấy menu mua sắm).

Mục tiêu: Hoàn thiện kho hàng và hệ thống bảo mật người dùng.

Đã hoàn thành
hoàn thành
Buổi 3
Không vi phạm

Ngày 3: Nghiệp vụ Mua hàng & Giỏ hàng (Shopping Workflow)

Hiển thị danh sách sản phẩm cho Customer (Lọc theo hãng, theo giá).

Xây dựng logic Đặt hàng:

Kiểm tra tồn kho trước khi tạo đơn.

Sử dụng Transaction để đồng thời lưu Đơn hàng (Orders), Chi tiết đơn (OrderDetails) và trừ số lượng sản phẩm trong kho.

Mục tiêu: Đây là ngày quan trọng nhất, đảm bảo tính toàn vẹn dữ liệu khi mua bán.

Đang xử lý
Chưa có nhận xét
Buổi 4
Không vi phạm

Ngày 4: Quản lý Đơn hàng & Lịch sử (Order Management)

Admin: Xem danh sách đơn hàng toàn hệ thống, cập nhật trạng thái đơn (Duyệt/Giao hàng/Hủy).

Customer: Xem lịch sử đơn hàng cá nhân và theo dõi tiến độ xử lý đơn.

Hoàn thiện các chức năng tìm kiếm nâng cao và sắp xếp sản phẩm theo giá.

Mục tiêu: Kết thúc toàn bộ các tính năng bắt buộc trong SRS.

Đang xử lý
Chưa có nhận xét
Buổi 5
Không vi phạm

Ngày 5: Kiểm thử (Testing) & Hoàn thiện (Polishing)

Unit Test: Kiểm tra các trường hợp nhập liệu sai (Validation): Số điện thoại sai định dạng, nhập chữ vào ô giá tiền, đặt hàng khi kho bằng 0.

Security Test: Thử tấn công SQL Injection (như ví dụ thầy dạy) để đảm bảo PreparedStatement đã chặn đứng các chuỗi độc hại.

Refactoring: Tối ưu code (Clean Code), định dạng bảng Console cho đẹp mắt, viết file README.md hướng dẫn chạy dự án.

Mục tiêu: Đóng gói sản phẩm chất lượng cao, không còn lỗi logic.

: check xem đã làm đủ các task chưa


        admin@gmail.com
