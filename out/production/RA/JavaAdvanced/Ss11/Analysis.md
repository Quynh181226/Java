###### 1. Việc khởi tạo kết nối liên tục mà không đóng (close) hoặc không quản lý tập trung sẽ gây nguy hiểm cho hệ thống vì:

* Mỗi kết nối đến Database đều tiêu tốn tài nguyên (bộ nhớ, socket, thread).
* Nếu không đóng kết nối, các kết nối sẽ bị “rò rỉ” (connection leak) và tích tụ theo thời gian.
* Sau một thời gian, Database sẽ đạt giới hạn số lượng kết nối cho phép → không thể tạo thêm kết nối mới.
* Điều này dẫn đến lỗi như "Communications link failure" và làm hệ thống bị treo.

Trong hệ thống y tế cần hoạt động 24/7, việc này đặc biệt nguy hiểm vì có thể làm gián đoạn truy xuất hồ sơ bệnh nhân, ảnh hưởng trực tiếp đến việc khám chữa bệnh.



###### 2. Lệnh if không đủ để xử lý yêu cầu "in danh sách" vì:

* if(rs.next()) chỉ kiểm tra và di chuyển con trỏ xuống đúng 1 dòng đầu tiên.
* Sau khi thực hiện xong, chương trình không tiếp tục đọc các dòng tiếp theo nên chỉ in được 1 bản ghi.

Cơ chế con trỏ của ResultSet:

* Ban đầu con trỏ nằm trước dòng đầu tiên.
* Mỗi lần gọi next() → con trỏ di chuyển xuống 1 dòng.
* Nếu còn dữ liệu → trả về true.
* Nếu hết dữ liệu → trả về false.

Vì vậy, để duyệt toàn bộ dữ liệu, cần dùng vòng lặp (while) thay vì if.



###### 3. Giá trị trả về của phương thức executeUpdate() là một số nguyên (int), đại diện cho số lượng dòng dữ liệu bị tác động bởi câu lệnh SQL (INSERT, UPDATE, DELETE).

* Nếu giá trị > 0: Có ít nhất một dòng đã được cập nhật → thao tác thành công.
* Nếu giá trị = 0: Không có dòng nào bị tác động → có thể do điều kiện WHERE không khớp (ví dụ: mã giường không tồn tại).

Trong bài toán này, nếu executeUpdate() trả về 0, ta có thể kết luận rằng mã giường không tồn tại và cần thông báo cho y tá để tránh hiểu nhầm là cập nhật thành công.




###### 4. Khi sử dụng nối chuỗi để tạo câu lệnh SQL, dữ liệu người dùng nhập vào sẽ được gắn trực tiếp vào câu lệnh.

Ví dụ:
Nếu người dùng nhập: ' OR '1'='1

Câu lệnh SQL sẽ trở thành:
SELECT * FROM patients WHERE name = '' OR '1'='1';

Phân tích:

* '1'='1' luôn đúng (true)
* Do có toán tử OR, toàn bộ điều kiện WHERE luôn đúng

Kết quả:

* Hệ thống sẽ trả về toàn bộ dữ liệu trong bảng patients thay vì chỉ một bệnh nhân
* Đây chính là lỗ hổng SQL Injection gây rò rỉ dữ liệu

Ngoài ra, ký tự -- có thể dùng để comment phần còn lại của câu lệnh, giúp hacker kiểm soát truy vấn hoàn toàn.





###### 7. Các kịch bản lỗi có thể xảy ra trong hệ thống:

1. Lỗi trùng khóa chính (Primary Key)

* Người dùng nhập mã bác sĩ đã tồn tại
* → Lỗi SQLIntegrityConstraintViolationException

2. Lỗi nhập dữ liệu quá dài

* Ví dụ: chuyên khoa vượt quá độ dài cột VARCHAR
* → Data too long for column

3. Lỗi để trống dữ liệu

* Không nhập tên hoặc chuyên khoa
* → Gây dữ liệu không hợp lệ

4. Lỗi định dạng dữ liệu

* Nhập sai định dạng (ví dụ nếu có ngày tháng)
* → ParseException hoặc lỗi SQL

5. Lỗi kết nối database

* Sai URL, user, password
* → SQLException

6. Lỗi SQL Injection (nếu dùng Statement)

* Người dùng nhập ký tự nguy hiểm (' OR 1=1)
* → Lộ dữ liệu

7. Lỗi không tìm thấy dữ liệu

* Bảng rỗng khi thống kê hoặc hiển thị
* → Không có kết quả

=> Cần validate dữ liệu + bắt exception để đảm bảo hệ thống chạy ổn định.
