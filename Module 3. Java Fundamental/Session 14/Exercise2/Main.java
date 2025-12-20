package exercise02;

import exercise01.Student;
import exercise01.StudentManager;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Student student = new Student(1, "Nguyễn Văn A", 21); // ID của sinh viên cần cập nhật
        manager.updateStudent(student);
    }
}
