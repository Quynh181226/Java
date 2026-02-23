//package JavaCore.Ss7;
//
//[Bài tập] Quản Lý Sinh Viên
//Từ khóa static và final
//1. Mục tiêu
//Hiểu sự khác nhau giữa biến nguyên thủy và biến tham chiếu
//Phân biệt biến của đối tượng và biến của lớp (static)
//Sử dụng đúng từ khóa static cho biến và phương thức dùng chung
//Hiểu và áp dụng từ khóa final cho biến, phương thức hoặc lớp
//Biết cách khai báo và sử dụng hằng số (static final)
//Hiểu vai trò của package trong việc tổ chức mã nguồn
//2. Mô tả
//Xây dựng chương trình quản lý sinh viên bằng Java
//Tạo class Student đại diện cho sinh viên
//        Mỗi sinh viên có thông tin riêng:
//Mã sinh viên
//Tên sinh viên
//Sử dụng biến instance để lưu thông tin riêng của từng sinh viên
//private String id;
//
//private String name;
//
//Sử dụng biến static để lưu thông tin dùng chung:
//Tên trường
//Tổng số sinh viên đã được tạo
//static int studentCount;
//
//Áp dụng từ khóa final cho các giá trị không được thay đổi
//static final String SCHOOL_NAME = "ABC University";
//
//Có phương thức của đối tượng:
//Hiển thị thông tin của từng sinh viên
//void displayInfo() { ... }
//
//Có phương thức static:
//Hiển thị thông tin chung (ví dụ: tổng số sinh viên)
//static void showTotalStudent() { ... }
//
//Tổ chức mã nguồn trong package đúng quy ước đặt tên
//Trong chương trình chính:
//Tạo nhiều đối tượng Student
//Gọi cả phương thức instance và phương thức static
//Quan sát sự khác nhau giữa dữ liệu riêng và dữ liệu dùng chung
//
//
//3. Đánh giá
//Hoàn thành đầy đủ các yêu cầu trong phần mô tả
//Sử dụng đúng từ khóa static và final
//Phân biệt rõ biến instance và biến static
//Không sử dụng this trong phương thức static
//Chương trình chạy đúng, không lỗi
//Đặt tên class, biến, phương thức, package đúng quy ước
//Đưa mã nguồn lên GitHub
//Dán link repository GitHub lên hệ thống nộp bài
//public class Btth {
//}
