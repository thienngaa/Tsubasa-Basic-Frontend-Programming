package exercise02;

import java.util.HashMap;

public class BookManager {
    private HashMap<String, Book> books;

    public BookManager() {
        books = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getTitle(), book);
    }

    public Book findBook(String title) throws Exception {
        if (!books.containsKey(title)) {
            throw new Exception("Sách không tồn tại!");
        }
        return books.get(title);
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("Chưa có sách nào trong danh sách.");
        } else {
            for (Book book : books.values()) {
                System.out.println(book);
            }
        }
    }
}
