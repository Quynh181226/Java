package JavaAdvanced.Ss3;

import java.util.List;
import java.util.stream.Collectors;

//[Bài tập] Bài toán làm phẳng
//1. Mục tiêu
//Luyện tập sử dụng phương thức flatMap() trong Java Stream API để biến đổi và làm phẳng cấu trúc dữ liệu dạng lồng nhau.
//2. Mô tả
//Giả sử mỗi bài viết có thể được gắn nhiều thẻ (tag).
//Ví dụ:
//Bài viết về Java có các tag: ["java", "backend"]
//Bài viết về Python có các tag: ["python", "data"]
//Đối tượng Post có thuộc tính List<String> tags;
//Yêu cầu
//Sử dụng Java Stream API và phương thức flatMap() để làm phẳng danh sách lồng nhau trên thành một danh sách duy nhất chứa tất cả các tag.
//3. Kết quả mong muốn
//[java, backend, python, data]
//In ra kết quả đã được làm phẳng
public class Ex6 {
    static class Post {
        List<String> tags;

        public Post(List<String> tags) {
            this.tags = tags;
        }

        public List<String> getTags() {
            return tags;
        }
    }

    public static void main(String[] args) {

        List<Post> posts = List.of(
                new Post(List.of("java", "backend")),
                new Post(List.of("python", "data")));

        // Làm phẳng danh sách tags
        List<String> allTags = posts.stream()
                .flatMap(post -> post.getTags().stream())
                .collect(Collectors.toList());

        System.out.println(allTags);
    }
}
