package JavaCore.Ss14.Ex;

import java.util.*;

//[Bài tập] Thống kê dịch tễ (Frequency Counting)
//Mục tiêu:
//Sử dụng Map để đếm số lượng và TreeMap để sắp xếp kết quả.
//Mô tả:
//Một danh sách List<String> lưu trữ các ca bệnh được báo cáo trong ngày: ["Cúm A", "Sốt xuất huyết", "Cúm A", "Covid-19", "Cúm A", "Sốt xuất huyết"].
//Yêu cầu:
//Thống kê số lượng ca mắc của từng loại bệnh.
//In ra kết quả báo cáo được sắp xếp theo tên bệnh (Alphabet) để gửi lên Sở Y tế.
//Kết quả mong muốn:
//Output (đã sắp xếp):
//Covid-19: 1 ca
//Cúm A: 3 ca
//Sốt xuất huyết: 2 ca
//Gợi ý: Dùng TreeMap<String, Integer>. Duyệt danh sách, nếu bệnh đã có trong Map thì tăng value lên 1, nếu chưa thì put giá trị 1.
public class Ex4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<String> listSick=new ArrayList<>(List.of("Cúm A", "Sốt xuất huyết", "Cúm A", "Covid-19", "Cúm A", "Sốt xuất huyết"));

        Map<String, Integer> statistic=new TreeMap<>();

        for (String sick: listSick){
            if(statistic.containsKey(sick)){
                statistic.put(sick, statistic.get(sick)+1);
            }else{
                statistic.put(sick, 1);
            }
        }

        for(Map.Entry<String, Integer> entry: statistic.entrySet()){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }
}
