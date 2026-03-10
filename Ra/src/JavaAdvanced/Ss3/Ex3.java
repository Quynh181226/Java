package JavaAdvanced.Ss3;

import java.util.List;
import java.util.Optional;

//[Bài tập] Optional tìm kiếm
//1. Mục tiêu
//Sử dụng Optional + findFirst, ifPresent, orElse
//2. Mô tả
//Yêu cầu
//Viết một class UserRepository, gồm:
//1 danh sách List<User> users (static hoặc non-static)
//Optional<User> findUserByUsername(String username)
//Nhiệm vụ
//Trong main, tìm user "alice".
//Nếu tồn tại:
//Welcome alice
//Nếu không:
//Guest login
//3. Kết quả mong muốn
//Chương trình chạy và tìm kiếm user “alice”
public class Ex3 {
    public record User(String username, String email, String status) {
    }

    static class UserRepository {
        private List<User> users = List.of(
                new User("alice", "alice@gmail.com", "ACTIVE"),
                new User("bob", "bob@yahoo.com", "INACTIVE"),
                new User("charlie", "charlie@gmail.com", "ACTIVE"));

        public Optional<User> findUserByUsername(String username) {
            return users.stream()
                    .filter(user -> user.username().equals(username))
                    .findFirst();
        }
    }

    public static void main(String[] args) {
        UserRepository repo = new UserRepository();

        Optional<User> userOpt = repo.findUserByUsername("bob");

        userOpt.ifPresentOrElse(user -> System.out.println("Welcome " + user.username()),
                () -> System.out.println("Guest login"));
    }
}
