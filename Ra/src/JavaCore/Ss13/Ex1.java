package JavaCore.Ss13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//[Bài tập] Sàng lọc dữ liệu thân nhiệt bệnh nhân
//1. Mục tiêu
//Luyện tập sử dụng Iterator để duyệt và xóa phần tử trong ArrayList một cách an toàn, tránh lỗi ConcurrentModificationException.
//2. Mô tả
//Viết một chương trình quản lý danh sách thân nhiệt (độ C) của các bệnh nhân vừa nhập viện. Do thiết bị đo thỉnh thoảng bị lỗi, danh sách có chứa những giá trị không hợp lệ (ví dụ: nhiệt độ quá thấp dưới 34 độ hoặc quá cao trên 45 độ do nhiễu máy).
//Yêu cầu :
//Tạo một ArrayList<Double> chứa các giá trị: [36.5, 40.2, 37.0, 12.5, 39.8, 99.9, 36.8].
//Sử dụng Iterator để duyệt danh sách và xóa bỏ các giá trị không hợp lệ (hợp lệ là từ 34.0 đến 42.0).
//Tính nhiệt độ trung bình của các bệnh nhân còn lại.
//3. Kết quả mong muốn
//Danh sách ban đầu: [36.5, 40.2, 37.0, 12.5, 39.8, 99.9, 36.8]
//Danh sách sau khi lọc: [36.5, 40.2, 37.0, 39.8, 36.8]
//Nhiệt độ trung bình: 38.06
public class Ex1 {
    static void execute(){
        List<Double> list1 = new ArrayList<>(List.of(36.5, 40.2, 37.0, 12.5, 39.8, 99.9, 36.8));
        Iterator<Double> it1 = list1.iterator();
        double total = 0.0;
        while (it1.hasNext()){
            double n = it1.next();
            if(n < 34.0 || n > 42.0){
                it1.remove();
            }else{
                total += n;
            }
        }
        System.out.println("Nhiet do tb:" + (total/list1.size()));
    }
}
