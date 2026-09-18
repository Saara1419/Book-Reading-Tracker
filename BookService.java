import java.util.ArrayList;
import java.util.List;

/**
 * Handles all operations related to managing books:
 * adding, deleting, viewing, and updating reading progress.
 */
public class BookService {
    private List<Book> books;
    private int nextId;

    public BookService() {
        books = new ArrayList<>();
        nextId = 1;
    }

    public Book addBook(String title, String author, int totalPages) {
        Book book = new Book(nextId++, title, author, totalPages);
        books.add(book);
        return book;
    }

    public boolean deleteBook(int id) {
        return books.removeIf(b -> b.getId() == id);
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book findById(int id) {
        for (Book b : books) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    public boolean updateProgress(int id, int pages) {
        Book book = findById(id);
        if (book == null) {
            return false;
        }
        book.addPagesRead(pages);
        return true;
    }

    public boolean isEmpty() {
        return books.isEmpty();
    }
}
