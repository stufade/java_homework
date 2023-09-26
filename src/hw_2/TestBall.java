package hw_2;

public class TestBall {
    public static void main(String[] args) {
        Ball ball = new Ball(10, 20);
        System.out.println(ball);

        ball.setXY(30, 40);
        System.out.println(ball);

        ball.move(-5, 10);
        System.out.println(ball);
    }
}