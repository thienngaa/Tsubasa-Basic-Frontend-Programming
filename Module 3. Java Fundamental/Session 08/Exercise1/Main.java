package exercise01;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Animals[] animalsArray = new Animals[2]; // Mảng để lưu động vật

        // Tạo đối tượng Dog và Cat
        Dog dog1 = new Dog("Buddy", 3, "Golden Retriever");
        Cat cat1 = new Cat("Whiskers", 2, "Ghi");

        // Thêm vào mảng
        animalsArray[0] = dog1;
        animalsArray[1] = cat1;

        // Hiển thị thông tin và âm thanh của từng đối tượng
        for (Animals animal : animalsArray) {
            animal.displayInfo();
            System.out.println("Âm thanh: " + animal.makeSound());
            System.out.println();
        }
    }
}
