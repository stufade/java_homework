package hw_5;

import java.util.Scanner;

public class task_3 {
    public static void main(String[] args) {
        printUnevenPositionNumbers();
    }

    public static void printUnevenPositionNumbers() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        if (num == 0) {
            scanner.close();
            return;
        }

        System.out.println(num);

        int nextNum = scanner.nextInt();
        if (nextNum == 0) {
            scanner.close();
            return;
        }

        printUnevenPositionNumbers();
    }
}
