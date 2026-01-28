package JavaCore.Ss4;

import java.util.Scanner;

//Hệ thống nhận dữ liệu thô từ thủ thư nhập vào nhưng thường xuyên bị thừa khoảng trắng hoặc sai định dạng hoa/thường
//
//Yêu cầu:
//Nhập vào tên sách, tác giả
//Loại bỏ khoảng trắng thừa ở hai đầu và giữa các từ
//Định dạng lại: Tên sách viết hoa toàn bộ, Tên tác giả viết hoa chữ cái đầu mỗi từ
//Xuất ra chuỗi tổng hợp: [TÊN SÁCH] - Tác giả: [Tên Tác Giả]
//B1:
//Chuan hoa khoang trang
//B2
//Viet hoa chu cai dau moi tu
//Tach thanh cac tu de xu ly tung tu 1
//Lay chu cai dau viet hoa + phan con lai cua tu
//C1-C2: while + contains(" ") + replace

public class B1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập tên sách: ");
        String book= sc.nextLine();
        book = book.trim().replaceAll("\\s+", " ").toUpperCase();

        System.out.print("Nhập tên tác giả: ");
        String author = sc.nextLine();
        author=format(author);

        System.out.println("\n["+book+"] - "+"Tác giả: "+author);
    }

    public static String format(String str){
        if(str==null || str.isEmpty()) return "";
        str=str.trim().replaceAll("\\s+"," ");

        String[] words = str.split(" ");
        StringBuilder res=new StringBuilder();

        for(String e: words){
            if(!e.isEmpty()){
                res.append(Character.toUpperCase(e.charAt(0)));
                res.append(e.substring(1).toLowerCase());
                res.append(" ");
            }
        }

        return res.toString().trim();
    }
}
