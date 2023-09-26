package hw_2;

public class Author {
    private String name;
    private String email;
    private char gender;

    // Конструктор для инициализации полей name, email и gender
    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    // Геттер для имени автора
    public String getName() {
        return name;
    }

    // Геттер для email автора
    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    // Геттер для пола автора
    public char getGender() {
        return gender;
    }

    // Метод toString() для форматированного вывода информации об авторе
    @Override
    public String toString() {
        String genderStr;
        if (gender == 'M') {
            genderStr = "m";
        } else if (gender == 'F') {
            genderStr = "f";
        } else {
            genderStr = "u";
        }
        return name + " (" + genderStr + ") at " + email;
    }
}