package JavaCore.Ss6;

//[Bài tập 6] Quản lý người dùng hoàn chỉnh theo OOP
//1. Mục tiêu
//Tổng hợp: class, object, constructor, encapsulation, getter/setter
//Thiết kế class đúng chuẩn thực tế
//2. Mô tả
//Xây dựng lớp User cho hệ thống quản lý người dùng.
//
//Yêu cầu:
//Thuộc tính private: id, username, password, email
//Constructor khởi tạo đầy đủ
//Getter/Setter:
//Kiểm tra email hợp lệ
//Không cho password rỗng
//Phương thức:
//Hiển thị thông tin người dùng (ẩn password)
//Tạo nhiều đối tượng và kiểm tra các trường hợp sai dữ liệu
//3. Kết quả mong muốn
//Code thể hiện rõ tư duy OOP
//Dữ liệu được bảo vệ và kiểm soát
//Chương trình chạy ổn định
public class B6User {
    private int id;
    private String username;
    private String password;
    private String email;

    public void setPassword(String password) {
        if(password.equals("")){
            System.out.println("Password is empty\n" + " ");
        }else{
            this.password = password;
            System.out.println("Password has been set\n" + " ");
        }
    }

    public void setEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if(email.matches(regex)){
            this.email = email;
            System.out.println("Email is valid, Change success\n" + " ");
        }else{
            System.out.println("Email is invalid\n" + " ");
        }
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public B6User(int id, String email, String password, String username) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public void displayInfo() {
        System.out.println("ID: " + id + ", Username: " + username + ", Email: " + email);

        if (password != null && !password.isEmpty()) {
            System.out.println("Password: ********\n" + " ");
        } else {
            System.out.println("Password: (xxxxxxx)\n" + " ");
        }

        System.out.println(" " );
    }
}
