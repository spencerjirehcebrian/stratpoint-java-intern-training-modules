package com.miniproject.two;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Library Management System - Library Class
 *
 * This class represents a Library that contains a collection of books and
 * provides
 * various methods to manage them. The Library allows adding, removing,
 * searching,
 * borrowing, and returning books. It also supports displaying all books in the
 * collection.
 *
 * The Library class includes methods for:
 * <ul>
 * <li>Adding a new book with details like title, author, ISBN, genre,
 * publication format, and more.
 * <li>Removing books based on a search term.
 * <li>Searching for books using a search term.
 * <li>Displaying all books in the library.
 * <li>Borrowing a book by ISBN and recording the borrower's name.
 * <li>Returning a borrowed book by ISBN.
 * </ul>
 *
 * Input validation includes:
 * <ul>
 * <li>Ensuring the ISBN is valid.
 * <li>Handling availability status updates when borrowing and returning books.
 * </ul>
 *
 * The program uses ANSI escape codes for color formatting in the console.
 *
 * @version 1.0
 * @since 2024-06-25
 */
public class Library {

    private List<Book> books;
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";

    public Library() {
        this.books = new ArrayList<>();
    }

    /**
     * Adds a new book to the library.
     *
     * @param title              the title of the book
     * @param author             the author of the book
     * @param isbn               the ISBN of the book
     * @param genre              the genre of the book
     * @param subgenre           the subgenre of the book
     * @param nationality        the nationality of the book
     * @param publicationFormat  the publication format of the book
     * @param publishedYear      the year the book was published
     * @param publisherName      the name of the publisher
     * @param deweyDecimal       the Dewey decimal classification of the book
     * @param isAvailable        whether the book is available or not
     * @param borrowedByUserName the username of the user who borrowed the book
     */
    public void addBook(String title, String author, String isbn, String genre, String subgenre, String nationality,
            String publicationFormat, int publishedYear, String publisherName,
            String deweyDecimal, boolean isAvailable, String borrowedByUserName) {
        Book bookObject = new Book(title, author, isbn, genre, subgenre, nationality,
                publicationFormat, publishedYear, publisherName, deweyDecimal, isAvailable, borrowedByUserName);
        books.add(bookObject);
    }

    /**
     * Removes books from the library based on the provided search term.
     *
     * @param searchTerm the term used for searching books
     * @return a list of books that match the search criteria
     */
    public List<Book> removeBook(String searchTerm) {
        String lowercaseSearchTerm = searchTerm.toLowerCase();
        List<Book> matchingBooks = books.stream()
                .filter(e -> e.getAuthor().toLowerCase().contains(lowercaseSearchTerm) ||
                        e.getISBN().toLowerCase().contains(lowercaseSearchTerm) ||
                        e.getTitle().toLowerCase().contains(lowercaseSearchTerm) ||
                        e.getGenre().toLowerCase().contains(lowercaseSearchTerm) ||
                        e.getSubgenre().toLowerCase().contains(lowercaseSearchTerm) ||
                        e.getNationality().toLowerCase().contains(lowercaseSearchTerm) ||
                        e.getPublicationFormat().toLowerCase().contains(lowercaseSearchTerm) ||
                        Integer.toString(e.getPublishedYear()).contains(lowercaseSearchTerm) ||
                        e.getPublisherName().toLowerCase().contains(lowercaseSearchTerm) ||
                        e.getDeweyDecimal().toLowerCase().contains(lowercaseSearchTerm) ||
                        Boolean.toString(e.isAvailable()).toLowerCase().contains(lowercaseSearchTerm) ||
                        e.getBorrowedByUserName().toLowerCase().contains(lowercaseSearchTerm))
                .collect(Collectors.toList());
        books.removeAll(matchingBooks);
        return matchingBooks;
    }

    /**
     * Searches for books in the library based on the provided search term.
     *
     * @param searchTerm the term used for searching books
     * @return a list of books that match the search criteria
     */
    public List<Book> searchBooks(String searchTerm) {
        String lowercaseSearchTerm = searchTerm.toLowerCase();
        return books.stream()
                .filter(e -> e.getAuthor().toLowerCase().contains(lowercaseSearchTerm) ||
                        e.getISBN().toLowerCase().contains(lowercaseSearchTerm) ||
                        e.getTitle().toLowerCase().contains(lowercaseSearchTerm) ||
                        e.getGenre().toLowerCase().contains(lowercaseSearchTerm) ||
                        e.getSubgenre().toLowerCase().contains(lowercaseSearchTerm) ||
                        e.getNationality().toLowerCase().contains(lowercaseSearchTerm) ||
                        e.getPublicationFormat().toLowerCase().contains(lowercaseSearchTerm) ||
                        Integer.toString(e.getPublishedYear()).contains(lowercaseSearchTerm) ||
                        e.getPublisherName().toLowerCase().contains(lowercaseSearchTerm) ||
                        e.getDeweyDecimal().toLowerCase().contains(lowercaseSearchTerm) ||
                        Boolean.toString(e.isAvailable()).toLowerCase().contains(lowercaseSearchTerm) ||
                        e.getBorrowedByUserName().toLowerCase().contains(lowercaseSearchTerm))
                .collect(Collectors.toList());
    }

    /**
     * Displays all the books in the library.
     *
     * This function checks if the list of books is empty. If it is, it prints a
     * message indicating that no books were found.
     * If the list is not empty, it prints a message indicating that all books are
     * being shown, followed by the title, author,
     * ISBN, publication year, and genre of each book in the list.
     *
     * @return void
     */
    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println(ANSI_RED + "\n\t\t\tNo books found" + ANSI_RESET);
        } else {
            System.out.println(ANSI_YELLOW + "\n\t\t\tShowing All Books" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "\t\t\t-------------------" + ANSI_RESET);
            for (Book book : books) {
                book.printData();
            }
        }
    }

    /**
     * Borrows a book from the library based on the provided ISBN and borrower name.
     *
     * @param ISBN         the ISBN of the book to be borrowed
     * @param borrowerName the name of the borrower
     * @return true if the book was successfully borrowed, false otherwise
     */
    public boolean borrowBook(String ISBN, String borrowerName) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    book.setBorrowedByUserName(borrowerName);
                    System.out.println(ANSI_GREEN + "\n\t\t\tBook with ISBN " + ISBN + " has been borrowed by "
                            + borrowerName + ANSI_RESET);
                    return true;
                } else {
                    System.out.println(ANSI_RED + "\n\t\t\tBook with ISBN " + ISBN + " is not available for borrowing"
                            + ANSI_RESET);
                    return false;
                }
            }
        }
        System.out.println(ANSI_RED + "\n\t\t\tBook with ISBN " + ISBN + " not found" + ANSI_RESET);
        return false;
    }

    /**
     * Returns a book to the library based on the provided ISBN.
     *
     * @param ISBN the ISBN of the book to be returned
     * @return true if the book was successfully returned, false otherwise
     */
    public boolean returnBook(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    book.setBorrowedByUserName("");
                    System.out
                            .println(ANSI_GREEN + "\n\t\t\tBook with ISBN " + ISBN + " has been returned" + ANSI_RESET);
                    return true;
                } else {
                    System.out.println(
                            ANSI_YELLOW + "\n\t\t\tBook with ISBN " + ISBN + " is already available" + ANSI_RESET);
                    return false;
                }
            }
        }
        System.out.println(ANSI_RED + "\n\t\t\tBook with ISBN " + ISBN + " not found" + ANSI_RESET);
        return false;
    }

}
