package JavaCore.Ss15;

import java.util.Comparator;
import java.util.PriorityQueue;

//[Bài tập] Hàng đợi khám theo mức độ ưu tiên
//1. Mục tiêu: Hiểu mở rộng về Priority Queue. Mô phỏng bài toán y tế thực tế.
//2. Mô tả: Khoa cấp cứu tiếp nhận bệnh nhân với mức độ: Cấp cứu (ưu tiên cao), Thông thường (ưu tiên thấp).
//Yêu cầu: Bệnh nhân cấp cứu được khám trước. Nếu cùng mức độ, áp dụng FIFO. Sử dụng PriorityQueue hoặc tự thiết kế logic.
//Cài đặt lớp EmergencyPatient: Thuộc tính: String id, String name, int priority (1: cấp cứu, 2: thường). Phương thức khởi tạo, getter/setter.
//Cài đặt lớp EmergencyQueue: Thuộc tính (một trong hai cách): PriorityQueue<EmergencyPatient> hoặc Hai Queue<EmergencyPatient> (cấp cứu & thường). Phương thức: void addPatient(EmergencyPatient p), EmergencyPatient callNextPatient(), void displayQueue().
//3. Kết quả mong muốn: Cài đặt Queue ưu tiên đúng logic y tế. Hiển thị thứ tự bệnh nhân được khám. Giải thích rõ tiêu chí ưu tiên.
public class Ex4 {
    static void use(){
        EmergencyQueue hospital = new EmergencyQueue();

        hospital.addPatient(new EmergencyPatient("BN01", "A", 2));
        hospital.addPatient(new EmergencyPatient("BN02", "B", 2));
        hospital.addPatient(new EmergencyPatient("CC01", "C", 1));
        hospital.displayQueue();
        System.out.println("Mời bệnh nhân: " + hospital.callNextPatient());
        System.out.println("Mời bệnh nhân: " + hospital.callNextPatient());
    }
}

class EmergencyPatient {
    private String id;
    private String name;
    private int priority;

    public EmergencyPatient(String id, String name, int priority) {
        this.id = id;
        this.name = name;
        this.priority = priority;
    }
    public int getPriority() { return priority; }
    public String getName() { return name; }
    @Override
    public String toString() {
        String type = (priority == 1) ? " [CẤP CỨU]" : " [Thường]";
        return "ID: " + id + " | Tên: " + name + type;
    }
}

class EmergencyQueue {
    private PriorityQueue<EmergencyPatient> queue = new PriorityQueue<>(
            Comparator.comparingInt(EmergencyPatient::getPriority)
    );

    void addPatient(EmergencyPatient p) {
        queue.offer(p);
        System.out.println("-> Đã thêm: " + p.getName());
    }

    EmergencyPatient callNextPatient() {
        if (queue.isEmpty()) {
            System.out.println("Hàng đợi trống!");
            return null;
        }
        return queue.poll();
    }

    void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("Không có bệnh nhân chờ.");
            return;
        }
        System.out.println("--- Danh sách chờ khám (Theo thứ tự ưu tiên) ---");
        Object[] sortedArray = queue.toArray();
        java.util.Arrays.sort(sortedArray, (Object a, Object b) ->
                ((EmergencyPatient)a).getPriority() - ((EmergencyPatient)b).getPriority());

        for (Object p : sortedArray) {
            System.out.println(p);
        }
    }
}

