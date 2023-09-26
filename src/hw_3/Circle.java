package hw_3;

public class Circle extends Shape{
    private double radius;
    private static final float PI = 3.14f;

    public Circle(){
        super();
        this.radius = 0;
    }
    public Circle(double radius){
        super();
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled){
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius*radius*PI;
    }

    @Override
    public double getPerimeter() {
        return 2*radius*PI;
    }

    @Override
    public String toString() {
        return "Circle: (" + super.toString() + "), radius: " + radius;
    }
}
