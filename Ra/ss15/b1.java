import java.util.Stack;

public class b1 {
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


