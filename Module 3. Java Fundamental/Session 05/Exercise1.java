import java.util.Scanner;

public class TimTuTrongChuoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập chuỗi văn bản
        System.out.print("Nhập chuỗi: ");
        String text = sc.nextLine();

        // Nhập từ cần tìm
        System.out.print("Nhập từ cần tìm: ");
        String word = sc.nextLine();

        // Tìm vị trí xuất hiện đầu tiên
        int index = text.indexOf(word);

        if (index != -1) {
            System.out.println("Từ '" + word + "' xuất hiện lần đầu tiên tại vị trí: " + index);
        } else {
            System.out.println("Từ '" + word + "' không xuất hiện trong chuỗi.");
        }
    }
}
