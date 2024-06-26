package org.Alminiana;

import org.Alminiana.model.Genre;
import org.Alminiana.model.GenreBook;
import org.Alminiana.service.Impl.LibraryServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        LibraryServiceImpl library = new LibraryServiceImpl();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Books");
            System.out.println("4. Display All Books");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = InputValidator.getValidatedChoice(scanner, 1, 5);

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.println("Choose genre:");
                    System.out.println("1. Fiction");
                    System.out.println("2. Non-Fiction");
                    System.out.println("3. Novel");
                    System.out.println("4. History");
                    System.out.println("5. Romance");
                    Genre genre = InputValidator.getValidatedGenre(scanner);
                    System.out.print("Enter ISBN: ");
                    String ISBN = scanner.nextLine();

                    GenreBook book = new GenreBook(title, author, genre, ISBN);
                    library.addBook(book);
                    break;

                case 2:
                    System.out.print("Enter ISBN to remove: ");
                    String removeISBN = scanner.nextLine();
                    library.removeBook(removeISBN);
                    break;

                case 3:
                    System.out.print("Enter search query (title, author, or ISBN): ");
                    String query = scanner.nextLine();
                    List<GenreBook> foundBooks = library.searchBooks(query);
                    library.displayBooks(foundBooks);
                    pause();
                    break;

                case 4:
                    library.displayAllBooks();
                    pause();
                    break;

                case 5:
                    running = false;
                    logger.info("Exiting Library Management System.");
                    System.out.println("Exiting Library Management System.");
                    break;

                default:
                    logger.warn("Invalid option chosen: " + choice);
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static void pause() {
        System.out.println("Press Enter to continue...");
        try {
            System.in.read();
        } catch (IOException e) {
            logger.error("Error occurred while pausing.", e);
        }
    }
}