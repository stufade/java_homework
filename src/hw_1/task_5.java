package hw_1;

import java.util.Scanner;

public class task_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число для определения факториала: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Введены неправильные параметры.");
            System.exit(-1);
        }
        int number = scanner.nextInt();
        long factorial = calculateFactorial(number);

        System.out.println("Факториал числа " + number + " равен " + factorial);
    }

    public static long calculateFactorial(int n) {
        if (n < 1 || n > 20) {
            System.out.println("Введены неправильные параметры. Невозможно определить факториал");
            System.exit(-1);
        }
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}