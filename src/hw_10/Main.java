package hw_10;

// Абстрактный класс Dish
abstract class Dish {
    private String material;
    private String color;

    public Dish(String material, String color) {
        this.material = material;
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public String getColor() {
        return color;
    }

    // Абстрактный метод для использования посуды
    public abstract void use();
}

// Подкласс для тарелки
class Plate extends Dish {
    private int diameter;

    public Plate(String material, String color, int diameter) {
        super(material, color);
        this.diameter = diameter;
    }

    @Override
    public void use() {
        System.out.println("Используем тарелку для подачи еды.");
    }

    public int getDiameter() {
        return diameter;
    }
}

// Подкласс для чашки
class Cup extends Dish {
    private int volume;

    public Cup(String material, String color, int volume) {
        super(material, color);
        this.volume = volume;
    }

    @Override
    public void use() {
        System.out.println("Пьем из чашки.");
    }

    public int getVolume() {
        return volume;
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаем объекты разных видов посуды
        Dish dish1 = new Plate("Керамика", "Белый", 20);
        Dish dish2 = new Cup("Стекло", "Прозрачный", 250);

        // Используем посуду и получаем информацию о ней
        dish1.use();
        System.out.println("Тарелка диаметром " + ((Plate) dish1).getDiameter() + " см, сделана из "
                + dish1.getMaterial() + ", цвет: " + dish1.getColor());

        dish2.use();
        System.out.println("Чашка объемом " + ((Cup) dish2).getVolume() + " мл, сделана из " + dish2.getMaterial()
                + ", цвет: " + dish2.getColor());
    }
}
