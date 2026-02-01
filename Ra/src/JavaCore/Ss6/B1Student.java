package JavaCore.Ss6;

//[Bài tập 1] Quản lý thông tin sinh viên cơ bản
//1. Mục tiêu
//Hiểu khái niệm Class – Object
//Biết khai báo thuộc tính, phương thức
//Làm quen với constructor có tham số
//2. Mô tả
//Hệ thống cần lưu thông tin sinh viên để phục vụ việc quản lý lớp học.
//
//Yêu cầu:
//Tạo lớp Student gồm:
//Thuộc tính: mã sinh viên, họ tên, năm sinh, điểm trung bình
//Constructor có tham số để khởi tạo đầy đủ thông tin
//Tạo phương thức:
//Hiển thị thông tin sinh viên ra màn hình
//Trong hàm main:
//Khởi tạo ít nhất 2 đối tượng sinh viên
//Gọi phương thức hiển thị thông tin
//3. Kết quả mong muốn
//Hiển thị đúng thông tin của từng sinh viên
//Phân biệt rõ class và object
//Dữ liệu mỗi sinh viên là độc lập
public class B1Student {
    int id;
    String fullName;
    int year;
    double average;

    B1Student(int id, String fullName, int year,double average){
        this.average = average;
        this.fullName = fullName;
        this.year = year;
        this.id = id;
    }

    void displayInfo(){
        System.out.println("ID: " + id
                        + ", Ho Ten: " + fullName
                        + ", Nam sinh: " + year
                        + ", Diem TB: " + average);
    }
}