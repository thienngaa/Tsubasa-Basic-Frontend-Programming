package exercise04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static  Map<Integer, Product> productMap = new HashMap<>();
    public static void main(String[] args) {


        int choice;

        do {
            System.out.println("\n--- Product Management System ---");
            System.out.println("1. Add Product");
            System.out.println("2. Edit Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Products");
            System.out.println("5. Filter Products (Price > 100)");
            System.out.println("6. Total Value of Products");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    editProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    displayProducts();
                    break;
                case 5:
                    filterProducts();
                    break;
                case 6:
                    totalValue();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private static void addProduct() {
        System.out.print("Enter Product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Product Price: ");
        double price = scanner.nextDouble();
        productMap.put(id, new Product(id, name, price));
        System.out.println("Product added successfully.");
    }

    private static void editProduct() {
        System.out.print("Enter Product ID to edit: ");
        int id = scanner.nextInt();
        if (productMap.containsKey(id)) {
            scanner.nextLine(); // Consume newline
            System.out.print("Enter new Product Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new Product Price: ");
            double price = scanner.nextDouble();
            productMap.put(id, new Product(id, name, price));
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void deleteProduct() {
        System.out.print("Enter Product ID to delete: ");
        int id = scanner.nextInt();
        if (productMap.remove(id) != null) {
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void displayProducts() {
        if (productMap.isEmpty()) {
            System.out.println("No products available.");
        } else {
            productMap.values().forEach(System.out::println);
        }
    }

    private static void filterProducts() {
        System.out.println("Products with price greater than 100:");
        productMap.values().stream()
                .filter(product -> product.getPrice() > 100)
                .forEach(System.out::println);
    }

    private static void totalValue() {
        double total = productMap.values().stream()
                .mapToDouble(Product::getPrice)
                .sum();
        System.out.println("Total value of products: " + total);
    }

}
