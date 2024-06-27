package org.Alminiana;

import org.Alminiana.Model.Genre;
import org.Alminiana.Model.GenreBook;
import org.Alminiana.Service.Impl.InputValidatorServiceImpl;
import org.Alminiana.Service.Impl.LibraryServiceImpl;
import org.Alminiana.Service.InputValidatorService;
import org.Alminiana.Service.LibraryService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryService libraryService = new LibraryServiceImpl();
        InputValidatorService inputValidator = new InputValidatorServiceImpl();
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

            int choice = inputValidator.getValidatedChoice(scanner, 1, 5);

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String ISBN = scanner.nextLine();

                    System.out.println("Choose genre:");
                    System.out.println("1. Fiction");
                    System.out.println("2. Non-Fiction");
                    System.out.println("3. Novel");
                    System.out.println("4. History");
                    System.out.println("5. Romance");
                    Genre genre = inputValidator.getValidatedGenre(scanner);

                    GenreBook book = new GenreBook(title, author, ISBN, genre);
                    libraryService.addBook(book);
                    break;

                case 2:
                    System.out.print("Enter ISBN to remove: ");
                    String removeISBN = scanner.nextLine();
                    libraryService.removeBook(removeISBN);
                    break;

                case 3:
                    System.out.print("Enter search query (title, author, or ISBN): ");
                    String query = scanner.nextLine();
                    List<GenreBook> foundBooks = libraryService.searchBooks(query);
                    libraryService.displayBooks(foundBooks);
                    pause();
                    break;

                case 4:
                    libraryService.displayAllBooks();
                    pause();
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting Library Management System.");
                    break;

                default:
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
            e.printStackTrace();
        }
    }
}