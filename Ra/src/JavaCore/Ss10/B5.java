package JavaCore.Ss10;
//[Bài tập] Hệ thống Nhân viên Đa hình và Tính lương Phức tạp
//
//1. Mục tiêu
//Kết hợp Abstract Class và Interface để xây dựng hệ thống quản lý nhân sự chuyên nghiệp.
//Sử dụng thuộc tính protected và phương thức thông thường để tái sử dụng mã nguồn.
//2. Mô tả Một công ty có nhiều loại nhân viên. Tất cả đều là con người (IS-A), nhưng chỉ một số vị trí được hưởng chế độ thưởng KPI (CAN-DO).
//Yêu cầu:
//Tạo abstract class Employee với các thuộc tính name, baseSalary và phương thức abstract double calculateSalary().
//Tạo interface BonusCalculator với phương thức double getBonus().
//Triển khai OfficeStaff (kế thừa Employee) và Manager (kế thừa Employee đồng thời thực thi BonusCalculator).
//Viết logic tính lương cuối cùng: Salary = baseSalary + bonus (nếu có).
//3. Kết quả mong muốn
//Hệ thống tính toán và in ra bảng lương chi tiết cho từng vị trí, phân biệt rõ người có thưởng và người không.
public class B5 {
    abstract static class Employee{
        protected String name;
        protected double baseSalary;

        public Employee(String name, double baseSalary){
            this.name = name;
            this.baseSalary = baseSalary;
        }

        abstract double calculateSalary();
    }

    interface BonusCalculator{
        double getBonus();
    }

    public static   class OfficeStaff extends Employee{
        public OfficeStaff(String name, double baseSalary){
            super(name, baseSalary);
        }

        @Override
        public double calculateSalary(){
            return this.baseSalary;
        }
    }

    public static class Manager extends Employee implements BonusCalculator{
        public Manager(String name, double baseSalary){
            super(name, baseSalary);
        }

        @Override
        public double getBonus(){
            return 3000;
        }

        @Override
        public double calculateSalary(){
            return baseSalary + getBonus();
        }
    }
}

