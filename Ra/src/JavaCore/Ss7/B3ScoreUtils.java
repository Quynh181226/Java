package JavaCore.Ss7;

//1. Mục tiêu
//Hiểu phương thức static
//Biết khi nào nên dùng static method
//2. Mô tả
//Xây dựng lớp tiện ích xử lý dữ liệu điểm số.
//Yêu cầu:
//Tạo lớp ScoreUtils
//Viết các phương thức static:
//Kiểm tra điểm đạt / không đạt
//Tính điểm trung bình
//Gọi phương thức static:
//Không tạo đối tượng
//Gọi trực tiếp qua tên lớp
//3. Kết quả mong muốn
//Không sử dụng this trong phương thức static
//Hiểu static method không phụ thuộc đối tượng
//Code chạy đúng logic
public class B3ScoreUtils {
    public static void getResult(int score){
        if(score >= 5){
            System.out.println("Dat");
        }else{
            System.out.println("Khong dat");
        }
    }

    public static void calAvg(int[] arr){
        double avg = 0;
        for(int i = 0; i < arr.length ; i ++){
            avg += arr[i];
        }
        avg = avg/ arr.length;
        System.out.println(avg);
    }
}
