package com.example.Ss2.Ex2.controller;

import com.example.Ss2.Ex2.model.Student;   // ← SỬA ĐÂY
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 *  Ex02: Report Controller
 *
 * URL: /ex02/report
 *
 * Chức năng:
 * 1. Lấy danh sách sinh viên
 * 2. Đẩy vào Model
 * 3. Trỏ tới View để hiển thị
 *
 * Không chứa logic xử lý (đó là việc của Model/Service)
 */
@Controller
@RequestMapping("/Ex2")
public class ReportController {

    @GetMapping("/report")
    public String showReport(Model model) {
        //  Dữ liệu sinh viên (giả lập từ database)
        List<Student> students = new ArrayList<>();
        students.add(new Student("Nguyễn Thị Bình", 92));
        students.add(new Student("Trần Minh Khoa", 75));
        students.add(new Student("Lê Thu Hà", 55));
        students.add(new Student("Phạm Duy An", 48));
        students.add(new Student("Hoàng Minh Tuấn", 88));

        //  Đẩy dữ liệu vào Model (Request scope)
        model.addAttribute("studentList", students);
        model.addAttribute("reportTitle", "Báo cáo điểm cuối kỳ");

        //  Trỏ tới View: /WEB-INF/views/ex02/report.jsp
        return "ex02/report";
    }
}