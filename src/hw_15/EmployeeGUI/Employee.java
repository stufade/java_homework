package EmployeeGUI;

public class Employee {
    private String name;
    private double hourlyRate;
    private int hoursWorked;
    public void setName(String name) {
        this.name = name;
    }
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}

