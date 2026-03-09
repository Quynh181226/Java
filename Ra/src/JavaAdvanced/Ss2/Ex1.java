package JavaAdvanced.Ss2;

//[Bài tập] Lựa chọn Functional Interface phù hợp
//1. Mục tiêu
//Hiểu khi nào thì áp dụng Functional Interface nào.
//2. Mô tả
//Lựa chọn Functional Interface phù hợp Trong hệ thống quản lý, bạn cần thực hiện các công việc sau với đối tượng User. Hãy xác định xem công việc nào tương ứng với loại Functional Interface nào (Predicate, Function, Consumer, Supplier):
//Kiểm tra xem một User có phải là Admin hay không (trả về true/false).
//Chuyển đổi một đối tượng User thành một chuỗi String chứa thông tin username.
//In thông tin chi tiết của User ra màn hình Console.
//Khởi tạo một đối tượng User mới với các giá trị mặc định.
//3. Kết quả mong muốn
//Học viên viết câu trả lời và giải thích lý do vào markdown hoặc text
public class Ex1 {
//# Lựa chọn Functional Interface phù hợp
//1. Kiểm tra xem một User có phải là Admin hay không
//Functional Interface: Predicate<User>
//Lý do:
//Predicate dùng để kiểm tra một điều kiện và trả về true/false.
//Ví dụ:
//Predicate<User> isAdmin = user -> user.getRole().equals("ADMIN");
//2. Chuyển đổi một đối tượng User thành chuỗi String chứa thông tin username
//Functional Interface: Function<User, String>
//Lý do:
//Function dùng khi nhận vào một đối tượng và trả về một giá trị khác.
//Ví dụ:
//Function<User, String> getUsername = user -> user.getUsername();
//3. In thông tin chi tiết của User ra màn hình Console
//Functional Interface: Consumer<User>
//Lý do:
//Consumer dùng khi nhận một tham số nhưng không trả về giá trị, thường để thực hiện hành động như in ra màn hình.
//Ví dụ:
//Consumer<User> printUser = user -> System.out.println(user);
//4. Khởi tạo một đối tượng User mới với các giá trị mặc định
//Functional Interface: Supplier<User>
//Lý do:
//Supplier dùng khi không có tham số đầu vào nhưng trả về một đối tượng.
//Ví dụ:
//Supplier<User> createUser = () -> new User("guest", "USER");
}
