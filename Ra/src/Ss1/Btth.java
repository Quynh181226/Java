package Ss1;

//[Bài tập] Thực hành thao tác cơ bản về Quản lý thư viện
//
//
//
//1. Mục tiêu
//Hiểu và cấu hình được môi trường lập trình (JDK)
//Phân biệt được cách Java vận hành trên các nền tảng (JVM, JRE)
//Sử dụng thành thạo các kiểu dữ liệu nguyên thủy và kiểu dữ liệu tham chiếu
//Hiểu cơ chế lưu trữ biến trên Stack và Heap
//Thực hiện thành thạo thao tác nhập xuất dữ liệu từ bàn phím
//
//
//2. Mô tả
//Bạn đang xây dựng phân hệ đầu tiên của phần mềm Quản lý Thư viện. Nhiệm vụ của bạn là viết một chương trình cho phép thủ thư nhập thông tin của một cuốn sách mới nhập kho, tính toán giá trị lưu kho sau thuế và hiển thị báo cáo tình trạng sách
//
// 
//
//3. Yêu cầu kiến thức
//JDK/JRE/JVM: Chương trình phải được biên dịch bằng JDK và chạy trên JVM.
//Biến & Bộ nhớ: * Các biến số (ID, giá tiền, số lượng) sẽ lưu trực tiếp giá trị trên Stack.
//Các biến đối tượng (Tên sách, Thể loại) sẽ lưu tham chiếu trên Stack và giá trị thực trên Heap.
//Toán tử: Sử dụng toán tử số học để tính thuế VAT (10%) và toán tử logic để kiểm tra tình trạng kho
//
//
//4. Bài tập thực hành
//Thiết lập môi trường và Cấu trúc chương trình
//Nhiệm vụ: Tạo một lớp (class) có tên LibraryManager. Khai báo hàm main để chương trình có thể thực thi
//
//
//Khai báo biến và Lựa chọn kiểu dữ liệu
//Nhiệm vụ: Khai báo các biến để lưu trữ thông tin của một cuốn sách bao gồm:
//bookID: Mã số sách (Số nguyên)
//title: Tên sách (Chuỗi ký tự)
//price: Giá nhập (Số thực)
//quantity: Số lượng (Số nguyên)
//isAvailable: Trạng thái còn sách hay không (Boolean)
//
//
//Thao tác Nhập dữ liệu từ bàn phím
//Nhiệm vụ: Sử dụng lớp Scanner để cho phép người dùng nhập giá trị cho tất cả các biến đã khai báo ở Yêu cầu 2
//
//
//Xử lý logic và Tính toán (Toán tử)
//Nhiệm vụ: Thực hiện các phép tính sau:
//Tạo biến totalValue = price * quantity (Toán tử số học)
//Tạo biến isLargeStock có giá trị true nếu quantity > 100 (Toán tử so sánh)
//Tạo biến canBorrow có giá trị true nếu isAvailable là true VÀ quantity > 0 (Toán tử logic &&)
//
//
//Xuất dữ liệu và Định dạng báo cáo
//Nhiệm vụ: Sử dụng System.out.printf() để in ra báo cáo cuối cùng với định dạng:
//Tên sách viết hoa hoàn toàn
//Giá tiền hiển thị 2 chữ số thập phân (ví dụ: 150.00)
//Trạng thái kho (Dùng toán tử điều kiện ? : để in ra chữ "Còn hàng" thay vì true/false)
public class Btth {
}
