package hw_10;

// Абстрактный класс Furniture
abstract class Furniture {
    private String name;
    private double price;

    public Furniture(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Абстрактный метод для описания мебели
    public abstract String toString();
}

// Подкласс для стола
class Table extends Furniture {
    private int numberOfLegs;

    public Table(String name, double price, int numberOfLegs) {
        super(name, price);
        this.numberOfLegs = numberOfLegs;
    }

    @Override
    public String toString() {
        return ("Стол " + getName() + " с " + numberOfLegs + " ногами. Цена: $" + getPrice());
    }
}

// Подкласс для стула
class Chair extends Furniture {
    private boolean hasArmrests;

    public Chair(String name, double price, boolean hasArmrests) {
        super(name, price);
        this.hasArmrests = hasArmrests;
    }

    @Override
    public String toString() {
        String armrestsInfo = hasArmrests ? "с подлокотниками" : "без подлокотников";
        return ("Стул " + getName() + " " + armrestsInfo + ". Цена: $" + getPrice());
    }
}

// Класс FurnitureShop
class FurnitureShop {
    private Furniture[] inventory;

    public FurnitureShop(int capacity) {
        inventory = new Furniture[capacity];
    }

    public Furniture[] getInventory() {
        return inventory;
    }

    public void addFurniture(Furniture furniture) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) {
                inventory[i] = furniture;
                System.out.println("Добавлена мебель: " + furniture.getName());
                return;
            }
        }
        System.out.println("Магазин полон, не удалось добавить мебель: " + furniture.getName());
    }

    public void sellFurniture(String name) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null && inventory[i].getName().equals(name)) {
                System.out.println("Продана мебель: " + inventory[i].getName());
                inventory[i] = null;
                return;
            }
        }
        System.out.println("Мебель с именем " + name + " не найдена в магазине.");
    }
}

public class Main3 {
    public static void main(String[] args) {
        // Создаем мебельные объекты
        Furniture table = new Table("Деревянный стол", 150.0, 4);
        Furniture chair = new Chair("Кресло", 80.0, true);

        // Создаем магазин мебели
        FurnitureShop furnitureShop = new FurnitureShop(10);

        // Добавляем мебель в магазин
        furnitureShop.addFurniture(table);
        furnitureShop.addFurniture(chair);

        // Продаем мебель
        furnitureShop.sellFurniture("Деревянный стол");

        // Выводим информацию о мебели в магазине
        System.out.println("Мебель в магазине:");
        for (Furniture item : furnitureShop.getInventory()) {
            if (item != null) {
                System.out.println(item);
            }
        }
    }
}
