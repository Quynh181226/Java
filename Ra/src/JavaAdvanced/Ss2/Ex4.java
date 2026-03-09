package JavaAdvanced.Ss2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

//[Bài tập] Chuyển đổi sang Tham chiếu phương thức
//1. Mục tiêu
//Học viên nắm được kiến thức và áp dụng tham chiếu phương thức
//2. Mô tả
//Chuyển đổi sang Tham chiếu phương thức (Method Reference): Dựa trên danh sách users, hãy chuyển các biểu thức Lambda sau sang dạng Method Reference tương ứng:
//(user) -> user.getUsername() (Tham chiếu instance method của đối tượng bất kỳ thuộc kiểu cụ thể).
//(s) -> System.out.println(s) (Tham chiếu instance method của một đối tượng cụ thể).
//() -> new User() (Tham chiếu Constructor).
//3. Kết quả mong muốn
//Sinh viên tự định nghĩa danh sách users.
//Sinh viên áp dụng Method Reference để viết code ngắn gọn.
public class Ex4 {
    public static class User {
        private String username;

        public User(){
            this.username = "guest";
        }

        public User(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("alice"));
        users.add(new User("bob"));
        users.add(new User("charlie"));

        // (user) -> user.getUsername()
        Function<User, String> getUsername = User::getUsername;

        // (s) -> System.out.println(s)
        Consumer<String> print = System.out::println;

        // () -> new User()
        Supplier<User> createUser = User::new;

        // sử dụng
        users.stream()
                .map(getUsername)
                .forEach(print);

        User newUser = createUser.get();
        System.out.println(newUser.getUsername());
    }
}
