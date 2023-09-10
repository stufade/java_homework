package hw_1;

import java.util.Scanner;

public class task_1 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        int sum = 0;
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
            sum += arr[i];
        }

        float average = (float) sum / arr.length;

        System.out.println(sum);
        System.out.println(average);
    }
}