package EmployeeMVC;

public class MVCEmployeeDemo {
    public static void main(String[] args) {
        // Создаем объект модели
        Employee employee = new Employee("John", 20.0, 40);
        // Создаем объект представления
        EmployeeView employeeView = new EmployeeView();
        // Создаем контроллер и связываем его с моделью и представлением
        EmployeeController controller = new EmployeeController(employee, employeeView);
        // Выводим информацию о сотруднике
        controller.updateView();
        // Изменяем данные сотрудника через контроллер
        controller.setEmployeeName("Jane");
        controller.setEmployeeHourlyRate(25.0);
        controller.setEmployeeHoursWorked(45);
        // Выводим обновленную информацию о сотруднике
        controller.updateView();
    }
}
