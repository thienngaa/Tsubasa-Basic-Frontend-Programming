package ra.run;

import ra.business.AppointmentBusiness;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AppointmentBusiness business = new AppointmentBusiness();

        while (true) {
            System.out.println("\n*********************QUẢN LÝ LỊCH HẸN********************");
            System.out.println("1. Thêm lịch hẹn");
            System.out.println("2. Hiển thị danh sách lịch hẹn");
            System.out.println("3. Tìm kiếm lịch hẹn theo tên bệnh nhân");
            System.out.println("4. Cập nhật lịch hẹn theo mã");
            System.out.println("5. Xóa lịch hẹn theo mã");
            System.out.println("6. Thống kê");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.err.println("Nhập sai!");
                continue;
            }

            switch (choice) {
                case 1:
                    business.addAppointment(scanner);
                    break;
                case 2:
                    business.displayAppointments();
                    break;
                case 3:
                    System.out.print("Nhập tên bệnh nhân: ");
                    business.searchByPatientName(scanner.nextLine());
                    break;
                case 4:
                    System.out.print("Nhập mã lịch hẹn: ");
                    business.updateAppointment(scanner.nextLine(), scanner);
                    break;
                case 5:
                    System.out.print("Nhập mã lịch hẹn: ");
                    business.deleteAppointment(scanner.nextLine(), scanner);
                    break;
                case 6:
                    business.statistics();
                    break;
                case 0:
                    System.out.println("Thoát chương trình!");
                    return;
                default:
                    System.err.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
