package com.example.miniprojecttwo;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MainTest {

    /**
     * Sets up the test environment by clearing the book list before each test.
     */
    @Before
    public void setUp() {
        Main.books.clear(); 
    }

    /**
     * Test case for the addBook method in the Main class.
     *
     * This test adds a book with the title "Test Title", author "Test Author", and ISBN "1234567890"
     * to the book list. It then asserts that the size of the book list is 1 and that the title of the
     * first book in the list is "Test Title".
     *
     * @throws AssertionError if the size of the book list is not 1 or if the title of the first book in
     *                        the list is not "Test Title".
     */
    @Test
    public void testAddBook() {
        Main.addBook("Test Title", "Test Author", "1234567890");
        assertEquals(1, Main.books.size());
        assertEquals("Test Title", Main.books.get(0).getTitle());
    }

    /**
     * Test case for the removeBook method in the Main class.
     *
     * This test adds a book with the title "Test Title", author "Test Author", and ISBN "1234567890"
     * to the book list. It then asserts that the size of the book list is 1.
     *
     * After removing the book with the title "Test Title" from the book list, it asserts that the book list is empty.
     *
     * @throws AssertionError if the size of the book list is not 1 or if the book list is not empty after removing the book.
     */
    @Test
    public void testRemoveBook() {
        Main.addBook("Test Title", "Test Author", "1234567890");
        assertEquals(1, Main.books.size());

        Main.removeBook("Test Title");
        assertTrue(Main.books.isEmpty());
    }

    /**
     * Test case for the showBooks method in the Main class.
     *
     * This test adds a book with the title "Test Title", author "Test Author", and ISBN "1234567890"
     * to the book list. It then redirects the console output to check the print statements.
     * It asserts that the output contains the expected output string.
     *
     * @throws AssertionError if the output does not contain the expected output string.
     */
    @Test
    public void testShowBooks() {
        Main.addBook("Test Title", "Test Author", "1234567890");

        // Redirecting console output to check the print statements
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        Main.showBooks();
        String expectedOutput = "\nShowing All Books\n-------------------\n";
        assertTrue(outContent.toString().contains(expectedOutput));

        // Resetting the standard output
        System.setOut(System.out);
    }

    /**
     * Test case for searching books by a specific title.
     *
     * @return The list of books matching the search criteria.
     */
    @Test
    public void testSearchBooks() {
        Main.addBook("Test Title", "Test Author", "1234567890");

        List<Book> results = Main.searchBooks("Test Title");
        assertEquals(1, results.size());
        assertEquals("Test Title", results.get(0).getTitle());
    }
}
