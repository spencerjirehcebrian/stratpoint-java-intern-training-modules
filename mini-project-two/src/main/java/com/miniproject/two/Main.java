package com.miniproject.two;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.validator.routines.ISBNValidator;

/**
 * Library Management System
 *
 * This program provides a simple console-based library management system.
 * It allows users to add books, display a list of books, remove books,
 * search for books, and exit the system. The program includes input validation,
 * including ISBN validation for book entries.
 *
 * The main menu offers the following options:
 * <ul>
 * <li>[1] Add Book: Prompts the user to enter details of a new book and adds it
 * to the library.
 * <li>[2] Book List: Displays all the books currently in the library.
 * <li>[3] Remove Books: Prompts the user to enter a search term and removes
 * matching books from the library.
 * <li>[4] Search Books: Prompts the user to enter a search term and displays
 * matching books from the library.
 * <li>[5] Exit: Exits the application with a thank you message.
 * </ul>
 *
 * Input validation includes:
 * <ul>
 * <li>ISBN: Ensures that the ISBN is either a valid 10-digit or 13-digit
 * number.
 * <li>Published Year: Ensures that the published year is a valid integer.
 * <li>Availability: Ensures that the availability status is either 'true' or
 * 'false'.
 * </ul>
 *
 * The program uses ANSI escape codes for color formatting in the console.
 *
 * @version 1.0
 * @since 2024-06-25
 */
public class Main {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";

    /**
     * The main entry point of the Java program.
     *
     * This method creates a new instance of the Library class and initializes a
     * Scanner object to read user input.
     * It then enters a loop that displays a main menu and waits for user input.
     *
     * The user can choose from several options, including adding a book, displaying
     * all books, removing a book,
     * searching for a book, and quitting the program.
     * 
     * @param args the command line arguments
     * @return void
     */
    public static void main(String[] args) {
        Library library = new Library();
        Scanner lmsScanner = new Scanner(System.in);

        try {
            printWelcomeMessage();

            while (true) {
                printMainMenu();
                String action = lmsScanner.nextLine();

                switch (action) {
                    case "1":
                        addBookInterface(lmsScanner, library);
                        break;
                    case "2":
                        library.showBooks();
                        break;
                    case "3":
                        removeBooksInterface(lmsScanner, library);
                        break;
                    case "4":
                        searchBooksInterface(lmsScanner, library);
                        break;
                    case "5":
                        System.out.println(ANSI_YELLOW
                                + "\n\t\tThank you for using the Library Management System. Goodbye!\n\n" + ANSI_RESET);
                        lmsScanner.close();
                        return;
                    // TODO: Implement 2 new cases for checking out and returning books
                    default:
                        System.out.println(ANSI_RED + "\n\t\tInvalid option. Please try again." + ANSI_RESET);
                }
                pressAnyKeyToContinue(lmsScanner);
            }
        } catch (Exception e) {
            System.out.println(ANSI_RED + "\t\tAn error occurred: " + e.getMessage() + ANSI_RESET);
        }
    }

    /**
     * Prints a welcome message for the Library Management System.
     *
     * This function prints a formatted welcome message to the console using ANSI
     * escape
     * sequences for color. The message includes the title "Welcome to the Library
     * Management
     * System" surrounded by a green rectangle.
     *
     * @return void
     */
    private static void printWelcomeMessage() {
        System.out.println(ANSI_GREEN + "\n\t\t-----------------------------------------");
        System.out.println("\t\tWelcome to the Library Management System");
        System.out.println("\t\t-----------------------------------------" + ANSI_RESET);
    }

    /**
     * Prints the main menu options to the console.
     *
     * @return void
     */
    private static void printMainMenu() {
        System.out.println(ANSI_YELLOW + "\n\t\tPlease select an option:" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "\t\t[1] Add Book");
        System.out.println("\t\t[2] Book List");
        System.out.println("\t\t[3] Remove Books");
        System.out.println("\t\t[4] Search Books");
        System.out.println("\t\t[5] Exit" + ANSI_RESET);
        System.out.print("\t\tEnter Action Number: ");
    }

