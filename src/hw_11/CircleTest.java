package hw_11;

class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle(5);

        System.out.println("Радиус окружности: " + circle.getRadius());

        System.out.println("Площадь окружности: " + circle.getArea());

        System.out.println("Длина окружности: " + circle.getPerimeter());

        circle.setRadius(8);

        System.out.println("Новый радиус окружности: " + circle.getRadius());

        System.out.println("Обновленная площадь окружности: " + circle.getArea());

        System.out.println("Обновленная длина окружности: " + circle.getPerimeter());
    }
}
