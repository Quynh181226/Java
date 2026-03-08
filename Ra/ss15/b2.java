import java.util.LinkedList;
import java.util.Queue;

public class b2 {
    static  void use(){
        Queue<Patient> queueData = new LinkedList<>();
        PatientQueue hospitalQueue = new PatientQueue(queueData);
        hospitalQueue.addPatient(new Patient("BN01", "A", 24));
        hospitalQueue.addPatient(new Patient("BN02", "B", 20));
        hospitalQueue.addPatient(new Patient("BN03", "C", 22));

        hospitalQueue.displayQueue();
        System.out.println("\nBệnh nhân chuẩn bị đến lượt: " + hospitalQueue.peekNextPatient());

        System.out.println("\nMời bệnh nhân vào phòng khám: " + hospitalQueue.callNextPatient());

        System.out.println("\n--- Danh sách còn lại sau khi gọi ---");
        hospitalQueue.displayQueue();

    }
}

class Patient{
    private String id;
    private String name;
    private int age;

    public Patient(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString(){
        return "ID: " + id +"." + name + "- Tuoi: " + age;
    }
}

class PatientQueue{
    Queue<Patient> queue;

    public PatientQueue(Queue<Patient> queue) {
        this.queue = queue;
    }
    void addPatient(Patient p){
        queue.offer(p);
    }

    Patient callNextPatient(){
        return queue.poll();
    }

    Patient peekNextPatient(){
        return queue.peek();
    }

    boolean isEmpty(){
        return queue.isEmpty();
    }

    void displayQueue(){
        if (isEmpty()) {
            System.out.println("Lịch sử trống.");
            return;
        }
        for (Patient p : queue) {
            System.out.println(p);
        }
    }
}