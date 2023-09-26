package hw_2;

public class TestAuthor {
    public static void main(String[] args) {
        Author author1 = new Author("Ivan Ivanov", "ivanivanov@mail.ru", 'M');
        System.out.println(author1.getEmail());
        System.out.println(author1.getName());
        System.out.println(author1.getGender());
        System.out.println(author1.toString());
        author1.setEmail("ivan@mail.ru");
        System.out.println(author1.toString());
    }
}