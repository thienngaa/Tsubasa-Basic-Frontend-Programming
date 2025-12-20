package exercise03;

import java.util.LinkedList;

public class UserManager {
    private LinkedList<User> users;

    public UserManager() {
        users = new LinkedList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public boolean removeUser(String email) {
        return users.removeIf(user -> user.getEmail().equals(email));
    }

    public void displayUsers() {
        if (users.isEmpty()) {
            System.out.println("Chưa có người dùng nào trong danh sách.");
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

}
