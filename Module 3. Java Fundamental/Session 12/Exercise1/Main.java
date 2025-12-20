package ra.run;

import ra.business.ProductBusiness;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductBusiness business = new ProductBusiness();

        while (true) {
            System.out.println("\n*********************QUẢN LÝ SẢN PHẨM********************");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Danh sách sản phẩm");
            System.out.println("3. Cập nhật sản phẩm theo mã");
            System.out.println("4. Xóa sản phẩm theo mã");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("6. Sắp xếp theo giá tăng dần");
            System.out.println("7. Sắp xếp theo số lượng giảm dần");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.err.println("Nhập sai!");
                continue;
            }

            switch (choice) {
                case 1:
                    business.addProduct(scanner);
                    break;
                case 2:
                    business.displayProducts();
                    break;
                case 3:
                    System.out.print("Nhập mã sản phẩm: ");
                    business.updateProduct(Integer.parseInt(scanner.nextLine()), scanner);
                    break;
                case 4:
                    System.out.print("Nhập mã sản phẩm: ");
                    business.deleteProduct(Integer.parseInt(scanner.nextLine()));
                    break;
                case 5:
                    System.out.print("Nhập từ khóa: ");
                    business.searchByName(scanner.nextLine());
                    break;
                case 6:
                    business.sortByPriceAsc();
                    break;
                case 7:
                    business.sortByQuantityDesc();
                    break;
                case 0:
                    System.out.println("Thoát chương trình!");
                    return;
                default:
                    System.err.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
