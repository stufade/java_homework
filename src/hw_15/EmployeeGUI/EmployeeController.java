package EmployeeGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class EmployeeController {
    private Employee model;
    private EmployeeView view;
    public EmployeeController(Employee model, EmployeeView view) {
        this.model = model;
        this.view = view;

        this.view.addCalculateListener(new CalculateListener());
    }
    class CalculateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = view.getName();
            double hourlyRate = view.getHourlyRate();
            int hoursWorked = view.getHoursWorked();

            model.setName(name);
            model.setHourlyRate(hourlyRate);
            model.setHoursWorked(hoursWorked);

            double salary = model.calculateSalary();
            view.setResult(salary);
        }
    }
}
