package JavaCore.Ss14.Ex;

import java.util.*;

//[Bài tập] Hệ thống phân loại cấp cứu (Triage Sorting)
//Mục tiêu:
//Sử dụng TreeSet với Comparator để xử lý ưu tiên phức tạp.
//Mô tả:
//Tạo class Patient gồm: name, severity (độ nghiêm trọng: 1-Nguy kịch, 2-Nặng, 3-Nhẹ), arrivalTime (thời gian đến - String hoặc int).
//Sử dụng TreeSet để quản lý hàng đợi cấp cứu.
//Quy tắc ưu tiên (Sorting):
//Bệnh nhân có severity nhỏ hơn (nguy kịch hơn) được xếp trước.
//Nếu cùng mức độ severity, ai đến sớm hơn (arrivalTime nhỏ hơn) được xếp trước.
//Thêm 3-4 bệnh nhân với mức độ và thời gian khác nhau vào Set.
//Kết quả mong muốn:
//Input:
//Bệnh nhân A (Mức 3, đến lúc 8:00)
//Bệnh nhân B (Mức 1, đến lúc 8:15)
//Bệnh nhân C (Mức 1, đến lúc 8:05)
//Output (Thứ tự xử lý):
//Bệnh nhân C (Mức 1 - Nguy kịch, đến sớm hơn B)
//Bệnh nhân B (Mức 1 - Nguy kịch, đến sau C)
//Bệnh nhân A (Mức 3 - Nhẹ)
//Gợi ý: Implement Comparator so sánh field severity trước, nếu bằng nhau thì so sánh arrivalTime.
public class Ex5 {
    public static class Patient{
        private String name;
        private int severity;
        private int arrivalTime;

        public Patient(String name, int severity, int arrivalTime) {
            this.arrivalTime = arrivalTime;
            this.severity = severity;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getSeverity() {
            return severity;
        }

        public int getArrivalTime() {
            return arrivalTime;
        }

        @Override
        public String toString() {
            return name + " (Mức: " + severity + ", đến lúc " + arrivalTime +")";
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Comparator<Patient> triageComparator = (p1, p2)->{
            if(p1.getSeverity()!=p2.getSeverity()){
                return p1.getSeverity()-p2.getSeverity();
            }else{
                return p1.getArrivalTime()-p2.getArrivalTime();
            }
        };

        Set<Patient> queue=new TreeSet<>(triageComparator);

        queue.add(new Patient("Bệnh nhân A", 3, 800));
        queue.add(new Patient("Bệnh nhân B", 1, 815));
        queue.add(new Patient("Bệnh nhân C", 1, 805));
        queue.add(new Patient("Bệnh nhân D", 2, 810));

        for(Patient p:queue){
            System.out.println(p);
        }
    }
}
