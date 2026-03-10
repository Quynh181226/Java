package JavaAdvanced.Ss3;

import java.util.Comparator;
import java.util.List;

//[Bài tập] Top những người dùng có tên dài nhất
//1. Mục tiêu
//Sử dụng sorted() và limit(), Comparator()
//2. Mô tả
//Nhiệm vụ:
//Sinh viên tự định nghĩa danh sách users.
//Từ List<User> in ra 3 người dùng có username dài nhất.
//Ví dụ
//alexander
//charlotte
//Benjamin
//3. Kết quả mong muốn
//Chương trình chạy và in ra 3 người dùng với username dài nhất.
public class Ex5 {
    record User(String username, String email) {
    }

    public static void main(String[] args) {

        List<User> users = List.of(
                new User("alex", "alex@gmail.com"),
                new User("alexander", "alexander@gmail.com"),
                new User("charlotte", "charlotte@gmail.com"),
                new User("ben", "ben@gmail.com"),
                new User("Benjamin", "benjamin@gmail.com"),
                new User("anna", "anna@gmail.com"));

        users.stream()
                .sorted(Comparator.comparingInt((User u) -> u.username().length()).reversed())
                .limit(3)
                .forEach(user -> System.out.println(user.username()));
    }
}
