package hw_1;

public class task_3 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Аргументы отсутствуют.");
            System.exit(0);
        }
        System.out.println("Аргументы командной строки:");

        // Выводим аргументы в цикле for
        for (int i = 0; i < args.length; i++) {
            System.out.println("Аргумент " + (i + 1) + ": " + args[i]);
        }
    }
}