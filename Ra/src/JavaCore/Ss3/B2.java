package JavaCore.Ss3;

import java.util.Scanner;

//Thủ thư cần tìm xem một cuốn sách có tên cụ thể (hoặc mã cụ thể) có nằm trong danh sách sách hiện có hay không
//
//Yêu cầu:
//Khai báo và khởi tạo sẵn một mảng String[] books chứa tên của ít nhất 5 cuốn sách
//Viết phương thức searchBooks(String[] arr, String search): Trả về vị trí (index) của cuốn sách nếu tìm thấy, hoặc trả về -1 nếu không tìm thấy
//Trong main, cho người dùng nhập tên sách cần tìm, gọi phương thức và in ra kết quả: "Tìm thấy tại vị trí X" hoặc "Sách không tồn tại"
public class B2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] books={"Abc", "Abd", "Abg", "Abj", "Abl"};

        System.out.print("Nhập tên sách cần tìm kiếm: ");
        String search=sc.nextLine();

        int idx=searchBooks(books, search);

        if(idx!=-1){
            System.out.println("Tìm thấy sách '"+search+"' tại vị trí " + idx);
        } else {
            System.out.println("Sách không tồn tại");
        }
    }

    public static int searchBooks(String[] arr, String search){
        for(int i = 0; i < arr.length; i++){
            if(arr[i].equals(search)){
                return i;
            }
        }
        return -1;
    }
}
