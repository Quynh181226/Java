package JavaAdvanced.Ss3;

import java.util.List;
import java.util.stream.Collectors;

//[Bài tập]  Loại bỏ người dùng trùng lặp
//1. Mục tiêu
//Ứng dụng Set(), hoặc Collectors.toMap()
//2. Mô tả
//Nhiệm vụ:
//Định nghĩa một danh sách record User trong main, và có trùng lặp username.
//Xử lý để có được danh sách không còn trùng lặp theo username.
//3. Kết quả mong muốn
//Chương trình chạy và in ra danh sách không trùng lặp
public class Ex4 {
    record User(String username, String email) {
    }

    public static void main(String[] args) {

        List<User> users = List.of(
                new User("minh", "minh@gmail.com"),
                new User("hoa", "hoa@gmail.com"),
                new User("minh", "minh2@gmail.com"),
                new User("tuan", "tuan@gmail.com"),
                new User("hoa", "hoa2@gmail.com"));

        // Loại bỏ trùng username
        List<User> uniqueUsers = users.stream()
                .collect(Collectors.toMap(
                        User::username,
                        user -> user,
                        (existing, replacement) -> existing))
                .values()
                .stream()
                .toList();

        // In kết quả
        uniqueUsers.forEach(System.out::println);
    }
}
