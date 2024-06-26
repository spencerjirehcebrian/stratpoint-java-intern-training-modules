package com.miniproject.two;

/**
 * This class represents the author data.
 * It contains the author's name and nationality.
 */
public class AuthorData implements DataInterface {
    /**
     * The author's name.
     */
    private String author;

    /**
     * The author's nationality.
     */
    private String nationality;

    /**
     * Constructs an AuthorData object with the given author and nationality.
     *
     * @param author      the author's name
     * @param nationality the author's nationality
     */
    public AuthorData(String author, String nationality) {
        this.author = author;
        this.nationality = nationality;
    }

    /**
     * Returns the author's name.
     *
     * @return the author's name
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns the author's nationality.
     *
     * @return the author's nationality
     */
    public String getNationality() {
        return nationality;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
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
