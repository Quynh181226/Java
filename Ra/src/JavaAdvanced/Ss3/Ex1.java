package JavaAdvanced.Ss3;

import java.util.Arrays;
import java.util.List;

//[Bài tập] Làm quen với Record
//1. Mục tiêu
//Làm quen với Record.
//2. Mô tả
//Yêu cầu
//Tạo một record User gồm:
//username
//email
//Status
//Trong main, tạo 3 User.
//alice - ACTIVE
//bob - INACTIVE
//charlie - ACTIVE
//Nhiệm vụ
//In danh sách người dùng ra màn hình bằng:
//users.forEach(...)
//3. Kết quả mong muốn
//Chạy chương trình và in ra danh sách
record User(String userName, String email, Status status) {}

enum Status {
    ACTIVE,
    INACTIVE
}

public class Ex1 {
    public static void main(String[] args) {
        User a = new User("a", "a@gmail.com", Status.ACTIVE);
        User b   = new User("b",   "b@gmail.com",   Status.INACTIVE);
        User c = new User("c", "c@gmail.com", Status.ACTIVE);

        List<User> users = Arrays.asList(a, b, c);
        users.forEach(System.out::println);
        users.forEach(x -> System.out.println(x.toString()));
    }
}
