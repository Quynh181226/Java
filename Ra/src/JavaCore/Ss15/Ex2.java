package JavaCore.Ss15;

import java.util.Scanner;

//Bài 2 (Khá) – Hàng đợi bệnh nhân khám thường
//Mục tiêu: Hiểu nguyên lý FIFO của Queue. Sử dụng enqueue, dequeue, peek.
//Mô tả: Phòng khám đa khoa tiếp nhận bệnh nhân theo thứ tự đến trước – khám trước.
//Yêu cầu: Mỗi bệnh nhân đến → thêm vào Queue. Khi bác sĩ gọi khám → lấy bệnh nhân đầu Queue. Cho phép xem bệnh nhân tiếp theo sẽ được khám.
//Cài đặt lớp Patient: Thuộc tính: String id, String name, int age. Phương thức khởi tạo, getter/setter.
//Cài đặt lớp PatientQueue: Thuộc tính: Queue<Patient> queue. Phương thức: void addPatient(Patient p), Patient callNextPatient(), Patient peekNextPatient(), boolean isEmpty(), void displayQueue().
//Kết quả mong muốn: Cài đặt Queue quản lý danh sách bệnh nhân. Đảm bảo thứ tự khám đúng FIFO. Hiển thị danh sách bệnh nhân còn chờ.
public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }
}
