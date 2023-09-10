package hw_1;

import java.util.Scanner;

class FactorialCounter {
    double count(int num) {
        double fact = 1;
        for (int i = 2; i <= num; i++) {
            fact = fact * i;
        }
        return fact;
    }
}

public class task_5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        FactorialCounter c = new FactorialCounter();

        System.out.println(c.count(n));
    }
}