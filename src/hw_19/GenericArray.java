package hw_19;

public class GenericArray<T> {
    private T[] array;

    public GenericArray(int size) {
        array = (T[]) new Object[size];
    }

    public void set(int index, T value) {
        array[index] = value;
    }

    public T get(int index) {
        return array[index];
    }

    public int length() {
        return array.length;
    }

    public void printArray() {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public T getElement(int index) {
        if (index >= 0 && index < array.length) {
            return array[index];
        } else {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
    }

    public static void main(String[] args) {
        GenericArray<Integer> intArray = new GenericArray<>(5);
        intArray.set(0, 5);
        intArray.set(1, 2);
        intArray.set(2, 6);
        intArray.set(3, 14);
        intArray.set(4, 51);

        System.out.println("Integer Array:");
        intArray.printArray();

        int index = 1;
        try {
            Integer element = intArray.getElement(index);
            System.out.println("Element at index " + index + ": " + element);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index is out of bounds.");
        }
    }
}
