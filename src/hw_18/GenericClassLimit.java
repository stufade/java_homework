package hw_18;

import java.io.Serializable;

class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public Animal() {
        this.name = "";
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}

public class GenericClassLimit<T extends Comparable<T>, V extends Animal & Serializable, K> {
    private T variableT;
    private V variableV;
    private K variableK;
    public GenericClassLimit(T variableT, V variableV, K variableK) {
        this.variableT = variableT;
        this.variableV = variableV;
        this.variableK = variableK;
    }
    public void printVariableTypes() {
        System.out.println("Type of variableT: " + variableT.getClass().getName());
        System.out.println("Type of variableV: " + variableV.getClass().getName());
        System.out.println("Type of variableK: " + variableK.getClass().getName());
    }

    public static void main(String[] args) {
        GenericClass<Integer, Animal, String> genericObject = new GenericClass<>(10, new Animal(), "Hello");
        genericObject.printVariableTypes();
    }
}

