package exercise04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int age;
    private String className;
    private double avgScore;

    // Constructor
    public Student(String name, int age, String className, double avgScore) {
        this.name = name;
        this.age = age;
        this.className = className;
        this.avgScore = avgScore;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getAvgScore() {
        return avgScore;
    }

    @Override
    public String toString() {
        return "Tên: " + name + ", Tuổi: " + age + ", Lớp: " + className + ", Điểm trung bình: " + avgScore;
    }
}
