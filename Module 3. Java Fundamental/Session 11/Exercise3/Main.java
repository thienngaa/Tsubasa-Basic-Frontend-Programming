package exercise06;

import exercise05.Validator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChatApplication chatApp = new ChatApplication();

        while (true) {
            System.out.println("Nhập tên người gửi (hoặc 'exit' để thoát): ");
            String sender = scanner.nextLine();
            if (sender.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println("Nhập nội dung tin nhắn: ");
            String content = scanner.nextLine();
            chatApp.sendMessage(sender, content);

            System.out.println("Nhập 'history' để xem lịch sử, hoặc 'filter' để lọc tin nhắn theo người gửi, hoặc 'date' để lọc theo ngày:");
            String command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "history":
                    chatApp.displayMessages();
                    break;
                case "filter":
                    System.out.println("Nhập tên người gửi để lọc:");
                    String filterSender = scanner.nextLine();
                    chatApp.filterMessagesBySender(filterSender);
                    break;
                case "date":
                    LocalDateTime date = Validator.getDate(scanner,"Nhập ngày (dd-MM-yyyy):");
                    chatApp.filterMessagesByDate(date);
                    break;
                default:
                    System.out.println("Lệnh không hợp lệ.");
                    break;
            }
        }

        scanner.close();
    }
}
