package JavaCore.Ss14.Ex;

//HỆ THỐNG QUẢN LÝ BỆNH NHÂN & HỒ SƠ KHÁM BỆNH
//1. Mục tiêu bài tập
//Sinh viên xây dựng một chương trình Java console nhằm:
//Quản lý bệnh nhân và hồ sơ khám bệnh
//Áp dụng:
//Set, Map
//Comparable, Comparator
//Lập trình hướng đối tượng nâng cao
//Thực hiện đầy đủ:
//CRUD
//Tìm kiếm
//Sắp xếp
//Menu tương tác
//2. Mô tả bài toán
//Một phòng khám cần hệ thống đơn giản để:
//Lưu thông tin bệnh nhân
//Lưu hồ sơ khám bệnh theo từng bệnh nhân
//Tìm nhanh bệnh nhân theo mã
//Sắp xếp danh sách theo nhiều tiêu chí
//3. Thiết kế hệ thống (bắt buộc)
//3.1 Lớp trừu tượng
//Person (abstract class)
//public abstract class Person {
//protected String id;
//protected String name;
//protected int age;
//public abstract void displayInfo();
//}
//3.2 Lớp kế thừa
//Patient (extends Person, implements Comparable)
//public class Patient extends Person implements Comparable<Patient> {
//private String phone;
//@Override
//public int compareTo(Patient o) {
//return this.name.compareToIgnoreCase(o.name);
//}
//@Override
//public void displayInfo() {
//System.out.println(id + " - " + name + " - " + age + " - " + phone);
//}
//}
//3.3 Giao diện
//Manageable<T>
//public interface Manageable<T> {
//void add(T t);
//void update(String id);
//void delete(String id);
//void displayAll();
//}
//3.4 Lớp nghiệp vụ
//PatientService implements Manageable<Patient>
//Sử dụng Set để lưu bệnh nhân
//Chọn:
//HashSet → tốc độ
//LinkedHashSet → giữ thứ tự thêm
//TreeSet → sắp xếp tự động
//private Set<Patient> patients = new HashSet<>();
//3.5 Lớp dữ liệu Map
//MedicalRecord
//public class MedicalRecord {
//private String recordId;
//private String diagnosis;
//private String date;
//}
//Quản lý hồ sơ bằng Map
//Map<String, List<MedicalRecord>> recordMap;
//// key = patientId
//4. Các chức năng bắt buộc
//PHẦN A – QUẢN LÝ BỆNH NHÂN (SET)
//Thêm bệnh nhân
//Không cho trùng id
//Cập nhật bệnh nhân theo id
//Xóa bệnh nhân theo id
//Hiển thị danh sách bệnh nhân
//PHẦN B – QUẢN LÝ HỒ SƠ KHÁM (MAP)
//Thêm hồ sơ khám cho bệnh nhân
//Key: patientId
//Value: List<MedicalRecord>
//Xem hồ sơ của một bệnh nhân
//Xóa hồ sơ theo mã
//PHẦN C – TÌM KIẾM
//Tìm bệnh nhân theo
//ID
//Tên (gần đúng)
//Tìm hồ sơ theo
//Ngày khám
//Chẩn đoán
//PHẦN D – SẮP XẾP
//Sắp xếp bệnh nhân
//Mặc định → theo tên (Comparable)
//Tùy chọn:
//Theo tuổi → Comparator
//Theo id → Comparator
//Comparator<Patient> byAge =
//(a, b) -> Integer.compare(a.getAge(), b.getAge());
//5. Menu chương trình (bắt buộc)
//========= QUẢN LÝ PHÒNG KHÁM =========
//1. Thêm bệnh nhân
//2. Cập nhật bệnh nhân
//3. Xóa bệnh nhân
//4. Hiển thị danh sách bệnh nhân
//------------------------------------
//5. Thêm hồ sơ khám bệnh
//6. Xem hồ sơ theo bệnh nhân
//7. Xóa hồ sơ khám
//------------------------------------
//8. Tìm bệnh nhân
//9. Sắp xếp bệnh nhân
//------------------------------------
//0. Thoát chương trình
//====================================
//Chọn chức năng:
//6. Yêu cầu kỹ thuật
//Bắt buộc sử dụng
//Nội dung	Áp dụng
//Set	Lưu danh sách bệnh nhân
//Map	Lưu hồ sơ khám theo bệnh nhân
//Comparable	Sắp xếp mặc định
//Comparator	Sắp xếp linh hoạt
//Abstract class	Person
//Interface	Manageable
//CRUD	Thêm – sửa – xóa – xem
//Menu	Điều khiển chương trình
public class Btth {
}
