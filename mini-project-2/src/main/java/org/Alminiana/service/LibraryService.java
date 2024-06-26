package org.Alminiana.service;

import org.Alminiana.model.GenreBook;

import java.util.List;

public interface LibraryService {
    void removeBook(String ISBN);
    void addBook(GenreBook book);
    List<GenreBook> searchBooks(String query);
}
