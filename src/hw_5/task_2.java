package hw_5;

import java.util.Scanner;

public class task_2 {
    public static void main(String[] args) {
        printUneven();
    }

    public static void printUneven() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        if (num == 0) {
            scanner.close();
            return;
        }

        if (num % 2 != 0) {
            System.out.println(num);
        }

        printUneven();
    }
}
