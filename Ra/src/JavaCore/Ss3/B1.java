package JavaCore.Ss3;

import java.util.Scanner;

//Thư viện cần quản lý một danh sách các mã số sách (ISBN) dưới dạng các số nguyên. Bạn cần xây dựng một chương trình nhỏ để nhập danh sách này và in ra màn hình để kiểm kê
//
//Yêu cầu:
//Viết phương thức addBookToLibraries(int n): Cho phép người dùng nhập vào n mã sách và trả về một mảng số nguyên.
//Viết phương thức displayLibraries(int[] arr): Nhận vào mảng mã sách và in các mã này ra màn hình, mỗi mã cách nhau một dấu phẩy.
//Trong hàm main, yêu cầu người dùng nhập số lượng sách n, gọi hàm nhập và sau đó gọi hàm hiển thị
public class B1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng sách cần quản lý: ");
        int n = sc.nextInt();

        System.out.println("Nhập mã số cho "+n+" cuốn sách: ");

        //arr code book
        int[] library=addBookToLibraries(n);
        System.out.println("--- Kết quả ---");
        System.out.print("Danh sách mã số sách: ");
        displayLibraries(library);
    }

    public static int[] addBookToLibraries(int n){
        Scanner sc = new Scanner(System.in);
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            System.out.print("Sách thứ " + (i + 1) + ": ");
            arr[i]=sc.nextInt();
        }
        return arr;
    }

    public static void displayLibraries(int[] arr){
        if (arr.length > 0) {
            System.out.print(arr[0]);
            for (int i = 1; i < arr.length; i++) {
                System.out.print(", " + arr[i]);
            }
        }
        else{
            System.out.print("Empty");
        }
        System.out.println();
    }
}
