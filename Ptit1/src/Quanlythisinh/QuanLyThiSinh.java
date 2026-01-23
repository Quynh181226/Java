/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quanlythisinh;

import java.util.Scanner;

public class QuanLyThiSinh {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello");
        PhongThi phongthi=new PhongThi("A101", "Phong 101", 30);
        while(true){
            System.out.println("Chương trình quản lý thí sinh trong phòng thi");
            System.out.println("0- Thoát chương trình");
            System.out.println("1- Thêm thí sinh");
            System.out.println("2- Sửa thí sinh");
            System.out.println("3- Danh sách thí sinh");
            System.out.println("4- Nhập điểm");
            System.out.println("5- Sắp xếp theo Họ Tên");
            System.out.println("6- Sắp xếp theo Điểm toán");
            System.out.println("Mời bạn chọn số: ");
            Scanner input = new Scanner(System.in);
            int selection = input.nextInt();
            switch(selection){
                case 1:
                    phongthi.themThiSinh();
                    break;
                case 2:
                    phongthi.suaThiSinh();
                    break;
                case 3:
                    phongthi.inDanhSach();
                    break;
                case 4:
                    phongthi.nhapDiem();
                    break;
                case 5:
                    phongthi.sapXepByTen();
                    phongthi.inDanhSach();
                    break;
                case 6:
                    phongthi.sapXepByDiemToan();
                    phongthi.inDanhSach();
                    break;
                case 0:
                    System.exit(0);

            }
        }

    }

}