package exercise01;

public class Rectangle {
    // Thuộc tính
    private double length;
    private double width;

    // Constructor mặc định
    public Rectangle() {
        this.length = 1.0;
        this.width = 1.0;
    }

    // Constructor có tham số
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Phương thức tính diện tích
    public double getArea() {
        return length * width;
    }

    // Phương thức tính chu vi
    public double getPerimeter() {
        return 2 * (length + width);
    }

    // Phương thức hiển thị thông tin
    public void display() {
        System.out.println("Chiều dài: " + length);
        System.out.println("Chiều rộng: " + width);
        System.out.println("Diện tích: " + getArea());
        System.out.println("Chu vi: " + getPerimeter());
    }
}
