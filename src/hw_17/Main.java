
class InvalidINNException extends NumberFormatException {
    private String errorDetails;
    public InvalidINNException(String message, String errorDetails) {
        super(message);
        this.errorDetails = errorDetails;
    }
    public String getErrorDetails() {
        return errorDetails;
    }
}

class Client {
    private String fullName;
    private String INN;
    public Client(String fullName, String INN) {
        this.fullName = fullName;
        this.INN = INN;
    }
    public void validateINN() throws InvalidINNException {
        if (INN.length() != 10) {
            throw new InvalidINNException("Недействительный ИНН: " + INN, "ИНН должен содержать только цифровые символы.");
        }

        if (!INN.matches("\\d+")) {
            throw new InvalidINNException("Недействительный ИНН: " + INN, "ИНН должен состоять из 10 цифр.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        String fullName = "Иван Иванов";
        String INN = "123456789";
        // Создаем объект клиента
        Client client = new Client(fullName, INN);

        try {
            client.validateINN();
            System.out.println("ИНН действителен. Заказ оформлен.");
        } catch (InvalidINNException e) {
            System.out.println("Ошибка: " + e.getMessage());
            System.out.println("Детали ошибки: " + e.getErrorDetails());
        }
    }
}
