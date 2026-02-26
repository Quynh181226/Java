package JavaCore.Ss13;

import java.util.ArrayList;
import java.util.List;

//[Bài tập] Tìm bệnh nhân trùng khớp
//1. Mục tiêu
//Luyện tập viết phương thức Generic <T> để xử lý dữ liệu linh hoạt (có thể là Mã số bệnh nhân dạng String hoặc Số thứ tự dạng Integer).
//2. Mô tả
//Viết một phương thức Generic tĩnh (static) tên là findCommonPatients.
//Phương thức nhận vào 2 danh sách List<T>: Danh sách A (Bệnh nhân khám Khoa Nội) và Danh sách B (Bệnh nhân khám Khoa Ngoại).
//Nhiệm vụ: Tìm và trả về một List<T> mới chứa các bệnh nhân khám ở cả hai khoa (xuất hiện ở cả 2 danh sách) để bệnh viện áp dụng chương trình ưu đãi.
//Viết hàm main kiểm thử với 2 trường hợp:
//Trường hợp 1 (Integer): ID số nguyên [101, 102, 105] và [102, 105, 108].
//Trường hợp 2 (String): Mã BHYT ["DN01", "DN02", "DN03"] và ["DN02", "DN04"].
//3. Kết quả mong muốn
//Test Case 1 Output: [102, 105]
//Test Case 2 Output: ["DN02"]
public class Ex3 {
    static void  execute(){
        List<Integer> l1 = new ArrayList<>(List.of(101, 102, 105));
        List<Integer> l3 = new ArrayList<>(List.of(102, 105, 108));
        List<String> l4 = new ArrayList<>(List.of("DN02", "DN04"));
        List<String> l2 = new ArrayList<>(List.of("DN01", "DN02", "DN03"));
        findCommonPatients(l1,l3);
        findCommonPatients(l2,l4);
    }
    static <T> void findCommonPatients(List<T> A,List<T> B){
        List<T> list = new ArrayList<>();
        for (T x: A){
            if(B.contains(x)){
                list.add(x);
            }
        }
        for (T x: list) System.out.print(x + " ");
    }
}
