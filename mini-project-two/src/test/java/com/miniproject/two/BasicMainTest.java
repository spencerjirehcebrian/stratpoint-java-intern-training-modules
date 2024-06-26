package com.miniproject.two;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Scanner;

public class BasicMainTest {

    private Library library;
    private Scanner scanner;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        library = new Library();
        scanner = new Scanner(System.in);
    }

    @Test
    public void testAddBookInterface() {
        scanner = new Scanner("Title\nAuthor\n978-0-545-01022-1\nGenre\nSubgenre\nNationality\n"
                + "PublicationFormat\n2020\nPublisherName\n123.456\ntrue\nBorrower\n");

        Main.addBookInterface(scanner, library, false, 1001);

        List<Book> books = library.searchBooks("978-0-545-01022-1");
        assertFalse(books.isEmpty());
    }

    @Test
    public void testPrintMainMenu() {
        System.setOut(new java.io.PrintStream(outContent));

        Main.printMainMenu();

        assertTrue(outContent.toString().contains("[MAIN MENU]"));
    }

    @Test
    public void testPrintWelcomeMessage() {
        // Redirect console output
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        Main.printWelcomeMessage();

        assertTrue(outContent.toString().contains("Welcome to the Library Management System"));
    }

    @Test
    public void testRemoveBookInterface() {
        scanner = new Scanner("Title\nAuthor\n978-0-545-01022-1\nGenre\nSubgenre\nNationality\n"
                + "PublicationFormat\n2020\nPublisherName\n123.456\ntrue\nBorrower\n");

        Main.addBookInterface(scanner, library, false, 1001);

        scanner = new Scanner("978-0-545-01022-1\n");

        Main.removeBooksInterface(scanner, library);

        assertTrue(library.searchBooks("978-0-545-01022-1").isEmpty());
    }

    @Test
    public void testSearchBooksInterface() {
        scanner = new Scanner("Title\nAuthor\n978-0-545-01022-1\nGenre\nSubgenre\nNationality\n"
                + "PublicationFormat\n2020\nPublisherName\n123.456\ntrue\nBorrower\n");

        Main.addBookInterface(scanner, library, false, 1001);

        scanner = new Scanner("Title\n0\n");

        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        Main.searchBooksInterface(scanner, library);

        assertTrue(outContent.toString().contains("Title"));
    }

    @Test
    public void testBorrowBookInterface() {
        scanner = new Scanner("Title\nAuthor\n978-0-545-01022-1\nGenre\nSubgenre\nNationality\n"
                + "PublicationFormat\n2020\nPublisherName\n123.456\ntrue\nBorrower\n");

        Main.addBookInterface(scanner, library, false, 1001);

        scanner = new Scanner("978-0-545-01022-1\nBorrowerName\n");

        Main.borrowBookInterface(scanner, library);

        List<Book> books = library.searchBooks("978-0-545-01022-1");
        assertFalse(books.isEmpty());
        assertFalse(books.get(0).isAvailable());
    }

    @Test
    public void testReturnBookInterface() {
        scanner = new Scanner("Title\nAuthor\n978-0-545-01022-1\nGenre\nSubgenre\nNationality\n"
                + "PublicationFormat\n2020\nPublisherName\n123.456\ntrue\nBorrower\n");

        Main.addBookInterface(scanner, library, false, 1001);

        scanner = new Scanner("978-0-545-01022-1\nBorrowerName\n");

        Main.borrowBookInterface(scanner, library);

        scanner = new Scanner("978-0-545-01022-1\n");

        Main.returnBookInterface(scanner, library);

        List<Book> books = library.searchBooks("978-0-545-01022-1");
        assertFalse(books.isEmpty());
        assertTrue(books.get(0).isAvailable());
    }

    @Test
    public void testUpdateBook() {
        scanner = new Scanner("Title\nAuthor\n978-0-545-01022-1\nGenre\nSubgenre\nNationality\n"
                + "PublicationFormat\n2020\nPublisherName\n123.456\ntrue\nBorrower\n");

        Main.addBookInterface(scanner, library, false, 1001);

        List<Book> books = library.searchBooks("978-0-545-01022-1");
        assertFalse(books.isEmpty());

        int bookId = books.get(0).getBookId();
        library.updateBook(bookId, "NewTitle", "NewAuthor", "978-0-545-01022-1", "NewGenre",
                "NewSubgenre", "NewNationality", "NewFormat", 2021, "NewPublisher",
                "456.789", false, "NewBorrower");

        books = library.searchBooks("978-0-545-01022-1");
        assertFalse(books.isEmpty());
        assertEquals("NewTitle", books.get(0).getTitle());
        assertEquals("NewAuthor", books.get(0).getAuthor());
        assertEquals(2021, books.get(0).getPublishedYear());
    }

    @Test
    public void testShowBooks() {
        List<Book> books = library.showBooks();
        assertTrue(books.isEmpty());

        scanner = new Scanner("Title\nAuthor\n978-0-545-01022-1\nGenre\nSubgenre\nNationality\n"
                + "PublicationFormat\n2020\nPublisherName\n123.456\ntrue\nBorrower\n");

        Main.addBookInterface(scanner, library, false, 1001);
        books = library.showBooks();
        assertFalse(books.isEmpty());
        assertEquals(1, books.size());
    }

    @Test
    public void testShowBookById() {
        scanner = new Scanner("Title\nAuthor\n978-0-545-01022-1\nGenre\nSubgenre\nNationality\n"
                + "PublicationFormat\n2020\nPublisherName\n123.456\ntrue\nBorrower\n");

        Main.addBookInterface(scanner, library, false, 1001);

        List<Book> books = library.searchBooks("978-0-545-01022-1");
        assertFalse(books.isEmpty());

        int bookId = books.get(0).getBookId();

        // Test showBookById
        books = library.showBookById(bookId);
        assertFalse(books.isEmpty());
        assertEquals(1, books.size());
        assertEquals(bookId, books.get(0).getBookId());
    }

}
