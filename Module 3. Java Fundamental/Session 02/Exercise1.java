import java.util.Scanner;

public class BaiTapTongHop {
    public static void main(String[] args) {
        // Kiểm tra số chẵn lẽ
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập 1 số nguyên bất kỳ: ");
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println("n không phải là số chẵn cũng không phải là số lẻ");
        } else {
            if (n % 2 == 0) {
                System.out.println("n là số chẵn");
            } else {
                System.out.println("n là số lẻ");
            }
            ;
        }
    }
};
