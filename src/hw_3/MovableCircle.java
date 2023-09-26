package hw_3;

public class MovableCircle implements Movable{

    private int radius;
    private MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius){
        this.radius = radius;
        center = new MovablePoint(x, y, xSpeed, ySpeed);
    }

    @Override
    public void moveUp() {
        center.moveUp();
    }

    @Override
    public void moveDown() {
        center.moveDown();
    }

    @Override
    public void moveRight() {
        center.moveRight();
    }

    @Override
    public void moveLeft() {
        center.moveLeft();
    }

    @Override
    public String toString() {
        return "Circle: (" + center.toString() + "), radius = " + radius;
    }
}
