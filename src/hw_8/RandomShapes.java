

import javax.swing.*;
import java.awt.*;
import java.util.Random;

abstract class Shape {
    protected Color color;
    protected int x, y;

    public Shape(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public abstract void draw(Graphics g);
}

class RectangleShape extends Shape {
    private int width, height;

    public RectangleShape(Color color, int x, int y, int width, int height) {
        super(color, x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}

class CircleShape extends Shape {
    private int radius;

    public CircleShape(Color color, int x, int y, int radius) {
        super(color, x, y);
        this.radius = radius;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, 2 * radius, 2 * radius);
    }
}

public class RandomShapes {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int NUM_SHAPES = 20;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Random Shapes");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Random random = new Random();

                for (int i = 0; i < NUM_SHAPES; i++) {
                    int x = random.nextInt(700);
                    int y = random.nextInt(500);
                    Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));

                    Shape shape;
                    if (random.nextBoolean()) {
                        int width = random.nextInt(100) + 50;
                        int height = random.nextInt(100) + 50;
                        shape = new RectangleShape(color, x, y, width, height);
                    } else {
                        int radius = random.nextInt(50) + 25;
                        shape = new CircleShape(color, x, y, radius);
                    }

                    shape.draw(g);
                }
            }
        };

        frame.add(panel);
        frame.setVisible(true);
    }
}
