package org.Alminiana;

import org.Alminiana.Model.Genre;
import org.Alminiana.Model.GenreBook;
import org.Alminiana.Service.Impl.LibraryServiceImpl;
import org.Alminiana.Service.LibraryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryServiceImplTest {
    private LibraryService library;

    @BeforeEach
    void setUp() {
        library = new LibraryServiceImpl();
    }

    @Test
    void testAddBook() {
        GenreBook book1 = new GenreBook("The Wonders", "Jake Kennedy", "91287378127", Genre.FICTION);
        library.addBook(book1);
        assertEquals(1, library.searchBooks("91287378127").size());

        // Attempt to add a book with the same ISBN
        GenreBook book2 = new GenreBook("Synthesizer", "Alister", "91287378127", Genre.NON_FICTION);
        library.addBook(book2);
        assertEquals(1, library.searchBooks("91287378127").size());
    }

    @Test
    void testRemoveBook() {
        GenreBook book1 = new GenreBook("The Wonders", "Jake Kennedy", "91287378127", Genre.FICTION);
        library.addBook(book1);
        library.removeBook("91287378127");
        assertEquals(0, library.searchBooks("9128").size());

        // Attempt to remove a book that does not exist
        library.removeBook("87128878132");
    }

    @Test
    void testSearchBooks() {
        GenreBook book1 = new GenreBook("The Wonders", "Jake Kennedy", "91287378127", Genre.FICTION);
        GenreBook book2 = new GenreBook("Synthesizer", "Alister", "87183718272", Genre.HISTORY);
        library.addBook(book1);
        library.addBook(book2);

        List<GenreBook> result1 = library.searchBooks("wonders");
        assertEquals(1, result1.size());

        List<GenreBook> result2 = library.searchBooks("Ali");
        assertEquals(1, result2.size());

        List<GenreBook> result3 = library.searchBooks("8718");
        assertEquals(1, result3.size());

        List<GenreBook> result4 = library.searchBooks("the");
        assertEquals(2, result4.size());

        List<GenreBook> result5 = library.searchBooks("fiction");
        assertEquals(1, result5.size());

        List<GenreBook> result6 = library.searchBooks("History");
        assertEquals(1, result6.size());
    }

    @Test
    void testDisplayBooks() {
        // This test can be used to verify display methods, it should be run manually to check console output.
    }
}