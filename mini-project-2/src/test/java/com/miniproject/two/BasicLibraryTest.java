package com.miniproject.two;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class BasicLibraryTest {

    private Library library;

    @Before
    public void setUp() {
        library = new Library();
        library.addBook("Test Title", "Test Author", "978-0-545-01022-1", "Test Genre", "Test Subgenre",
                "Test Nationality", "Test PublicationFormat", 2020, "Test PublisherName", "123.456", true,
                "Test Borrower");
    }

    @Test
    public void testAddBook() {
        List<Book> books = library.showBooks();
        assertFalse(books.isEmpty());
        assertEquals(1, books.size());
        assertEquals("Test Title", books.get(0).getTitle());
    }

    @Test
    public void testShowBooks() {
        List<Book> books = library.showBooks();
        assertFalse(books.isEmpty());
        assertEquals(1, books.size());
    }

    @Test
    public void testSearchBooks() {
        List<Book> books = library.searchBooks("978-0-545-01022-1");
        assertFalse(books.isEmpty());
        assertEquals(1, books.size());
        assertEquals("Test Title", books.get(0).getTitle());
    }

    @Test
    public void testUpdateBook() {
        int globalBookId = library.getBooks().get(0).getBookId();
        library.updateBook(globalBookId, "New Title", "New Author", "123-4-567-89012-3", "New Genre", "New Subgenre",
                "New Nationality", "New PublicationFormat", 2021, "New PublisherName", "654.321", true, "New Borrower");
        List<Book> books = library.searchBooks("123-4-567-89012-3");
        assertFalse(books.isEmpty());
        assertEquals("New Title", books.get(0).getTitle());
    }

    @Test
    public void testBorrowBook() {
        boolean result = library.borrowBook("978-0-545-01022-1", "BorrowerName");
        assertTrue(result);
        List<Book> books = library.searchBooks("978-0-545-01022-1");
        assertFalse(books.get(0).isAvailable());
    }

    @Test
    public void testReturnBook() {
        library.borrowBook("978-0-545-01022-1", "BorrowerName");
        boolean result = library.returnBook("978-0-545-01022-1");
        assertTrue(result);
        List<Book> books = library.searchBooks("978-0-545-01022-1");
        assertTrue(books.get(0).isAvailable());
    }

    @Test
    public void testRemoveBook() {
        library.removeBook("978-0-545-01022-1");
        List<Book> books = library.searchBooks("978-0-545-01022-1");
        assertTrue(books.isEmpty());
    }

}
