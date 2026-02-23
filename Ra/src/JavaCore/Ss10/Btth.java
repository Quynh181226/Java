package JavaCore.Ss10;

//[Bài tập] Thực hành Tính trừu tượng trong Hệ thống Quản lý Thanh toán
//
//1. Mục tiêu
//Hiểu và áp dụng Interface để định nghĩa "bản hợp đồng" hành vi chung cho các đối tượng.
//Sử dụng Abstract Class để xây dựng bộ khung, quản lý các thuộc tính chung và phương thức chia sẻ code giữa các lớp con.
//Thành thạo việc khai báo và sử dụng các loại Access Modifier khác nhau cho thuộc tính trong lớp trừu tượng.
//Sử dụng Anonymous Class để tối ưu hóa việc triển khai các đối tượng có tính chất tạm thời hoặc dùng một lần.
//2. Mô tả
//Sinh viên cần xây dựng một hệ thống xử lý giao dịch điện tử. Dữ liệu của mỗi phương thức thanh toán không chỉ khác nhau về cách xử lý mà còn khác nhau về các thông tin lưu trữ (số thẻ, email, số điện thoại). Nhiệm vụ của sinh viên là thiết kế các lớp sao cho vừa đảm bảo tính bảo mật (che giấu thuộc tính), vừa đảm bảo tính thống nhất trong việc thực hiện thanh toán.
//3. Bài tập thực hành
//Phần 1: Thiết kế cấu trúc dữ liệu chung (Interface & Abstract Class)
//Xây dựng nền tảng quản lý thông tin định danh:
//Interface Payable: Định nghĩa hành vi cốt lõi. Khai báo phương thức trừu tượng void pay(double amount);.
//Abstract Class PaymentMethod: Quản lý các thông tin định danh cơ bản.
//Thuộc tính bắt buộc:
//protected String accountName; (Tên chủ tài khoản).
//protected String paymentId; (Mã định danh phương thức thanh toán).
//Phương thức:
//Triển khai hàm khởi tạo (Constructor) để gán giá trị cho các thuộc tính trên.
//Khai báo phương thức trừu tượng abstract void validate(); để kiểm tra tính hợp lệ của thông tin tài khoản.
//Phần 2: Chi tiết hóa thuộc tính cho từng loại hình thanh toán
//Triển khai các lớp con với các thuộc tính đặc thù để quản lý dữ liệu riêng biệt:
//Lớp CreditCard: Kế thừa PaymentMethod và triển khai Payable.
//Thuộc tính riêng:
//private String cardNumber; (Số thẻ tín dụng - yêu cầu kiểm tra $16$ chữ số).
//private String cvv; (Mã bảo mật).
//private double creditLimit; (Hạn mức tín dụng).
//Hành vi: Ghi đè phương thức validate() để kiểm tra định dạng thẻ và pay() để thực hiện trừ hạn mức.
//Lớp EWallet: Kế thừa PaymentMethod và triển khai Payable.
//Thuộc tính riêng:
//private String phoneNumber; (Số điện thoại liên kết ví).
//private double balance; (Số dư trong ví).
//Hành vi: Triển khai logic kiểm tra số dư trước khi cho phép gọi phương thức pay().
//Phần 3: Triển khai thực tế và Lớp nặc danh
//Thực hiện chạy chương trình trong hàm main để kiểm tra khả năng đa hình:
//Khởi tạo đối tượng CreditCard và EWallet với đầy đủ thông tin thuộc tính đã yêu cầu.
//Sử dụng Anonymous Class: Tạo nhanh một hình thức "Thanh toán bằng Điểm thưởng" (Reward Points) từ Interface Payable.
//Yêu cầu: Triển khai trực tiếp phương thức pay(double amount) để quy đổi số tiền sang điểm thưởng và in ra thông báo thanh toán.
//Câu hỏi: Tại sao các thuộc tính trong lớp con (CreditCard, EWallet) nên để là private trong khi thuộc tính ở lớp cha (PaymentMethod) nên là protected?.
public class Btth {
}
