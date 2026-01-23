package Pratice1;

import java.util.Scanner;

//Cho do dai 2 canh cua hinh chu nhat
//Gtri ko qua 10^4
//Viet ctrinh tinh chu vi va dtich hinh chu nhat do
//Neu dlieu ko hop le(chieu dai or chieu rong <=0 thi in ra so 0)
//Input: Co duy nhat 1 dong ghi 2 so nguyen, cach nhau 1 khoang trong
//Output: In ket qua tren 1 dong, chu vi roi den dien tich, cach nhau 1 khoang trong
//Example Input: 10 2
//Example Output: 24 20
public class Hinh_chu_nhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int width=sc.nextInt();
        int height=sc.nextInt();
        //B1: Validate
        if(width<=0||height<=0){
            System.out.print(0);
        }else{
        //B2: Tinh C, S
            System.out.println(2*(width+height)+" "+width*height);
        }
    }
}
