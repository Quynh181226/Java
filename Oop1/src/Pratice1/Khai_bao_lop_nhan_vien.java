package Pratice1;
//Bai 4: Khai bao lop nhan vien
//Một nhân viên làm việc trong công ty được lưu lại các thông tin sau:
//Mã nhân viên: được gán giá trị là 00001
//Họ tên: Xâu ký tự không quá 40 chữ cái.
//Giới tính: Nam hoặc Nu
//Ngày sinh: đúng theo chuẩn dd/mm/yyyy
//Địa chỉ: Xâu ký tự không quá 100 chữ cái
//Mã số thuế: Dãy số có đúng 10 chữ số
//Ngày ký hợp đồng: đúng theo chuẩn dd/mm/yyyy
//Viết chương trình nhập một nhân viên (không nhập mã) in ra màn hình thông tin của nhân viên đó.
//Input
//Gồm 6 dòng lần lượt ghi các thông tin theo thứ tự đã ghi trong đề bài. Không có mã nhân viên.
//Output
//Ghi ra đầy đủ thông tin nhân viên trên một dòng, các thông tin cách nhau đúng một khoảng trống.
//Ví dụ
//Input:
//Nguyen Van Hoa
//Nam
//22/11/1982
//Mo Lao-Ha Dong-Ha Noi
//8333123456
//31/12/2013
//Output:
//00001 Nguyen Van Hoa Nam 22/11/1982 Mo Lao-Ha Dong-Ha Noi 8333123456 31/12/2013
import java.util.Scanner;
class Staff {
    private String mnv, name, sex, dob, address, tax, date;
    public Staff() {

        this("00001", "", "", "", "", "", "");
    }
    public Staff(String mnv, String name, String sex, String dob, String address, String tax, String date) {
        this.mnv = mnv;
        this.name = name;
        this.sex = sex;
        this.dob = dob;
        this.address = address;
        this.tax = tax;
        this.date = date;
    }
    @Override
    public String toString() {
        return mnv + " " + name + " " + sex + " " + dob + " " + address + " " + tax + " " + date;
    }
}
public class Khai_bao_lop_nhan_vien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String sex = sc.nextLine();
        String dob = sc.nextLine();
        String address = sc.nextLine();
        String tax = sc.nextLine();
        String date = sc.nextLine();
        Staff sta = new Staff("00001", name, sex, dob, address, tax, date);
        System.out.println(sta);
    }
}

