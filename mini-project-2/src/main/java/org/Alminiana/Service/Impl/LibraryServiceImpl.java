package org.Alminiana.Service.Impl;

import org.Alminiana.Model.GenreBook;
import org.Alminiana.Service.LibraryService;
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

    @Override
    public void addBook(GenreBook book) {
        // Validate for ISBN duplicates
        if (isDuplicateISBN(book.getISBN())) {
            logger.warn("Attempt to add duplicate book with ISBN: {}", book.getISBN());
            System.out.println("Error: A book with ISBN " + book.getISBN() + " already exists.");
        } else {
            books.add(book);
            logger.info("Book added: {}", book.getTitle());
            System.out.println("Book added: " + book.getTitle());
        }
    }

    @Override
    public void removeBook(String ISBN) {
        if (books.removeIf(book -> book.getISBN().equals(ISBN))) {
            logger.info("Book with ISBN {} removed", ISBN);
            System.out.println("Book with ISBN " + ISBN + " removed.");
        } else {
            logger.warn("Attempt to remove non-existent book with ISBN: {}", ISBN);
            System.out.println("Error: No book found with ISBN " + ISBN);
        }
    }

    @Override
    public List<GenreBook> searchBooks(String query) {
        List<GenreBook> result = books.stream()
                // Filtering based on user query
                .filter(book -> book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                        book.getAuthor().toLowerCase().contains(query.toLowerCase()) ||
                        book.getISBN().contains(query) ||
                        book.getGenre().toString().toLowerCase().contains(query.toLowerCase()))
                // Collect filtered books to list
                .collect(Collectors.toList());
        logger.info("Search for '{}' returned {} result(s)", query, result.size());
        return result;
    }

    @Override
    public void displayBooks(List<GenreBook> booksToDisplay) {
        if (booksToDisplay.isEmpty()) {
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

    @Override
    public void displayAllBooks() {
        displayBooks(books);
    }

    private boolean isDuplicateISBN(String ISBN) {
        return books.stream().anyMatch(book -> book.getISBN().equals(ISBN));
    }
}