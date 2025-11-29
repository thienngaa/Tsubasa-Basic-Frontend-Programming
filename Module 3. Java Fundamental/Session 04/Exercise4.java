import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập số lượng phần tử mảng
        System.out.print("Nhập số lượng phần tử mảng: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Nhập các phần tử mảng
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Đảo ngược mảng
        reverseArray(arr);

        // In mảng sau khi đảo ngược
        System.out.print("Mảng sau khi đảo ngược: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    // Phương thức đảo ngược mảng
    public static void reverseArray(int[] arr) {
        int n = arr.length;
        // Dùng hai con trỏ: đầu và cuối, hoán đổi đến khi gặp nhau
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
    }
}
