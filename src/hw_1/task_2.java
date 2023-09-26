package hw_1;

import java.util.Scanner;

public class task_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        if (!scanner.hasNextInt()){
            System.out.print("Ошибка! Введены неправильные параметры");
            System.exit(-1);
        }

        int n = scanner.nextInt();

        int[] arr = new int[n];

        int i = 0;
        do {
            System.out.print("Введите элемент массива №" + (i + 1) + ": ");

            if (!scanner.hasNextInt()){
                System.out.print("Ошибка! Введены неправильные параметры");
                System.exit(-1);
            }

            arr[i] = scanner.nextInt();
            i++;
        } while (i < n);

        int sum = 0;
        i = 0;
        while (i < n) {
            sum += arr[i];
            i++;
        }

        int max = arr[0];
        int min = arr[0];

        i = 1;
        while (i < n) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
            i++;
        }

        System.out.println("Сумма элементов массива: " + sum);
        System.out.println("Максимальный элемент массива: " + max);
        System.out.println("Минимальный элемент массива: " + min);

        scanner.close();
    }
}