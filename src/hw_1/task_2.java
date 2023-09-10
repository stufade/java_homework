package hw_1;

import java.util.Scanner;

public class task_2 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        int sum = 0,
            min = Integer.MAX_VALUE,
            max = 0;
        Scanner in = new Scanner(System.in);

        int i = 0;
        while (i < arr.length) {
            arr[i] = in.nextInt();
            sum += arr[i];
            i++;
        }

        i = 0;
        while (i < arr.length) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            i++;
        }
        System.out.printf("While loop results:\nsum = %d\nmin = %d\nmax = %d", sum, min, max);

        sum = 0;
        min = Integer.MAX_VALUE;
        max = 0;

        i = 0;
        do {
            arr[i] = in.nextInt();
            sum += arr[i];
            i++;
        } while (i < arr.length);

        i = 0;
        do {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            i++;
        } while (i < arr.length);

        System.out.printf("Do While loop results:\nsum = %d\nmin = %d\nmax = %d", sum, min, max);
    }
}