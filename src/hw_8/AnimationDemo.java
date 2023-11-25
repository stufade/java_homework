import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class AnimationDemo extends JPanel implements ActionListener {
    private static final int ANIMATION_SIZE = 8;
    private BufferedImage[] frames;
    private int frameIndex = 0;
    private Timer timer;

    public AnimationDemo() {
        frames = new BufferedImage[ANIMATION_SIZE];
        loadFrames();
        timer = new Timer(50, this);
        timer.start();
    }

    private void loadFrames() {
        for (int i = 0; i < ANIMATION_SIZE; i++) {
            String imagePath = "animation-" + (i + 1) + ".png";
            try {
                frames[i] = ImageIO.read(getClass().getResource(imagePath));
            } catch (IOException e) {
                System.err.println("Error loading image: " + imagePath);
                frames[i] = null;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (frameIndex < frames.length && frames[frameIndex] != null) {
            g.drawImage(frames[frameIndex], 0, 0, null);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frameIndex++;
        if (frameIndex >= frames.length) {
            frameIndex = 0;
        }
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Анимация");
            AnimationDemo animationDemo = new AnimationDemo();
            frame.add(animationDemo);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 680);
            frame.setVisible(true);
        });
    }
}
