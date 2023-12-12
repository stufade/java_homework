class ThrowsDemo {
    public void getDetails(String key) {
        if (key == null) {
            throw new NullPointerException("null key in getDetails");
        }
    }
}
public class number5 {
    public static void main(String[] args) {
        ThrowsDemo demo = new ThrowsDemo();

        try {
            demo.getDetails(null);
        } catch (NullPointerException e) {
            System.err.println("Caught NullPointerException: " + e.getMessage());
        }
    }
}


