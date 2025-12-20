package ra.business;

import ra.entity.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ProductBusiness {
    private ArrayList<Product> products = new ArrayList<>();

    // Thêm sản phẩm
    public void addProduct(Scanner scanner) {
        Product product = new Product();
        product.inputData(scanner);

        // Check trùng tên
        for (Product p : products) {
            if (p.getProductName().equalsIgnoreCase(product.getProductName())) {
                System.err.println("Tên sản phẩm đã tồn tại!");
                return;
            }
        }

        products.add(product);
        System.out.println("Thêm sản phẩm thành công!");
    }

    // Hiển thị danh sách
    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống!");
            return;
        }
        products.forEach(System.out::println);
    }

    // Cập nhật
    public void updateProduct(int id, Scanner scanner) {
        for (Product p : products) {
            if (p.getProductId() == id) {
                System.out.println("Nhập thông tin mới:");
                p.inputData(scanner);
                System.out.println("Cập nhật thành công!");
                return;
            }
        }
        System.err.println("Không tìm thấy sản phẩm!");
    }

    // Xóa
    public void deleteProduct(int id) {
        for (Product p : products) {
            if (p.getProductId() == id) {
                products.remove(p);
                System.out.println("Xóa thành công!");
                return;
            }
        }
        System.err.println("Không tìm thấy sản phẩm!");
    }

    // Tìm theo tên (gần đúng)
    public void searchByName(String keyword) {
        boolean found = false;
        for (Product p : products) {
            if (p.getProductName().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sản phẩm!");
        }
    }

    // Sắp xếp giá tăng dần
    public void sortByPriceAsc() {
        products.sort(Comparator.comparing(Product::getPrice));
        System.out.println("Đã sắp xếp theo giá tăng dần!");
    }

    // Sắp xếp số lượng giảm dần
    public void sortByQuantityDesc() {
        products.sort((a, b) -> b.getQuantity() - a.getQuantity());
        System.out.println("Đã sắp xếp theo số lượng giảm dần!");
    }
}
