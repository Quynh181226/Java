package Pratice3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
//danh sách nhân viên + sắp xếp già nhất
class Staff implements Comparable<Staff> {
    private String mnv, name, gender, dob, address, tax, contractDate;
    public Staff(String mnv, String name, String gender, String dob, String address, String tax, String date){
        this.mnv = mnv;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.tax = tax;
        this.contractDate = date;
    }
    public Date getDobDate(){
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(dob);
        } catch (ParseException e) {
            return new Date(0);
        }
    }
    @Override
    public int compareTo(Staff o) {
        return this.getDobDate().compareTo(o.getDobDate());
    }
    @Override
    public String toString() {
        return mnv+" "+name+" "+gender+" "+dob+" "+address+" "+tax+" "+ contractDate;
    }
}
public class danhSachNhanVien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Staff[] staff = new Staff[n];
        for (int i = 0; i < n; i++) {
            String mnv=String.format("%05d", i+1);
            String name = sc.nextLine();
            String gender = sc.nextLine();
            String dob = sc.nextLine();
            String address = sc.nextLine();
            String tax = sc.nextLine();
            String date = sc.nextLine();
            staff[i]=new Staff(mnv, name, gender, dob, address, tax, date);
        }
        Arrays.sort(staff);
        for(Staff staff1 : staff){
            System.out.println(staff1);
        }
    }
}
