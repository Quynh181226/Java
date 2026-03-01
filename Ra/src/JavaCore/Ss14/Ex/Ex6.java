package JavaCore.Ss14.Ex;

import java.util.*;

//Bài Tập: Quản lý hồ sơ bệnh án theo Khoa
//Mục tiêu:
//Sử dụng cấu trúc dữ liệu phức tạp Map<String, List<Patient>>.
//Mô tả:
//Có một danh sách các đối tượng Patient (gồm tên, tuổi, tên khoa điều trị).
//Viết chương trình gom nhóm bệnh nhân vào từng Khoa.
//Key: Tên khoa (Ví dụ: "Tim mạch", "Nội tiết").
//Value: Danh sách (List) các bệnh nhân đang nằm tại khoa đó.
//Chức năng:
//Hiển thị danh sách bệnh nhân của một khoa bất kỳ.
//Tìm khoa nào đang có đông bệnh nhân nhất (Quá tải).
//Kết quả mong muốn:
//Input List: [("Lan", Tim mạch), ("Hùng", Nội tiết), ("Mai", Tim mạch)]
//Output Map Structure:
//Key "Tim mạch" -> Value [Patient(Lan), Patient(Mai)]
//Key "Nội tiết" -> Value [Patient(Hùng)]
//Output Analysis: "Khoa Tim mạch đang đông nhất (2 bệnh nhân)".
//Gợi ý: Duyệt list bệnh nhân. Với mỗi người, kiểm tra xem Khoa của họ đã có trong Map chưa. Nếu chưa put list mới, nếu rồi get list đó ra và add bệnh nhân vào.
public class Ex6 {
    public static class Patient {
        private String name;
        private int age;
        private String department;

        public Patient(String name, int age, String department) {
            this.name = name;
            this.age = age;
            this.department = department;
        }

        public String getDepartment() {
            return department;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name + " (Tuổi: " + age + ")";
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<Patient> patients= Arrays.asList(
                new Patient("Lan", 25, "Tim mạch"),
                new Patient("Hùng", 40, "Nội tiết"),
                new Patient("Mai", 30, "Tim mạch"),
                new Patient("Tuấn", 50, "Nội tiết"),
                new Patient("An", 60, "Tim mạch")
        );

        Map<String, List<Patient>> departmentMap=new HashMap<>();

        for(Patient p:patients){
            departmentMap.computeIfAbsent(p.getDepartment(), k -> new ArrayList<>()).add(p);
        }

        for (Map.Entry<String, List<Patient>> e:departmentMap.entrySet()){
            System.out.printf("Khoa: "+e.getKey()+" - ");
//            for(Patient p:e.getValue()){
//                System.out.print(p);
//            }
            for(int  i=0;i<e.getValue().size();i++){
                System.out.print(e.getValue().get(i));

                if(i<e.getValue().size()-1){
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
        System.out.println();

        String random="Nội tiết";
        System.out.printf("Patient Department "+random+": \n");
        List<Patient> list=departmentMap.get(random);
        if(list!=null){
            list.forEach(System.out::println);
        }

        String maxDepartment=null;
        int maxSize=0;
        for(Map.Entry<String, List<Patient>> e:departmentMap.entrySet()){
            if(e.getValue().size()>maxSize){
                maxSize=e.getValue().size();
                maxDepartment=e.getKey();
            }
        }

        System.out.println("\nKhoa " + maxDepartment + " đang đông nhất (" + maxSize + " bệnh nhân)");
    }
}
