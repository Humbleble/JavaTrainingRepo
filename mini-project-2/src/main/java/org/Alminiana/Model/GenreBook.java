package org.Alminiana.Model;

public class GenreBook extends Book {
    private Genre genre;

    public GenreBook(String title, String author, String ISBN, Genre genre) {
        super(title, author, ISBN);
        this.genre = genre;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return String.format("%-40s %-30s %-10s %s", getTitle(), getAuthor(), genre, getISBN());
    }
}