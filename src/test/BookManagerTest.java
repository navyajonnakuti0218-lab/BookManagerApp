package navya.first.BookManagerApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class BookManagerTest {

    private BookManager manager;

    // Runs before *each* test
    @BeforeEach
    public void setUp() {
        manager = new BookManager();
    }

    /**
     * Test adding and searching.
     * This also now implicitly tests the Book's toString() method.
     */
    @Test
    public void testAddAndSearchBook() {
        // Action
        manager.addBook("The Hobbit", "J.R.R. Tolkien");
        
        // Check
        Book foundBook = manager.searchBook("The Hobbit");

        // Assert
        assertNotNull(foundBook);
        assertEquals("J.R.R. Tolkien", foundBook.getAuthor());

        // We can also test the new toString() method
        assertEquals("The Hobbit by J.R.R. Tolkien", foundBook.toString());
    }

    /**
     * Test searching for a book that doesn't exist.
     */
    @Test
    public void testSearchForMissingBook() {
        // Action
        Book foundBook = manager.searchBook("A Missing Book");
        
        // Assert
        assertNull(foundBook);
    }

    /**
     * --- NEW TEST ---
     * This test checks the "Show All Books" (getAllBooks) method.
     */
    @Test
    public void testGetAllBooks() {
        // Action: Add two books
        manager.addBook("Book One", "Author A");
        manager.addBook("Book Two", "Author B");

        // Check: Get the list
        List<Book> allBooks = manager.getAllBooks();

        // Assert: Check if the list is correct
        assertNotNull(allBooks);
        assertEquals(2, allBooks.size()); // Check if we have 2 books
        
        // Check the contents
        assertEquals("Book One", allBooks.get(0).getTitle());
        assertEquals("Book Two", allBooks.get(1).getTitle());
    }

    /**
     * --- NEW TEST ---
     * This tests an "edge case": what if the list is empty?
     */
    @Test
    public void testGetAllBooksEmpty() {
        // Action: Get the list (without adding any books)
        List<Book> allBooks = manager.getAllBooks();

        // Assert: Check if the list is empty
        assertNotNull(allBooks);
        assertEquals(0, allBooks.size()); // or assertTrue(allBooks.isEmpty());
    }
}