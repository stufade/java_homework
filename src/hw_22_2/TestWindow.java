package hw_22_2;

import javax.swing.*;

public class TestWindow {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }

        CarcasController controller = new CarcasController();
        controller.showWindow();
    }
}
