package hw_12;

class Dog {
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

    public void bark() {
        System.out.println(name + " лает: Гав-гав!");
    }
}

public class DogTest {
    public static void main(String[] args) {
        Dog dog = new Dog("Барон", 3);

        System.out.println("Имя собаки: " + dog.getName());
        System.out.println("Возраст собаки: " + dog.getAge() + " года");

        dog.bark();
    }
}
