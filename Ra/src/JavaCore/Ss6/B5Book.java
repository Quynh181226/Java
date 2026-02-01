package JavaCore.Ss6;

//[Bài tập 5] Sử dụng this để quản lý dữ liệu đối tượng
//1. Mục tiêu
//Hiểu rõ vai trò của từ khóa this
//Tránh nhầm lẫn giữa thuộc tính và tham số
//2. Mô tả
//Hệ thống quản lý sách cần khởi tạo dữ liệu chính xác.
//
//Yêu cầu:
//Tạo lớp Book
//Constructor nhận tham số trùng tên với thuộc tính
//Sử dụng this để gán giá trị
//Phương thức hiển thị thông tin sách
//3. Kết quả mong muốn
//Phân biệt rõ biến instance và biến tham số
//Dữ liệu được gán chính xác
//Hiểu bản chất this là đối tượng hiện tại
public class B5Book {
    private int id;
    private String title;
    private String author;
    private double price;

    public B5Book(int id, String title, String author, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + title + "Author: " + author + ", Price: " + price);
    }
}
