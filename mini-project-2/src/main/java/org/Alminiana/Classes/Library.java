package org.Alminiana.Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        if (isDuplicateISBN(book.getISBN())) {
            System.out.println("Error: A book with ISBN " + book.getISBN() + " already exists.");
        } else {
            books.add(book);
            System.out.println("Book added: " + book.getTitle());
        }
    }

    public void removeBook(String ISBN) {
        if (books.removeIf(book -> book.getISBN().equals(ISBN))) {
            System.out.println("Book with ISBN " + ISBN + " removed.");
        } else {
            System.out.println("Error: No book found with ISBN " + ISBN);
        }
    }

    // Allows partial match search with title, authors, and ISBN
    public List<Book> searchBooks(String query) {
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                        book.getAuthor().toLowerCase().contains(query.toLowerCase()) ||
                        book.getISBN().contains(query))
                .collect(Collectors.toList());
    }

    public void displayBooks(List<Book> booksToDisplay) {
        if (booksToDisplay.isEmpty()) {
            System.out.println("No books found.");
        } else {
            // Determine max length of attributes for formatting
            int titleWidth = booksToDisplay.stream().mapToInt(book -> book.getTitle().length()).max().orElse(40);
            int authorWidth = booksToDisplay.stream().mapToInt(book -> book.getAuthor().length()).max().orElse(30);
            int isbnWidth = booksToDisplay.stream().mapToInt(book -> book.getISBN().length()).max().orElse(13);

            // Ensures min width are at least as wide as the headers
            titleWidth = Math.max(titleWidth, "Title".length());
            authorWidth = Math.max(authorWidth, "Author".length());
            isbnWidth = Math.max(isbnWidth, "ISBN".length());

            // Adjusts the table depending on the string length of the data
            String format = "%-" + titleWidth + "s %-" + authorWidth + "s %-" + isbnWidth + "s%n";

            System.out.printf(format, "Title", "Author", "ISBN");
            System.out.println("=".repeat(titleWidth + authorWidth + isbnWidth + 2));
            booksToDisplay.forEach(book -> System.out.printf(format, book.getTitle(), book.getAuthor(), book.getISBN()));
        }
    }

    public void displayAllBooks() {
        displayBooks(books);
    }

    private boolean isDuplicateISBN(String ISBN) {
        return books.stream().anyMatch(book -> book.getISBN().equals(ISBN));
    }
}