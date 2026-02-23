package JavaCore.Ss10;
//[Bài tập] Tối ưu hóa Sắp xếp Sản phẩm (Anonymous vs Lambda)
//
//1. Mục tiêu
//So sánh sự khác biệt và cách chuyển đổi giữa Anonymous Class và Lambda Expression.
//Sử dụng interface có sẵn của Java (Comparator) để xử lý dữ liệu thực tế.
//2. Mô tả Một trang web bán hàng cần sắp xếp danh sách sản phẩm theo giá và theo tên để hiển thị cho người dùng.
//Yêu cầu:
//Tạo lớp Product có thuộc tính name và price.
//Sử dụng Anonymous Class của Comparator để sắp xếp sản phẩm theo giá tăng dần.
//Sử dụng Lambda Expression để sắp xếp sản phẩm theo tên (A-Z).
//Giải thích: Viết ghi chú trong code về trường hợp nào bắt buộc dùng Anonymous Class thay vì Lambda (ví dụ: khi cần thêm thuộc tính nội bộ).
//3. Kết quả mong muốn
//In ra hai danh sách sản phẩm đã được sắp xếp theo hai tiêu chí khác nhau bằng hai kỹ thuật khác nhau.
public class B6 {
     static class Product{
        String name;
        double price;

         public Product(String name, double price) {
             this.name = name;
             this.price = price;
         }
     }
}
