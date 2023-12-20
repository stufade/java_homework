package hw_24;

public class OrderAlreadyAddedException extends Exception {
    public OrderAlreadyAddedException() {
        super("С указанным столиком уже связан заказ");
    }
}
