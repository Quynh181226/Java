package JavaAdvanced.Ss10.HN_K24_CNTT2_PhamHuongQuynh_004.entity;

public class Course {
    private String courseId;
    private String courseName;
    private int credit;
    private double tuitionFee;
    private String instructor;
    private boolean status;

    public Course() {
    }

    public Course(String courseId, String courseName, int credit, double tuitionFee, String instructor, boolean status) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credit = credit;
        this.tuitionFee = tuitionFee;
        this.instructor = instructor;
        this.status = status;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public double getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(double tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void displayData() {
        System.out.println("============Thông tin khóa học===========");
        System.out.println("Course Id: " + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.println("Credit: " + credit);
        System.out.println("Tuition Fee: " + tuitionFee + " VNĐ");
        System.out.println("Instructor: " + instructor);
        System.out.println("Status: " + status);
        System.out.println("========================================");
    }
}