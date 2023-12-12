import java.util.Scanner;

public class number8 {
    public void getKey() {
        Scanner myScanner = new Scanner(System.in);
        String key;
        do {
            System.out.print("Enter a key: ");
            key = myScanner.next();
        } while (key.equals(""));
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
            throw new Exception("Key set to an empty string");
        }
        return "Data for " + key;
    }
    public static void main(String[] args) {
        number8 demo = new number8();
        demo.getKey();
    }
}