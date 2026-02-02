package JavaCore.Ss7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //1
        B1Student s1 = new B1Student("1", "Thanh");
        B1Student s2 = new B1Student("2", "Nam");
        System.out.println(B1Student.displayTotalStudent());
        s1.displayInfo();

        //2
//        B2.execute();

        //3
//        B3ScoreUtils.getResult(8);
//        B3ScoreUtils.getResult(4);
//        int[] arr = {6, 8, 4};
//        B3ScoreUtils.calAvg(arr);

        //4
//        B4Classroom s11 = new B4Classroom("Thanh");
//        B4Classroom s22 = new B4Classroom("Nhat");
//        B4Classroom.showFund();
//        s11.addFund(1000);
//        s22.addFund(3400);
//        B4Classroom.showFund();

        //5
//        System.out.println(B5Config.MAX_SCORE);
//        System.out.println(B5Config.MIN_SCORE);
//        B5Config.MAX_SCORE = 1.2;
//        System.out.println(B5Config.MAX_SCORE);

        //6
//        B6User u1 = new B6User(1, "thanhPro", "abc1254");
//        B6User u2 = new B6User(2, "Bahcpro", "142egdfffd");
//        B6User u3 = new B6User(3, "minhHack", "133gfdhjyt");
//
//        B6User.UserManager.addUser(u1);
//        B6User.UserManager.addUser(u2);
//        B6User.UserManager.addUser(u3);
//
//        B6User.UserManager.searchUser(1);
//        B6User.UserManager.searchUser(14);


//        while (true) {
//            System.out.println("\n1. Thêm học sinh");
//            System.out.println("2. Hiển thị danh sách");
//            System.out.println("3. Điểm trung bình");
//            System.out.println("0. Thoát");
//            int c = Integer.parseInt(sc.nextLine());
//
//            switch (c) {
//                case 1:
//                    Btth1.addStudent(sc);
//                    break;
//                case 2:
//                    Btth1.showStudents();
//                    break;
//                case 3:
//                    Btth1.averageScore();
//                    break;
//                case 0:
//                    return;
//            }
//        }
    }
}
