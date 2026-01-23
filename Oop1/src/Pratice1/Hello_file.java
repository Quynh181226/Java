package Pratice1;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
//Du lieu van ban chua file trg Hello.txt
//Yeu cau doc noi dung tu file van ban Hello.txt va in ket qua ra man hinh
//Input: Ko co dlieu vao
//Output: Noi dung trg file vban Hello.txt
//Day la lop chinh chua phuong thuc main
public class Hello_file {
    //pthuc chinh de chay ctrinh
    public static void main(String[] args) throws FileNotFoundException {
                                           //Neu file ko ton tai ctrinh se bao loi thay vi dung dot ngot
        Scanner sc = new Scanner(new File("Hello.txt"));
//Tao 1 dtuong Sc de doc ndung file   //Mo file...de doc
        while(sc.hasNext()) {
            //de ktra xem con dong nao trg file ko
            System.out.println(sc.nextLine());
//In ndung vua doc ra man hinh //Doc tung dong trg file
        }
    }
}
