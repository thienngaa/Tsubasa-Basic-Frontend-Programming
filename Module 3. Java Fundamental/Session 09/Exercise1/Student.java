import java.util.Scanner;

public class Student {
    private String studentId;
    private String studentName;
    private int age;
    private String major;

    // Constructor không tham số
    public Student() {
    }

    // Constructor đầy đủ tham số
    public Student(String studentId, String studentName, int age, String major) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.major = major;
    }

    // Getter & Setter
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    // Nhập thông tin sinh viên
    public void inputData(Scanner scanner) {
        System.out.print("Nhập mã sinh viên: ");
        this.studentId = scanner.nextLine();

        System.out.print("Nhập tên sinh viên: ");
        this.studentName = scanner.nextLine();

        System.out.print("Nhập tuổi: ");
        this.age = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập chuyên ngành: ");
        this.major = scanner.nextLine();
    }

    // Hiển thị thông tin sinh viên
    public void displayData() {
        System.out.println("Mã SV: " + studentId +
                " | Tên: " + studentName +
                " | Tuổi: " + age +
                " | Chuyên ngành: " + major);
    }
}
