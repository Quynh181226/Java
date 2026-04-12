package com.Ss6.edupath.repository;

import com.Ss6.edupath.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    private final List<Course> courses= new ArrayList<>();

    public CourseRepository() {
        courses.add(new Course("IELTS-5.5", "IELTS 5.5", "Beginner", 3000000,
                "Lộ trình cơ bản", "Mr A", 3, 0, "2026-05-01"));

        courses.add(new Course("IELTS-6.5", "IELTS 6.5", "Intermediate", 5000000,
                "Lộ trình nâng cao", "Mr B", 4, 20, "2026-06-01"));

        courses.add(new Course("TOEIC-700", "TOEIC 700", "Intermediate", 4000000,
                "TOEIC trung cấp", "Ms C", 3, 10, "2026-05-15"));

        courses.add(new Course("TOEIC-500", "TOEIC 500", "Beginner", 2800000,
                "TOEIC nền tảng", "Mr G", 3, 0, "2026-05-10"));

        courses.add(new Course("ADV-ENG", "Advanced English", "Advanced", 6000000,
                "Nâng cao toàn diện", "Mr D", 5, 0, "2026-07-01"));

        courses.add(new Course("BUS-ENG", "Business English", "Advanced", 6500000,
                "Tiếng Anh doanh nghiệp", "Mr K", 3, 25, "2026-07-15"));
    }

    public List<Course> findAll() {
        return courses;
    }

    public Course findById(String id) {
        return courses.stream()
                .filter(course -> course.getId().equals(id))
                .findFirst().orElse(null);
    }

    public void update(Course course) {
        for (Course c : courses) {
            if (c.getId().equals(course.getId())) {
                c.setFee(course.getFee());
                c.setStartDate(course.getStartDate());
                break;
            }
        }
    }

    public void delete(String id) {
        courses.removeIf(course -> course.getId().equals(id));
    }
}