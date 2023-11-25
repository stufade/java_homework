import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class DisplayImage extends JFrame {
    private JLabel imageLabel;

    public DisplayImage(String imagePath) {
        setTitle("Отображение изображения");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создаем метку для отображения изображения
        imageLabel = new JLabel();
        getContentPane().add(imageLabel, BorderLayout.CENTER);

        // Загружаем и отображаем изображение
        displayImage(imagePath);

        // Устанавливаем размер окна и положение на весь экран
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
    }

    private void displayImage(String imagePath) {
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            ImageIcon imageIcon = new ImageIcon(image);

            // Устанавливаем изображение на метку
            imageLabel.setIcon(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Ошибка открытия изображения: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Пожалуйста, укажите путь к изображению в аргументах командной строки.");
            System.exit(1);
        }

        SwingUtilities.invokeLater(() -> {
            String imagePath = args[0];
            new DisplayImage(imagePath).setVisible(true);
        });
    }
}
