import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PetManagement {
    private static List<Pet> pets = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n*********************QUẢN LÝ THÚ CƯNG********************");
            System.out.println("1. Hiển thị danh sách thú cưng");
            System.out.println("2. Thêm thú cưng");
            System.out.println("3. Gọi tiếng kêu");
            System.out.println("4. Xóa thú cưng");
            System.out.println("5. Tìm thú cưng theo tên");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    displayPets();
                    break;
                case 2:
                    addPet(scanner);
                    break;
                case 3:
                    callSpeak(scanner);
                    break;
                case 4:
                    deletePet(scanner);
                    break;
                case 5:
                    searchPetByName(scanner);
                    break;
                case 6:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 6);
    }

    // 1. Hiển thị danh sách
    private static void displayPets() {
        if (pets.isEmpty()) {
            System.out.println("Danh sách thú cưng trống!");
            return;
        }
        pets.forEach(Pet::displayData);
    }

    // 2. Thêm thú cưng
    private static void addPet(Scanner scanner) {
        System.out.print("Chọn loại thú cưng (1-Chó, 2-Mèo): ");
        int type = Integer.parseInt(scanner.nextLine());

        Pet pet;
        if (type == 1) {
            pet = new Dog();
        } else if (type == 2) {
            pet = new Cat();
        } else {
            System.out.println("Loại thú cưng không hợp lệ!");
            return;
        }

        pet.inputData(scanner);
        pets.add(pet);
    }

    // 3. Gọi tiếng kêu
    private static void callSpeak(Scanner scanner) {
        System.out.print("Nhập mã thú cưng: ");
        String id = scanner.nextLine();

        for (Pet pet : pets) {
            if (pet.getPetId().equals(id)) {
                pet.speak();
                return;
            }
        }
        System.out.println("Không tìm thấy thú cưng!");
    }

    // 4. Xóa thú cưng
    private static void deletePet(Scanner scanner) {
        System.out.print("Nhập mã thú cưng cần xóa: ");
        String id = scanner.nextLine();

        boolean removed = pets.removeIf(p -> p.getPetId().equals(id));
        if (!removed) {
            System.out.println("Không tìm thấy thú cưng!");
        }
    }

    // 5. Tìm thú cưng theo tên
    private static void searchPetByName(Scanner scanner) {
        System.out.print("Nhập tên thú cưng cần tìm: ");
        String name = scanner.nextLine();
        int count = 0;

        for (Pet pet : pets) {
            if (pet.getPetName().toLowerCase().contains(name.toLowerCase())) {
                pet.displayData();
                count++;
            }
        }
        System.out.println("Số thú cưng tìm thấy: " + count);
    }
}
