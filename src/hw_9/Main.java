package hw_9;

// Интерфейс Nameable
interface Nameable {
    String getName();
}

// Пример класса, представляющего планету
class Planet implements Nameable {
    private String name;

    public Planet(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

// Пример класса, представляющего машину
class Car implements Nameable {
    private String modelName;

    public Car(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public String getName() {
        return modelName;
    }
}

// Пример класса, представляющего животное
class Animal implements Nameable {
    private String species;

    public Animal(String species) {
        this.species = species;
    }

    @Override
    public String getName() {
        return species;
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаем объекты разных классов, реализующих интерфейс Nameable
        Nameable earth = new Planet("earth");
        Nameable toyotaCamry = new Car("Toyota Camry");
        Nameable lion = new Animal("Lion");

        // Вызываем метод getName() для каждого объекта
        System.out.println("Планета: " + earth.getName());
        System.out.println("Машина: " + toyotaCamry.getName());
        System.out.println("Животное: " + lion.getName());
    }
}
