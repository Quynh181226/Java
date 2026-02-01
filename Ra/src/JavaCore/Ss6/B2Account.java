package JavaCore.Ss6;

//[Bài tập 2] Tài khoản người dùng và phương thức xử lý
//1. Mục tiêu
//Sử dụng phương thức (method) trong class
//Thực hành gọi phương thức thông qua đối tượng
//2. Mô tả
//Hệ thống cần quản lý tài khoản người dùng.
//
//Yêu cầu:
//Tạo lớp Account gồm:
//Thuộc tính: username, password, email
//Constructor khởi tạo thông tin ban đầu
//Các phương thức:
//Đổi mật khẩu
//Hiển thị thông tin tài khoản (ẩn mật khẩu)
//Tạo đối tượng và thực hiện đổi mật khẩu
//3. Kết quả mong muốn
//Gọi được phương thức thông qua đối tượng
//Phân biệt rõ thuộc tính và phương thức
//Dữ liệu thay đổi đúng theo thao tác
public class B2Account {
    String username;
    String password;
    String email;

    public B2Account(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    void displayInfo(){
        System.out.println("Username: " + username + ", Password: ********, Email: " + email);
    }

    void changePassword(String password){
        this.password = password;
    }
}
