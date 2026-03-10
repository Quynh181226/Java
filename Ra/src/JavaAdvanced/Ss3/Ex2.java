package JavaAdvanced.Ss3;

//[Bài tập] Lọc người dùng theo Email domain
//1. Mục tiêu
//Ứng dụng Stream filter
//2. Mô tả
//Hệ thống muốn thống kê user dùng gmail.
//Ví dụ:
//alice@gmail.com
//bob@yahoo.com
//charlie@gmail.com
//Nhiệm vụ:
//Dùng Stream để:
//Lọc email gmail.com
//In ra username
//3. Kết quả mong muốn
//Chương trình chạy và in ra danh sách đã lọc

import java.util.Arrays;
import java.util.List;

record User1(String username, String email, Status status) {}

enum Status1 {
    ACTIVE, INACTIVE
}
public class Ex2 {
    public static void main(String[] args) {
        List<User1> users = Arrays.asList(
                new User1("a", "a@gmail.com", Status.ACTIVE),
                new User1("b", "b@gmail.com", Status.INACTIVE),
                new User1("c", "c@gmail.com", Status.ACTIVE),
                new User1("d", "d@gmail.com", Status.ACTIVE),
                new User1("e", "e@gmail.com", Status.INACTIVE),
                new User1("f", "f@gmail.com", Status.ACTIVE)
        );

        users.stream()
             .filter(user -> user.email().toLowerCase().endsWith("gmail.com"))
             .map(User1::username)
             .forEach(System.out::println);
        ;
    }
}
