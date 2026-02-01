package JavaCore.Ss6;

//[Bài tập 4] Constructor Overloading cho nhân viên
//1. Mục tiêu
//Hiểu constructor mặc định & constructor có tham số
//Thực hành constructor overloading
//2. Mô tả
//Hệ thống quản lý nhân viên cho phép tạo nhân viên theo nhiều cách.
//
//Yêu cầu:
//Tạo lớp Employee
//Các constructor:
//Không tham số
//Có mã và tên
//Có đầy đủ mã, tên, lương
//Phương thức hiển thị thông tin nhân viên
//Tạo nhiều đối tượng bằng các constructor khác nhau
//3. Kết quả mong muốn
//Phân biệt rõ từng constructor
//Hiểu cách khởi tạo đối tượng linh hoạt
//Thông tin hiển thị đúng theo constructor sử dụng
public class B4Employee {
    private int id;
    private String name;
    private double salary;

    public B4Employee(){
        this.id = 0;
        this.name = "Employee";
        this.salary = 0;
    }

    public B4Employee(int id,String name){
        this.id = id;
        this.name = name;
        this.salary = 0;
    }

    public B4Employee(double salary, String name, int id) {
        this.salary = salary;
        this.name = name;
        this.id = id;
    }

    public void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary);
    }
}
