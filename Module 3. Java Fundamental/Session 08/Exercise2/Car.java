package exercise02;

public class Car extends Vehicle {
    public Car(String name, int speed) {
        super(name, speed); // Gọi constructor của lớp cha
    }

    // Ghi đè phương thức displayInfo
    @Override
    public void displayInfo() {
        System.out.println("Car Name: " + getName() + ", Speed: " + getSpeed() + " km/h");
    }
}
