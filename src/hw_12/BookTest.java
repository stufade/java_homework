package hw_12;

class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
}

// Класс для тестирования класса Book
public class BookTest {
    public static void main(String[] args) {
        Book book = new Book("Война и мир", "Лев Толстой", 1869);

        System.out.println("Название книги: " + book.getTitle());
        System.out.println("Автор книги: " + book.getAuthor());
        System.out.println("Год издания: " + book.getYear());
    }
}
