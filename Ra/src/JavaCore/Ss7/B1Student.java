package JavaCore.Ss7;

//1. Mục tiêu
//Phân biệt biến instance và biến static
//Hiểu biến static dùng chung cho tất cả đối tượng
//2. Mô tả
//Hệ thống cần thống kê tổng số sinh viên đã được tạo trong chương trình.
//Yêu cầu:
//Tạo lớp Student
//Có:
//Biến instance: mã sinh viên, tên sinh viên
//Biến static: totalStudent
//Mỗi lần tạo mới một sinh viên:
//Biến totalStudent tăng lên 1
//Viết phương thức hiển thị:
//Thông tin từng sinh viên
//Tổng số sinh viên đã tạo
//3. Kết quả mong muốn
//Tổng số sinh viên đúng dù tạo nhiều đối tượng
//Hiểu vì sao static chỉ có 1 bản sao
//Không dùng static cho dữ liệu riêng của từng sinh viên
public class B1Student {
    public String studentName;
    private String studentId;
    private String StudentName;

    private static int totalStudent = 0;

    public B1Student(String studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
        totalStudent++;
    }

    public void displayInfo() {
        System.out.println(studentId + " " + StudentName);
    }

    public static boolean displayTotalStudent() {
        System.out.println(totalStudent);
        return false;
    }
}
