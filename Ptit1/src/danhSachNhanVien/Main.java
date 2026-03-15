
package danhSachNhanVien;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        ArrayList<NhanVien> ds = new ArrayList<>();
        int n = Integer.parseInt(in.nextLine());
        for(int i=1; i<=n; i++){
            NhanVien a = new NhanVien(i, in.nextLine(), in.nextLine(),in.nextLine(),in.nextLine(),in.nextLine(),in.nextLine());
            ds.add(a);
        }

        Collections.sort(ds);
        for(NhanVien nv : ds){
            System.out.println(nv);
        }
    }
}

