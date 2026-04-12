package com.Ss6.edupath.model;

public class Course {
    private String id;
    private String name;
    private String level;
    private double fee;
    private String description;
    private String instructor;
    private int duration;
    private int studentCount;
    private String startDate;

    public Course() {
    }

    public Course(String id, String name, String level, double fee, String description, String instructor, int duration, int studentCount, String startDate) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.fee = fee;
        this.description = description;
        this.instructor = instructor;
        this.duration = duration;
        this.studentCount = studentCount;
        this.startDate = startDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}