package org.Alminiana;

import org.Alminiana.Classes.Book;
import org.Alminiana.Classes.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library();
    }

    @Test
    void testAddBook() {
        Book book1 = new Book("The Wonders", "Jake Kennedy", "91287378127");
        library.addBook(book1);
        assertEquals(1, library.searchBooks("91287378127").size());

        // Attempt to add a book with the same ISBN
        Book book2 = new Book("Synthesizer", "Alister", "91287378127");
        library.addBook(book2);
        assertEquals(1, library.searchBooks("91287378127").size());
    }

    @Test
    void testRemoveBook() {
        Book book1 = new Book("The Wonders", "Jake Kennedy", "91287378127");
        library.addBook(book1);
        library.removeBook("91287378127");
        assertEquals(0, library.searchBooks("9128").size());

        // Attempt to remove a book that does not exist
        library.removeBook("87128878132");
    }

    @Test
    void testSearchBooks() {
        Book book1 = new Book("The Wonders", "Jake Kennedy", "91287378127");
        Book book2 = new Book("Synthesizer", "Alister", "87183718272");
        library.addBook(book1);
        library.addBook(book2);

        List<Book> result1 = library.searchBooks("wonders");
        assertEquals(1, result1.size());

        List<Book> result2 = library.searchBooks("Ali");
        assertEquals(1, result2.size());

        List<Book> result3 = library.searchBooks("8718");
        assertEquals(1, result3.size());

        List<Book> result4 = library.searchBooks("the");
        assertEquals(2, result4.size());
    }

    @Test
    void testDisplayBooks() {
        // This test can be used to verify display methods, it should be run manually to check console output.
    }
}