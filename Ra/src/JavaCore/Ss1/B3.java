package JavaCore.Ss1;

import java.util.Scanner;

//Thực hiện hoán đổi vị trí của hai tên sách trong danh sách để quan sát cơ chế tham chiếu
//Yêu cầu:
//
//Khai báo hai biến:
//String book1 = "Java Basic";
//String book2 = "Python Intro";.
//Thực hiện hoán đổi giá trị của chúng bằng một biến tạm temp.
//Vẽ sơ đồ hoặc giải thích bằng comment:
// Khi biến temp thay đổi, vùng nhớ Heap chứa nội dung chuỗi được quản lý như thế nào?
// Biến trên Stack thay đổi ra sao?

//Trg Java
// - Vari b1, b2, tmp lying on Stack
// - String s1, s2 lying on Heap (String Pool)
//Begin:
// - Stack:
//  b1 reference to Heap s1
//  b2 reference to Heap s2
// - Heap:
//  s1
//  s2
//=> When performing:
//  tmp=b1 -> Stack: tmp->Heap s1
//  b1=b2  -> Stack: b1->Heap s2
//  b2=tmp -> Stack: b2->Heap s1
// => Data on the Heap remains unchanged
// => Only the references on the stack have been changed
// Because: String is immutable (bất biến), Java does not modify the string's content,
//          but only changes the variable pointing to a different memory location
public class B3 {
    public  static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String book1 = "Java Basic";
        String book2 = "Python Intro";

        System.out.print("Trước khi hoán đổi: Book1="+book1+", Book2="+book2);

        String tmp=book1;
        book1=book2;
        book2=tmp;

        System.out.print("\nSau khi hoán đổi: Book1="+book1+", Book2="+book2);
    }
}
