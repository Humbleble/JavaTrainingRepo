package org.Alminiana;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library();
    }

    @Test
    void testAddBook() {
        Book book1 = new Book("The Wonders of our Little World", "Kennedy Johns", "98127389182");
        library.addBook(book1);
        assertEquals(1, library.searchBooks("98127389182").size());

        // Attempt to add a book with the same ISBN
        Book book2 = new Book("Synthesizer", "Jake Alister", "98127389182");
        library.addBook(book2);
        assertEquals(1, library.searchBooks("98127389182").size());
    }

    @Test
    void testRemoveBook() {
        Book book1 = new Book("Synthesizer", "Jake Alister", "89712977388");
        library.addBook(book1);
        library.removeBook("8971");
        assertEquals(0, library.searchBooks("8971").size());

        // Attempt to remove a book that does not exist
        library.removeBook("8217");
    }

    @Test
    void testSearchBooks() {
        Book book1 = new Book("The Wonders of our Little World", "Kennedy Johns", "98127389182");
        Book book2 = new Book("Synthesizer", "Jake Alister", "89712977388");
        library.addBook(book1);
        library.addBook(book2);

        List<Book> result1 = library.searchBooks("wonders");
        assertEquals(1, result1.size());

        List<Book> result2 = library.searchBooks("Jake");
        assertEquals(1, result2.size());

        List<Book> result3 = library.searchBooks("9812");
        assertEquals(2, result3.size());
    }

    @Test
    void testDisplayBooks() {
        // This test can be used to verify display methods, it should be run manually to check console output.
    }
}
