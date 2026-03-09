package JavaAdvanced.Ss2;

//[Bài tập] Triển khai Functional Interface tùy chỉnh và Method Reference
//1. Mục tiêu
//Học viên tự định nghĩa Functional Interface và hiểu cách sử dụng Method Reference cho static method.
//2. Mô tả
//Triển khai Functional Interface tùy chỉnh và Method Reference
//Yêu cầu:
//Tạo một Functional Interface tên là UserProcessor có duy nhất một phương thức trừu tượng: String process(User u)
//Tạo một lớp tiện ích UserUtils có một phương thức tĩnh: public static String convertToUpperCase(User u), trả về tên người dùng (username) viết hoa.
//Trong hàm main, hãy khai báo một biến kiểu UserProcessor. Sau đó, thay vì dùng Lambda, hãy sử dụng Method Reference để gán phương thức convertToUpperCase của lớp UserUtils cho biến đó
//Thực hiện gọi phương thức process với một đối tượng User cụ thể và in kết quả ra màn hình.
//3. Kết quả mong muốn
//Sinh viên tự định nghĩa các class/interface UserProcessor , UserUtils, UserProcessor.
//Chương trình chính chạy được và in kết quả user ra màn hình.
public class Ex6 {
    @FunctionalInterface
    public interface UserProcessor {
        String process(User u);
    }

    public class UserUtils {
        public static String convertToUpperCase(User u){
            return u.getUsername().toUpperCase();
        }
    }

    public static class User {
        private String username;

        public User(String username){
            this.username = username;
        }

        public String getUsername(){
            return username;
        }
    }

    public static void main(String[] args) {
        UserProcessor processor = UserUtils::convertToUpperCase;

        User user = new User("john_doe");
        String result = processor.process(user);
        System.out.println(result);
    }
}
