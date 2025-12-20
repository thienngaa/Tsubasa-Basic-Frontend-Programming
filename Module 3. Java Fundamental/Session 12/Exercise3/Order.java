package ra.entity;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Order {

    // Enum trạng thái
    public enum Status {
        PENDING, SHIPPED, DELIVERED
    }

    private static int autoId = 1;

    private int orderId;
    private String customerName;
    private String phoneNumber;
    private String address;
    private float orderAmount;
    private Status status;

    // Constructor không tham số
    public Order() {
        this.orderId = autoId++;
        this.status = Status.PENDING; // mặc định
    }

    // Constructor đầy đủ tham số
    public Order(String customerName, String phoneNumber,
                 String address, float orderAmount, Status status) {
        this.orderId = autoId++;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.orderAmount = orderAmount;
        this.status = status;
    }

    // Getter & Setter
    public int getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public float getOrderAmount() { return orderAmount; }
    public void setOrderAmount(float orderAmount) { this.orderAmount = orderAmount; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    // Nhập dữ liệu
    public void inputData(Scanner scanner) {
        // Tên khách hàng
        while (true) {
            System.out.print("Nhập tên khách hàng (6-100 ký tự): ");
            String name = scanner.nextLine().trim();
            if (name.length() >= 6 && name.length() <= 100) {
                this.customerName = name;
                break;
            }
            System.err.println("Tên khách hàng không hợp lệ!");
        }

        // Số điện thoại Việt Nam
        Pattern phonePattern = Pattern.compile("^(03|05|07|08|09)\\d{8}$");
        while (true) {
            System.out.print("Nhập số điện thoại: ");
            String phone = scanner.nextLine().trim();
            if (phonePattern.matcher(phone).matches()) {
                this.phoneNumber = phone;
                break;
            }
            System.err.println("Số điện thoại không hợp lệ!");
        }

        // Địa chỉ
        while (true) {
            System.out.print("Nhập địa chỉ giao hàng: ");
            String addr = scanner.nextLine().trim();
            if (!addr.isEmpty()) {
                this.address = addr;
                break;
            }
            System.err.println("Địa chỉ không được để trống!");
        }

        // Giá trị đơn hàng
        while (true) {
            System.out.print("Nhập giá trị đơn hàng (>0): ");
            try {
                float amount = Float.parseFloat(scanner.nextLine());
                if (amount > 0) {
                    this.orderAmount = amount;
                    break;
                }
            } catch (Exception ignored) {}
            System.err.println("Giá trị đơn hàng không hợp lệ!");
        }
    }

    @Override
    public String toString() {
        return "ID: " + orderId +
                " | KH: " + customerName +
                " | SĐT: " + phoneNumber +
                " | ĐC: " + address +
                " | Giá trị: " + orderAmount +
                " | Trạng thái: " + status;
    }
}
