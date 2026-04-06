package com.example.Ss2.Ex5.model;



import java.time.LocalDate;

/**
 * Employee Model (Ex05)
 * Dai dien cho mot nhan vien
 */
public class Employee {
    private String code;           // NV001, NV002, ...
    private String fullName;
    private String department;    // Ke toan, Ky thuat, ...
    private double salary;
    private LocalDate hireDate;
    private String status;        // Dang lam, Nghi phep, Thu viec

    public Employee(String code, String fullName, String department,
                    double salary, LocalDate hireDate, String status) {
        this.code = code;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        this.hireDate = hireDate;
        this.status = status;
    }

    // ========== GETTERS ==========

    public String getCode() {
        return code;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "code='" + code + '\'' +
                ", fullName='" + fullName + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", hireDate=" + hireDate +
                ", status='" + status + '\'' +
                '}';
    }
}