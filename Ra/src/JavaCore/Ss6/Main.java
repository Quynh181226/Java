package JavaCore.Ss6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //1
//        B1Student s2 = new B1Student(2, "Quynh", 2016, 7.5);
//        B1Student s1 = new B1Student(1, "Quynh", 2006, 9.5);
//        s1.displayInfo();
//        s2.displayInfo();

        //2
//        B2Account a1 = new B2Account("Quynh1812", "abc12345", "quynh@gmail.com");
//        B2Account a2 = new B2Account("Wuynk", "123456", "wuynk@gmail.com");
//        a1.displayInfo();
//        a2.displayInfo();
//        a1.changePassword("newPas1244");
//        System.out.println(a1.password);

        //3
//        System.out.print("1. ");
//        B3Product p1 = new B3Product(10, "gucci", 1000);
//        p1.displayInfo();
//        System.out.print("2. ");
//        p1.setPrice(-1);
//        System.out.print("3. ");
//        p1.setPrice(2000);
//        p1.displayInfo();

        //4
//        B4Employee e1 = new B4Employee();
//        B4Employee e2 = new B4Employee(12, "Wuynk");
//        B4Employee e3 = new B4Employee(25000, "Quynh", 33);
//        e1.displayInfo();
//        e2.displayInfo();
//        e3.displayInfo();

        //5
//        B5Book b = new B5Book(1, "Clean Code", "Rose Pak", 99.5);
//        b.displayInfo();

        //6
        B6User u1 = new B6User(1, "user@gmail.com", "123456", "B6User");
        B6User u2 = new B6User(2, "user01@ptit.edu.vn", "password@2025", "user01");
        u1.displayInfo();
        u2.displayInfo();

        System.out.print("1. ");
        u1.setEmail("abc");
        System.out.print("2. ");
        u1.setEmail("B6User@gmail.com");

        System.out.print("3. ");
        u1.setPassword("");

        System.out.print("4. ");
        u1.setPassword("B6UserB6User");
        u1.displayInfo();

        System.out.println(u1.getPassword());
    }
}
