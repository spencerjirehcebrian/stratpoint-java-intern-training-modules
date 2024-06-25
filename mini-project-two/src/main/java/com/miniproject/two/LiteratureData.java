package com.miniproject.two;

/**
 * This class represents a piece of literature (e.g., a book, an article) and
 * contains
 * information about its title, genre, and subgenre.
 */
class LiteratureData implements DataInterface {

    /** The title of the literature. */
    private final String title;

    /** The genre of the literature. */
    private final String genre;

    /** The subgenre of the literature. */
    private final String subgenre;

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
     * Returns the genre of the literature.
     *
     * @return the genre of the literature
     */
    public String getGenre() {
        return genre;
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
     * Prints the data of the literature.
     *
     * This method does not print anything as it is not implemented yet.
     */
    @Override
    public void printData() {

    }
}
