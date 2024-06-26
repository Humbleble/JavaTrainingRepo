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
            System.out.printf("%-40s %-30s %s%n", "Title", "Author", "ISBN");
            System.out.println("=".repeat(80));
            booksToDisplay.forEach(System.out::println);
        }
    }

    public void displayAllBooks() {
        displayBooks(books);
    }

    private boolean isDuplicateISBN(String ISBN) {
        return books.stream().anyMatch(book -> book.getISBN().equals(ISBN));
    }
}