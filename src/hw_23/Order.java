package hw_23;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Order {
    private Integer currentIndex = 0;
    private Item[] orderArray = new Item[10];

    int getSizeOfOrder() {
        return orderArray.length;
    }

    Order() {
        makeOrder();
    }

    void makeOrder() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Добро пожаловать");
        System.out.println("1 - Для добавления блюда");
        System.out.println("2 - Для добавления напитка");
        System.out.println("3 - Для завершения");

        int orderType = 0;
        String name;
        String description = "", acceptation;
        while (true) {
            System.out.print("Введите тип заказа: ");
            orderType = sc.nextInt();
            if (orderType == 1) {
                System.out.print("Введите название блюда: ");
                name = sc.next();
                System.out.print("Вы уверены, что хотите заказать \"" + name + "\" (Да/Нет): ");
                acceptation = sc.next();
                while (!acceptation.toLowerCase().equals("да")) {
                    if (!acceptation.toLowerCase().equals("нет")) {
                        System.out.println("Ошибка. Нераспознанная команда");
                    } else {
                        System.out.println("Перезапись заказа!");
                    }
                    System.out.print("Введите название блюда: ");
                    name = sc.next();
                    System.out.print("Вы уверены, что хотите заказать \"" + name + "\" (Да/Нет): ");
                    acceptation = sc.next();
                }
                System.out.print("Добавьте описание к блюду (По желанию): ");
                description = sc.next();
                this.add(new Dish(8, name, description));
                System.out.println("Добавлено блюдо \"" + name + "\"(" + description + ")");
                System.out.println(orderArray[0].getName());

            } else if (orderType == 2) {
                System.out.print("Введите название напитка: ");
                name = sc.next();
                System.out.print("Вы уверены, что хотите заказать \"" + name + "\" (Да/Нет): ");
                acceptation = sc.next();
                while (!acceptation.toLowerCase().equals("да")) {
                    if (!acceptation.toLowerCase().equals("нет")) {
                        System.out.println("Ошибка. Нераспознанная команда");
                    } else {
                        System.out.println("Перезапись заказа!");
                    }
                    System.out.print("Введите название напитка: ");
                    name = sc.next();
                    System.out.print("Вы уверены, что хотите заказать \"" + name + "\" (Да/Нет): ");
                    acceptation = sc.next();
                }
                System.out.print("Добавьте описание к напитку (По желанию): ");
                description = sc.next();
                this.add(new Dish(3, name, description));
                System.out.println("Добавлен напиток \"" + name + "\"(" + description + ")");
            } else if (orderType == 3) {
                break;
            }
        }

        while (true) {
            System.out.println("Давайте уточним ваш заказ: ");
            System.out.println(this.viewOrder());
            System.out.print("Все верно? (Да/Нет): ");
            acceptation = sc.next();
            while (!(acceptation.toLowerCase().equals("да") || acceptation.toLowerCase().equals("нет"))) {
                System.out.println("Нераспознаная команда. Допускается \"Да\" или \"Нет\" ");
                System.out.print("Все верно? (Да/Нет): ");
                acceptation = sc.next();
            }
            int orderTypeInner;
            if (acceptation.toLowerCase().equals("нет")) {
                System.out.println("Что вы хотите сделать?");
                System.out.println("1 - Добавить позицию");
                System.out.println("2 - Удалить позицию");
                System.out.println("3 - Удалить весь заказ");
                orderType = sc.nextInt();
                if (orderType == 1) {
                    System.out.print("Введите (1) чтобы добавить блюдо или (2) чтобы добавить напиток: ");
                    orderTypeInner = sc.nextInt();
                    // добавление напитка
                    if (orderTypeInner == 1) {
                        System.out.print("Введите название блюда: ");
                        name = sc.next();
                        System.out.print("Вы уверены, что хотите заказать \"" + name + "\" (Да/Нет): ");
                        acceptation = sc.next();
                        while (!acceptation.toLowerCase().equals("да")) {
                            if (!acceptation.toLowerCase().equals("нет")) {
                                System.out.println("Ошибка. Нераспознанная команда");
                            } else {
                                System.out.println("Перезапись заказа!");
                            }
                            System.out.print("Введите название блюда: ");
                            name = sc.next();
                            System.out.print("Вы уверены, что хотите заказать \"" + name + "\" (Да/Нет): ");
                            acceptation = sc.next();
                        }
                        System.out.print("Добавьте описание к блюду: ");
                        description = sc.next();
                        this.add(new Dish(19, name, description));
                        System.out.println("Добавлено блюдо \"" + name + "\"(" + description + ")");
                    } else if (orderTypeInner == 2) {
                        // добавление напитка
                        System.out.print("Введите название напитка: ");
                        name = sc.next();
                        System.out.print("Вы уверены, что хотите заказать \"" + name + "\" (Да/Нет): ");
                        acceptation = sc.next();
                        while (!acceptation.toLowerCase().equals("да")) {
                            if (!acceptation.toLowerCase().equals("нет")) {
                                System.out.println("Ошибка. Нераспознанная команда");
                            } else {
                                System.out.println("Перезапись заказа!");
                            }
                            System.out.print("Введите название напитка: ");
                            name = sc.next();
                            System.out.print("Вы уверены, что хотите заказать \"" + name + "\" (Да/Нет): ");
                            acceptation = sc.next();
                        }
                        System.out.print("Добавьте описание к напитку: ");
                        description = sc.next();

                        this.add(new Dish(15, name, description));
                        System.out.println("Добавлен напиток \"" + name + "\"(" + description + ")");
                    }
                } else if (orderType == 2) {
                    System.out.print("Какую позицию вы хотите удалить? ");
                    int position = sc.nextInt();
                    if (position - 1 < orderArray.length) {
                        this.remove(this.orderArray[position - 1]);
                        System.out.println("Позицию " + position + " удалена!");
                    }

                } else if (orderType == 3) {
                    Arrays.fill(orderArray, null);
                    System.out.println("Заказ очищен!");
                }
            }
            if (acceptation.toLowerCase().equals("да")) {
                break;
            }
        }
    }

    String viewOrder() {
        String result = "";
        for (int i = 0; i < orderArray.length; i++) {

            if (orderArray[i] != null) {
                result += i + 1;
                result += ") ";
                if (orderArray[i] instanceof Dish) {
                    result += "Блюдо: ";
                } else {
                    result += "Напиток: ";
                }
                result += orderArray[i].getName() + "(" + orderArray[i].getDescription() +
                        "), [" + orderArray[i].getPrice() + " руб.]\n";
            }
        }
        result += "Итого: " + this.coastTotal();
        return result;
    }

    boolean add(Item item) {
        if (this.currentIndex + 1 > this.orderArray.length) {
            Item[] temporaryOrderArray = new Item[this.orderArray.length * 2];
            System.arraycopy(this.orderArray, 0, temporaryOrderArray, 0, orderArray.length);
            this.orderArray = temporaryOrderArray;
        }
        this.orderArray[this.currentIndex] = item;
        this.currentIndex += 1;
        return true;
    }

    boolean remove(Item item) {
        Item[] temporaryOrderArray = new Item[this.orderArray.length];
        boolean deleted = false;
        for (int i = orderArray.length - 1, k = 0; i >= 0; i--) {
            if (orderArray[i] != null) {
                if (!orderArray[i].equals(item) || deleted) {
                    temporaryOrderArray[k] = this.orderArray[i];
                    k++;
                    this.currentIndex = k;
                } else {
                    deleted = true;
                }
            }
        }
        this.currentIndex++;
        this.orderArray = reverseCopyArray(temporaryOrderArray);

        return true;
    }

    public Item[] reverseCopyArray(Item[] originalArray) {
        int length = originalArray.length;
        Item[] reversedArray = new Item[length];

        for (int i = 0; i < length; i++) {
            reversedArray[i] = originalArray[length - 1 - i];
        }

        return reversedArray;
    }

    int removeAll(String dishName) {
        Item[] temporaryOrderArray = new Item[this.orderArray.length];
        int cnt = 0;
        for (int i = orderArray.length - 1, k = 0; i > 0; i--) {
            if (orderArray[i] != null) {
                if (!orderArray[i].getName().equals(dishName)) {
                    temporaryOrderArray[k] = this.orderArray[i];
                    k++;
                    this.currentIndex = k;
                }
            }
        }
        this.currentIndex++;
        this.orderArray = temporaryOrderArray;
        return cnt;
    }

    int dishQuantity() {
        int cnt = 0;
        for (int i = 0; i < this.orderArray.length; i++) {
            if (this.orderArray[i] instanceof Dish)
                cnt++;
        }
        return cnt;
    }

    int dishQuantity(String dishName) {
        int cnt = 0;
        for (int i = 0; i < this.orderArray.length; i++) {
            if (this.orderArray[i] instanceof Dish && this.orderArray[i].equals(dishName))
                cnt++;
        }
        return cnt;
    }

    Item[] getDishes() {
        Item[] temporaryOrderArray = new Item[this.orderArray.length];
        for (int i = 0, k = 0; i < this.orderArray.length; i++) {
            if (orderArray[i] instanceof Dish) {
                temporaryOrderArray[k] = this.orderArray[i];
                k++;
            }
        }
        return temporaryOrderArray;
    }

    double coastTotal() {
        int total = 0;
        for (Item item : orderArray) {
            if (item != null)
                total += item.getPrice();
        }
        return total;
    }

    String[] dishesName() {
        String[] names = new String[this.orderArray.length];
        int k = 0;
        for (Item element : this.getDishes()) {
            if (element != null) {
                names[k] = element.getName();
                k++;
            }
        }
        return names;
    }

    Item[] sortedDishesByCostDesc() {
        Item[] sortedArray = Arrays.copyOf(orderArray, orderArray.length);
        Arrays.sort(sortedArray, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                return Double.compare(item2.getPrice(), item1.getPrice());
            }
        });

        return sortedArray;
    }
}
