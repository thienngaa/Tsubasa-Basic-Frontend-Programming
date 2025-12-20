package ra.entity;

import java.util.Scanner;

public class Product {
    private static int autoId = 1;

    private int productId;
    private String productName;
    private float price;
    private String category;
    private int quantity;

    // Constructor không tham số
    public Product() {
        this.productId = autoId++;
    }

    // Constructor đầy đủ tham số
    public Product(String productName, float price, String category, int quantity) {
        this.productId = autoId++;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    // Getter & Setter
    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Nhập dữ liệu sản phẩm
    public void inputData(Scanner scanner) {
        // Tên sản phẩm
        while (true) {
            System.out.print("Nhập tên sản phẩm (10-50 ký tự): ");
            String name = scanner.nextLine().trim();
            if (name.length() >= 10 && name.length() <= 50) {
                this.productName = name;
                break;
            }
            System.err.println("Tên sản phẩm không hợp lệ!");
        }

        // Giá
        while (true) {
            System.out.print("Nhập giá sản phẩm (>0): ");
            try {
                float p = Float.parseFloat(scanner.nextLine());
                if (p > 0) {
                    this.price = p;
                    break;
                }
            } catch (Exception ignored) {}
            System.err.println("Giá không hợp lệ!");
        }

        // Danh mục
        while (true) {
            System.out.print("Nhập danh mục (<=200 ký tự): ");
            String cat = scanner.nextLine();
            if (cat.length() <= 200) {
                this.category = cat;
                break;
            }
            System.err.println("Danh mục quá dài!");
        }

        // Số lượng
        while (true) {
            System.out.print("Nhập số lượng (>=0): ");
            try {
                int q = Integer.parseInt(scanner.nextLine());
                if (q >= 0) {
                    this.quantity = q;
                    break;
                }
            } catch (Exception ignored) {}
            System.err.println("Số lượng không hợp lệ!");
        }
    }

    @Override
    public String toString() {
        return "ID: " + productId +
                " | Tên: " + productName +
                " | Giá: " + price +
                " | Danh mục: " + category +
                " | Tồn kho: " + quantity;
    }
}
