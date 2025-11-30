package exercise02;

public class Book {
    // Các thuộc tính được khai báo là private
    private String title;
    private String author;
    private double price;

    // Phương thức getter cho title
    public String getTitle() {
        return title;
    }

    // Phương thức setter cho title
    public void setTitle(String title) {
        this.title = title;
    }

    // Phương thức getter cho author
    public String getAuthor() {
        return author;
    }

    // Phương thức setter cho author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Phương thức getter cho price
    public double getPrice() {
        return price;
    }

    // Phương thức setter cho price với kiểm tra tính hợp lệ
    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("Giá không được âm");
        }else {
            this.price = price;
        }
        
    }
}
