package JavaCore.Ss4;

//Mỗi cuốn sách có một đoạn mô tả ngắn, trong đó thường chứa mã vị trí kệ sách theo quy tắc: "Kệ: [Vị trí]"
//
//Yêu cầu:
//Cho một đoạn văn bản mô tả cuốn sách
//Kiểm tra xem trong đoạn văn có chứa từ khóa "Kệ:" hay không
//Nếu có, hãy trích xuất mã vị trí đứng ngay sau từ "Kệ:" cho đến hết dòng hoặc đến dấu phẩy tiếp theo
//Thay thế từ khóa "Kệ:" thành "Vị trí lưu trữ:" và in lại đoạn mô tả mới

//Sách giáo khoa Toán lớp 12, Kệ: A1-102 tình trạng mới.
//Sách giáo khoa Toán lớp 12, Kệ: A1-102, tình trạng mới.

import java.util.Scanner;

public class B2 {
    public  static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập đoạn mô tả sách: ");
        String descript=sc.nextLine();

        //Check keyword
        //Check mã vtri
        //Check point end + Check t.hop 1 or 2
        //Print + replace theo request or Print not found
        String key="Kệ:";

        boolean check=false;
//      check=descript.contains("Kệ:");
        check=descript.contains(key);
        if(check){

            int startIdx=descript.indexOf("Kệ:")+key.length();
            int endIdx=descript.indexOf(",",startIdx);

            if(endIdx==-1) endIdx=descript.length();

            String pos=descript.substring(startIdx,endIdx).trim();

            System.out.println("Vị trí tìm thấy: "+pos);

            String newDescript=descript.replace(key, "Vị trí lưu trữ:");

            System.out.println("Mô tả ms: " +newDescript);
        }else {
            System.out.println("Không tìm thấy từ khóa: '"+key+"' trong đoạn!!");
        }
    }
}
