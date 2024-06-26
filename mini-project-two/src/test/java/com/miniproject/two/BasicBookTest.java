package com.miniproject.two;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasicBookTest {

    private Book book;

    @Before
    public void setUp() {
        book = new Book(1, "Title", "Author", "978-0-545-01022-1", "Genre", "Subgenre",
                "Nationality", "PublicationFormat", 2020, "PublisherName", "123.456", true, "Borrower");
    }

    @Test
    public void testGetBookId() {
        assertEquals(1, book.getBookId());
    }

    @Test
    public void testGetTitle() {
        assertEquals("Title", book.getTitle());
    }

    @Test
    public void testSetTitle() {
        book.setTitle("New Title");
        assertEquals("New Title", book.getTitle());
    }

    @Test
    public void testGetAuthor() {
        assertEquals("Author", book.getAuthor());
    }

    @Test
    public void testSetAuthor() {
        book.setAuthor("New Author");
        assertEquals("New Author", book.getAuthor());
    }

    @Test
    public void testGetISBN() {
        assertEquals("978-0-545-01022-1", book.getISBN());
    }

    @Test
    public void testSetISBN() {
        book.setISBN("978-3-16-148410-0");
        assertEquals("978-3-16-148410-0", book.getISBN());
    }

    @Test
    public void testGetGenre() {
        assertEquals("Genre", book.getGenre());
    }

    @Test
    public void testSetGenre() {
        book.setGenre("New Genre");
        assertEquals("New Genre", book.getGenre());
    }

    @Test
    public void testGetSubgenre() {
        assertEquals("Subgenre", book.getSubgenre());
    }

    @Test
    public void testSetSubgenre() {
        book.setSubgenre("New Subgenre");
        assertEquals("New Subgenre", book.getSubgenre());
    }

    @Test
    public void testGetNationality() {
        assertEquals("Nationality", book.getNationality());
    }

    @Test
    public void testSetNationality() {
        book.setNationality("New Nationality");
        assertEquals("New Nationality", book.getNationality());
    }

    @Test
    public void testGetPublicationFormat() {
        assertEquals("PublicationFormat", book.getPublicationFormat());
    }

    @Test
    public void testSetPublicationFormat() {
        book.setPublicationFormat("New PublicationFormat");
        assertEquals("New PublicationFormat", book.getPublicationFormat());
    }

    @Test
    public void testGetPublishedYear() {
        assertEquals(2020, book.getPublishedYear());
    }

    @Test
    public void testSetPublishedYear() {
        book.setPublishedYear(2021);
        assertEquals(2021, book.getPublishedYear());
    }

    @Test
    public void testGetPublisherName() {
        assertEquals("PublisherName", book.getPublisherName());
    }

    @Test
    public void testSetPublisherName() {
        book.setPublisherName("New PublisherName");
        assertEquals("New PublisherName", book.getPublisherName());
    }

    @Test
    public void testGetDeweyDecimal() {
        assertEquals("123.456", book.getDeweyDecimal());
    }

    @Test
    public void testSetDeweyDecimal() {
        book.setDeweyDecimal("654.321");
        assertEquals("654.321", book.getDeweyDecimal());
    }

    @Test
    public void testIsAvailable() {
        assertTrue(book.isAvailable());
    }

    @Test
    public void testSetAvailable() {
        book.setAvailable(false);
        assertFalse(book.isAvailable());
    }

    @Test
    public void testGetBorrowedByUserName() {
        assertEquals("Borrower", book.getBorrowedByUserName());
    }

    @Test
    public void testSetBorrowedByUserName() {
        book.setBorrowedByUserName("NewBorrower");
        assertEquals("NewBorrower", book.getBorrowedByUserName());
    }
}
