package JavaCore.Ss15;

//Bài 1 (Khá) – Quản lý lịch sử bệnh án (Stack)
//Mục tiêu
//Hiểu và áp dụng nguyên lý LIFO của Stack
//Sử dụng các thao tác push, pop, peek
//Mô tả
//Trong hệ thống bệnh viện, mỗi khi bác sĩ chỉnh sửa hồ sơ bệnh án, hệ thống cần lưu lại lịch sử chỉnh sửa để có thể hoàn tác (Undo) khi cần.
//Yêu cầu:
//Mỗi lần chỉnh sửa → push một mô tả chỉnh sửa vào Stack
//Khi bác sĩ chọn Undo → pop chỉnh sửa gần nhất
//Cho phép xem chỉnh sửa gần nhất bằng peek
//Hiển thị danh sách các chỉnh sửa hiện có trong Stack
//Cài đặt lớp
//EditAction
//Thuộc tính:
//String description – mô tả chỉnh sửa
//String time – thời điểm chỉnh sửa
//Phương thức khởi tạo, getter/setter
//MedicalRecordHistory
//Thuộc tính:
//Stack<EditAction> history
//Phương thức:
//void addEdit(EditAction action)
//EditAction undoEdit()
//EditAction getLatestEdit()
//boolean isEmpty()
//void displayHistory()
//Kết quả mong muốn
//Cài đặt Stack lưu lịch sử chỉnh sửa bệnh án
//Thực hiện đúng Undo theo thứ tự ngược (LIFO)
//Hiển thị trạng thái Stack sau mỗi thao tác
public class Ex1 {
}
