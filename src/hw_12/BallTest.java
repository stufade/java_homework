package hw_12;

class Ball {
    private String color;
    private double diameter;
    public Ball(String color, double diameter) {
        this.color = color;
        this.diameter = diameter;
    }
    public String getColor() {
        return color;
    }
    public double getDiameter() {
        return diameter;
    }
    public void displayInfo() {
        System.out.println("Мяч цвета " + color + " и диаметром " + diameter + " см.");
    }
}


public class BallTest {
    public static void main(String[] args) {
        Ball ball = new Ball("красный", 10);

        System.out.println("Цвет мяча: " + ball.getColor());
        System.out.println("Диаметр мяча: " + ball.getDiameter() + " см");

        ball.displayInfo();
    }
}
