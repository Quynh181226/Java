package com.example.Ss2.Ex5.service;

import com.example.Ss2.Ex5.model.Employee;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * EmployeeService (Ex05)
 *
 * Xu ly logic nhan vien (tach ra khoi Controller)
 */
@Service
public class EmployeeService {

    /**
     * Lay danh sach tat ca nhan vien
     */
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("NV001", "Nguyen Thi Lan", "Ke toan",
                15000000, LocalDate.of(2020, 3, 1), "Dang lam"));
        employees.add(new Employee("NV002", "Tran Van Hung", "Ky thuat",
                25000000, LocalDate.of(2019, 7, 15), "Dang lam"));
        employees.add(new Employee("NV003", "Le Minh Duc", "Kinh doanh",
                18500000, LocalDate.of(2021, 11, 20), "Nghi phep"));
        employees.add(new Employee("NV004", "Pham Thu Huong", "Ky thuat",
                22000000, LocalDate.of(2022, 1, 5), "Dang lam"));
        employees.add(new Employee("NV005", "Hoang Van Nam", "Ke toan",
                12000000, LocalDate.of(2023, 6, 10), "Thu viec"));

        return employees;
    }

    /**
     * Lay thong tin nhan vien theo ma
     */
    public Employee getEmployeeByCode(String code) {
        return getAllEmployees().stream()
                .filter(e -> e.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }

    /**
     * Tinh tong luong theo phong ban
     */
    public double calculateSalaryByDepartment(String department) {
        return getAllEmployees().stream()
                .filter(e -> e.getDepartment().equals(department))
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    /**
     * Lay tong luong phong ban Ky thuat
     */
    public double getTechDepartmentTotalSalary() {
        return calculateSalaryByDepartment("Ky thuat");
    }
}