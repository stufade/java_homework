package hw_5;

import java.util.Scanner;

public class task_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите натуральное число N:");
        int N = scanner.nextInt();

        System.out.println("Цифры числа N в обратном порядке:");
        printDigitsReverse(N);

        scanner.close();
    }

    public static void printDigitsReverse(int num) {
        if (num == 0) {
            return;
        }

        int lastDigit = num % 10;
        System.out.println(lastDigit);
        printDigitsReverse(num / 10);
    }
}
