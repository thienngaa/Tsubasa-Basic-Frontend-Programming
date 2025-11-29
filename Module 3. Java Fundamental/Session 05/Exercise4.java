import java.util.Scanner;
import java.util.regex.Pattern;

public class KiemTraEmail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập chuỗi từ bàn phím
        System.out.print("Nhập địa chỉ email: ");
        String email = sc.nextLine().trim(); // loại bỏ khoảng trắng thừa

        // Biểu thức chính quy kiểm tra email hợp lệ
        String regex = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$";

        // Kiểm tra
        if (Pattern.matches(regex, email)) {
            System.out.println("Email hợp lệ");
        } else {
            System.out.println("Email không hợp lệ");
        }
    }
}
