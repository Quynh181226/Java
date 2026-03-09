package JavaAdvanced.Ss2;

//[Bài tập] Thiết kế Interface Authenticatable
//1. Mục tiêu
//Học viên tự biết viết Functional Interface phục vụ cho nghiệp vụ.
//2. Mô tả
//Thiết kế Interface: Học viên sẽ thiết kế interface Authenticatable cho người dùng với các yêu cầu sau:
//Tạo một phương thức trừu tượng getPassword().
//Tạo một phương thức mặc định (default method) isAuthenticated() để kiểm tra nếu mật khẩu không rỗng (giúp các class con không cần viết lại logic này)
//Tạo một phương thức tĩnh (static method) encrypt(String rawPassword) để mô phỏng việc mã hóa mật khẩu (có thể gọi trực tiếp từ tên Interface)
//3. Kết quả mong muốn
//Sinh viên thiết kế được Functional Interface Authenticatable
public class Ex3 {
   @FunctionalInterface
    public interface Authenticatable{
        String getPass();
//       default implementation
        default boolean isAuthenticated(){
            String pass = getPass();
            return pass !=null && !pass.isEmpty();
        }

        static String encrypt(String pass){
            return pass;
        }
    }

    public static class User implements Authenticatable{
        private String pass;

        public User(String password) {
            this.pass = password;
        }

        @Override
        public String getPass() {
            return pass;
        }
    }

    public static void main(String[] args) {
        User user=new User("12345678");

        System.out.println(user.isAuthenticated());

        String encrypted = Authenticatable.encrypt(user.getPass());
        System.out.println(encrypted);
    }
}
