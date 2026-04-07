package com.example.Ss2.Ex2.model;

public class Student {
    private String FullName;

    private double score;
    
    public Student() {}
    
    public Student(String FullName,  double score) {
        this.FullName = FullName;
        this.score = score;
    }

    

    
    public double getScore() {
        return score;
    }
    
    public void setScore(double score) {
        this.score = score;
    }
    
    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }
}
