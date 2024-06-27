package com.miniproject.two;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";

    public Library() {
        this.books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return this.books;
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
    public void addBook(String title, String author, String isbn, String genre, String subgenre,
            String nationality, String publicationFormat, int publishedYear, String publisherName,
            String deweyDecimal, boolean isAvailable, String borrowedByUserName) {

        int bookId = RandomIdGenerator.generateId();
        Book bookObject = new Book(bookId, title, author, isbn, genre, subgenre, nationality,
                publicationFormat, publishedYear, publisherName, deweyDecimal, isAvailable, borrowedByUserName);
        books.add(bookObject);
    }

    /**
     * Updates the details of a book in the library.
     *
     * @param bookId             the ID of the book to be updated
     * @param title              the new title of the book
     * @param author             the new author of the book
     * @param isbn               the new ISBN of the book
     * @param genre              the new genre of the book
     * @param subgenre           the new subgenre of the book
     * @param nationality        the new nationality of the book
     * @param publicationFormat  the new publication format of the book
     * @param publishedYear      the new year the book was published
     * @param publisherName      the new name of the publisher
     * @param deweyDecimal       the new Dewey decimal classification of the book
     * @param isAvailable        the new availability status of the book
     * @param borrowedByUserName the new username of the user who borrowed the book
     */
    public void updateBook(int bookId, String title, String author, String isbn, String genre, String subgenre,
            String nationality, String publicationFormat, int publishedYear, String publisherName,
            String deweyDecimal, boolean isAvailable, String borrowedByUserName) {

        for (Book book : books) {
            if (book.getBookId() == bookId) {
                book.setTitle(title);
                book.setAuthor(author);
                book.setISBN(isbn);
                book.setGenre(genre);
                book.setSubgenre(subgenre);
                book.setNationality(nationality);
                book.setPublicationFormat(publicationFormat);
                book.setPublishedYear(publishedYear);
                book.setPublisherName(publisherName);
                book.setDeweyDecimal(deweyDecimal);
                book.setAvailable(isAvailable);
                book.setBorrowedByUserName(borrowedByUserName);
                return;
            }
        }

        System.out.println("Book with ID " + bookId + " not found.");
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
                        Integer.toString(e.getBookId()).contains(lowercaseSearchTerm) ||
                        e.getPublisherName().toLowerCase().contains(lowercaseSearchTerm) ||
                        e.getDeweyDecimal().toLowerCase().contains(lowercaseSearchTerm) ||
                        Boolean.toString(e.isAvailable()).toLowerCase().contains(lowercaseSearchTerm) ||
                        e.getBorrowedByUserName().toLowerCase().contains(lowercaseSearchTerm))
                .collect(Collectors.toList());
        books.removeAll(matchingBooks);
        return matchingBooks;
    }

    /**
     * Removes a book from the library based on the provided book ID.
     *
     * @param bookId the ID of the book to be removed
     * @return a list of books that match the provided book ID
     */
    public List<Book> removeBookById(int bookId) {
        List<Book> matchingBooks = books.stream()
                .filter(e -> e.getBookId() == bookId)
                .collect(Collectors.toList());
        books.removeAll(matchingBooks);
        System.out.println(ANSI_GREEN + "\n\t\t\tBook has been deleted successfully" + ANSI_RESET);
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
                        Integer.toString(e.getBookId()).contains(lowercaseSearchTerm) ||
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
     * @return the list of all books in the library
     */
    public List<Book> showBooks() {
        return books;
    }

    /**
     * Displays books in the library based on the provided book ID.
     *
     * @param bookId the ID of the book to be displayed
     * @return a list of books that match the provided book ID
     */
    public List<Book> showBookById(int bookId) {
        return books.stream()
                .filter(e -> e.getBookId() == bookId)
                .collect(Collectors.toList());
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

    /**
     * Sets the demo data for the library by creating a list of books and adding
     * them to the library.
     *
     * @return void
     */
    public void setDemoData() {

        Book book1 = new Book(1001, "To Kill a Mockingbird", "Harper Lee", "978-0-06-112008-4", "Fiction",
                "Southern Gothic", "American",
                "Hardcover", 1960, "J.B. Lippincott & Co.", "813.54", true, "");
        books.add(book1);

        Book book2 = new Book(1002, "1984", "George Orwell", "978-0-45-152493-5", "Fiction", "Dystopian", "British",
                "Paperback", 1949, "Secker & Warburg", "823.912", true, "");
        books.add(book2);

        Book book3 = new Book(1003, "Pride and Prejudice", "Jane Austen", "978-0-14-104034-9", "Fiction", "Romantic",
                "British",
                "Hardcover", 1813, "T. Egerton", "823.7", false, "john_doe");
        books.add(book3);

        Book book4 = new Book(1004, "The Great Gatsby", "F. Scott Fitzgerald", "978-0-74-327356-5", "Fiction",
                "Tragedy", "American",
                "Paperback", 1925, "Charles Scribner's Sons", "813.52", true, "");
        books.add(book4);

        Book book5 = new Book(1005, "Moby Dick", "Herman Melville", "978-1-50-328078-6", "Fiction", "Adventure",
                "American",
                "Hardcover", 1851, "Harper & Brothers", "813.3", false, "jane_smith");
        books.add(book5);

        Book book6 = new Book(1006, "War and Peace", "Leo Tolstoy", "978-1-85-326062-9", "Fiction", "Historical",
                "Russian",
                "Paperback", 1869, "The Russian Messenger", "891.73", true, "");
        books.add(book6);

        Book book7 = new Book(1007, "The Catcher in the Rye", "J.D. Salinger", "978-0-31-676948-8", "Fiction",
                "Realist", "American",
                "Hardcover", 1951, "Little, Brown and Company", "813.54", true, "");
        books.add(book7);

        Book book8 = new Book(1008, "The Hobbit", "J.R.R. Tolkien", "978-0-26-110221-7", "Fiction", "Fantasy",
                "British",
                "Paperback", 1937, "George Allen & Unwin", "823.912", false, "alice_johnson");
        books.add(book8);

        Book book9 = new Book(1009, "Anna Karenina", "Leo Tolstoy", "978-1-85-326271-5", "Fiction", "Realist",
                "Russian",
                "Hardcover", 1877, "The Russian Messenger", "891.73", true, "");
        books.add(book9);

        Book book10 = new Book(1010, "The Alchemist", "Paulo Coelho", "978-0-06-112241-5", "Fiction", "Adventure",
                "Brazilian",
                "Paperback", 1988, "HarperOne", "869.342", false, "bob_williams");
        books.add(book10);

    }

    private class RandomIdGenerator {
        private static final Random random = new Random();
        private static final int LOWER_BOUND = 1000;
        private static final int UPPER_BOUND = 9999;

        /**
         * Generates a random ID between LOWER_BOUND and UPPER_BOUND.
         *
         * @return a randomly generated ID
         */
        public static int generateId() {
            return LOWER_BOUND + random.nextInt(UPPER_BOUND - LOWER_BOUND + 1);
        }
    }

}
