package hw_21;

import java.util.Arrays;

// Класс, представляющий модуль с циклической очередью на массиве
class ArrayQueueModule {
    private static Object[] elements = new Object[10];
    private static int size = 0;
    private static int head = 0;
    private static int tail = 0;

    // Предусловие: элемент не равен null
    // Постусловие: элемент добавлен в конец очереди
    public static void enqueue(Object element) {
        assert element != null;
        ensureCapacity(size + 1);
        elements[tail] = element;
        tail = (tail + 1) % elements.length;
        size++;
    }

    // Предусловие: очередь не пуста
    // Постусловие: удален и возвращен первый элемент очереди
    public static Object dequeue() {
        assert size > 0;
        Object element = elements[head];
        elements[head] = null;
        head = (head + 1) % elements.length;
        size--;
        return element;
    }

    public static Object element() {
        assert size > 0;
        return elements[head];
    }

    public static int size() {
        return size;
    }

    public static boolean isEmpty() {
        return size == 0;
    }

    public static void clear() {
        Arrays.fill(elements, null);
        size = 0;
        head = 0;
        tail = 0;
    }

    private static void ensureCapacity(int capacity) {
        if (capacity > elements.length) {
            int newCapacity = Math.max(2 * elements.length, capacity);
            elements = Arrays.copyOf(elements, newCapacity);
            if (head > tail) {
                System.arraycopy(elements, head, elements, head + elements.length, elements.length - head);
                head += elements.length;
            }
        }
    }
}

// Класс, представляющий очередь в виде абстрактного типа данных (ADT)
class ArrayQueueADT {
    private Object[] elements = new Object[10];
    private int size = 0;
    private int head = 0;
    private int tail = 0;

    public static void enqueue(ArrayQueueADT queue, Object element) {
        assert element != null;
        ensureCapacity(queue, queue.size + 1);
        queue.elements[queue.tail] = element;
        queue.tail = (queue.tail + 1) % queue.elements.length;
        queue.size++;
    }

    public static Object dequeue(ArrayQueueADT queue) {
        assert queue.size > 0;
        Object element = queue.elements[queue.head];
        queue.elements[queue.head] = null;
        queue.head = (queue.head + 1) % queue.elements.length;
        queue.size--;
        return element;
    }

    public static Object element(ArrayQueueADT queue) {
        assert queue.size > 0;
        return queue.elements[queue.head];
    }

    public static int size(ArrayQueueADT queue) {
        return queue.size;
    }

    public static boolean isEmpty(ArrayQueueADT queue) {
        return queue.size == 0;
    }

    public static void clear(ArrayQueueADT queue) {
        Arrays.fill(queue.elements, null);
        queue.size = 0;
        queue.head = 0;
        queue.tail = 0;
    }

    private static void ensureCapacity(ArrayQueueADT queue, int capacity) {
        if (capacity > queue.elements.length) {
            int newCapacity = Math.max(2 * queue.elements.length, capacity);
            queue.elements = Arrays.copyOf(queue.elements, newCapacity);
            if (queue.head > queue.tail) {
                System.arraycopy(queue.elements, queue.head, queue.elements, queue.head + queue.elements.length,
                        queue.elements.length - queue.head);
                queue.head += queue.elements.length;
            }
        }
    }
}

// Класс, представляющий очередь в виде класса
class ArrayQueue {
    private Object[] elements = new Object[10];
    private int size = 0;
    private int head = 0;
    private int tail = 0;

    public void enqueue(Object element) {
        assert element != null;
        ensureCapacity(size + 1);
        elements[tail] = element;
        tail = (tail + 1) % elements.length;
        size++;
    }

    public Object dequeue() {
        assert size > 0;
        Object element = elements[head];
        elements[head] = null;
        head = (head + 1) % elements.length;
        size--;
        return element;
    }

    public Object element() {
        assert size > 0;
        return elements[head];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
        head = 0;
        tail = 0;
    }

    private void ensureCapacity(int capacity) {
        if (capacity > elements.length) {
            int newCapacity = Math.max(2 * elements.length, capacity);
            elements = Arrays.copyOf(elements, newCapacity);
            if (head > tail) {
                System.arraycopy(elements, head, elements, head + elements.length, elements.length - head);
                head += elements.length;
            }
        }
    }
}

public class QueueTest {
    public static void main(String[] args) {
        testArrayQueueModule();
        testArrayQueueADT();
        testArrayQueue();
    }

    private static void testArrayQueueModule() {
        ArrayQueueModule.clear();

        ArrayQueueModule.enqueue("A");
        ArrayQueueModule.enqueue("B");
        ArrayQueueModule.enqueue("C");

        System.out.println("Testing ArrayQueueModule:");
        System.out.println("Size: " + ArrayQueueModule.size());
        System.out.println("Element: " + ArrayQueueModule.element());
        System.out.println("Dequeue: " + ArrayQueueModule.dequeue());

        ArrayQueueModule.clear();
        System.out.println("Is Empty: " + ArrayQueueModule.isEmpty());
        System.out.println();
    }

    private static void testArrayQueueADT() {
        ArrayQueueADT queue = new ArrayQueueADT();
        ArrayQueueADT.clear(queue);

        ArrayQueueADT.enqueue(queue, "X");
        ArrayQueueADT.enqueue(queue, "Y");
        ArrayQueueADT.enqueue(queue, "Z");

        System.out.println("Testing ArrayQueueADT:");
        System.out.println("Size: " + ArrayQueueADT.size(queue));
        System.out.println("Element: " + ArrayQueueADT.element(queue));
        System.out.println("Dequeue: " + ArrayQueueADT.dequeue(queue));

        ArrayQueueADT.clear(queue);
        System.out.println("Is Empty: " + ArrayQueueADT.isEmpty(queue));
        System.out.println();
    }

    private static void testArrayQueue() {
        ArrayQueue queue = new ArrayQueue();
        queue.clear();

        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");

        System.out.println("Testing ArrayQueue:");
        System.out.println("Size: " + queue.size());
        System.out.println("Element: " + queue.element());
        System.out.println("Dequeue: " + queue.dequeue());

        queue.clear();
        System.out.println("Is Empty: " + queue.isEmpty());
        System.out.println();
    }
}
