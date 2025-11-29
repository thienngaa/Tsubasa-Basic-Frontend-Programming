public class StringBuilderExample {
    public static void main(String[] args) {
        // Khởi tạo chuỗi ban đầu
        StringBuilder sb = new StringBuilder("Hello, Java World!");
        System.out.println("Chuỗi ban đầu: " + sb);

        // Xóa các ký tự từ vị trí 5 đến 9
        sb.delete(5, 10); // delete(startIndex, endIndex) - xóa từ start đến end-1
        System.out.println("Chuỗi sau khi xóa ký tự từ vị trí 5 đến 9: " + sb);

        // Thay thế đoạn "World" bằng "Universe"
        // Tìm vị trí bắt đầu của "World"
        int start = sb.indexOf("World");
        if (start != -1) {
            int end = start + "World".length();
            sb.replace(start, end, "Universe"); // replace(startIndex, endIndex, str)
        }
        System.out.println("Chuỗi sau khi thay thế 'World' bằng 'Universe': " + sb);
    }
}
