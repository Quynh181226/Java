package Begin;

import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ThS. Hoang Anh
 */
public class Menu {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        while(true){
            System.out.println("\n 1: Lựa chọn 1");
            System.out.println("\n 2: Lựa chọn 2");
            System.out.println("\n 3: Lựa chọn 3");
            System.out.println("\n 0: Thoát chương trình");
            System.out.println("\n Chọn 1 2 3 hoặc 0");
            Scanner sc=new Scanner(System.in);
            int number=sc.nextInt();
            switch(number){
                case 1:
                    System.out.println("Chức năng 1");
                    break;
                case 2:
                    System.out.println("Chức năng 2");
                    break;
                case 3:
                    System.out.println("Chức năng 3");
                    break;
                case 0:
                    System.exit(0);
                    break;
            }

        }
    }
}
