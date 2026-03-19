package JavaAdvanced.Ss10.HN_K24_CNTT2_PhamHuongQuynh_004.business.singleton;

import JavaAdvanced.Ss10.HN_K24_CNTT2_PhamHuongQuynh_004.entity.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CourseBusiness {
    private static CourseBusiness instance;
    private List<Course> courses = new ArrayList<>();

    private CourseBusiness() {}

    public static CourseBusiness getInstance() {
        if (instance == null) {
            instance = new CourseBusiness();
        }
        return instance;
    }

    public void addCourse(Course c) {
        courses.add(c);
        System.out.println("Course added");
    }

    public void updateCourse(String id, Course c) {
        Optional<Course> optional = findById(id);
        if (optional.isPresent()) {
            for (int i = 0; i < courses.size(); i++) {
                if (courses.get(i).getCourseId().equals(id)) {
                    courses.set(i, c);
                    System.out.println("Course updated");
                    return;
                }
            }
        } else {
            System.out.println("Course id not found");
        }
    }

    public boolean deleteCourse(String id) {
        return courses.removeIf(c -> c.getCourseId().equals(id));
    }

    public void searchByInstructor(String key) {
        List<Course> res = courses.stream()
                .filter(c -> c.getInstructor().toLowerCase().contains(key.toLowerCase()))
                .collect(Collectors.toList());

        if (res.isEmpty()) {
            System.out.println("No courses found");
        } else {
            System.out.println("Found " + res.size() + " course:");
            for (Course c : res) {
                c.displayData();
            }
        }
    }

    public void sortByFeeDesc() {
        List<Course> sorted = courses.stream()
                .sorted((c1, c2) -> Double.compare(c2.getTuitionFee(), c1.getTuitionFee()))
                .collect(Collectors.toList());

        if (sorted.isEmpty()) {
            System.out.println("Course empty");
        } else {
            System.out.println("Courses sorted desc:");
            for (Course c : sorted) {
                c.displayData();
            }
        }
    }

    public void filterActiveCourse() {
        List<Course> active = courses.stream()
                .filter(Course::isStatus)
                .collect(Collectors.toList());

        if (active.isEmpty()) {
            System.out.println("No active courses");
        } else {
            System.out.println("Active courses:");
            for (Course c : active) {
                c.displayData();
            }
        }
    }

    public Optional<Course> findById(String id) {
        return courses.stream()
                .filter(c -> c.getCourseId().equals(id))
                .findFirst();
    }

    public List<Course> getAllCourses() {
        return courses;
    }
}