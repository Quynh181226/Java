package com.Ss6.edupath.service;

import com.Ss6.edupath.model.Course;
import com.Ss6.edupath.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    @Autowired
    private CourseRepository repo;

    public List<Course> filter(String level, double maxFee) {
        return repo.findAll().stream()
                .filter(course -> level.equals("ALL") || course.getLevel().equalsIgnoreCase(level))
                .filter(course -> maxFee <= 0 || course.getFee() <= maxFee)
                .collect(Collectors.toList());
    }

    public Course findById(String id) {
        Course course = repo.findById(id);
        return course != null ? course : new Course();
    }

    public void update(Course course) {
        repo.update(course);
    }

    public boolean delete(String id) {
        Course course = repo.findById(id);
        if (course.getStudentCount() > 0) {
            return false;
        }
        repo.delete(id);
        return true;
    }
}
