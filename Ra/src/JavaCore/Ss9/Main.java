package JavaCore.Ss9;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//    Student s1 = new Student("Thanh" , 19 , 1, 4.5);
//    s1.displayInfo();
//    Animal dog = new Dog();
//    Animal cat = new Cat();
//    dog.sound();
//    cat.sound();
//
//        Manager m = new Manager("An", 15000000, 101);
//        m.displayInfo();
//        Animal ani = new Dog();
//        ani.feed();
//        if ( ani instanceof Dog){
//            Dog dog = (Dog) ani;
//            dog.piss();
//        }
//        ArrayList<Employee> list1 = new ArrayList<>();
//        Employee e1 = new OfficeEmployee("An", 1000 ); //3000
//        Employee e2 = new OfficeEmployee("Binh", 2000); // 4000
//        Employee e3 = new ProductionEmployee("Cuong", 3000); //13000
//        list1.add(e1);        list1.add(e2);     list1.add(e3);
//        double total = 0;
//        for (int i = 0 ; i < list1.size() ; i ++){
//            total += list1.get(i).calculateSalary();
//        }
//        System.out.println(total);
        ArrayList<Shape> list = new ArrayList<>();

        Shape s1 = new Circle();
        Shape s2 = new Circle();
        Shape s3 = new Rectangle();
        Shape s4 = new Rectangle();

        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        double totalArea = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) instanceof Circle){
                totalArea += list.get(i).area(5);
            }else{
                totalArea += list.get(i).area(3,6);
            }
        }

        System.out.println("Tong dien tich = " + totalArea);






    }
}