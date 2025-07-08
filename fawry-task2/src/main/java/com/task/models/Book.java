package com.task.models;

// Base class for all book types
public abstract class Book {
protected String isbn;
    protected String title;
    protected int publishYear;
    protected double price;
    protected String author;

    public Book(String isbn, String title, int publishYear, double price, String author) {
        this.isbn = isbn;
        this.title = title;
        this.publishYear = publishYear;
        this.price = price;
        this.author = author;
    }

    // Basic getters
    public String getIsbn() { return isbn; }
    public int getPublishYear() { return publishYear; }
    public double getPrice() { return price; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
}
