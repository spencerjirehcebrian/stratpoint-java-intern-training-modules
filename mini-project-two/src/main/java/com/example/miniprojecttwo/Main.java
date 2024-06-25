package com.example.miniprojecttwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Book> books = new ArrayList<>();

    /**
     * Adds a new book to the list of books.
     *
     * @param title  the title of the book
     * @param author the author of the book
     * @param isbn   the ISBN of the book
     */
    public static void addBook(String title, String author, String isbn) {
        Book bookObject = new Book(title, author, isbn);
        books.add(bookObject);
    }

    /**
     * Removes books from the list that match the given search term.
     *
     * @param searchTerm the search term to match against the author, ISBN, or title
     *                   of the books
     * @return a list of books that match the search criteria
     */
    public static List<Book> removeBook(String searchTerm) {
        List<Book> matchingBooks = books.stream()
                .filter(e -> searchTerm.equalsIgnoreCase(e.getAuthor()) ||
                        searchTerm.equalsIgnoreCase(e.getISBN()) ||
                        searchTerm.equalsIgnoreCase(e.getTitle()))
                .toList();
        books = books.stream()
                .filter(e -> !searchTerm.equalsIgnoreCase(e.getAuthor()) &&
                        !searchTerm.equalsIgnoreCase(e.getISBN()) &&
                        !searchTerm.equalsIgnoreCase(e.getTitle()))
                .toList();
        return matchingBooks;
    }

    /**
     * Searches for books in the given list by matching the search term against the
     * author, ISBN, or title.
     *
     * @param searchTerm the search term to match against the author, ISBN, or title
     *                   of the books
     * @return a list of books that match the search criteria
     */
    public static List<Book> searchBooks(String searchTerm) {
        return books.stream()
                .filter(e -> searchTerm.equalsIgnoreCase(e.getAuthor()) ||
                        searchTerm.equalsIgnoreCase(e.getISBN()) ||
                        searchTerm.equalsIgnoreCase(e.getTitle()))
                .toList();
    }

    public static List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    /**
     * Displays all the books in the list.
     *
     * If the list is empty, it prints "No books found".
     * Otherwise, it prints "Showing All Books" and then the information of each
     * book in the list.
     */
    public static void showBooks() {
        if (books.isEmpty()) {
            System.out.println("\nNo books found");
        } else {
            System.out.println("\nShowing All Books");
            System.out.println("-------------------\n");
            for (Book book : books) {
                book.getInfo();
            }
        }
    }

    /**
     * The main function of the program, which serves as the entry point. It creates
     * a scanner to read user input,
     * displays a welcome message, and enters a loop to handle user actions. The
     * user can add a book, remove a book,
     * search for a book, show all books, or exit the program. The program uses a
     * switch statement to handle the
     * different actions. The addBook, removeBook, searchBooks, and showBooks
     * methods are called based on the user's
     * input. The program catches any exceptions that occur during the execution and
     * prints the stack trace.
     */
    public static void main(String[] args) {
        try {

            Scanner lmsScanner = new Scanner(System.in);

            System.out.println("\n-----------------------------------------");
            System.out.println("Welcome to this Library Management System");
            System.out.println("-----------------------------------------");

            while (true) {
                System.out.println("""
                        [1] Add Book
                        [2] Remove Book
                        [3] Search Book
                        [4] Show All Books
                        [5] Exit
                        Enter Action Number: """);
                String action = lmsScanner.nextLine();

                switch (action) {
                    case "1":
                        System.out.println("\nAdding a Book");
                        System.out.print("Enter the book's title: ");
                        String bookTitle = lmsScanner.nextLine();
                        System.out.print("Enter the book's author: ");
                        String bookAuthor = lmsScanner.nextLine();
                        System.out.print("Enter the book's ISBN: ");
                        String bookISBN = lmsScanner.nextLine();
                        addBook(bookTitle, bookAuthor, bookISBN);
                        System.out.println("\nBook Added. Press any key to continue...");
                        try {
                            System.in.read();
                        } catch (Exception ignored) {
                        }
                        break;
                    case "2":
                        System.out.println("\nRemove Books");
                        System.out.print("Enter the book's Title/Author/ISBN: ");
                        String toDelete = lmsScanner.nextLine();
                        List<Book> deleteResults = removeBook(toDelete);
                        if (deleteResults.isEmpty()) {
                            System.out.println("\nNo books found with the provided search criteria.");
                        } else {
                            System.out.println("\nThe following books are deleted:");
                            System.out.println("-------------------\n");
                            for (Book book : deleteResults) {
                                book.getInfo();
                            }
                        }
                        System.out.println("Books removed. Press any key to continue...");
                        try {
                            System.in.read();
                        } catch (Exception ignored) {
                        }
                        break;
                    case "3":
                        System.out.println("\nSearch Books");
                        System.out.print("Enter the book's Title/Author/ISBN: ");
                        String searchTerm = lmsScanner.nextLine();
                        List<Book> results = searchBooks(searchTerm);
                        if (results.isEmpty()) {
                            System.out.println("\nNo books found with the provided search criteria.");
                        } else {
                            System.out.println("\nThe following books match your search:");
                            System.out.println("-------------------\n");
                            for (Book book : results) {
                                book.getInfo();
                            }
                        }
                        System.out.println("Press any key to continue...");
                        try {
                            System.in.read();
                        } catch (Exception ignored) {
                        }
                        break;
                    case "4":
                        showBooks();
                        System.out.println("Press any key to continue...");
                        try {
                            System.in.read();
                        } catch (Exception ignored) {
                        }
                        break;
                    case "5":
                        lmsScanner.close();
                        return;
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
