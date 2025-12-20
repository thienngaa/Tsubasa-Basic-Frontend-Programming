import java.util.Scanner;

public class Product implements IShop {
    private String productId;
    private String productName;
    private float price;
    private String description;
    private int catalogId;
    private int productStatus;

    public Product() {
    }

    public Product(String productId, String productName, float price, String description, int catalogId, int productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.catalogId = catalogId;
        this.productStatus = productStatus;
    }

    // Getter & Setter
    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public float getPrice() {
        return price;
    }

    public int getCatalogId() {
        return catalogId;
    }

    // Nhập dữ liệu sản phẩm
    public void inputData(Scanner scanner, Product[] arrProduct, int indexProduct,
                          Categories[] arrCategories, int indexCatalog) {

        // Nhập mã SP
        while (true) {
            System.out.print("Nhập mã sản phẩm: ");
            String id = scanner.nextLine();
            if (id.matches("[CSA]\\w{3}") && !isExistId(id, arrProduct, indexProduct)) {
                this.productId = id;
                break;
            }
            System.out.println("Mã SP không hợp lệ hoặc bị trùng!");
        }

        // Tên SP
        while (true) {
            System.out.print("Nhập tên sản phẩm: ");
            String name = scanner.nextLine();
            if (name.length() >= 10 && name.length() <= 50 && !isExistName(name, arrProduct, indexProduct)) {
                this.productName = name;
                break;
            }
            System.out.println("Tên không hợp lệ hoặc bị trùng!");
        }

        // Giá
        while (true) {
            System.out.print("Nhập giá: ");
            float p = Float.parseFloat(scanner.nextLine());
            if (p > 0) {
                this.price = p;
                break;
            }
            System.out.println("Giá phải > 0");
        }

        System.out.print("Nhập mô tả: ");
        this.description = scanner.nextLine();

        // Chọn danh mục
        System.out.println("Danh sách danh mục:");
        for (int i = 0; i < indexCatalog; i++) {
            arrCategories[i].displayData();
        }
        System.out.print("Chọn mã danh mục: ");
        this.catalogId = Integer.parseInt(scanner.nextLine());

        // Trạng thái
        while (true) {
            System.out.print("Nhập trạng thái (0-Đang bán,1-Hết hàng,2-Không bán): ");
            int st = Integer.parseInt(scanner.nextLine());
            if (st >= 0 && st <= 2) {
                this.productStatus = st;
                break;
            }
        }
    }

    private boolean isExistId(String id, Product[] arr, int index) {
        for (int i = 0; i < index; i++) {
            if (arr[i].productId.equals(id)) return true;
        }
        return false;
    }

    private boolean isExistName(String name, Product[] arr, int index) {
        for (int i = 0; i < index; i++) {
            if (arr[i].productName.equalsIgnoreCase(name)) return true;
        }
        return false;
    }

    @Override
    public void displayData() {
        System.out.println("ID: " + productId +
                " | Name: " + productName +
                " | Price: " + price +
                " | CatalogID: " + catalogId +
                " | Status: " + productStatus);
    }
}
