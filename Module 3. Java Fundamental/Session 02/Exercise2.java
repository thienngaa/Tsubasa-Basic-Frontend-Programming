import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số từ 1 đến 7: ");
        int n = sc.nextInt();
        // Kiểm tra giá trị nhập vào
        switch (n) {
            case 1:
                day = "Chủ nhật";
                break;
            case 2:
                day = "Thứ hai";
                break;
            case 3:
                day = "Thứ ba";
                break;
            case 4:
                day = "Thứ tư";
                break;
            case 5:
                day = "Thứ năm";
                break;
            case 6:
                day = "Thứ sáu";
                break;
            case 7:
                day = "Thứ bảy";
                break;
            default:
                day = "Số nhập vào không hợp lệ";
        }

        System.out.println(day);

        sc.close();
    }
}
