package JavaCore.Ss13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//[Bài tập] Điều phối phòng cấp cứu
//1. Mục tiêu
//Hiểu và ứng dụng cấu trúc LinkedList để mô phỏng hàng đợi ưu tiên trong y tế.
//2. Mô tả
//Tạo class EmergencyRoom sử dụng LinkedList<String> để quản lý tên bệnh nhân chờ cấp cứu. Cần thực hiện các phương thức sau:
//patientCheckIn(String name): Bệnh nhân thường đến, xếp vào cuối hàng đợi.
//emergencyCheckIn(String name): Ca cấp cứu nguy kịch (Tai nạn, Đột quỵ...), chèn ngay vào đầu hàng đợi để bác sĩ xử lý trước.
//treatPatient(): Bác sĩ gọi bệnh nhân đầu tiên vào phòng khám (in tên và xóa khỏi danh sách).
//Mô phỏng: Có 2 bệnh nhân A, B đến. Đột nhiên có ca C nguy kịch. Sau đó bác sĩ lần lượt chữa trị.
//3. Kết quả mong muốn
//Logic thực thi: CheckIn A -> CheckIn B -> Emergency C.
//Output khi gọi treatPatient 3 lần:
//Đang cấp cứu: C
//Đang khám: A
//Đang khám: B
public class Ex4 {
    static List<String> list = new LinkedList<>();
    static void patientCheckIn(String name){
        list.add(name);
    }
    static void emergencyCheckIn(String name){
        list.addFirst(name);
    }

    static void treatPatient(){
        if(!list.isEmpty()){
            System.out.println("Dang dieu tri benh nhan: "+list.getFirst());
            list.removeFirst();
        }else{
            System.out.println("Ko co benh nhan nao");
        }
    }
}
