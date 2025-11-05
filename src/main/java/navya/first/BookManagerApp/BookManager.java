package navya.first.BookManagerApp;
import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private List<Book> books;

    public BookManager() {
        books = new ArrayList<>();
    }

    // Add a book
    public void addBook(String title, String author) {
        books.add(new Book(title, author));
    }

    // Search for a book by title
    public Book searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; // not found
    }

    // Get all books (The Corrected Method)
    public List<Book> getAllBooks() {
        // This returns a *new copy* of the list,
        // protecting the original list from being changed.
        return new ArrayList<>(books);
    }
}