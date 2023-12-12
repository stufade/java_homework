package EmployeeGUI;

import javax.swing.*;
import java.awt.event.ActionListener;

public class EmployeeView {
    private JFrame frame;
    private JLabel nameLabel;
    private JLabel rateLabel;
    private JLabel hoursLabel;
    private JLabel resultLabel;
    private JTextField nameTextField;
    private JTextField rateTextField;
    private JTextField hoursTextField;
    private JButton calculateButton;

    public EmployeeView() {
        frame = new JFrame("Salary Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        nameLabel = new JLabel("Name:");
        rateLabel = new JLabel("Hourly Rate:");
        hoursLabel = new JLabel("Hours Worked:");
        resultLabel = new JLabel("");

        nameTextField = new JTextField();
        rateTextField = new JTextField();
        hoursTextField = new JTextField();
        calculateButton = new JButton("Calculate");

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.add(nameLabel);
        inputPanel.add(nameTextField);
        inputPanel.add(rateLabel);
        inputPanel.add(rateTextField);
        inputPanel.add(hoursLabel);
        inputPanel.add(hoursTextField);

        frame.add(inputPanel);
        frame.add(calculateButton);
        frame.add(resultLabel);
        frame.setVisible(true);
    }

    public String getName() {
        return nameTextField.getText();
    }
    public double getHourlyRate() {
        return Double.parseDouble(rateTextField.getText());
    }
    public int getHoursWorked() {
        return Integer.parseInt(hoursTextField.getText());
    }
    public void setResult(double result) {
        resultLabel.setText("Salary: $" + result);
    }
    public void addCalculateListener(ActionListener listener) {
        calculateButton.addActionListener(listener);
    }
}
