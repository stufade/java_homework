package hw_2;

public class Ball {
    private float x;
    private float y;

    public Ball (){
        this.x = .0f;
        this.y = .0f;
    }
    public Ball(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void move(float xDisp, float yDisp) {
        x += xDisp;
        y += yDisp;
    }

    @Override
    public String toString() {
        return "Ball @ (" + x + ", " + y + ")";
    }
}

