package hw_1;

public class task_4 {
    public static void main(String[] args) {
        double val = 0;
        for (int i = 1; i <= 10; i++) {
            val += (double) 1/i;
            System.out.printf("%,.2f\n", val);
        }
    }
}