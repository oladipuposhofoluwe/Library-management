package com.decagon;

public class Book {
    private String title;
    private int isbn;
    private String author;
    private String publicationYear;


    // Constructor for Book.
    public Book(String title, String author, int isbn, String publicationYear) {
        this.title=title;
        this.author=author;
        this.isbn=isbn;
        this.publicationYear=publicationYear;
    }


    public String getTitle() {
        return title;
    }
    public int getIsbn() {
        return isbn;
    }
    public String getAuthor() {
        return author;
    }


}