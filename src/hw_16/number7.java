import java.util.Scanner;

public class number7 {
    public void getKey() {
        Scanner myScanner = new Scanner(System.in);
        String key = myScanner.next();
        printDetails(key);
    }
    public void printDetails(String key) {
        try {
            String message = getDetails(key);
            System.out.println(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private String getDetails(String key) throws Exception {
        if (key.equals("")) {
            throw new Exception("Key set to empty string");
        }
        return "data for " + key;
    }
    public static void main(String[] args) {
        System.out.println("Enter text: ");
        number7 demo = new number7();
        demo.getKey();
    }
}

