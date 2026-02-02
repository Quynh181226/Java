package JavaCore.Ss7;

import java.util.ArrayList;
import java.util.Scanner;

//Đề bài: Xây dựng chương trình Quản lý Học sinh
//Yêu cầu kiến thức:
//Package: Tổ chức code trong package có tên com.rikkeiedu.management.
//        Static: Sử dụng biến static để tạo cơ chế ID tự tăng (auto-increment) cho mỗi học sinh mới và tính toán thống kê.
//Final: Sử dụng từ khóa final để đảm bảo ID của học sinh không thể bị thay đổi sau khi khởi tạo, và định nghĩa tên trường học là hằng số.
//Yêu cầu chức năng: Tạo class Student với các thuộc tính:
//id: Số nguyên, tự động tăng (ví dụ: học sinh 1 là ID 1, học sinh 2 là ID 2...), không được phép thay đổi.
//fullName: Họ tên.
//score: Điểm số.
//className: Tên lớp.
//Viết chương trình Menu thực hiện:
//Thêm mới học sinh: Nhập thông tin và lưu vào danh sách.
//Hiển thị danh sách: In ra thông tin tất cả học sinh (bao gồm cả ID tự tăng).
//Tính điểm trung bình: Tính và hiển thị điểm trung bình của toàn bộ học sinh trong danh sách.
public class Btth1 {
    public static final String SCHOOL_NAME = "Ptit";
    private static int autoId = 0;

    private static ArrayList<Btth1> students = new ArrayList<>();

    private final int id;
    private String fullName;
    private double score;
    private String className;

    public Btth1(String fullName, double score, String className) {
        this.id = ++autoId;
        this.fullName = fullName;
        this.score = score;
        this.className = className;
    }

    public double getScore() {
        return score;
    }

    public void display() {
        System.out.println("ID: " + id + ", Tên: " + fullName + ", Điểm: " + score + ", Lớp: " + className);
    }

    // Thêm học sinh
    public static void addStudent(Scanner sc) {
        System.out.print("Nhập họ tên: ");
        String name = sc.nextLine();

        System.out.print("Nhập điểm: ");
        double score = Double.parseDouble(sc.nextLine());

        System.out.print("Nhập lớp: ");
        String className = sc.nextLine();

        students.add(new Btth1(name, score, className));
        System.out.println("Thêm học sinh thành công!");
    }

    // Hiển thị danh sách
    public static void showStudents() {
        if (students.isEmpty()) {
            System.out.println("Danh sách rỗng!");
            return;
        }
        for (Btth1 s : students) {
            s.display();
        }
    }

    // Tính điểm trung bình
    public static void averageScore() {
        if (students.isEmpty()) {
            System.out.println("Chưa có học sinh!");
            return;
        }
        double sum = 0;
        for (Btth1 s : students) {
            sum += s.getScore();
        }
        System.out.println("Điểm trung bình: " + sum / students.size());
    }
}

