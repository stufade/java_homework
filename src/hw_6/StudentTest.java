package hw_6;
class Student {
    private int iDNumber;
    private String name;

    public Student(int iDNumber, String name) {
        this.iDNumber = iDNumber;
        this.name = name;
    }

    public int getIDNumber() {
        return iDNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "iDNumber=" + iDNumber +
                ", name='" + name + '\'' +
                '}';
    }
}

public class StudentTest {
    public static void main(String[] args) {
        // Создаем массив студентов
        Student[] students = {
                new Student(3, "Alice"),
                new Student(1, "Bob"),
                new Student(2, "Charlie"),
                new Student(4, "David"),
        };

        // Выводим несортированный массив
        System.out.println("Неотсортированный массив:");
        printArray(students);

        // Сортируем массив по iDNumber методом сортировки вставками
        insertionSort(students);

        // Выводим отсортированный массив
        System.out.println("\nОтсортированный массив по iDNumber:");
        printArray(students);
    }

    public static void insertionSort(Student[] students) {
        int n = students.length;
        for (int i = 1; i < n; i++) {
            Student key = students[i];
            int j = i - 1;
            while (j >= 0 && students[j].getIDNumber() > key.getIDNumber()) {
                students[j + 1] = students[j];
                j = j - 1;
            }
            students[j + 1] = key;
        }
    }

    public static void printArray(Student[] students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
