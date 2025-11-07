import java.util.HashMap;

public class Library {
    HashMap<String, Book> books;

    public Library() {
        books = new HashMap<>();
    }

    public void add(String isbn, Book book) {
        books.put(isbn, book);
        System.out.println("The book has been added: " + book);
    }

    public Book search(String isbn) {
        Book book = books.get(isbn);
        if (book != null) {
            System.out.println("A book has been found: " + book);
        } else {
            System.out.println("Book with isbn " + isbn + " not found");
        }
        return book;
    }

    public void del(String isbn) {
        Book removed = books.remove(isbn);
        if (removed != null) {
            System.out.println("The book was deleted: " + removed);
        } else {
            System.out.println("Book with isbn " + isbn + " not found");
        }
    }

}