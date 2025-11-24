import java.util.Scanner;

public class BaiTapTongHop {
    public static void main(String[] args) {
        // Toán tử số học
        // Yêu cầu nhập
        final float pi = 3.14f;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số a:");
        int a = sc.nextInt();
        System.out.println("Nhập số b:");
        int b = sc.nextInt();
        int sum = a+b;
        int dif = a-b;
        int pro = a*b;
        int quo = a/b;
        int rem = a%b;
        System.out.printf("\n a= %d và b = %d",a,b);
        System.out.printf("\n Tổng 2 số a+b = %d",sum);
        System.out.printf("\n Hiệu 2 số a-b = %d",dif);
        System.out.printf("\n Tích 2 số a*b = %d",pro);
        System.out.printf("\n Thương 2 số a/b = %d",quo);
        System.out.printf("\n Số dư khi chia số a cho b = %d",rem);
    }
};
