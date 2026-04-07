package org.example.controller;

import org.example.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

//Create by Quynh at 7:44 SA on 07/04/2026

@Controller
public class EmployeeController {

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String listEmployees(Model model) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Pham Huong Quynh", "Training Department", 15000));
        employeeList.add(new Employee(2, "Vu Hoang Nhi", "Training Department", 8500));
        employeeList.add(new Employee(3, "Nguyen Anh Minh", "Training Department", 12000));
        employeeList.add(new Employee(4, "Nguyen Hong Vu", "Training Department", 7500));

        model.addAttribute("employees", employeeList);

        return "employee-list";
    }
}