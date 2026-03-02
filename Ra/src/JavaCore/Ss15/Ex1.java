package JavaCore.Ss15;

import java.util.Stack;
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
    static void use(){
        Stack<EditAction> stack = new Stack<>();
        MedicalRecordHistory medicalHistory = new MedicalRecordHistory(stack);
        medicalHistory.addEdit(new EditAction("Chỉnh sửa thông tin A", "10:00 AM"));
        medicalHistory.addEdit(new EditAction("Cập nhật rank cho B lên S-", "10:30 AM"));
        medicalHistory.addEdit(new EditAction("Xóa nhân vật C (Rank F)", "11:00 AM"));
        medicalHistory.displayHistory();

        System.out.println(medicalHistory.isEmpty());
        System.out.println(medicalHistory.getLatestEdit());
        medicalHistory.undoEdit();

        medicalHistory.displayHistory();

    }
}

class EditAction{
    private String description;
    private String time;

    public EditAction(String description, String time) {
        this.description = description;
        this.time = time;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    @Override
    public String toString() {
        return "[" + time + "] " + description;
    }
}

class MedicalRecordHistory{
    Stack<EditAction> history;
    public MedicalRecordHistory(Stack<EditAction> history) {
        this.history = history;
    }
    void addEdit(EditAction action){
        history.push(action);
    }

    EditAction undoEdit(){
        return history.pop();
    }

    EditAction getLatestEdit(){
        return history.peek();
    }

    boolean isEmpty(){
        return history.isEmpty();
    }

    void displayHistory(){
        if (isEmpty()) {
            System.out.println("Lịch sử trống.");
            return;
        }
        for (int i = history.size() - 1; i >= 0; i--) {
            System.out.println(history.get(i));
        }
    }

}
