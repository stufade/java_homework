import java.util.Arrays;
import java.util.Scanner;

// Пользовательское исключение для случая, если студент не найден
class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}
// Пользовательское исключение для пустой строки
class EmptyStringException extends Exception {
    public EmptyStringException(String message) {
        super(message);
    }
}

// Класс, представляющий студента
class Student {
    private String name;
    private double gpa;
    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }
    public String getName() {
        return name;
    }
    public double getGPA() {
        return gpa;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}

// Класс для управления списком студентов
class LabClass {
    private Student[] students;
    public Student[] getStudents() {
        return students;
    }
    public LabClass(Student[] students) {
        this.students = students;
    }
    public Student findStudentByName(String name) throws StudentNotFoundException, EmptyStringException {
        if (name.isEmpty()) {
            throw new EmptyStringException("Имя студента не может быть пустым.");
        }
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        throw new StudentNotFoundException("Студент с именем " + name + " не найден.");
    }
}

// Интерфейс для взаимодействия с пользователем
interface LabClassUI {
    void run();
}

// Реализация интерфейса LabClassUI
class LabClassConsoleUI implements LabClassUI {
    private LabClass labClass;
    private Scanner scanner;
    public LabClassConsoleUI(LabClass labClass) {
        this.labClass = labClass;
        this.scanner = new Scanner(System.in);
    }
    @Override
    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.print("Введите команду (find для поиска, sort для сортировки, exit для выхода): ");
            String command = scanner.nextLine().trim();

            switch (command.toLowerCase()) {
                case "find":
                    searchStudent();
                    break;
                case "sort":
                    sortStudents();
                    break;
                case "exit":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Неверная команда. Попробуйте еще раз.");
            }
        }
        scanner.close();
        System.out.println("Программа завершена.");
    }
    private void searchStudent() {
        System.out.print("Введите имя студента: ");
        String input = scanner.nextLine().trim();
        try {
            Student student = labClass.findStudentByName(input);
            System.out.println("Студент найден: " + student);
        } catch (EmptyStringException | StudentNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
    private void sortStudents() {
        System.out.println("\nНеотсортированный список студентов:");
        for (Student student : labClass.getStudents()) {
            System.out.println(student);
        }
        // Сортировка студентов по убыванию GPA
        Arrays.sort(labClass.getStudents(), (s1, s2) -> Double.compare(s2.getGPA(), s1.getGPA()));
        // Вывод отсортированного списка студентов
        System.out.println("\nОтсортированный список студентов:");
        for (Student student : labClass.getStudents()) {
            System.out.println(student);
        }
    }
}

// Класс для запуска приложения
public class LabClassDriver {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Alice", 3.9),
                new Student("Bob", 3.5),
                new Student("Charlie", 4.0)
        };

        LabClass labClass = new LabClass(students);
        LabClassUI labClassUI = new LabClassConsoleUI(labClass);
        labClassUI.run();
    }
}
