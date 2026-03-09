package JavaAdvanced.Ss2;

//[Bài tập] Rút gọn cú pháp Lambda
//1. Mục tiêu
//Biết cách rút gọn Anonymous Class bằng Lambda
//2. Mô tả
//Rút gọn cú pháp Lambda: Giả sử có một Functional Interface dùng để kiểm tra tính hợp lệ của mật khẩu:
//Trong chương trình chính, viết lại đoạn mã triển khai sau đây bằng cú pháp Lambda ngắn gọn nhất có thể (lược bỏ dấu ngoặc, từ khóa không cần thiết nếu được):
//3. Kết quả mong muốn
//Chương trình chạy được và thực hiện kiểm tra 2 mật khẩu:
//“12345678” -> in ra true
//“1234” -> in ra false
public class Ex2 {
    public interface PasswordValidator {
        boolean validate(String pass);
    }

    public static void main(String[] args) {
        PasswordValidator validator = pass -> pass.length() >= 8;

        System.out.println(validator.validate("12345678"));
        System.out.println(validator.validate("1234"));
    }
}
