package com.example.Ss2.Ex5.controller;

import com.example.Ss2.Ex5.model.Employee;
import com.example.Ss2.Ex5.model.User;
import com.example.Ss2.Ex5.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * EmployeeController (Ex05)
 *
 * URL: /ex05/employees (GET)
 *      /ex05/employees/{code} (GET)
 */
@Controller
@RequestMapping("/Ex5")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Danh sach nhan vien
     */
    @GetMapping("/employees")
    public String listEmployees(Model model, HttpSession session) {
        // Kiem tra session
        User loggedUser = (User) session.getAttribute("loggedUser");
        if (loggedUser == null) {
            return "redirect:/Ex5/login";
        }

        // Lay danh sach nhan vien
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);

        // Tinh tong luong phong ban Ky thuat
        double techSalary = employeeService.getTechDepartmentTotalSalary();
        model.addAttribute("techDepartmentSalary", techSalary);

        return "ex05/employees";
    }

    /**
     * Chi tiet nhan vien
     */
    @GetMapping("/employees/{code}")
    public String employeeDetail(
            @PathVariable String code,
            Model model,
            HttpSession session) {

        // Kiem tra session
        User loggedUser = (User) session.getAttribute("loggedUser");
        if (loggedUser == null) {
            return "redirect:/Ex5/login";
        }

        // Lay thong tin nhan vien
        Employee employee = employeeService.getEmployeeByCode(code);
        if (employee == null) {
            // Nem Exception -> GlobalExceptionHandler bat va dua toi error.jsp
            throw new RuntimeException("Nhan vien [" + code + "] khong ton tai trong he thong");
        }

        model.addAttribute("employee", employee);
        model.addAttribute("role", loggedUser.getRole());

        return "ex05/employee-detail";
    }
}