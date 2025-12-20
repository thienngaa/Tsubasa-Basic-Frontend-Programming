package exercise02;

public class Bike extends Vehicle {
    public Bike(String name, int speed) {
        super(name, speed); // Gọi constructor của lớp cha
    }

    // Ghi đè phương thức displayInfo
    @Override
    public void displayInfo() {
        System.out.println("Bike Name: " + getName() + ", Speed: " + getSpeed() + " km/h");
    }
}
