package Pratice3;
//J05014 - TUYỂN GIÁO VIÊN
//Trường THPT ACB tuyển giáo viên mới cho ba môn Toán, Lý, Hóa. Theo yêu cầu mới, bài thi tuyển gồm 2 nội dung: Tin học và Chuyên môn. Điểm thi Tin học sẽ được nhân đôi khi tính tổng điểm.
//
//Mỗi GV có thể có điểm ưu tiên được xét theo mã như trong bảng sau:
//
//Alt text
//
//Mã xét tuyển gồm 2 thành phần. Chữ cái đầu tiên ứng với môn học: A là Toán, B là Lý và C là Hóa; tiếp theo là 1 chữ số thể hiện mã ưu tiên.
//
//Tổng điểm sau khi cộng điểm ưu tiên nếu từ 18 trở lên sẽ được xét TRÚNG TUYỂN, nhỏ hơn sẽ bị LOẠI.
//
//Viết chương trình nhập danh sách điểm thi và sắp xếp GV theo thứ tự tổng điểm giảm dần. Mã GV dự thi được tự động gán theo thứ tự bắt đầu từ 01.
//
//Input
//
//Dòng đầu thi số giáo viên đăng ký thi tuyển (không quá 20).
//
//Mỗi GV được viết trên 4 dòng gồm:
//
//Tên GV (xâu ký tự độ dài không quá 50)
//Mã xét tuyển
//Điểm tin học (số thực trong phạm vi 0 đến 10)
//Điểm chuyên môn (số thực trong phạm vi 0 đến 10)
//Output
//
//Ghi ra danh sách đã sắp xếp. Thông tin mỗi GV gồm: Mã GV, Tên, Môn học, Tổng điểm (1 chữ số phần thập phân), Kết quả. Mỗi thông tin cách nhau một khoảng trống.
//
//Ví dụ
//
//Input	Output
//3 Le Van Binh A1 7.0 3.0 Tran Van Toan B3 4.0 7.0 Hoang Thi Tam C2 7.0 6.0	GV03 Hoang Thi Tam HOA 21.5 TRUNG TUYEN GV01 Le Van Binh TOAN 19.0 TRUNG TUYEN GV02 Tran Van Toan LY 16.0 LOAI
/* Author: NgTienHungg */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Teacher {

    private int id;
    private String name;
    private String idd;
    private double point1, point2;

    public Teacher(int id, String name, String idd, double point1, double point2) {
        this.id = id;
        this.name = name;
        this.idd = idd;
        this.point1 = point1;
        this.point2 = point2;
    }

    public String getId() {
        return String.format("GV%02d", id);
    }

    public String getSubject() {
        String s = idd.substring(0, 1);
        switch (s) {
            case "A":
                return "TOAN";
            case "B":
                return "LY";
            case "C":
                return "HOA";
            default:
                return "";
        }
    }

    public double getBonus() {
        int n = Integer.parseInt(idd.substring(1, 2));
        switch (n) {
            case 1:
                return 2.0;
            case 2:
                return 1.5;
            case 3:
                return 1.0;
            default:
                return 0.0;
        }
    }

    public double getTotalPoint() {
        return point1 * 2 + point2 + getBonus();
    }

    public String getStatus() {
        if (getTotalPoint() >= 18) {
            return "TRUNG TUYEN";
        }
        return "LOAI";
    }

    @Override
    public String toString() {
        return getId() + " " + name + " " + getSubject() + " " + String.format("%.1f", getTotalPoint()) + " " + getStatus();
    }
}

public class tuyenGiaoVien {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        List<Teacher> teachers = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            scanner.nextLine();
            teachers.add(new Teacher(i + 1, scanner.nextLine(), scanner.nextLine(), scanner.nextDouble(), scanner.nextDouble()));
        }

        Collections.sort(teachers, new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                if (o1.getTotalPoint() == o2.getTotalPoint()) {
                    return o1.getId().compareTo(o2.getId());
                }
                return o1.getTotalPoint() < o2.getTotalPoint() ? 1 : -1;
            }
        });

        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }
}