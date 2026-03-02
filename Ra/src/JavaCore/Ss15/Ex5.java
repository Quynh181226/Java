package JavaCore.Ss15;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//[Bài tập] Mô phỏng quy trình cấp cứu hoàn chỉnh
//1. Mục tiêu: Kết hợp nhiều cấu trúc dữ liệu. Mô phỏng hệ thống y tế thực tế.
//2. Mô tả: Hệ thống cấp cứu gồm: Queue bệnh nhân chờ cấp cứu. Stack lưu các bước xử lý của từng bệnh nhân (tiếp nhận, chẩn đoán, điều trị…).
//Yêu cầu: Bệnh nhân vào Queue theo thứ tự. Khi xử lý bệnh nhân, các bước được đẩy vào Stack. Cho phép Undo bước xử lý gần nhất nếu có sai sót.
//Cài đặt lớp TreatmentStep: Thuộc tính: String description, String time.
//Cài đặt lớp EmergencyCase: Thuộc tính: Patient patient, Stack<TreatmentStep> steps. Phương thức: void addStep(TreatmentStep step), TreatmentStep undoStep(), void displaySteps().
//Cài đặt lớp EmergencyCaseQueue: Thuộc tính: Queue<EmergencyCase> cases. Phương thức: void addCase(EmergencyCase c), EmergencyCase getNextCase().
//3. Kết quả mong muốn: Hệ thống mô phỏng đúng quy trình. Áp dụng Stack cho xử lý nội bộ. Áp dụng Queue cho luồng bệnh nhân.
public class Ex5 {
    static  void use(){
        Queue<EmergencyCase> qData = new LinkedList<>();
        EmergencyCaseQueue hospitalQueue = new EmergencyCaseQueue(qData);

        Patient p1 = new Patient("BN01", "A", 24);
        Stack<TreatmentStep> s1 = new Stack<>();
        EmergencyCase case1 = new EmergencyCase(p1, s1);

        case1.addStep(new TreatmentStep("Kiem tra vet thuong", "08:00"));
        case1.addStep(new TreatmentStep("Sat trung", "08:15"));
        case1.addStep(new TreatmentStep("Bang bo", "08:30"));

        hospitalQueue.addCase(case1);

        Patient p2 = new Patient("BN02", "B", 20);
        Stack<TreatmentStep> s2 = new Stack<>();
        EmergencyCase case2 = new EmergencyCase(p2, s2);

        case2.addStep(new TreatmentStep("Do huyet ap", "09:00"));
        case2.addStep(new TreatmentStep("Tiem thuoc giam dau", "09:10"));

        hospitalQueue.addCase(case2);

        System.out.println("\n--- XU LY CA CAP CUU DAU TIEN ---");
        EmergencyCase currentCase = hospitalQueue.getNextCase();
        if (currentCase != null) {
            System.out.println("Benh nhan: " + currentCase.patient.getName());

            System.out.println("Cac buoc da thuc hien:");
            currentCase.displaySteps();

            System.out.println("\nThuc hien Undo buoc cuoi cung:");
            currentCase.undoStep();

            System.out.println("\nDanh sach buoc sau khi Undo:");
            currentCase.displaySteps();
        }

        System.out.println("\n--- CA CAP CUU TIEP THEO ---");
        EmergencyCase nextCase = hospitalQueue.getNextCase();
        if (nextCase != null) {
            System.out.println("Benh nhan: " + nextCase.patient.getName());
            nextCase.displaySteps();
        }
    }
}

class TreatmentStep{
    String description;
    String time;

    public TreatmentStep(String description, String time) {
        this.description = description;
        this.time = time;
    }
    @Override
    public String toString(){
        return "[" + time + "]" + description;
    }
}
class EmergencyCase{
    Patient patient;
    Stack<TreatmentStep> steps;

    public EmergencyCase(Patient patient, Stack<TreatmentStep> steps) {
        this.patient = patient;
        this.steps = steps;
    }
    void addStep(TreatmentStep step){
        steps.push(step);
        System.out.println("Them thanh cong buoc " + step);
    }

    TreatmentStep undoStep(){
        if(steps.isEmpty()){
            System.out.println("Loi. Dang trong buoc");
            return null;
        }else{
            System.out.println("Undo thanh cong");
            return steps.pop();
        }
    }

    void displaySteps(){
        if(steps.isEmpty()){
            System.out.println("Loi. Dang trong buoc");
        }else{
            for (int i = steps.size() - 1 ; i >= 0 ; i --){
                System.out.println(steps.get(i));
            }
        }
    }
}

class EmergencyCaseQueue{
    Queue<EmergencyCase> cases;

    public EmergencyCaseQueue(Queue<EmergencyCase> cases) {
        this.cases = cases;
    }
    void addCase(EmergencyCase c){
        cases.offer(c);
        System.out.println("Them thanh cong");
    }

    EmergencyCase getNextCase(){
        if(cases.isEmpty()){
            System.out.println("ERROR");
            return null;
        }else{
            return cases.poll();
        }
    }
}

