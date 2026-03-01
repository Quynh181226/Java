package JavaCore.Ss14.Ex;

import java.util.*;

//[Bài tập] Phân tích dị ứng thuốc
//Mục tiêu:
//Vận dụng các phép toán giao (retainAll) và hiệu (removeAll) trên Set.
//Mô tả:
//Bác sĩ có 2 tập hợp dữ liệu:
//Set A: Danh sách các thành phần có trong thuốc mới (ví dụ: Aspirin, Caffeine, Paracetamol).
//Set B: Danh sách các chất mà bệnh nhân bị dị ứng (ví dụ: Penicillin, Aspirin, Pollen).
//Yêu cầu:
//Kiểm tra xem thuốc mới có an toàn không bằng cách tìm các chất trùng nhau giữa A và B (Giao).
//Liệt kê các thành phần trong thuốc mà bệnh nhân không bị dị ứng (Hiệu).
//Kết quả mong muốn:
//Input:
//Thuốc: [Aspirin, Caffeine, Paracetamol]
//Dị ứng: [Penicillin, Aspirin]
//Output:
//Cảnh báo dị ứng: [Aspirin]
//Thành phần an toàn: [Caffeine, Paracetamol]
//Gợi ý: Sử dụng retainAll để tìm cảnh báo và removeAll (trên một bản sao) để tìm thành phần an toàn.
public class Ex3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Set<String> medicine=new HashSet<String>();
        medicine.add("Aspirin");
        medicine.add("Caffeine");
        medicine.add("Paracetamol");

        Set<String> allergy=new HashSet<>();

        allergy.add("Penicillin");
        allergy.add("Aspirin");

        Set<String> warming=new HashSet<>(medicine);
        warming.retainAll(allergy);

        Set<String> elSafe=new HashSet<>(medicine);
        elSafe.removeAll(allergy);

       System.out.println(warming+"\n"+elSafe);
    }
}
