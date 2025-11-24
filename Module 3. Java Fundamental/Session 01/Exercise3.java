import java.util.Scanner;
public class BaiTapTongHop {
    public static void main(String[] args) {
        // Tính diện tích hình tròn
        // Yêu cầu nhập
        final float pi = 3.14f;
        Scanner sc = new Scanner(System.in);
        System.out.println("Hãy nhập bán kính hình tròn:　");
        int radius = sc.nextInt();
        float area = radius*radius*pi;
        System.out.println("Diện tích hình tròn: "+area);
        scanner.close();
    }
};
