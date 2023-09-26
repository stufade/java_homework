package hw_1;

import java.util.Scanner;

public class task_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число - количество элементов массива: ");
        int sizeArray;
        if (!scanner.hasNextInt()) {
            System.out.println("Ошибка! Введено нецелое число");
            System.exit(-1);
        }

        sizeArray = scanner.nextInt();
        int[] array = new int[sizeArray];
        int sum = 0;
        for (int i = 0; i < sizeArray; i++) {
            System.out.print("Введите значение " + (i + 1) + " -го элемента массива: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка! Введено нецелое число");
                System.exit(-1);
            }
            array[i] = scanner.nextInt();
            sum += array[i];
        }

        double average = (double) sum / sizeArray;

        System.out.println("Сумма элементов массива: " + sum);
        System.out.println("Среднее арифметическое элементов массива: " + average);

        scanner.close();
    }
}
