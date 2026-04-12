package com.Ss6.edupath.controller;

import com.Ss6.edupath.model.Course;
import com.Ss6.edupath.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService service;

    // list + filter
    @GetMapping("/list")
    public String list(@RequestParam(name = "level", defaultValue = "ALL") String level,
                       @RequestParam(name = "fee", defaultValue = "0") double fee,
                       Model model) {
        List<Course> courses= service.filter(level, fee);
        model.addAttribute("courses", courses);
        model.addAttribute("level", level);
        model.addAttribute("fee", fee);
        return "course/list";
    }

    // chi tiet
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable ("id") String id, Model model) {
        model.addAttribute("course", service.findById(id));
        return "course/detail";
    }

    // form
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable ("id") String id, Model model) {
        model.addAttribute("course", service.findById(id));
        return "course/form";
    }

    // update
    @PostMapping("/update")
    public String update(@ModelAttribute("course") Course course) {
        service.update(course);
        return "redirect:/course/list";
    }

    // delete
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable ("id") String id, RedirectAttributes ra) {
        boolean ok = service.delete(id);
        if (!ok) {
            ra.addFlashAttribute("error", "Không thể xóa! Khóa học đã có học viên");
        } else {
            ra.addFlashAttribute("success", "Xóa thành công");
        }

        return "redirect:/course/list";
    }
}
