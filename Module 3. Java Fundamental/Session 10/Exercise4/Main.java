package exercise04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AttendanceManager manager = new AttendanceManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            // Hiển thị menu
            System.out.println("\n*************** MENU QUẢN LÝ ĐIỂM DANH ***************");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Sửa sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Hiển thị danh sách sinh viên");
            System.out.println("5. Thoát");

                choice = InputData3.getInt(scanner ,"Lựa chọn của bạn: ");

                switch (choice) {
                    case 1:
                        // Thêm sinh viên
                       int id = InputData3.getInt(scanner ,"Nhập id sinh viên : ");
                        String name = InputData3.getString(scanner,"Nhập tên sinh viên: ");
                        Student student = new Student(name,id);
                        manager.add(student);
                        System.out.println("Sinh viên đã được thêm thành công.");
                        break;

                    case 2:
                        // Sửa sinh viên
                        manager.display();
                        int idStudent = InputData3.getInt(scanner,"Nhập id sinh viên cần sửa: ");
                        int index = -1 ;
                        for (int i = 0 ; i < manager.students.size() ; i++) {
                            if(manager.students.get(i).getId() == idStudent) {
                                index = i;
                                break;
                            }
                        }
                        if(index == -1) {
                            System.out.println("Không tìm thấy sinh viên cần sửa !");
                        }else {

                            String newName = InputData3.getString(scanner,"Nhập tên mới sinh viên: ");
                            manager.update(index, new Student(newName,idStudent));
                            System.out.println("Sinh viên đã được sửa thành công.");
                        }

                        break;

                    case 3:
                        // Xóa sinh viên
                        manager.display();
                        int idDelete = InputData3.getInt(scanner,"Nhập id sinh viên cần xóa: ");
                        int indexDelete = -1 ;
                        for (int i = 0 ; i < manager.students.size() ; i++) {
                            if(manager.students.get(i).getId() == idDelete) {
                                indexDelete = i;
                                break;
                            }
                        }
                        if(indexDelete == -1) {
                            System.out.println("Không tìm thấy sinh viên cần xóa !");
                        }else {
                            manager.delete(indexDelete);
                            System.out.println("Đã xóa thành công sinh viên !");
                        }

                        break;

                    case 4:
                        // Hiển thị danh sách sinh viên
                        manager.display();
                        break;

                    case 5:
                        // Thoát chương trình
                        System.out.println("Thoát chương trình.");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
                }

        }
    }
}
