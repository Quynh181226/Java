package Pratice3;

//J05013 - TUYỂN DỤNG
//Doanh nghiệp X cần tuyển một số nhân viên mới. Bài thi tuyển có hai phần: lý thuyết và thực hành. Sau khi tính điểm trung bình, các thí sinh sẽ được xếp thành 4 loại:
//
//Nếu điểm dưới 5 -> TRUOT
//Nếu điểm lớn hơn 5 nhưng nhỏ hơn 8 -> CAN NHAC
//Nếu điểm từ 8 đến 9.5 -> DAT
//Nếu điểm lớn hơn 9.5 -> XUAT SAC
//Điểm các bài thi lý thuyết và thực hành đều là số thực trong phạm vi từ 0 đến 10. Tuy nhiên, khi nhập điểm các bài thi, cán bộ tuyển dụng có thể quên mất dấu . phân cách phần nguyên và phần thập phân. Do đó nếu điểm ghi là 78 thì cần được hiểu là 7.8. Tuy nhiên, điểm 10 thì vẫn ghi là 10 (không có giá trị điểm nào bằng 1.0).
//
//Hãy sắp xếp danh sách thí sinh đã được xếp loại theo điểm trung bình giảm dần.
//
//        Input
//
//Dòng đầu ghi số thí sinh. Mỗi thí sinh ghi trên 3 dòng lần lượt là:
//
//Họ và tên (xâu ký tự độ dài không quá 100)
//Điểm lý thuyết
//Điểm thực hành
//Mã thí sinh cần được tự động gán theo mẫu TS + số thứ tự (tính từ 01).
//
//Output
//
//Ghi ra danh sách thí sinh đã sắp xếp, mỗi thí sinh gồm 4 thông tin: mã thí sinh, họ tên, điểm trung bình (với 2 số phần thập phân) và xếp loại. Mỗi thông tin cách nhau một khoảng trống.
//
//Ví dụ
//
//Input	                                                        Output
//3 Nguyen Thai Binh 45 75 Le Cong Hoa 4 4.5 Phan Van Duc 56 56	TS01 Nguyen Thai Binh 6.00 CAN NHAC TS03 Phan Van Duc 5.60 CAN NHAC TS02 Le Cong Hoa 4.25 TRUOT

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/* Author: NgTienHungg */
class Person {

    private int id;
    private String name;
    private double pointA;
    private double pointB;

    public Person(int id, String name, double pointA, double pointB) {
        this.id = id;
        this.name = name;
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public String getId() {
        return String.format("TS%02d", id);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPointA() {
        if (pointA > 10) {
            return pointA /= 10;
        }
        return pointA;
    }

    public double getPointB() {
        if (pointB > 10) {
            return pointB /= 10;
        }
        return pointB;
    }

    public double getTotalPoint() {
        return (getPointA() + getPointB()) / 2;
    }

    public String getStatus() {
        if (getTotalPoint() < 5) {
            return "TRUOT";
        }
        if (getTotalPoint() < 8) {
            return "CAN NHAC";
        }
        if (getTotalPoint() <= 9.5) {
            return "DAT";
        }
        return "XUAT SAC";
    }

    @Override
    public String toString() {
        return getId() + " " + name + " " + String.format("%.2f", getTotalPoint()) + " " + getStatus();
    }
}

public class tuyenDung {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<Person> arrayList = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            sc.nextLine();
            arrayList.add(new Person(i + 1, sc.nextLine(), sc.nextDouble(), sc.nextDouble()));
        }

        Collections.sort(arrayList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getTotalPoint() < o2.getTotalPoint() ? 1 : -1;
            }
        });

        for (Person i : arrayList) {
            System.out.println(i);
        }
    }
}