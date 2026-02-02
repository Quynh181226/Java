package JavaCore.Ss7;

//1. Mục tiêu
//Hiểu sự khác nhau giữa primitive và reference
//Hiểu cách dữ liệu được lưu trong Stack và Heap
//2. Mô tả
//Xây dựng chương trình để quan sát sự khác nhau khi gán và thay đổi giá trị.
//Yêu cầu:
//Khai báo:
//Một biến kiểu nguyên thủy (int)
//Một biến kiểu tham chiếu (object Student)
//Gán giá trị cho biến khác
//Thay đổi giá trị và quan sát kết quả
//In ra màn hình để so sánh
//3. Kết quả mong muốn
//Nhận ra:
//Biến nguyên thủy sao chép giá trị
//Biến tham chiếu sao chép địa chỉ
//Giải thích được kết quả bằng lời
public class B2 {
    public static void execute(){
        int num = 12;
        B1Student s3 = new B1Student("3", "Nhat");
        B1Student s4 = s3;

        int num2 = num;
        num = 14;
        System.out.println(num2);
        s3.studentName = "abc";
        System.out.println(s3);
        //b = a copy giá trị nên a và b độc lập, thay đổi a không ảnh hưởng b.
        //s4 = s3 copy địa chỉ nên cùng trỏ 1 object, thay đổi s3 thì s4 cũng đổi.
        //Nguyên thủy copy giá trị (độc lập), tham chiếu copy địa chỉ (ảnh hưởng nhau).
    }
}
