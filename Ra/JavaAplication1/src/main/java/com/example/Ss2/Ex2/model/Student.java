package com.example.Ss2.Ex2.model;



/**
 *  Student Model (Ex02)
 * Đại diện cho một sinh viên
 *
 * ✨ CẢI THIỆN: Chứa method getRank() (chuyển logic từ JSP)
 */
public class Student {
    private String fullName;
    private int score;

    public Student(String fullName, int score) {
        this.fullName = fullName;
        this.score = score;
    }

    // ========== GETTERS ==========

    public String getFullName() {
        return fullName;
    }

    public int getScore() {
        return score;
    }

    // ========== BUSINESS LOGIC (SỬA LỖI 4) ==========

    /**
     *  SỬA LỖI: Logic xếp loại chuyển từ View (JSP) sang Model
     *
     * TRƯỚC: Logic nằm trong JSP → khó bảo trì, khó test, vi phạm MVC
     * SAU: Logic nằm trong Model → sạch sẽ, dễ test, tuân theo MVC
     *
     * Lợi ích:
     * - Nếu quy tắc xếp loại thay đổi, chỉ sửa method này
     * - Có thể unit test: new Student("Bình", 92).getRank() == "Xuất sắc"
     * - JSP chỉ việc hiển thị: ${student.rank}
     */
    public String getRank() {
        if (score >= 90) {
            return "Xuất sắc";
        } else if (score >= 80) {
            return "Giỏi";
        } else if (score >= 70) {
            return "Khá";
        } else if (score >= 60) {
            return "Trung bình khá";
        } else if (score >= 50) {
            return "Trung bình";
        } else {
            return "Yếu";
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", score=" + score +
                ", rank='" + getRank() + '\'' +
                '}';
    }
}