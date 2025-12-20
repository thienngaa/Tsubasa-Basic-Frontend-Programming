package ra.business;

import ra.entity.Order;
import ra.entity.Order.Status;

import java.util.*;

public class OrderBusiness {
    private List<Order> orders = new ArrayList<>();

    // Thêm đơn hàng
    public void addOrder(Scanner scanner) {
        Order order = new Order();
        order.inputData(scanner);
        orders.add(order);
        System.out.println("Thêm đơn hàng thành công!");
    }

    // Hiển thị danh sách (giá trị giảm dần)
    public void displayOrders() {
        if (orders.isEmpty()) {
            System.out.println("Danh sách đơn hàng trống!");
            return;
        }
        orders.stream()
                .sorted(Comparator.comparing(Order::getOrderAmount).reversed())
                .forEach(System.out::println);
    }

    // Cập nhật trạng thái
    public void updateStatus(int id) {
        for (Order o : orders) {
            if (o.getOrderId() == id) {
                if (o.getStatus() == Status.PENDING) {
                    o.setStatus(Status.SHIPPED);
                    System.out.println("Đã chuyển sang SHIPPED");
                } else if (o.getStatus() == Status.SHIPPED) {
                    o.setStatus(Status.DELIVERED);
                    System.out.println("Đã chuyển sang DELIVERED");
                } else {
                    System.out.println("Đơn hàng đã DELIVERED, không thể cập nhật!");
                }
                return;
            }
        }
        System.err.println("Không tìm thấy đơn hàng!");
    }

    // Xóa đơn hàng (chỉ pending)
    public void deleteOrder(int id) {
        Iterator<Order> it = orders.iterator();
        while (it.hasNext()) {
            Order o = it.next();
            if (o.getOrderId() == id) {
                if (o.getStatus() == Status.PENDING) {
                    it.remove();
                    System.out.println("Xóa đơn hàng thành công!");
                } else {
                    System.err.println("Chỉ được xóa đơn hàng PENDING!");
                }
                return;
            }
        }
        System.err.println("Không tìm thấy đơn hàng!");
    }

    // Tìm theo tên khách hàng
    public void searchByCustomerName(String keyword) {
        boolean found = false;
        for (Order o : orders) {
            if (o.getCustomerName().toLowerCase()
                    .contains(keyword.toLowerCase())) {
                System.out.println(o);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy đơn hàng!");
        }
    }

    // Thống kê
    public void statisticTotalOrders() {
        System.out.println("Tổng số đơn hàng: " + orders.size());
    }

    public void statisticDeliveredRevenue() {
        float total = 0;
        for (Order o : orders) {
            if (o.getStatus() == Status.DELIVERED) {
                total += o.getOrderAmount();
            }
        }
        System.out.println("Tổng doanh thu (Delivered): " + total);
    }

    public void statisticByStatus() {
        for (Status s : Status.values()) {
            long count = orders.stream()
                    .filter(o -> o.getStatus() == s)
                    .count();
            System.out.println(s + ": " + count);
        }
    }

    public void findMaxOrder() {
        orders.stream()
                .max(Comparator.comparing(Order::getOrderAmount))
                .ifPresentOrElse(
                        o -> System.out.println("Đơn hàng giá trị lớn nhất:\n" + o),
                        () -> System.out.println("Danh sách trống!")
                );
    }
}
