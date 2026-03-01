package JavaCore.Ss14.Ex;

import java.util.LinkedHashSet;
import java.util.Set;

//[Bài tập] Danh sách bệnh nhân chờ khám
//Mục tiêu:
//Hiểu đặc điểm "không trùng lặp" của Set và phân biệt HashSet vs LinkedHashSet.
//Mô tả:
//Tại quầy tiếp đón, nhân viên nhập tên bệnh nhân vào hệ thống.
//Đôi khi bệnh nhân sốt ruột nên ra báo tên lại nhiều lần, nhưng hệ thống chỉ được lưu tên đó 1 lần duy nhất.
//Yêu cầu: Lưu trữ danh sách tên bệnh nhân sao cho:
//Không có tên nào bị trùng.
//Quan trọng: Phải giữ nguyên thứ tự ai đến trước được lưu trước để gọi vào khám.
//3. Kết quả mong muốn:
//Input: ["Nguyễn Văn A – Yên Bái", "Trần Thị B – Thái Bình", "Nguyễn Văn A – Yên Bái", "Lê Văn C – Hưng Yên"]
//Output: In ra danh sách gọi khám: Nguyễn Văn A – Yên Bái, Trần Thị B – Thái Bình, Lê Văn C – Hưng Yên.
public class Ex1 {
    public static void main(String[] args) {
        String[] inp={"Nguyễn Văn A - Yên Bái", "Trần Thị B – Thái Bình", "Nguyễn Văn A - Yên Bái", "Lê Văn C – Hưng Yên"};

        Set<String> list=new LinkedHashSet<String>();

        for(String patient: inp) list.add(patient);

        for(String patient: list) System.out.println(patient);
    }
}
