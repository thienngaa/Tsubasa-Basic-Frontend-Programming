import java.util.Scanner;

public class ThayTheSo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập chuỗi từ bàn phím
        System.out.print("Nhập một chuỗi: ");
        String input = sc.nextLine();

        // Thay thế tất cả các ký tự số bằng '*'
        String result = input.replaceAll("\\d", "*"); // \d khớp với bất kỳ chữ số nào từ 0-9

        // In kết quả
        System.out.println("Chuỗi sau khi thay thế các ký tự số: " + result);
    }
}
