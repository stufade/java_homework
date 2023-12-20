package hw_23;

public class Main {
    public static void main(String[] args) {
        Order ord = new Order();
        TablesOrderManager t = new TablesOrderManager();
        t.add(ord);
        t.viewAllOrders();
    }
}