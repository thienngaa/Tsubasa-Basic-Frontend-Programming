import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int age = 0;             // biến lưu tuổi
        boolean valid = false;   // biến kiểm tra hợp lệ

        while (!valid) {
            System.out.print("Nhập tuổi của bạn: ");

            // Kiểm tra xem nhập vào có phải số nguyên hay không
            if (sc.hasNextInt()) {
                age = sc.nextInt();

                if (age > 0) {
                    valid = true;   // hợp lệ -> thoát vòng lặp
                } else {
                    System.out.println("Vui lòng nhập vào một số nguyên và lớn hơn 0.");
                }

            } else {
                // Nếu người dùng nhập chuỗi hoặc ký tự không phải số
                System.out.println("Vui lòng nhập vào một số nguyên và lớn hơn 0.");
                sc.next(); // đọc bỏ giá trị sai để tránh vòng lặp vô hạn
            }
        }

        System.out.println("Tuổi của bạn là " + age + " !");
        sc.close();
    }
}
