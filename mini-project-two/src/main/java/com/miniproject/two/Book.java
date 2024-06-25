package com.miniproject.two;

/**
 * Class representing a book in a library.
 * Extends BookData to inherit common book data fields.
 */
public class Book extends BookData {
    /**
     * Constructor for Book.
     *
     * @param title              book title
     * @param author             book author
     * @param ISBN               book ISBN
     * @param genre              book genre
     * @param subgenre           book subgenre
     * @param nationality        book author's nationality
     * @param publicationFormat  book publication format
     * @param publishedYear      book published year
     * @param publisherName      book publisher's name
     * @param deweyDecimal       book Dewey decimal number
     * @param isAvailable        book availability status
     * @param borrowedByUserName book's borrower username, if any
     */
    public Book(String title, String author, String ISBN, String genre, String subgenre, String nationality,
            String publicationFormat, int publishedYear, String publisherName,
            String deweyDecimal, boolean isAvailable, String borrowedByUserName) {
        super(title, author, ISBN, genre, subgenre, nationality, publicationFormat, publishedYear, publisherName,
                deweyDecimal, isAvailable, borrowedByUserName);
    }

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_GREEN = "\u001B[32m";

    /**
     * Prints the book's data in a formatted table.
     */
    @Override
    public void printData() {
        String format = "\t\t\t| %-20s | %-40s |\n";
        System.out.println(
                ANSI_CYAN + "\t\t\t+----------------------+------------------------------------------+" + ANSI_RESET);
        System.out.printf(ANSI_GREEN + format + ANSI_RESET, "Title", getTitle());
        System.out.println(
                ANSI_CYAN + "\t\t\t+----------------------+------------------------------------------+" + ANSI_RESET);

        System.out.printf(ANSI_YELLOW + format + ANSI_RESET, "Author", getAuthor());
        System.out.printf(ANSI_YELLOW + format + ANSI_RESET, "ISBN", getISBN());
        System.out.printf(ANSI_YELLOW + format + ANSI_RESET, "Genre", getGenre());
        System.out.printf(ANSI_YELLOW + format + ANSI_RESET, "Subgenre", getSubgenre());
        System.out.printf(ANSI_YELLOW + format + ANSI_RESET, "Nationality", getNationality());
        System.out.printf(ANSI_YELLOW + format + ANSI_RESET, "Publication Format", getPublicationFormat());
        System.out.printf(ANSI_YELLOW + format + ANSI_RESET, "Published Year", String.valueOf(getPublishedYear()));
        System.out.printf(ANSI_YELLOW + format + ANSI_RESET, "Publisher Name", getPublisherName());
        System.out.printf(ANSI_YELLOW + format + ANSI_RESET, "Dewey Decimal", getDeweyDecimal());
        System.out.printf(ANSI_YELLOW + format + ANSI_RESET, "Is Available", String.valueOf(isAvailable()));
        System.out.printf(ANSI_YELLOW + format + ANSI_RESET, "Borrowed By", getBorrowedByUserName());
        System.out.println(
                ANSI_CYAN + "\t\t\t+----------------------+------------------------------------------+" + ANSI_RESET);
        System.out.println();
    }
}
