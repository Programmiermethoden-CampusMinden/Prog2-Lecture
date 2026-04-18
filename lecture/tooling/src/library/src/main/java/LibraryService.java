import java.util.HashMap;
import java.util.Map;

public class LibraryService {
    private final Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public Book findBook(String id) {
        return books.get(id);
    }

    public boolean lendBook(String bookId) {
        Book book = books.get(bookId);
        if (book == null || !book.isAvailable()) return false;
        book.markLent();
        return true;
    }

    public boolean returnBook(String bookId) {
        Book book = books.get(bookId);
        if (book == null || book.isAvailable()) return false;
        book.markReturned();
        return true;
    }
}
