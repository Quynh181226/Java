package Pratice3;

//J04015 - TÍNH THU NHẬP GIÁO VIÊN
//        Trường phổ thông XYZ tính lương giáo viên theo quy tắc sau:
//
//        Mỗi giáo viên có mã ngạch gồm 4 ký tự trong đó
//        2 ký tự đầu là chức vụ (HT: Giáo viên kiêm nhiệm Hiệu trưởng, HP: Giáo viên kiêm nhiệm Hiệu phó, GV: Giáo viên thường)
//        2 ký tự số cuối cùng cho biết hệ số bậc lương (không quá 20)
//        Lương cơ bản của mỗi giáo viên cũng có thể khác nhau
//        Phụ cấp quy định như sau
//        HT: 2.000.000
//        HP: 900.000
//        GV: 500.000
//        Thu nhập được tính bằng lương cơ bản nhân với hệ số bậc lương và cộng thêm phụ cấp.
//        Hãy tính lương cho 1 giáo viên theo quy tắc trên.
//
//        Input
//
//        Có 3 dòng lần lượt là mã ngạch, họ tên và lương cơ bản.
//
//        Ouput
//
//        Chỉ có một dòng ghi lần lượt các thông tin: mã ngạch, họ tên, bậc lương, phụ cấp, thu nhập.
//
//        Ví dụ
//
//        Input	                                Output
//        HP04 Tran Quoc Huy 1578000	            HP04 Tran Quoc Huy 4 900000 7212000

import java.util.Scanner;

class Teacher1 {

    private String code, name;
    private int coeSalary, allowance, baseSalary;

    public Teacher1() {

    }

    public Teacher1(String code, String name, int baseSalary) {
        this.code = code;
        this.name = name;
        this.baseSalary = baseSalary;

        coeSalary = Integer.parseInt(code.substring(2));

        if (code.substring(0, 2).equals("HT")) {
            allowance = 2000000;
        } else if (code.substring(0, 2).equals("HP")) {
            allowance = 900000;
        } else if (code.substring(0, 2).equals("GV")) {
            allowance = 500000;
        }
    }

    public int getSalary() {
        return baseSalary * coeSalary + allowance;
    }

    @Override
    public String toString() {
        return code + " " + name + " " + coeSalary + " " + allowance + " " + getSalary();
    }
}

public class tinhThuNhapGiaoVien {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String code = sc.nextLine();
        String name = sc.nextLine();
        int bSalary = sc.nextInt();
        Teacher1 tc = new Teacher1(code, name, bSalary);
        System.out.println(tc);
    }
}
