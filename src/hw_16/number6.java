class ThrowsDemo6 {
    public void printMessage(String key) {
        String message = getDetails(key);
        System.out.println(message);
    }
    public String getDetails(String key) {
        if (key == null) {
            throw new NullPointerException("null key in getDetails");
        }
        return "data for " + key;
    }
}
public class number6 {
    public static void main(String[] args) {
        ThrowsDemo6 demo = new ThrowsDemo6();
        try {
            demo.printMessage("ValidKey");
        } catch (NullPointerException e) {
            System.err.println("Caught NullPointerException: " + e.getMessage());
        }
        try {
            demo.printMessage(null);
        } catch (NullPointerException e) {
            System.err.println("Caught NullPointerException: " + e.getMessage());
        }
    }
}


