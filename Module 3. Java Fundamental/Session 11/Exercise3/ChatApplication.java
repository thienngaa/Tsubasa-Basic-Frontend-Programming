package exercise06;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChatApplication {
    private List<Message> messages = new ArrayList<>();

    public void sendMessage(String sender, String content) {
        Message message = new Message(sender, content);
        messages.add(message);
    }

    public void displayMessages() {
        System.out.println("Lịch sử chat:");
        for (Message message : messages) {
            System.out.println(message);
        }
    }

    public void filterMessagesBySender(String sender) {
        List<Message> filteredMessages = messages.stream()
                .filter(msg -> msg.getSender().equalsIgnoreCase(sender))
                .collect(Collectors.toList());

        System.out.println("Tin nhắn từ " + sender + ":");
        filteredMessages.forEach(System.out::println);
    }

    public void filterMessagesByDate(LocalDateTime date) {
        List<Message> filteredMessages = messages.stream()
                .filter(msg -> msg.getTimestamp().toLocalDate().equals(date.toLocalDate()))
                .collect(Collectors.toList());

        System.out.println("Tin nhắn trong ngày " + date.toLocalDate() + ":");
        filteredMessages.forEach(System.out::println);
    }
}
