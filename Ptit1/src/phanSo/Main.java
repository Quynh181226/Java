package phanSo;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        phanSo.PhanSo p=new phanSo.PhanSo(in.nextLong(),in.nextLong());
        p.rutGon();
        System.out.println(p);
    }
}
