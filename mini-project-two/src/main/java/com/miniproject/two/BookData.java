package com.miniproject.two;

/**
 * This abstract class BookData is the base class for Book and Periodical
 * classes.
 * It contains common fields and methods for all types of literature.
 *
 * @author Hafizuddeen Lukman
 * @version 1.0
 */
abstract public class BookData implements DataInterface {

    private final int bookId;
    /**
     * LiteratureData object for storing title, genre, and subgenre of the
     * literature.
     */
    private LiteratureData literatureData;
    /**
     * AuthorData object for storing author's name and nationality.
     */
    private AuthorData authorData;
    /**
     * PublisherData object for storing publisher's name, ISBN, publication format,
     * and published year.
     */
    private PublisherData publisherData;
    /**
     * ManagementData object for storing management data such as dewey decimal,
     * availability, and borrowed by user name.
     */
    private ManagementData managementData;

    /**
     * Constructs a BookData object with the given parameters.
     *
     * @param bookId             the ID of the book
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
    public BookData(int bookId, String title, String author, String isbn, String genre, String subgenre,
            String nationality,
            String publicationFormat, int publishedYear, String publisherName,
            String deweyDecimal, boolean isAvailable, String borrowedByUserName) {
        this.bookId = bookId;
        this.literatureData = new LiteratureData(title, genre, subgenre);
        this.authorData = new AuthorData(author, nationality);
        this.publisherData = new PublisherData(isbn, publicationFormat, publishedYear, publisherName);
        this.managementData = new ManagementData(deweyDecimal, isAvailable, borrowedByUserName);
    }

    /**
     * Returns the title of the literature.
     *
     * @return the title of the literature
     */
    public int getBookId() {
        return this.bookId;
    }

    /**
     * Returns the title of the literature.
     *
     * @return the title of the literature
     */
    public String getTitle() {
        return literatureData.getTitle();
    }

    /**
     * Returns the author of the literature.
     *
     * @return the author of the literature
     */
    public String getAuthor() {
        return authorData.getAuthor();
    }

    /**
     * Returns the ISBN of the literature.
     *
     * @return the ISBN of the literature
     */
    public String getISBN() {
        return publisherData.getISBN();
    }

    /**
     * Returns the genre of the literature.
     *
     * @return the genre of the literature
     */
    public String getGenre() {
        return literatureData.getGenre();
    }

    /**
     * Returns the subgenre of the literature.
     *
     * @return the subgenre of the literature
     */
    public String getSubgenre() {
        return literatureData.getSubgenre();
    }

    /**
     * Returns the nationality of the author.
     *
     * @return the nationality of the author
     */
    public String getNationality() {
        return authorData.getNationality();
    }

    /**
     * Returns the publication format of the literature.
     *
     * @return the publication format of the literature
     */
    public String getPublicationFormat() {
        return publisherData.getPublicationFormat();
    }

    /**
     * Returns the year the literature was published.
     *
     * @return the year the literature was published
     */
    public int getPublishedYear() {
        return publisherData.getPublishedYear();
    }

    /**
     * Returns the name of the publisher.
     *
     * @return the name of the publisher
     */
    public String getPublisherName() {
        return publisherData.getPublisherName();
    }

    /**
     * Returns the Dewey decimal classification.
     *
     * @return the Dewey decimal classification
     */
    public String getDeweyDecimal() {
        return managementData.getDeweyDecimal();
    }

    /**
     * Returns whether the literature is available or not.
     *
     * @return true if the literature is available, false otherwise
     */
    public boolean isAvailable() {
        return managementData.isAvailable();
    }

    /**
     * Returns the username of the user who borrowed the literature.
     *
     * @return the username of the user who borrowed the literature
     */
    public String getBorrowedByUserName() {
        return managementData.getBorrowedByUserName();
    }

    /**
     * Sets whether the literature is available or not.
     *
     * @param available whether the literature is available or not
     */
    public void setAvailable(boolean available) {
        managementData.setAvailable(available);
    }

    /**
     * Sets the username of the user who borrowed the literature.
     *
     * @param borrowedByUserName the username of the user who borrowed the
     *                           literature
     */
    public void setBorrowedByUserName(String borrowedByUserName) {
        managementData.setBorrowedByUserName(borrowedByUserName);
    }

    public void setTitle(String title) {
        literatureData.setTitle(title);
    }

    public void setGenre(String genre) {
        literatureData.setGenre(genre);
    }

    public void setSubgenre(String subgenre) {
        literatureData.setSubgenre(subgenre);
    }

    public void setAuthor(String author) {
        authorData.setAuthor(author);
    }

    public void setNationality(String nationality) {
        authorData.setNationality(nationality);
    }

    public void setISBN(String isbn) {
        publisherData.setISBN(isbn);
    }

    public void setPublicationFormat(String publicationFormat) {
        publisherData.setPublicationFormat(publicationFormat);
    }

    public void setPublishedYear(int publishedYear) {
        publisherData.setPublishedYear(publishedYear);
    }

    public void setPublisherName(String publisherName) {
        publisherData.setPublisherName(publisherName);
    }

    public void setDeweyDecimal(String deweyDecimal) {
        managementData.setDeweyDecimal(deweyDecimal);
    }

    @Override
    public void printData() {
    }

    @Override
    public void printHeader() {
    }

    @Override
    public void printRow() {
    }

    @Override
    public void printFooter() {
    }
}
