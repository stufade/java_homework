package hw_6;

import java.util.Arrays;
import java.util.Comparator;

class StudentWithGPA {
    private String name;
    private double gpa;

    public StudentWithGPA(String name, double gpa) {
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

class SortingStudentsByGPA implements Comparator<StudentWithGPA> {
    @Override
    public int compare(StudentWithGPA student1, StudentWithGPA student2) {
        // Сравниваем студентов по убыванию GPA
        if (student1.getGPA() < student2.getGPA()) {
            return 1;
        } else if (student1.getGPA() > student2.getGPA()) {
            return -1;
        }
        return 0;
    }
}

public class StudentTest2 {
    public static void main(String[] args) {
        StudentWithGPA[] students = {
                new StudentWithGPA("Alice", 3.9),
                new StudentWithGPA("Bob", 3.5),
                new StudentWithGPA("Charlie", 4.0),
                new StudentWithGPA("David", 3.7),
        };

        System.out.println("Неотсортированный список студентов:");
        for (StudentWithGPA student : students) {
            System.out.println(student);
        }
        Arrays.sort(students, new SortingStudentsByGPA());

        System.out.println("\nОтсортированный список студентов:");
        for (StudentWithGPA student : students) {
            System.out.println(student);
        }
    }
}
