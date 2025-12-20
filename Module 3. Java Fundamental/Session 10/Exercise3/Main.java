package exercise03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserManager manager = new UserManager();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (true) {
            // Hiển thị menu
            System.out.println("\n*************** MENU QUẢN LÝ NGƯỜI DÙNG ***************");
            System.out.println("1. Thêm người dùng");
            System.out.println("2. Xóa người dùng");
            System.out.println("3. Hiển thị danh sách người dùng");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            try {
                choice = InputData2.getInt(scanner ,"Lựa chọn của bạn: ");

                switch (choice) {
                    case 1:
                            String name = InputData2.getString(scanner ,"Nhập tên người dùng: ");
                            String email = InputData2.getString(scanner , "Nhập email người dùng: ");
                            String phoneNumber = InputData2.getString(scanner , "Nhập số điện thoại người dùng: ");
                            User user = new User(name, email, phoneNumber);
                            manager.addUser(user);
                            System.out.println("Người dùng đã được thêm thành công.");
                            break;

                    case 2:
                        // Xóa người dùng

                        String emailToRemove = InputData2.getString(scanner ,"Nhập email người dùng để xóa: ");
                        if (manager.removeUser(emailToRemove)) {
                            System.out.println("Người dùng đã được xóa thành công.");
                        } else {
                            System.out.println("Không tìm thấy người dùng với email này.");
                        }
                        break;

                    case 3:
                        // Hiển thị danh sách người dùng
                        System.out.println("\nDanh sách người dùng:");
                        manager.displayUsers();
                        break;

                    case 4:
                        // Thoát chương trình
                        System.out.println("Thoát chương trình.");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi nhập liệu! Vui lòng chọn một số hợp lệ.");
            }
        }
    }

}
