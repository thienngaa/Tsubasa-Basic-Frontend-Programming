package exercise03;

public class Square implements Colorable {
    private double side;
    private String color;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public double getSide() {
        return side;
    }
}
