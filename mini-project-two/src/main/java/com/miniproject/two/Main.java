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
 * search for books, borrow books, return books, and exit the system.
 * The program includes input validation, including ISBN validation for book
 * entries.
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
 * <li>[5] Borrow Book: Prompts the user to enter the ISBN of a book to borrow
 * and the borrower's name.
 * <li>[6] Return Book: Prompts the user to enter the ISBN of a book to return.
 * <li>[7] Exit: Exits the application with a thank you message.
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
     * all books, removing a book, borrowing a book, returning a book,
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
                        showBooksInterface(lmsScanner, library);
                        break;
                    case "2":
                        addBookInterface(lmsScanner, library, false, 0);
                        break;
                    case "3":
                        removeBooksInterface(lmsScanner, library);
                        break;
                    case "4":
                        searchBooksInterface(lmsScanner, library);
                        break;
                    case "5":
                        borrowBookInterface(lmsScanner, library);
                        break;
                    case "6":
                        returnBookInterface(lmsScanner, library);
                        break;
                    case "7":
                        System.out.println(ANSI_YELLOW
                                + "\n\t\tThank you for using the Library Management System. Goodbye!\n\n" + ANSI_RESET);
                        lmsScanner.close();
                        return;

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
    static void printWelcomeMessage() {
        System.out.println(ANSI_GREEN + "\n\t\t-----------------------------------------");
        System.out.println("\t\tWelcome to the Library Management System");
        System.out.println("\t\t-----------------------------------------" + ANSI_RESET);
    }

    /**
     * Prints the main menu options to the console.
     *
     * @return void
     */
    static void printMainMenu() {
        System.out.println(ANSI_YELLOW + "\n\t\t[MAIN MENU] Please select an option:" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "\t\t[1] Book List");
        System.out.println("\t\t[2] Add Book");
        System.out.println("\t\t[3] Remove Books");
        System.out.println("\t\t[4] Search Books");
        System.out.println("\t\t[5] Borrow Book");
        System.out.println("\t\t[6] Return Book");
        System.out.println("\t\t[7] Exit" + ANSI_RESET);
        System.out.print("\t\tEnter Action Number: ");
    }

    /**
     * Displays the interface for showing all books in the library. If there are no
     * books in the library,
     * a message is printed indicating that no books were found. Otherwise, the list
     * of books is printed
     * with headers and footers for each book. Finally, a mini menu is printed.
     *
     * @param lmsScanner the Scanner object used for user input
     * @param library    the Library object to show books from
     */
    private static void showBooksInterface(Scanner lmsScanner, Library library) {

        List<Book> results = library.showBooks();
        if (results.isEmpty()) {
            System.out.println(ANSI_RED + "\n\t\t\tNo books found" + ANSI_RESET);
        } else {
            System.out.println(ANSI_YELLOW + "\n\t\t\tShowing All Books" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "\t\t\t-------------------" + ANSI_RESET);

            for (int i = 0; i < results.size(); i++) {
                Book book = results.get(i);
                if (i == 0) {
                    book.printHeader();
                }
                book.printRow();
                if (i == results.size() - 1) {
                    book.printFooter();
                }
            }

            printMiniMenu(lmsScanner, library);

        }
    }

    /**
     * A function that displays a mini menu interface allowing the user to select
     * options.
     *
     * @param lmsScanner the Scanner object for user input
     * @param library    the Library object containing book data
     * @return void
     */
    static void printMiniMenu(Scanner lmsScanner, Library library) {
        boolean miniMenuLoop = true;
        while (miniMenuLoop) {

            System.out.println(ANSI_YELLOW + "\n\t\t[MINI MENU] Please select an option:" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "\t\t[0] Return to Main Menu");
            System.out.println("\t\t[{Book ID}] Expand and Manage Book" + ANSI_RESET);

            System.out.print("\t\tEnter Action Number: ");
            String action = lmsScanner.nextLine();

            switch (action) {
                case "0":
                    return;
                default:
                    try {
                        int bookId = Integer.parseInt(action);
                        if (bookId >= 1000 && bookId <= 9999) {
                            miniMenuLoop = false;
                            manageBookInterface(lmsScanner, library, bookId);

                        } else {
                            System.out.println(ANSI_RED
                                    + "\t\tInvalid Book ID. Please enter a number between 1000 and 9999." + ANSI_RESET);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(ANSI_RED + "\t\tInvalid input. Please enter a valid number." + ANSI_RESET);
                    }
                    break;
            }
        }
    }

    /**
     * A function that displays a book management interface allowing the user to
     * select options for a specific book.
     *
     * @param lmsScanner the Scanner object for user input
     * @param library    the Library object containing book data
     * @param bookId     the ID of the book to manage
     */
    private static void manageBookInterface(Scanner lmsScanner, Library library, int bookId) {
        List<Book> results = library.showBookById(bookId);
        if (results.isEmpty()) {
            System.out.println(ANSI_RED + "\n\t\t\tNo books found" + ANSI_RESET);
        } else {
            boolean manageBookInterfaceLoop = true;
            while (manageBookInterfaceLoop) {

                for (Book book : results) {
                    book.printData();
                }
                System.out.println(ANSI_YELLOW + "\n\t\t[BOOK MENU] Please select an option:" + ANSI_RESET);
                System.out.println(ANSI_CYAN + "\t\t[1] Update Data");
                System.out.println(ANSI_CYAN + "\t\t[2] Delete Book");
                System.out.println("\t\t[3] Return to Main Menu" + ANSI_RESET);

                System.out.print("\t\tEnter Action Number: ");
                String action = lmsScanner.nextLine();

                switch (action) {
                    case "1":
                        addBookInterface(lmsScanner, library, true, bookId);
                        break;
                    case "2":
                        library.removeBookById(bookId);
                        break;
                    case "3":

                        manageBookInterfaceLoop = false;
                        return;
                    default:
                        System.out.println(ANSI_RED + "\t\tInvalid input. Please enter a valid number." + ANSI_RESET);
                        break;
                }
            }
        }

    }

    /**
     * Adds a book to the library. Updates it instead of params indicate whether the
     * book is an existing document
     *
     * @param scanner       the Scanner object used for user input
     * @param library       the Library object to which the book will be added
     * @param isExistingDoc a boolean indicating whether the book is an existing
     *                      document
     * @param bookId        the ID of the book to be updated (if it is an existing
     *                      document)
     */
    static void addBookInterface(Scanner scanner, Library library, Boolean isExistingDoc, int bookId) {
        System.out.println(ANSI_GREEN + "\n\t\t\t--- Adding a Book ---" + ANSI_RESET);

        String bookTitle = getValidStringInput(scanner, "\t\t\tTitle: ");
        String bookAuthor = getValidStringInput(scanner, "\t\t\tAuthor: ");

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

        String bookGenre = getValidStringInput(scanner, "\t\t\tGenre: ");
        String bookSubgenre = getValidStringInput(scanner, "\t\t\tSubgenre: ");
        String bookNationality = getValidStringInput(scanner, "\t\t\tAuthor Nationality: ");
        String publicationFormat = getValidStringInput(scanner, "\t\t\tPublication Format (eBook, Paperback, etc.): ");

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

        String publisherName = getValidStringInput(scanner, "\t\t\tPublisher Name: ");
        String deweyDecimal = getValidStringInput(scanner, "\t\t\tDewey Decimal: ");

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

        if (isExistingDoc) {
            try {
                library.updateBook(bookId, bookTitle, bookAuthor, bookISBN, bookGenre, bookSubgenre, bookNationality,
                        publicationFormat, publishedYear, publisherName, deweyDecimal, isAvailable, borrowedByUserName);
                System.out.println(ANSI_GREEN + "\n\t\t\tBook Updated Successfully" + ANSI_RESET);
            } catch (Exception e) {
                System.out.println(ANSI_RED + "\n\t\t\tError updating book: " + e.getMessage() + ANSI_RESET);
            }
        } else {
            try {
                library.addBook(bookTitle, bookAuthor, bookISBN, bookGenre, bookSubgenre, bookNationality,
                        publicationFormat, publishedYear, publisherName, deweyDecimal, isAvailable, borrowedByUserName);
                System.out.println(ANSI_GREEN + "\n\t\t\tBook Added Successfully" + ANSI_RESET);
            } catch (Exception e) {
                System.out.println(ANSI_RED + "\n\t\t\tError adding book: " + e.getMessage() + ANSI_RESET);
            }
        }
    }

    /**
     * Removes books from the library based on the user's search term.
     *
     * @param scanner the Scanner object used for user input
     * @param library the Library object from which books will be removed
     */
    static void removeBooksInterface(Scanner scanner, Library library) {
        System.out.println(ANSI_YELLOW + "\n\t\t\t--- Remove Books ---" + ANSI_RESET);
        System.out.print("\t\t\tEnter search term for deletion: ");
        String toDelete = scanner.nextLine();
        List<Book> results = library.removeBook(toDelete);
        if (results.isEmpty()) {
            System.out.println(ANSI_RED + "\n\t\t\tNo books found with the provided search criteria." + ANSI_RESET);
        } else {
            System.out.println(ANSI_GREEN + "\n\t\t\tThe following books have been deleted:" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "\t\t\t-------------------" + ANSI_RESET);
            for (int i = 0; i < results.size(); i++) {
                Book book = results.get(i);
                if (i == 0) {
                    book.printHeader();
                }
                book.printRow();
                if (i == results.size() - 1) {
                    book.printFooter();
                }
            }
        }
    }

    /**
     * Searches for books in the library based on the user's search term.
     *
     * @param scanner the Scanner object used for user input
     * @param library the Library object to search for books
     */
    static void searchBooksInterface(Scanner scanner, Library library) {
        System.out.println(ANSI_YELLOW + "\n\t\t\t--- Search Books ---" + ANSI_RESET);
        System.out.print("\t\t\tEnter search term: ");
        String searchTerm = scanner.nextLine();
        List<Book> results = library.searchBooks(searchTerm);
        if (results.isEmpty()) {
            System.out.println(ANSI_RED + "\n\t\t\tNo books found with the provided search criteria." + ANSI_RESET);
        } else {
            System.out.println(ANSI_GREEN + "\n\t\t\tThe following books match your search:" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "\t\t\t-------------------" + ANSI_RESET);
            for (int i = 0; i < results.size(); i++) {
                Book book = results.get(i);
                if (i == 0) {
                    book.printHeader();
                }
                book.printRow();
                if (i == results.size() - 1) {
                    book.printFooter();
                }
            }

            printMiniMenu(scanner, library);
        }
    }

    /**
     * Prompts the user to enter the ISBN and borrower name, and then calls the
     * borrowBook method of the library object
     * to borrow a book with the given ISBN and borrower name.
     *
     * @param scanner the Scanner object used for user input
     * @param library the Library object where the book will be borrowed
     */
    protected static void borrowBookInterface(Scanner scanner, Library library) {
        System.out.println(ANSI_YELLOW + "\n\t\t\t--- Borrow Books ---" + ANSI_RESET);
        System.out.print("\t\t\tISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("\t\t\tBorrower Name: ");
        String borrowerName = scanner.nextLine();
        library.borrowBook(isbn, borrowerName);
    }

    /**
     * Prompts the user to enter the ISBN of the book they want to return, and then
     * calls the returnBook method of the library object
     * to return the book with the given ISBN.
     *
     * @param scanner the Scanner object used for user input
     * @param library the Library object from which the book will be returned
     */
    protected static void returnBookInterface(Scanner scanner, Library library) {
        System.out.println(ANSI_YELLOW + "\n\t\t\t--- Return Book ---" + ANSI_RESET);
        System.out.print("\t\t\tISBN: ");
        String isbn = scanner.nextLine();
        library.returnBook(isbn);
    }

    /**
     * A method that prompts the user to press any key to continue.
     *
     * @param scanner the Scanner object used for input
     */
    private static void pressAnyKeyToContinue(Scanner scanner) {
        System.out.println(ANSI_YELLOW + "\n\t\tPress any key to continue..." + ANSI_RESET);
        try {
            // Consume the next key press and ignore additional input
            System.in.read();
            // Clear any remaining input in the buffer
            while (System.in.available() > 0) {
                System.in.read();
            }
        } catch (IOException e) {
            System.err.println("\t\tError reading input: " + e.getMessage());
        }
    }

    /**
     * Retrieves a valid string input from the user.
     *
     * @param scanner the Scanner object used for user input
     * @param prompt  the prompt to display to the user
     * @return the valid string input entered by the user
     */
    private static String getValidStringInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(ANSI_CYAN + prompt + ANSI_RESET);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println(ANSI_RED + "\t\t\tInvalid input. Please enter a non-empty value." + ANSI_RESET);
            }
        }
    }

}