import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuanLyBienSoXe {

    // Kiểm tra định dạng biển số xe hợp lệ
    public static boolean isValidPlate(String plate) {
        // Định dạng: 2 số (mã tỉnh) + chữ cái + - + 3 số + . + 2 số
        String regex = "^\\d{2}[A-Z]-\\d{3}\\.\\d{2}$";
        return plate.matches(regex);
    }

    // Lấy mã tỉnh từ biển số
    public static String getProvinceCode(String plate) {
        if (plate.length() >= 2)
            return plate.substring(0, 2);
        return "";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> plates = new ArrayList<>();

        while (true) {
            System.out.println("\n******************QUẢN LÝ BIỂN SỐ XE****************");
            System.out.println("1. Thêm các biển số xe");
            System.out.println("2. Hiển thị danh sách biển số xe");
            System.out.println("3. Tìm kiếm biển số xe");
            System.out.println("4. Tìm biển số xe theo mã tỉnh");
            System.out.println("5. Sắp xếp biển số xe tăng dần");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = sc.nextInt();
            sc.nextLine(); // đọc dòng trống sau nextInt()

            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng biển số muốn thêm: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Nhập biển số xe thứ " + (i + 1) + ": ");
                        String plate = sc.nextLine().toUpperCase();
                        if (isValidPlate(plate)) {
                            plates.add(plate);
                            System.out.println("Thêm thành công!");
                        } else {
                            System.out.println("Biển số không hợp lệ. Định dạng đúng: 30F-123.45");
                        }
                    }
                    break;
                case 2:
                    if (plates.isEmpty()) {
                        System.out.println("Danh sách biển số trống.");
                    } else {
                        System.out.println("Danh sách biển số xe:");
                        for (String p : plates) {
                            System.out.println(p);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Nhập biển số cần tìm: ");
                    String searchPlate = sc.nextLine().toUpperCase();
                    if (plates.contains(searchPlate)) {
                        System.out.println("Biển số " + searchPlate + " có trong danh sách.");
                    } else {
                        System.out.println("Không tìm thấy biển số " + searchPlate);
                    }
                    break;
                case 4:
                    System.out.print("Nhập mã tỉnh cần tìm (vd: 29,30,51,...): ");
                    String provinceCode = sc.nextLine();
                    boolean found = false;
                    for (String p : plates) {
                        if (getProvinceCode(p).equals(provinceCode)) {
                            if (!found) {
                                System.out.println("Các biển số xe ở tỉnh " + provinceCode + ":");
                                found = true;
                            }
                            System.out.println(p);
                        }
                    }
                    if (!found) {
                        System.out.println("Không có biển số xe nào thuộc tỉnh " + provinceCode);
                    }
                    break;
                case 5:
                    if (plates.isEmpty()) {
                        System.out.println("Danh sách biển số trống.");
                    } else {
                        Collections.sort(plates);
                        System.out.println("Danh sách biển số xe sau khi sắp xếp tăng dần:");
                        for (String p : plates) System.out.println(p);
                    }
                    break;
                case 6:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
