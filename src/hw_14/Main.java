package hw_14;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Интерфейс, представляющий методы для управления списком ожидания.
 * 
 * @param <T> Тип элементов в списке ожидания.
 */
interface IWaitList<T> {
    /**
     * Добавляет элемент в список ожидания.
     * 
     * @param element Элемент для добавления.
     */
    void add(T element);

    /**
     * Удаляет и возвращает следующий элемент из списка ожидания.
     * 
     * @return Удаленный элемент.
     */
    T remove();

    /**
     * Проверяет, содержится ли элемент в списке ожидания.
     * 
     * @param element Элемент для проверки.
     * @return true, если элемент содержится в списке ожидания, иначе false.
     */
    boolean contains(T element);

    /**
     * Проверяет, содержатся ли все элементы из коллекции в списке ожидания.
     * 
     * @param elements Коллекция элементов для проверки.
     * @return true, если все элементы из коллекции содержатся в списке ожидания,
     *         иначе false.
     */
    boolean containsAll(Collection<T> elements);

    /**
     * Проверяет, пуст ли список ожидания.
     * 
     * @return true, если список ожидания пуст, иначе false.
     */
    boolean isEmpty();
}

/**
 * Реализация интерфейса IWaitList с использованием связанного списка.
 * 
 * @param <T> Тип элементов в списке ожидания.
 */
class WaitList<T> implements IWaitList<T> {
    protected LinkedList<T> list = new LinkedList<>();

    public WaitList() {
    }

    public WaitList(Collection<T> elements) {
        list.addAll(elements);
    }

    @Override
    public void add(T element) {
        list.add(element);
    }

    @Override
    public T remove() {
        return list.poll();
    }

    @Override
    public boolean contains(T element) {
        return list.contains(element);
    }

    @Override
    public boolean containsAll(Collection<T> elements) {
        return list.containsAll(elements);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}

/**
 * Реализация интерфейса IWaitList с ограничением по размеру списка ожидания.
 * 
 * @param <T> Тип элементов в списке ожидания.
 */
class BoundedWaitList<T> extends WaitList<T> {
    private int capacity;

    public BoundedWaitList(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void add(T element) {
        if (list.size() < capacity) {
            super.add(element);
        } else {
            System.out.println("Wait list is full. Cannot add more elements.");
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public String toString() {
        return list.toString();
    }
}

/**
 * Реализация интерфейса IWaitList с возможностью перемещения элементов в конец
 * списка.
 * 
 * @param <T> Тип элементов в списке ожидания.
 */
class UnfairWaitList<T> extends WaitList<T> {
    public UnfairWaitList() {
        super();
    }

    public void remove(T element) {
        list.remove(element);
    }

    public void moveToBack(T element) {
        list.remove(element);
        list.add(element);
    }

    public String toString() {
        return list.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        // Используем WaitList
        WaitList<Integer> waitList = new WaitList<>();
        waitList.add(1);
        waitList.add(2);
        System.out.println(waitList.contains(1)); // true
        System.out.println(waitList.remove()); // 1

        // Используем BoundedWaitList
        BoundedWaitList<Integer> boundedWaitList = new BoundedWaitList<>(2);
        boundedWaitList.add(1);
        boundedWaitList.add(2);
        boundedWaitList.add(3); // Ошибка: список ожидания полон

        // Используем UnfairWaitList
        UnfairWaitList<Integer> unfairWaitList = new UnfairWaitList<>();
        unfairWaitList.add(1);
        unfairWaitList.add(2);
        System.out.println(unfairWaitList);
        unfairWaitList.moveToBack(1);
        unfairWaitList.remove(1);
        System.out.println(unfairWaitList.remove()); // 2
        System.out.println(unfairWaitList.isEmpty());
    }
}
