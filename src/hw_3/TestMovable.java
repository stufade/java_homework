package hw_3;

public class TestMovable {
    public static void main(String[] args) {
        MovablePoint point = new MovablePoint(2, 5, 3, 4);
        System.out.println(point);
        point.moveLeft();
        point.moveUp();
        System.out.println(point);

        MovableCircle circle = new MovableCircle(3, 4, 2, 3, 5);
        System.out.println(circle);
        circle.moveDown();
        circle.moveRight();
        System.out.println(circle);
    }
}