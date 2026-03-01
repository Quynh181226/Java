package JavaCore.Ss14.Ex;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//[Bài tập] Tra cứu danh mục thuốc BHYT
//Mục tiêu:
//Sử dụng Map để tra cứu nhanh thông tin (Key-Value).
//Mô tả:
//Tạo một HashMap để lưu danh mục thuốc với: Key là Mã thuốc (String), Value là Tên thuốc (String).
//Thêm sẵn 5 loại thuốc (ví dụ: T01-Paracetamol, T02-Ibuprofen...).
//Viết chương trình cho phép dược sĩ nhập vào Mã thuốc.
//Nếu mã tồn tại, in ra tên thuốc. Nếu không, thông báo "Thuốc không có trong danh mục BHYT".
//Kết quả mong muốn:
//Input: Nhập mã T01.
//Output: Tên thuốc: Paracetamol.
//Input: Nhập mã X99.
//Output: Thuốc không tồn tại.
public class Ex2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Map<String,String> danhMucThuoc=new HashMap<>();

        danhMucThuoc.put("T01", "Paracetamol");
        danhMucThuoc.put("T02", "Ibuprofen");
        danhMucThuoc.put("T03", "Amoxicillin");
        danhMucThuoc.put("T04", "Aspirin");
        danhMucThuoc.put("T05", "Vitamin C");

        String maThuoc=sc.nextLine();
        if(danhMucThuoc.containsKey(maThuoc)){
            System.out.println(danhMucThuoc.get(maThuoc));
        }else{
            System.out.println("Thuoc ko ton tai");
        }
    }
}

