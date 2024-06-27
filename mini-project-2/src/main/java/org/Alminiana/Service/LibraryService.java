package org.Alminiana.Service;

import org.Alminiana.Model.GenreBook;
import java.util.List;

public interface LibraryService {
    void addBook(GenreBook book);
    void removeBook(String ISBN);
    List<GenreBook> searchBooks(String query);
    void displayBooks(List<GenreBook> booksToDisplay);
    void displayAllBooks();
}
