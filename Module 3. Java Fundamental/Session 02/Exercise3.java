import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số nguyên dương N: ");
        int N = sc.nextInt();

        // Kiểm tra tính hợp lệ của N
        if (N <= 0) {
            System.out.println("Số nhập vào không hợp lệ");
        } else {
            int tong = 0;

            // Sử dụng vòng lặp for để tính tổng
            for (int i = 1; i <= N; i++) {
                tong += i;
            }

            // In kết quả
            System.out.println("Tổng từ 1 đến " + N + " là: " + tong);
        }

        sc.close();
    }
}
