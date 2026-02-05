package JavaCore.Ss9;

class Employee {
    String name;
    double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }
    double calculateSalary(){
        return 0;
    }

}
class OfficeEmployee extends Employee{
    public OfficeEmployee(String name, double salary) {
        super(name, salary);
    }
    @Override
    double calculateSalary(){
        return this.salary  + 2000;
    }
}

class ProductionEmployee extends Employee{
    public ProductionEmployee(String name, double salary) {
        super(name, salary);
    }
    @Override
    double calculateSalary(){
        return this.salary  + 10000;
    }
}


class Manager extends Employee{
    int deptId;

    public Manager(String name, double salary, int deptId) {
        super(name, salary);
        this.deptId = deptId;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Department ID: " + deptId);
    }

}