package ra.run;

import ra.business.OrderBusiness;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderBusiness business = new OrderBusiness();

        while (true) {
            System.out.println("\n*********************QUẢN LÝ ĐƠN HÀNG********************");
            System.out.println("1. Thêm đơn hàng");
            System.out.println("2. Hiển thị danh sách đơn hàng");
            System.out.println("3. Cập nhật trạng thái đơn hàng theo mã");
            System.out.println("4. Xóa đơn hàng theo mã");
            System.out.println("5. Tìm kiếm đơn hàng theo tên khách hàng");
            System.out.println("6. Thống kê tổng số đơn hàng");
            System.out.println("7. Thống kê tổng doanh thu đơn DELIVERED");
            System.out.println("8. Thống kê số lượng đơn theo trạng thái");
            System.out.println("9. Tìm đơn hàng có giá trị lớn nhất");
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
                    business.addOrder(scanner);
                    break;
                case 2:
                    business.displayOrders();
                    break;
                case 3:
                    System.out.print("Nhập mã đơn hàng: ");
                    business.updateStatus(Integer.parseInt(scanner.nextLine()));
                    break;
                case 4:
                    System.out.print("Nhập mã đơn hàng: ");
                    business.deleteOrder(Integer.parseInt(scanner.nextLine()));
                    break;
                case 5:
                    System.out.print("Nhập tên khách hàng: ");
                    business.searchByCustomerName(scanner.nextLine());
                    break;
                case 6:
                    business.statisticTotalOrders();
                    break;
                case 7:
                    business.statisticDeliveredRevenue();
                    break;
                case 8:
                    business.statisticByStatus();
                    break;
                case 9:
                    business.findMaxOrder();
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
