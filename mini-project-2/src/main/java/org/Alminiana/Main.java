package org.Alminiana;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
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

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("\nEnter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String ISBN = scanner.nextLine();
                    Book book = new Book(title, author, ISBN);
                    library.addBook(book);
                    break;

                case 2:
                    System.out.print("Enter ISBN to remove: ");
                    String removeISBN = scanner.nextLine();
                    library.removeBook(removeISBN);
                    break;

                case 3:
                    System.out.print("Enter search query (title or author): ");
                    String query = scanner.nextLine();
                    List<Book> foundBooks = library.searchBooks(query);
                    if (foundBooks.isEmpty()) {
                        System.out.println("No books found.");
                    } else {
                        foundBooks.forEach(System.out::println);
                    }
                    break;

                case 4:
                    library.displayAllBooks();
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
}