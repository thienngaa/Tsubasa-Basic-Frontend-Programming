import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n*********************QUẢN LÝ SINH VIÊN********************");
            System.out.println("1. Hiển thị danh sách sinh viên");
            System.out.println("2. Thêm sinh viên");
            System.out.println("3. Cập nhật thông tin sinh viên theo mã sinh viên");
            System.out.println("4. Xóa sinh viên theo mã sinh viên");
            System.out.println("5. Tìm sinh viên theo tên sinh viên");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    displayStudents();
                    break;
                case 2:
                    addStudents(scanner);
                    break;
                case 3:
                    updateStudent(scanner);
                    break;
                case 4:
                    deleteStudent(scanner);
                    break;
                case 5:
                    searchStudentByName(scanner);
                    break;
                case 6:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 6);
    }

    // 1. Hiển thị danh sách
    private static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên trống!");
            return;
        }
        students.forEach(Student::displayData);
    }

    // 2. Thêm sinh viên (nhiều sinh viên)
    private static void addStudents(Scanner scanner) {
        System.out.print("Nhập số lượng sinh viên cần thêm: ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("Sinh viên thứ " + (i + 1));
            Student student = new Student();
            student.inputData(scanner);
            students.add(student);
        }
    }

    // 3. Cập nhật sinh viên theo mã
    private static void updateStudent(Scanner scanner) {
        System.out.print("Nhập mã sinh viên cần cập nhật: ");
        String id = scanner.nextLine();
        boolean found = false;

        for (Student student : students) {
            if (student.getStudentId().equals(id)) {
                student.inputData(scanner);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Mã sinh viên không tồn tại");
        }
    }

    // 4. Xóa sinh viên theo mã
    private static void deleteStudent(Scanner scanner) {
        System.out.print("Nhập mã sinh viên cần xóa: ");
        String id = scanner.nextLine();
        boolean removed = students.removeIf(s -> s.getStudentId().equals(id));

        if (!removed) {
            System.out.println("Mã sinh viên không tồn tại");
        }
    }

    // 5. Tìm sinh viên theo tên
    private static void searchStudentByName(Scanner scanner) {
        System.out.print("Nhập tên sinh viên cần tìm: ");
        String name = scanner.nextLine();
        int count = 0;

        for (Student student : students) {
            if (student.getStudentName().toLowerCase().contains(name.toLowerCase())) {
                student.displayData();
                count++;
            }
        }

        System.out.println("Tổng số sinh viên tìm thấy: " + count);
    }
}
