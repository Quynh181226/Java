#### 1.
users: chứa thông tin tài khoản, bao gồm cả admin và customer, phân quyền qua role. Lưu thông tin họ tên, email, số điện thoại, địa chỉ, mật khẩu mã hóa.
categories: danh mục sản phẩm (iPhone, Samsung, Xiaomi...)
products: sản phẩm điện thoại, với các thuộc tính: tên, hãng, dung lượng, màu sắc, giá, số lượng tồn kho, mô tả, danh mục.
flash_sales: (nâng cao) lưu thông tin sản phẩm tham gia flash sale: giá flash, số lượng flash, thời gian bắt đầu/kết thúc.
coupons: (nâng cao) mã giảm giá: code, % giảm, hạn sử dụng, số lượng tối đa sử dụng, điều kiện đơn hàng tối thiểu.
orders: đơn hàng: user_id, ngày tạo, tổng tiền, trạng thái, địa chỉ giao hàng, số điện thoại, mã coupon đã áp dụng (nếu có).
order_details: chi tiết đơn hàng: order_id, product_id, số lượng, giá tại thời điểm mua (giá gốc hoặc giá flash đã áp dụng).
order_status_log: (tùy chọn) ghi lại lịch sử thay đổi trạng thái đơn hàng (theo yêu cầu có thể thêm để theo dõi).
