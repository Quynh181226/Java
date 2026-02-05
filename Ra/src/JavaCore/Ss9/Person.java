package JavaCore.Ss9;

public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayInfo() {
        System.out.println("Ho ten: " + name);
        System.out.println("Tuoi: " + age);
    }

}
