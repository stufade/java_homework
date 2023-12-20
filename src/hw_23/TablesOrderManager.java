package hw_23;

public class TablesOrderManager {
    Order[] tables = new Order[10];
    private int currentIndex = 0;

    void viewAllOrders() {
        for (int i = 0; i < tables.length; i++) {
            if (tables[i] != null) {
                System.out.println("Номер стола: " + i + 1);
                System.out.println(tables[i].viewOrder());
                System.out.println("-----------------");
            }
        }
    }

    void add(Order smNew) {
        if (this.currentIndex + 1 > this.tables.length) {
            Order[] temporaryOrderArray = new Order[this.tables.length * 2];
            System.arraycopy(this.tables, 0, temporaryOrderArray, 0, tables.length);
            this.tables = temporaryOrderArray;
        }
        this.tables[this.currentIndex] = smNew;
        this.currentIndex += 1;
    }

    String getOrderOfTable(int num) {
        if (num < tables.length + 1) {
            return tables[num - 1].viewOrder();
        }
        return null;
    }

    void addDishForTable(int tableNumber, Item item) {
        if (tableNumber < tables.length + 1) {
            tables[tableNumber - 1].add(item);
        }
    }

    void removeOrder(int number) {
        if (number < tables.length + 1) {
            Order[] temporaryOrderArray = new Order[this.tables.length];
            for (int i = tables.length - 1, k = 0; i > 0; i--) {
                if (i != number) {
                    temporaryOrderArray[k] = this.tables[i];
                    k++;
                    this.currentIndex = k;
                }
            }
            this.currentIndex++;
            this.tables = reverseCopyArray(temporaryOrderArray);
        }
    }

    public Order[] reverseCopyArray(Order[] originalArray) {
        int length = originalArray.length;
        Order[] reversedArray = new Order[length];

        for (int i = 0; i < length; i++) {
            reversedArray[i] = originalArray[length - 1 - i];
        }

        return reversedArray;
    }

    Integer freeTableNumber() {
        return tables.length;
    }

    Integer[] freeTableNumbers() {
        Integer[] numbers = new Integer[5];
        for (int i = 0; i < 5; i++) {
            numbers[i] = i + tables.length;
        }
        return numbers;
    }

    Order[] getOrders() {
        return tables;
    }

    Double ordersCostSummary() {
        double total = 0;
        for (int i = 0; i < tables.length; i++) {
            total += tables[i].coastTotal();
        }
        return total;
    }

    Integer dishQuantity(String name) {
        int hits = 0;
        for (int i = 0; i < tables.length; i++) {
            hits += tables[i].dishQuantity(name);
        }
        return hits;
    }
}
