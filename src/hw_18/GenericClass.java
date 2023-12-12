package hw_18;

public class GenericClass<T, V, K> {
    private T variableT;
    private V variableV;
    private K variableK;
    public GenericClass(T variableT, V variableV, K variableK) {
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
        GenericClass<Integer, String, Double> genericObject = new GenericClass<>(10, "Hello", 3.14);
        genericObject.printVariableTypes();
    }
}


