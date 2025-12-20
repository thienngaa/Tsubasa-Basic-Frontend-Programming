import java.util.Scanner;

public class ShopManagement {
    static Categories[] arrCategories = new Categories[100];
    static Product[] arrProducts = new Product[100];
    static int indexCatalog = 0;
    static int indexProduct = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n******************SHOP MENU*******************");
            System.out.println("1. Quản lý danh mục");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    categoryMenu(scanner);
                    break;
                case 2:
                    productMenu(scanner);
                    break;
                case 3:
                    System.out.println("Thoát chương trình!");
            }
        } while (choice != 3);
    }

    // MENU DANH MỤC
    static void categoryMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n************CATEGORIES MENU************");
            System.out.println("1. Nhập danh mục");
            System.out.println("2. Hiển thị danh mục");
            System.out.println("6. Thoát");
            choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                System.out.print("Nhập số danh mục: ");
                int n = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < n; i++) {
                    arrCategories[indexCatalog] = new Categories();
                    arrCategories[indexCatalog].inputData(scanner, arrCategories, indexCatalog);
                    indexCatalog++;
                }
            } else if (choice == 2) {
                for (int i = 0; i < indexCatalog; i++) {
                    arrCategories[i].displayData();
                }
            }
        } while (choice != 6);
    }

    // MENU SẢN PHẨM
    static void productMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n************PRODUCT MENU************");
            System.out.println("1. Nhập sản phẩm");
            System.out.println("2. Hiển thị sản phẩm");
            System.out.println("8. Thoát");
            choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                arrProducts[indexProduct] = new Product();
                arrProducts[indexProduct].inputData(scanner, arrProducts, indexProduct, arrCategories, indexCatalog);
                indexProduct++;
            } else if (choice == 2) {
                for (int i = 0; i < indexProduct; i++) {
                    arrProducts[i].displayData();
                }
            }
        } while (choice != 8);
    }
}
