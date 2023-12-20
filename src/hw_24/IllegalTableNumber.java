package hw_24;

public class IllegalTableNumber extends RuntimeException {
    public IllegalTableNumber(int n) {
        super("Не существует столика с номером " + n);
    }
}
