package com.example.miniprojecttwo;

/**
 * This class represents a book. It extends the Literature class and adds
 * additional properties for author and ISBN.
 */
public class Book extends Literature {
    private String author;
    private String ISBN;

    public Book(String title, String author, String ISBN) {
        super(title);
        this.author = author;
        this.ISBN = ISBN;
    }
    
    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    /**
     * Retrieves information about the book.
     * This method overrides the getInfo() method from the Literature class.
     
     * @see Literature#getInfo()
     */
    @Override
    public void getInfo(){
        System.out.println("Book Title: " + getTitle());
        System.out.println("Book Author: " + this.author);
        System.out.println("Book ISBN: " + this.ISBN);
        System.out.println("-------------------\n");
    }

}
