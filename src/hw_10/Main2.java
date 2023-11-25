package hw_10;

// Абстрактный класс Dog
abstract class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Абстрактный метод для описания голоса собаки
    public abstract String toString();
}

// Подкласс для породы Лабрадор
class Labrador extends Dog {
    public Labrador(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Лабрадор по имени " + getName() + " лает: Гав-гав!";
    }
}

// Подкласс для породы Бульдог
class Bulldog extends Dog {
    public Bulldog(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Бульдог по имени " + getName() + " лает: Гр-р-р!";
    }
}

public class Main2 {
    public static void main(String[] args) {
        // Создаем объекты разных пород собак
        Dog dog1 = new Labrador("Рекс", 3);
        Dog dog2 = new Bulldog("Спайк", 5);

        // Вызываем метод bark() для каждой собаки
        System.out.println(dog1);
        System.out.println(dog2);

        // Выводим информацию о каждой собаке
        System.out.println(dog1.getName() + " возраст: " + dog1.getAge() + " года");
        System.out.println(dog2.getName() + " возраст: " + dog2.getAge() + " лет");
    }
}
