package EmployeeGUI;

public class MVCEmployee {
    public static void main(String[] args) {
        Employee model = new Employee();
        EmployeeView view = new EmployeeView();
        EmployeeController controller = new EmployeeController(model, view);
    }
}
