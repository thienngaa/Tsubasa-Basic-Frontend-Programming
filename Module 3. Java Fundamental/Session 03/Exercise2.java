import java.util.Scanner;

public class BaiTH2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Khai báo biến
        int totalStu = 0;
        float totalScore = 0f;
        float avgScore = 0f;
        float maxScore = Float.MIN_VALUE; // Giá trị nhỏ nhất của dữ liệu float
        float minScore = Float.MAX_VALUE; // Giá trị lớn nhất của dữ liệu float
        do {
            System.out.println("1. Nhập điểm học viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Thoát");
            System.out.print("Mời bạn lựa chọn từ 1 đến 3: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    boolean isExit = true;
                    System.out.print("Mời nhập điểm sinh viên:");
                    do {
                        float mark = sc.nextFloat();
                        if(mark == -1){
                            isExit = false; // Không tiếp tục chạy code if bên dưới
                        } else {
                                if (mark < 0 && mark > 10) {
                                if (mark<5){
                                    System.out.println("Xếp loại: Yếu");
                                } else if (mark<7) {
                                    System.out.println("Xếp loại: Trung bình");
                                } else if (mark <7) {
                                    System.out.println("Xếp loại: Khá");
                                } else {
                                    System.out.println("Xếp loại: Giỏi");
                                }
                                // Tính tổng sinh viên
                                totalStu++;
                                // Tính tổng điểm
                                totalScore = totalScore + mark;
                                // Điểm cao nhất
                                if(maxScore<mark){
                                    maxScore = mark;
                                } if(minScore<mark){
                                    minScore = mark;
                                }
                            } else {
                                System.err.println("Điểm phải từ 0 -> 10, vui lòng nhập lại!");
                            }
                        }
                    } while(isExit);
                    break;
                case 2:
                    if(totalStu ==0){
                        System.out.println("Chưa có dữ liệu!");
                    } else {
                        System.out.println("Số sinh viên đã nhập: "+totalStu);
                        System.out.println("Điểm trung bình: "+(totalScore/totalStu));
                        System.out.println("Điểm cao nhất: "+maxScore);
                        System.out.println("Điểm thấp nhất: "+minScore);
                    }
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Vui lòng chọn 1, 2, 3!");
            }
        } while (true);
    }
}
