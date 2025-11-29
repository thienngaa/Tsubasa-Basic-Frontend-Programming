import java.util.Scanner;
import java.util.regex.Pattern;

public class QuanLyNguoiDung {

    // Kiểm tra email hợp lệ
    public static boolean isValidEmail(String email) {
        String regex = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$";
        return Pattern.matches(regex, email);
    }

    // Kiểm tra số điện thoại Việt Nam
    public static boolean isValidPhone(String phone) {
        String regex = "^(0|\\+84)(3|5|7|8|9)\\d{8}$";
        return Pattern.matches(regex, phone);
    }

    // Kiểm tra mật khẩu hợp lệ
    public static boolean isValidPassword(String password) {
        // ít nhất 8 ký tự, có chữ hoa, chữ thường, số và ký tự đặc biệt
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=[\\]{};':\"\\\\|,.<>/?]).{8,}$";
        return Pattern.matches(regex, password);
    }

    // Chuẩn hóa họ tên
    public static String chuanHoaHoTen(String hoTen) {
        hoTen = hoTen.trim().toLowerCase();
        String[] words = hoTen.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0) {
                sb.append(Character.toUpperCase(word.charAt(0)))
                  .append(word.substring(1))
                  .append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String hoTen = "", email = "", phone = "", password = "";

        while (true) {
            System.out.println("\n******************QUẢN LÝ NGƯỜI DÙNG****************");
            System.out.println("1. Nhập thông tin người dùng");
            System.out.println("2. Chuẩn hóa họ tên");
            System.out.println("3. Kiểm tra email hợp lệ");
            System.out.println("4. Kiểm tra số điện thoại hợp lệ");
            System.out.println("5. Kiểm tra mật khẩu hợp lệ");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = sc.nextInt();
            sc.nextLine(); // đọc dòng trống sau nextInt()

            switch (choice) {
                case 1:
                    System.out.print("Nhập họ và tên: ");
                    hoTen = sc.nextLine();
                    System.out.print("Nhập email: ");
                    email = sc.nextLine();
                    System.out.print("Nhập số điện thoại: ");
                    phone = sc.nextLine();
                    System.out.print("Nhập mật khẩu: ");
                    password = sc.nextLine();
                    break;
                case 2:
                    if (hoTen.isEmpty()) {
                        System.out.println("Chưa nhập họ tên.");
                    } else {
                        hoTen = chuanHoaHoTen(hoTen);
                        System.out.println("Họ tên sau khi chuẩn hóa: " + hoTen);
                    }
                    break;
                case 3:
                    if (email.isEmpty()) {
                        System.out.println("Chưa nhập email.");
                    } else {
                        System.out.println(isValidEmail(email) ? "Email hợp lệ" : "Email không hợp lệ");
                    }
                    break;
                case 4:
                    if (phone.isEmpty()) {
                        System.out.println("Chưa nhập số điện thoại.");
