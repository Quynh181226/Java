//package JavaCore.Ss9;
//
//[Bài tập] Quản Lý Nhân Viên – Kế Thừa & Đa Hình
//
//
//1. Mục tiêu
//Hiểu khái niệm kế thừa (Inheritance) và mối quan hệ IS-A
//Sử dụng từ khóa extends để tạo lớp con
//Hiểu và áp dụng ghi đè phương thức (Override)
//Sử dụng đúng annotation @Override
//Hiểu vai trò của super và super()
//Hiểu khái niệm đa hình (Polymorphism)
//Phân biệt kiểu khai báo và kiểu thực tế
//Phân biệt Overloading và Overriding
//2. Mô tả
//Xây dựng chương trình quản lý nhân viên bằng Java
//Tạo lớp cha Employee (hoặc NhanVien) đại diện cho nhân viên chung
//Lớp cha chứa các thông tin và hành vi cơ bản:
//Tên nhân viên
//Lương cơ bản
//Phương thức tính lương
//class Employee {
//
//    double getSalary() { ... }
//
//}
//
//Tạo các lớp con kế thừa từ lớp cha, ví dụ:
//Manager
//        Developer
//Các lớp con:
//Kế thừa thuộc tính từ lớp cha
//Ghi đè phương thức tính lương theo cách riêng
//class Manager extends Employee {
//
//    @Override
//
//    double getSalary() { ... }
//
//}
//
//Áp dụng từ khóa super:
//Truy cập phương thức của lớp cha
//Gọi constructor của lớp cha khi cần
//super.getSalary()
//
//Thể hiện đa hình:
//Khai báo biến kiểu lớp cha
//Gán đối tượng lớp con
//Employee e = new Manager();
//
//Khi gọi phương thức:
//Phương thức được thực thi dựa trên kiểu thực tế của đối tượng
//Không dựa vào kiểu khai báo
//e.getSalary(); // gọi phiên bản của Manager
//
//(Tuỳ chọn) Minh hoạ Overloading:
//Các phương thức cùng tên, khác tham số trong cùng một lớp
//double getSalary();
//
//double getSalary(int bonus);
//
//Quan sát và so sánh:
//Overloading → quyết định lúc biên dịch
//Overriding → quyết định lúc chạy chương trình
//3. Đánh giá
//Áp dụng đúng quan hệ kế thừa bằng extends
//Ghi đè phương thức đúng quy tắc
//Sử dụng annotation @Override
//Hiểu và thể hiện được đa hình trong chương trình
//Phân biệt rõ overloading và overriding
//Chương trình chạy đúng, không lỗi
//Đặt tên class, phương thức đúng chuẩn
//Đưa mã nguồn lên GitHub
//Dán link repository GitHub lên hệ thống nộp bài
//public class Btth {
//}