    /**
     * Adds a new book to the library by prompting the user for book details and
     * validating input.
     *
     * @param scanner the Scanner object used for user input
     * @param library the Library object where the book will be added
     */
    private static void addBookInterface(Scanner scanner, Library library) {
        System.out.println(ANSI_GREEN + "\n\t\t\t--- Adding a Book ---" + ANSI_RESET);

        System.out.print(ANSI_CYAN + "\t\t\tTitle: " + ANSI_RESET);
        String bookTitle = scanner.nextLine();

        System.out.print(ANSI_CYAN + "\t\t\tAuthor: " + ANSI_RESET);
        String bookAuthor = scanner.nextLine();

        String bookISBN;
        while (true) {
            System.out.print(ANSI_CYAN + "\t\t\tISBN: " + ANSI_RESET);
            bookISBN = scanner.nextLine().trim();
            ISBNValidator validator = new ISBNValidator();
            boolean isValidISBN = validator.isValid(bookISBN);
            if (isValidISBN) {
                break;
            } else {
                System.out.println(
                        ANSI_RED + "\t\t\tInvalid ISBN. Please enter a valid 10 or 13 digit ISBN." + ANSI_RESET);
            }
        }

        System.out.print(ANSI_CYAN + "\t\t\tGenre: " + ANSI_RESET);
        String bookGenre = scanner.nextLine();

        System.out.print(ANSI_CYAN + "\t\t\tSubgenre: " + ANSI_RESET);
        String bookSubgenre = scanner.nextLine();

        System.out.print(ANSI_CYAN + "\t\t\tAuthor Nationality: " + ANSI_RESET);
        String bookNationality = scanner.nextLine();

        System.out.print(ANSI_CYAN + "\t\t\tPublication Format (eBook, Paperback, etc.): " + ANSI_RESET);
        String publicationFormat = scanner.nextLine();

        int publishedYear = 0;
        while (true) {
            System.out.print(ANSI_CYAN + "\t\t\tPublished Year: " + ANSI_RESET);
            try {
                publishedYear = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "\t\t\tInvalid year. Please enter a valid number." + ANSI_RESET);
            }
        }

        System.out.print(ANSI_CYAN + "\t\t\tPublisher Name: " + ANSI_RESET);
        String publisherName = scanner.nextLine();

        System.out.print(ANSI_CYAN + "\t\t\tDewey Decimal: " + ANSI_RESET);
        String deweyDecimal = scanner.nextLine();

        boolean isAvailable = false;
        while (true) {
            System.out.print(ANSI_CYAN + "\t\t\tIs Available (true/false): " + ANSI_RESET);
            String isAvailableInput = scanner.nextLine().trim().toLowerCase();
            if (isAvailableInput.equals("true") || isAvailableInput.equals("false")) {
                isAvailable = Boolean.parseBoolean(isAvailableInput);
                break;
            } else {
                System.out.println(ANSI_RED + "\t\t\tInvalid input. Please enter 'true' or 'false'." + ANSI_RESET);
            }
        }

        System.out.print(ANSI_CYAN + "\t\t\tBorrowed By (leave empty if not borrowed): " + ANSI_RESET);
        String borrowedByUserName = scanner.nextLine();

        try {
            library.addBook(bookTitle, bookAuthor, bookISBN, bookGenre, bookSubgenre, bookNationality,
                    publicationFormat, publishedYear, publisherName, deweyDecimal, isAvailable,
                    borrowedByUserName);
            System.out.println(ANSI_GREEN + "\n\t\t\tBook Added Successfully" + ANSI_RESET);
        } catch (Exception e) {
            System.out.println(ANSI_RED + "\n\t\t\tError adding book: " + e.getMessage() + ANSI_RESET);
        }
    }

    /**
     * Removes books from the library based on the user's search term.
     *
     * @param scanner the Scanner object used for user input
     * @param library the Library object from which books will be removed
     */
    private static void removeBooksInterface(Scanner scanner, Library library) {
        System.out.println(ANSI_YELLOW + "\n\t\t\t--- Remove Books ---" + ANSI_RESET);
        System.out.print("\t\t\tEnter search term for deletion: ");
        String toDelete = scanner.nextLine();
        List<Book> deleteResults = library.removeBook(toDelete);
        if (deleteResults.isEmpty()) {
            System.out.println(ANSI_RED + "\n\t\t\tNo books found with the provided search criteria." + ANSI_RESET);
        } else {
            System.out.println(ANSI_GREEN + "\n\t\t\tThe following books have been deleted:" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "\t\t\t-------------------" + ANSI_RESET);
            for (Book book : deleteResults) {
                book.printData();
            }
        }
    }

    /**
     * Searches for books in the library based on the user's search term.
     *
     * @param scanner the Scanner object used for user input
     * @param library the Library object to search for books
     */
    private static void searchBooksInterface(Scanner scanner, Library library) {
        System.out.println(ANSI_YELLOW + "\n\t\t\t--- Search Books ---" + ANSI_RESET);
        System.out.print("\t\t\tEnter search term: ");
        String searchTerm = scanner.nextLine();
        List<Book> results = library.searchBooks(searchTerm);
        if (results.isEmpty()) {
            System.out.println(ANSI_RED + "\n\t\t\tNo books found with the provided search criteria." + ANSI_RESET);
        } else {
            System.out.println(ANSI_GREEN + "\n\t\t\tThe following books match your search:" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "\t\t\t-------------------" + ANSI_RESET);
            for (Book book : results) {
                book.printData();
            }
        }
    }

    /**
     * A method that prompts the user to press Enter or any key TBH to continue.
     *
     * @param scanner the Scanner object used for input
     */
    public static void pressAnyKeyToContinue(Scanner scanner) {
        System.out.println(ANSI_YELLOW + "\n\t\tPress Enter to continue..." + ANSI_RESET);
        try {
            System.in.read();
        } catch (IOException e) {
            System.err.println("\t\tError reading input: " + e.getMessage());
        }
    }
}