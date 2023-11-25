package hw_13;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FilesApp {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Введите команду:\n" +
                    "1 - чтение\n2 - запись в файл\n" +
                    "3 - перезапись существуещего файла\n" +
                    "0 - выход");
            int numAction;
            Scanner scanner = new Scanner(System.in);
            numAction = scanner.nextInt();
            scanner.nextLine();
            switch (numAction) {
                case (1):
                    try (FileReader reader = new FileReader("text.txt")) {
                        // чтение по символам
                        int c;
                        while ((c = reader.read()) != -1) {
                            System.out.print((char) c);
                        }
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case (2):
                    try (FileWriter writer = new FileWriter("text.txt", true)) {
                        // запись всей строки
                        System.out.println("Введите строку для записи");
                        String text = scanner.nextLine();
                        writer.write(text);
                        // запись по символам
                        writer.append('\n');
                        writer.flush();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 3:
                    try (FileWriter writer = new FileWriter("text.txt", false)) {
                        // запись всей строки
                        System.out.println("Введите строку для записи");
                        String text = scanner.nextLine();
                        writer.write(text);
                        // запись по символам
                        writer.append('\n');
                        writer.flush();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 0:
                    break;
            }
            scanner.close();
        }
    }
}