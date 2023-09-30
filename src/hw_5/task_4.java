package hw_5;

import java.util.Scanner;

public class task_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите натуральное число N:");
        int N = scanner.nextInt();

        System.out.println("Цифры числа N по одной:");
        printDigits(N);

        scanner.close();
    }

    public static void printDigits(int num) {
        if (num == 0) {
            return;
        }

        int lastDigit = num % 10;
        printDigits(num / 10);
        System.out.println(lastDigit);
    }
}
