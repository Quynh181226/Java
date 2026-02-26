package JavaCore.Ss13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//[Bài tập] Quản lý danh mục thuốc không trùng lặp
//Mục tiêu
//Sử dụng ArrayList kết hợp với logic kiểm tra tồn tại (contains) và sắp xếp (Collections.sort).
//Mô tả
//Bệnh viện nhận được các lô hàng thuốc từ nhiều nguồn khác nhau, dẫn đến việc tên thuốc bị trùng lặp trong danh sách nhập kho.
//Viết phương thức nhận vào một List chứa tên các loại thuốc (ví dụ: ["Paracetamol", "Ibuprofen", "Panadol", "Paracetamol", "Aspirin", "Ibuprofen"]). Lưu ý: Panadol và Paracetamol coi là khác nhau về mặt chuỗi ký tự.
//Xử lý để tạo ra một danh sách mới chỉ chứa tên các loại thuốc duy nhất (không trùng).
//Sắp xếp danh sách thuốc này theo thứ tự bảng chữ cái (A-Z).
//Kết quả mong muốn
//Input: ["Paracetamol", "Ibuprofen", "Panadol", "Paracetamol", "Aspirin", "Ibuprofen"]
//Output: ["Aspirin", "Ibuprofen", "Panadol", "Paracetamol"]
public class Ex2 {
    static void execute(){
        List<String> list = new ArrayList<>(List.of("Paracetamol", "Ibuprofen", "Panadol", "Paracetamol", "Aspirin", "Ibuprofen"));
        List<String> newList = new ArrayList<>();
        for (String x : list){
            if(!newList.contains(x)){
                newList.add(x);
            }
        }

        Collections.sort(newList);
        for (String x : newList) {
            System.out.print(x + " ");
        }
    }
}
