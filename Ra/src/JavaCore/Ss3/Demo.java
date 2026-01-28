package JavaCore.Ss3;

import java.util.Arrays;

// Sử dụng .equals() để so sánh chính xác tuyệt đối giá trị chuỗi
public class Demo {
    public static void main(String[] args) {
        // Định nghĩa mảng 1 chiều
        int[] arrInt = new int[5];
        String[] arrStr = new String[10];
        System.out.println("Độ dài của mảng arrInt: " + arrInt.length);
        System.out.println("Độ dài của mảng arrStr: " + arrStr.length);

        // Giá trị các phần tử
        System.out.println(Arrays.toString(arrInt));
        System.out.println(Arrays.toString(arrStr));

        // Khai báo và khởi tạo giá trị cho mảng: Khởi tạo trực tiếp: array literal
        int[] arrInteger = { 10, 20, 30, 40, 50 };
        System.out.println(Arrays.toString(arrInteger));

        // Truy xuất phần tử
        System.out.println("Phần tử tại vị trí index = 3 là " + arrInteger[3]);
        // Thay đổi giá trị
        arrInteger[3] = 100;
        System.out.println("Phần tử tại vị trí index = 3 sau khi thay đổi là " + arrInteger[3]);

        // Thao tác duyệt qua các phần tử của mảng 1 chiều
        // duyệt qua vòng lặp for
        for (int i = 0; i < arrInteger.length; i++) {
            System.out.printf("arrInteger[%d] = %d%n", i, arrInteger[i]);
        }

        // Duyệt qua for-each
        for (int element : arrInteger) {
            System.out.println("Giá trị phần tử element = " + element);
        }

        // Phương thức trong Java
        // modifier returnType methodName(parameterList) {
        // body method
        // return value; // nếu có giá trị trả về
        // }
        // modifier: public, private, protected, default
        // returnType: kiểu dữ liệu trả về: int, double, String, void (không trả về gì)
        // methodName: tên phương thức
        // parameterList: danh sách tham số (có thể không có tham số)

        // Giả sử khởi tạo một mảng arrayInt để code có thể chạy được
        int[] arrayInt = {10, 25, 5, 40, 30};

        // 1. Khai báo mảng
        int[] arrayInt1;
        int[][] array2D = {{1, 2}, {3, 4}}; // Mảng 2 chiều

        // Trỏ tới vùng nhớ null (chưa cấp phát)
        Object[] arrayObject;

        // 2. Cấp phát bộ nhớ cho mảng (Gán kích thước)
        arrayInt = new int[5]; // Mảng có 5 phần tử
        arrayObject = new Object[3];

        // 3. Khởi tạo giá trị cho từng phần tử
        arrayInt[0] = 10;
        arrayInt[1] = 20;
        arrayInt[2] = 30;

        System.out.println("Phần tử đầu tiên: " + arrayInt[0]);


        // Kiểm tra độ dài mảng
        System.out.println("Độ dài mảng arrayInt: " + arrayInt.length);

        // Duyệt mảng: thuật toán tìm kiếm tuần tự
        // for i: duyệt mảng theo chỉ số
        // Duyệt mảng arrayInt tìm ra số lớn nhất
        int max = arrayInt[0];

        for (int i = 1; i < arrayInt.length; i++) {
            if (arrayInt[i] > max) {
                max = arrayInt[i];
            }
        }

        System.out.println("Số lớn nhất trong mảng arrayInt: " + max);
        // foreach: duyệt mảng theo giá trị
        for (int e: arrayInt) {
            System.out.println("Element: "+e);
        }

        // Kỹ thuật lập trình
        // count, sum, multi, average, min, max, flag, search
        // Đếm số lượng phần tử trong 1 danh sách cho trước
        // Tính tổng của các phần tử trong mảng số
        // Tính min, max trg 1 dsach
        // Khi bài toán yêu cầu kiểm tra kết quả là có hay không mà cần xảy ra đk if ở trong 1 vòng lặp ít nhất 1 lần => Flag

    }
}