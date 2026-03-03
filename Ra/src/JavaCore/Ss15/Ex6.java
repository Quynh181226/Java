package JavaCore.Ss15;

import java.util.*;

public class Ex6 {
    static void use() {
        PatientWaitingQueue hospitalQueue = new PatientWaitingQueue();
        hospitalQueue.addPatient(new Patient("P01", "A", 24, "Nu"));
        hospitalQueue.addPatient(new Patient("P02", "V", 20, "Nu"));
        System.out.println("Goi kham: " + hospitalQueue.callPatient().getName());

        MedicalRecordHistory1 history = new MedicalRecordHistory1("REC100");
        history.saveAction(new EditAction1("Thay doi nhip tim", "Dr. HACKER", "08:00"));
        history.saveAction(new EditAction1("Cap nhat huyet ap", "Dr. KAKA", "08:15"));
        history.showHistory();

        TicketSystem ts = new TicketSystem();
        ts.issueTicket();
        ts.issueTicket();
        System.out.println("So dang goi: " + ts.callNextTicket().getTicketNumber());

        UndoManager undo = new UndoManager(5);
        undo.performAction(new InputAction("Age", "20", "25", "09:00"));
        undo.performAction(new InputAction("Name", "Dog", "Human", "09:05"));
        undo.undo();
    }

    public static void main(String[] args) {
        use();
    }
}

class Patient {
    private String id, name, gender;
    private int age;
    public Patient(String id, String name, int age, String gender) {
        this.id = id; this.name = name; this.age = age; this.gender = gender;
    }
    public String getName() { return name; }
}

class PatientWaitingQueue {
    private Queue<Patient> waitingQueue = new LinkedList<>();
    void addPatient(Patient p) { waitingQueue.offer(p); }
    Patient callPatient() { return waitingQueue.poll(); }
}

class EditAction1 {
    private String description, editedBy, editTime;
    public EditAction1(String d, String e, String t) {
        description = d; editedBy = e; editTime = t;
    }
    public String toString() { return "[" + editTime + "] " + description + " by " + editedBy; }
}

class MedicalRecordHistory1 {
    private Stack<EditAction1> editStack = new Stack<>();
    private String recordId;
    public MedicalRecordHistory1(String id) { this.recordId = id; }
    void saveAction(EditAction1 a) { editStack.push(a); }
    void showHistory() {
        for (int i = editStack.size() - 1; i >= 0; i--) System.out.println(editStack.get(i));
    }
}

class Ticket {
    private int ticketNumber;
    private String issuedTime;
    public Ticket(int num, String time) { ticketNumber = num; issuedTime = time; }
    public int getTicketNumber() { return ticketNumber; }
}

class TicketSystem {
    private Queue<Ticket> ticketQueue = new LinkedList<>();
    private int currentNumber = 1;
    void issueTicket() {
        ticketQueue.offer(new Ticket(currentNumber++, "Now"));
    }
    Ticket callNextTicket() { return ticketQueue.poll(); }
}

class InputAction {
    private String fieldName, oldValue, newValue, actionTime;
    public InputAction(String f, String o, String n, String t) {
        fieldName = f; oldValue = o; newValue = n; actionTime = t;
    }
    public String toString() { return "Undo " + fieldName + ": " + newValue + " -> " + oldValue; }
}

class UndoManager {
    private Stack<InputAction> undoStack = new Stack<>();
    private int maxUndoSteps;
    public UndoManager(int max) { maxUndoSteps = max; }
    void performAction(InputAction a) {
        if (undoStack.size() >= maxUndoSteps) undoStack.remove(0);
        undoStack.push(a);
    }
    void undo() {
        if (!undoStack.isEmpty()) System.out.println("Thuc hien: " + undoStack.pop());
    }
}