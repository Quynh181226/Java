package JavaCore.Ss15;

//[Bài tập] Mô phỏng quy trình cấp cứu hoàn chỉnh
//1. Mục tiêu: Kết hợp nhiều cấu trúc dữ liệu. Mô phỏng hệ thống y tế thực tế.
//2. Mô tả: Hệ thống cấp cứu gồm: Queue bệnh nhân chờ cấp cứu. Stack lưu các bước xử lý của từng bệnh nhân (tiếp nhận, chẩn đoán, điều trị…).
//Yêu cầu: Bệnh nhân vào Queue theo thứ tự. Khi xử lý bệnh nhân, các bước được đẩy vào Stack. Cho phép Undo bước xử lý gần nhất nếu có sai sót.
//Cài đặt lớp TreatmentStep: Thuộc tính: String description, String time.
//Cài đặt lớp EmergencyCase: Thuộc tính: Patient patient, Stack<TreatmentStep> steps. Phương thức: void addStep(TreatmentStep step), TreatmentStep undoStep(), void displaySteps().
//Cài đặt lớp EmergencyCaseQueue: Thuộc tính: Queue<EmergencyCase> cases. Phương thức: void addCase(EmergencyCase c), EmergencyCase getNextCase().
//3. Kết quả mong muốn: Hệ thống mô phỏng đúng quy trình. Áp dụng Stack cho xử lý nội bộ. Áp dụng Queue cho luồng bệnh nhân.
public class Ex5 {
}
