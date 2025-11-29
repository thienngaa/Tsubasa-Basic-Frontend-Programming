import java.util.Scanner;

public class DescendingArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập kích thước mảng: ");
        int arrSize = input.nextInt();
        int sum = 0;

        int[] arr = new int[arrSize];
        System.out.println("Nhập các phần tử cho mảng: ");
        for(int i=0;i<arrSize;i++){
            arr[i]=input.nextInt();
        }
        // Sắp xếp mảng theo thứ tự giảm dần
        bubbleSortDescending(arr);

        // In mảng đã sắp xếp
        System.out.print("Mảng sau khi sắp xếp giảm dần: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    // Phương thức Bubble Sort giảm dần
    public static void bubbleSortDescending(int[] arr) {
        int n = arr.length;
        // Duyệt từng phần tử trong mảng
        for (int i = 0; i < n - 1; i++) {
            // So sánh các phần tử liền kề và đổi chỗ nếu cần
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) { // Nếu phần tử bên trái < bên phải
                    // Đổi chỗ
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

