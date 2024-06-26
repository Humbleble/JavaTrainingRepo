package org.Alminiana.service.Impl;

import org.Alminiana.model.GenreBook;
import org.Alminiana.service.LibraryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryServiceImpl implements LibraryService {
    private static final Logger logger = LoggerFactory.getLogger(LibraryServiceImpl.class);

    private List<GenreBook> books;

    public LibraryServiceImpl() {
        this.books = new ArrayList<>();
    }

    public void addBook(GenreBook book) {
        if (isDuplicateISBN(book.getISBN())) {
            logger.error("Attempt to add duplicate ISBN: " + book.getISBN());
            System.out.println("Error: A book with ISBN " + book.getISBN() + " already exists.");
        } else {
            books.add(book);
            logger.info("Book added: " + book.getTitle());
            System.out.println("Book added: " + book.getTitle());
        }
    }

    public void removeBook(String ISBN) {
        if (books.removeIf(book -> book.getISBN().equals(ISBN))) {
            logger.info("Book with ISBN " + ISBN + " removed.");
            System.out.println("Book with ISBN " + ISBN + " removed.");
        } else {
            logger.warn("Attempt to remove non-existent ISBN: " + ISBN);
            System.out.println("Error: No book found with ISBN " + ISBN);
        }
    }

    public List<GenreBook> searchBooks(String query) {
        logger.info("Searching for books with query: " + query);
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                        book.getAuthor().toLowerCase().contains(query.toLowerCase()) ||
                        book.getISBN().contains(query))
                .collect(Collectors.toList());
    }

    public void displayBooks(List<GenreBook> booksToDisplay) {
        if (booksToDisplay.isEmpty()) {
            logger.info("No books found.");
            System.out.println("No books found.");
        } else {
            int titleWidth = booksToDisplay.stream().mapToInt(book -> book.getTitle().length()).max().orElse(40);
            int authorWidth = booksToDisplay.stream().mapToInt(book -> book.getAuthor().length()).max().orElse(30);
            int genreWidth = booksToDisplay.stream().mapToInt(book -> book.getGenre().toString().length()).max().orElse(10);
            int isbnWidth = booksToDisplay.stream().mapToInt(book -> book.getISBN().length()).max().orElse(13);

            titleWidth = Math.max(titleWidth, "Title".length());
            authorWidth = Math.max(authorWidth, "Author".length());
            genreWidth = Math.max(genreWidth, "Genre".length());
            isbnWidth = Math.max(isbnWidth, "ISBN".length());

            String format = "%-" + titleWidth + "s %-" + authorWidth + "s %-" + genreWidth + "s %-" + isbnWidth + "s%n";

            System.out.printf(format, "Title", "Author", "Genre", "ISBN");
            System.out.println("=".repeat(titleWidth + authorWidth + genreWidth + isbnWidth + 3));
            booksToDisplay.forEach(book -> System.out.printf(format, book.getTitle(), book.getAuthor(), book.getGenre(), book.getISBN()));
        }
    }

    public void displayAllBooks() {
        displayBooks(books);
    }

    private boolean isDuplicateISBN(String ISBN) {
        return books.stream().anyMatch(book -> book.getISBN().equals(ISBN));
    }
}