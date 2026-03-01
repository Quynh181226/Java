package JavaCore.Ss15;

//[Bài tập] Hàng đợi khám theo mức độ ưu tiên
//1. Mục tiêu: Hiểu mở rộng về Priority Queue. Mô phỏng bài toán y tế thực tế.
//2. Mô tả: Khoa cấp cứu tiếp nhận bệnh nhân với mức độ: Cấp cứu (ưu tiên cao), Thông thường (ưu tiên thấp).
//Yêu cầu: Bệnh nhân cấp cứu được khám trước. Nếu cùng mức độ, áp dụng FIFO. Sử dụng PriorityQueue hoặc tự thiết kế logic.
//Cài đặt lớp EmergencyPatient: Thuộc tính: String id, String name, int priority (1: cấp cứu, 2: thường). Phương thức khởi tạo, getter/setter.
//Cài đặt lớp EmergencyQueue: Thuộc tính (một trong hai cách): PriorityQueue<EmergencyPatient> hoặc Hai Queue<EmergencyPatient> (cấp cứu & thường). Phương thức: void addPatient(EmergencyPatient p), EmergencyPatient callNextPatient(), void displayQueue().
//3. Kết quả mong muốn: Cài đặt Queue ưu tiên đúng logic y tế. Hiển thị thứ tự bệnh nhân được khám. Giải thích rõ tiêu chí ưu tiên.
public class Ex4 {
}
