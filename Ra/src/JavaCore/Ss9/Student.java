package JavaCore.Ss9;

public class Student  extends Person{
    int id;
    double avg;

    public Student(String name, int age, int id, double avg) {
        super(name, age);
        this.id = id;
        this.avg = avg;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Ma sinh vien: " + id);
        System.out.println("Diem trung binh: " + avg);
    }
}