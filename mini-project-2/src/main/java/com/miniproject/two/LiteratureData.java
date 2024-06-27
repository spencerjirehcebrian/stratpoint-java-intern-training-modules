package com.miniproject.two;

/**
 * This class represents a piece of literature (e.g., a book, an article) and
 * contains information about its title, genre, and subgenre.
 */
class LiteratureData implements DataInterface {

    /** The title of the literature. */
    private String title;

    /** The genre of the literature. */
    private String genre;

    /** The subgenre of the literature. */
    private String subgenre;

    /**
     * Constructs a new LiteratureData object with the specified title, genre, and
     * subgenre.
     *
     * @param title    the title of the literature
     * @param genre    the genre of the literature
     * @param subgenre the subgenre of the literature
     */
    public LiteratureData(String title, String genre, String subgenre) {
        this.title = title;
        this.genre = genre;
        this.subgenre = subgenre;
    }

    /**
     * Returns the title of the literature.
     *
     * @return the title of the literature
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the literature.
     *
     * @param title the title of the literature
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the genre of the literature.
     *
     * @return the genre of the literature
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets the genre of the literature.
     *
     * @param genre the genre of the literature
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Returns the subgenre of the literature.
     *
     * @return the subgenre of the literature
     */
    public String getSubgenre() {
        return subgenre;
    }

    /**
     * Sets the subgenre of the literature.
     *
     * @param subgenre the subgenre of the literature
     */
    public void setSubgenre(String subgenre) {
        this.subgenre = subgenre;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printData() {
        // Implementation here
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printHeader() {
        // Implementation here
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printRow() {
        // Implementation here
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printFooter() {
        // Implementation here
    }
}
