import java.util.Scanner;

public class MinValue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Nhập số lượng phần tử của mảng
        System.out.println("Nhập kích thước mảng: ");
        int size = input.nextInt();

        // Khai báo và nhập phần tử mảng
        int[] arr = new int[size];
        System.out.println("Nhập các phần tử cho mảng: ");
        for (int i=0;i<size;i++) {
            arr[i]=input.nextInt();
        }

        // Sắp xếp mảng theo thứ tự giảm dần
        selectionSort(arr);
        // Lấy phần tử đầu tiên (lớn nhất) sau khi sắp xếp
        int maxValue = arr[0];
        System.out.println("Phần tử lớn nhất trong mảng là: " + maxValue);
    }

    // Khai báo hàm SelectionSort để sắp xếp mảng theo thứ tự giảm dần
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int maxIndex = i;
            // Tìm phần tử lớn nhất trong đoạn còn lại
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            // Hoán đổi phần tử lớn nhất với vị trí i
            if (maxIndex != i) {
                int temp = arr[i];
                arr[i] = arr[maxIndex];
                arr[maxIndex] = temp; 
            }
        }
    }
}
