package hw_11;

// Класс, описывающий голову человека
class Head {
    private String eyeColor; // Цвет глаз
    private int numberOfEyes; // Количество глаз
    private String hairColor; // Цвет волос

    // Конструктор класса
    public Head(String eyeColor, int numberOfEyes, String hairColor) {
        this.eyeColor = eyeColor;
        this.numberOfEyes = numberOfEyes;
        this.hairColor = hairColor;
    }

    // Методы для получения свойств головы
    public String getEyeColor() {
        return eyeColor;
    }

    public int getNumberOfEyes() {
        return numberOfEyes;
    }

    public String getHairColor() {
        return hairColor;
    }
}

// Класс, описывающий ногу человека
class Leg {
    private int length; // Длина ноги

    // Конструктор класса
    public Leg(int length) {
        this.length = length;
    }

    // Метод для получения длины ноги
    public int getLength() {
        return length;
    }
}

// Класс, описывающий руку человека
class Hand {
    private int fingers; // Количество пальцев на руке

    // Конструктор класса
    public Hand(int fingers) {
        this.fingers = fingers;
    }

    // Метод для получения количества пальцев на руке
    public int getFingers() {
        return fingers;
    }
}

// Класс, описывающий тело человека
class Human {
    private Head head; // Голова человека
    private Leg leftLeg; // Левая нога
    private Leg rightLeg; // Правая нога
    private Hand leftHand; // Левая рука
    private Hand rightHand; // Правая рука

    public Human(Head head, Leg leftLeg, Leg rightLeg, Hand leftHand, Hand rightHand) {
        this.head = head;
        this.leftLeg = leftLeg;
        this.rightLeg = rightLeg;
        this.leftHand = leftHand;
        this.rightHand = rightHand;
    }

    public Head getHead() {
        return head;
    }

    public Leg getLeftLeg() {
        return leftLeg;
    }

    public Leg getRightLeg() {
        return rightLeg;
    }

    public Hand getLeftHand() {
        return leftHand;
    }

    public Hand getRightHand() {
        return rightHand;
    }
}

public class HumanTest {
    public static void main(String[] args) {

        Head head = new Head("Brown", 2, "Black");
        Leg leftLeg = new Leg(100);
        Leg rightLeg = new Leg(101);
        Hand leftHand = new Hand(5);
        Hand rightHand = new Hand(5);

        Human person = new Human(head, leftLeg, rightLeg, leftHand, rightHand);

        System.out.println("Цвет глаз: " + person.getHead().getEyeColor());
        System.out.println("Количество глаз: " + person.getHead().getNumberOfEyes());
        System.out.println("Цвет волос: " + person.getHead().getHairColor());
        System.out.println("Длина левой ноги: " + person.getLeftLeg().getLength() + " см");
        System.out.println("Длина правой ноги: " + person.getRightLeg().getLength() + " см");
        System.out.println("Количество пальцев на левой руке: " + person.getLeftHand().getFingers());
        System.out.println("Количество пальцев на правой руке: " + person.getRightHand().getFingers());
    }
}
