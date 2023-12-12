package hw_19;

import java.util.ArrayList;
import java.util.List;

public class ArrayToListConverter {
    public static List<String> arrayToList(String[] array) {
        List<String> list = new ArrayList<>();
        for (String element : array) {
            list.add(element);
        }
        return list;
    }

    public static List<Integer> arrayToList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int element : array) {
            list.add(element);
        }
        return list;
    }

    public static void main(String[] args) {

        // Пример для чисел
        int[] intArray = {5, 7, 9, 3, 1};
        List<Integer> intList = arrayToList(intArray);
        System.out.println("Список чисел: " + intList);

        // Пример для строк
        String[] stringArray = {"test", "word"};
        List<String> stringList = arrayToList(stringArray);
        System.out.println("Список строк: " + stringList);


    }
}

