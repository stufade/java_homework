package hw_5;

import java.util.Scanner;

public class task_1 {
    public static void main(String[] args) {
        int count = countOnes();
        System.out.println("Число 1 встречается " + count + " раз.");
    }

    public static int countOnes() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int count = 0;
        if (num == 0) {
            int nextNum = scanner.nextInt();
            if (nextNum == 0) {
                scanner.close();
                return 0;
            } else if (nextNum == 1) {
                count++;
            }
        }
        if (num == 1) {
            ++count;
        }
        count += countOnes();
        scanner.close();
        return count;
    }
}
