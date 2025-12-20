package exercise04;

import java.util.ArrayList;
import java.util.Scanner;

public class AttendanceManager implements Manage<Student> {
    public ArrayList<Student> students;

    public AttendanceManager() {
        students = new ArrayList<>();
    }

    @Override
    public void add(Student student) {
        students.add(student);
    }

    @Override
    public void update(int index, Student student) {
        if (index >= 0 && index < students.size()) {
            students.set(index, student);
        }
    }

    @Override
    public void delete(int index) {
        if (index >= 0 && index < students.size()) {
            students.remove(index);
        }
    }

    @Override
    public void display() {
        if (students.isEmpty()) {
            System.out.println("Chưa có sinh viên nào trong danh sách.");
        } else {
            for (int i = 0; i < students.size(); i++) {
                System.out.println((i + 1) + ". " + students.get(i));
            }
        }
    }


}
