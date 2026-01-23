package Pratice3;

import java.util.Scanner;
//J04012 - BÀI TOÁN TÍNH CÔNG
//Thông tin về nhân viên bao gồm:
//
//Mã nhân viên (tự động tăng theo thứ tự nhập, tính từ NV01, nếu chỉ có 1 nhân viên thì mã là NV01)
//Họ và tên
//Lương cơ bản mỗi ngày công
//Số ngày công
//Chức vụ
//Tiền lương được tính bằng lương cơ bản nhân với số ngày công.
//
//Giả sử quy tắc tính tiền thưởng như sau:
//
//Số ngày công từ 25 trở lên thì thưởng 20% tiền lương
//Số ngày công từ 22 đến dưới 25 thì thưởng 10% tiền lương
//Dưới 22 ngày công thì không có thưởng.
//Mỗi nhân viên có thể có thêm phụ cấp chức vụ:
//
//GD: 250000
//PGD: 200000
//TP: 180000
//NV: 150000
//Hãy nhập thông tin 1 nhân viên và tính toán thu nhập theo quy tắc trên.
//
//        Input
//
//Gồm 4 dòng lần lượt ghi Họ tên, lương cơ bản, số ngày công và chức vụ.
//
//        Output
//
//Ghi ra một dòng gồm: mã nhân viên, tên nhân viên, lương tháng, thưởng, phụ cấp và thu nhập. Mỗi thông tin cách nhau một khoảng trống.
//
//Ví dụ
//
//Input	                            Output
//Bui Thi Trang 45000 23 PGD	        NV01 Bui Thi Trang 1035000 103500 200000 1338500
class Officer {

    private String id, name;
    private int salary, bonus, allowance;

    public Officer(String name, int wage, int workingDays, String role) {
        this.id = "NV01";
        this.name = name;
        this.salary = wage * workingDays;

        if (workingDays >= 25) {
            this.bonus = (int) (salary * 0.2f);
        } else if (workingDays >= 22) {
            this.bonus = (int) (salary * 0.1f);
        } else {
            this.bonus = 0;
        }

        switch (role) {
            case "GD":
                allowance = 250000;
                break;
            case "PGD":
                allowance = 200000;
                break;
            case "TP":
                allowance = 180000;
                break;
            case "NV":
                allowance = 150000;
                break;
        }
    }

    public int getIncome() {
        return salary + bonus + allowance;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + salary + " " + bonus + " " + allowance + " " + getIncome();
    }
}

public class baiToanTinhCong {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int salary = Integer.parseInt(sc.nextLine());
        int workingDays = Integer.parseInt(sc.nextLine());
        String role = sc.nextLine();
        Officer officer = new Officer(name, salary, workingDays, role);
        System.out.println(officer);
    }
}