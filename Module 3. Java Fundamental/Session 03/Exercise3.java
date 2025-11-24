import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Double> salaries = new ArrayList<>();

        while (true) {
            System.out.println("***************MENU NHẬP LƯƠNG***************");
            System.out.println("1. Nhập lương nhân viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Tính tổng số tiền thưởng cho nhân viên");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    // NHẬP LƯƠNG NHÂN VIÊN
                    while (true) {
                        System.out.print("Nhập lương nhân viên (-1 để dừng): ");
                        double salary = sc.nextDouble();

                        if (salary == -1) {
                            break; // thoát nhập
                        }

                        if (salary < 0 || salary > 500_000_000) {
                            System.out.println("Lương không hợp lệ! Nhập từ 0 đến 500 triệu.");
                            continue;
                        }

                        // Phân loại lương
                        if (salary < 5_000_000) {
                            System.out.println("Thu nhập thấp");
                        } else if (salary < 15_000_000) {
                            System.out.println("Thu nhập trung bình");
                        } else if (salary < 50_000_000) {
                            System.out.println("Thu nhập khá");
                        } else {
                            System.out.println("Thu nhập cao");
                        }

                        salaries.add(salary);
                    }
                    break;

                case 2:
                    // HIỂN THỊ THỐNG KÊ
                    if (salaries.isEmpty()) {
                        System.out.println("Chưa có dữ liệu");
                        break;
                    }

                    double sum = 0;
                    double max = salaries.get(0);
                    double min = salaries.get(0);

                    for (double s : salaries) {
                        sum += s;
                        if (s > max) max = s;
                        if (s < min) min = s;
                    }

                    double avg = sum / salaries.size();

                    System.out.println("===== THỐNG KÊ =====");
                    System.out.println("Số nhân viên: " + salaries.size());
                    System.out.println("Lương trung bình: " + avg);
                    System.out.prin
