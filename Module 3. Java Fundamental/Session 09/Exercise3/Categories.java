import java.util.Scanner;

public class Categories implements IShop {
    private int catalogId;
    private String catalogName;
    private String descriptions;
    private boolean catalogStatus;

    public Categories() {
    }

    public Categories(int catalogId, String catalogName, String descriptions, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    // Getter & Setter
    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    // Nhập dữ liệu danh mục
    public void inputData(Scanner scanner, Categories[] arrCategories, int index) {
        // Tự tăng ID
        this.catalogId = (index == 0) ? 1 : arrCategories[index - 1].catalogId + 1;

        // Nhập tên danh mục
        while (true) {
            System.out.print("Nhập tên danh mục: ");
            String name = scanner.nextLine();
            if (name.length() <= 50 && !isExistName(name, arrCategories, index)) {
                this.catalogName = name;
                break;
            }
            System.out.println("Tên danh mục không hợp lệ hoặc bị trùng!");
        }

        System.out.print("Nhập mô tả: ");
        this.descriptions = scanner.nextLine();

        while (true) {
            System.out.print("Nhập trạng thái (true/false): ");
            String status = scanner.nextLine();
            if (status.equalsIgnoreCase("true") || status.equalsIgnoreCase("false")) {
                this.catalogStatus = Boolean.parseBoolean(status);
                break;
            }
            System.out.println("Chỉ nhập true hoặc false!");
        }
    }

    private boolean isExistName(String name, Categories[] arr, int index) {
        for (int i = 0; i < index; i++) {
            if (arr[i].catalogName.equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void displayData() {
        System.out.println("ID: " + catalogId +
                " | Name: " + catalogName +
                " | Status: " + (catalogStatus ? "Hoạt động" : "Không hoạt động") +
                " | Mô tả: " + descriptions);
    }
}
