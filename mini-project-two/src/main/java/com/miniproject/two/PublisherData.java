package com.miniproject.two;

/**
 * Class representing the data of a publisher.
 */
class PublisherData implements DataInterface {
    /**
     * The ISBN of the publication.
     */
    private final String ISBN;

    /**
     * The publication format of the publication.
     */
    private final String publicationFormat;

    /**
     * The year the publication was published.
     */
    private final int publishedYear;

    /**
     * The name of the publisher.
     */
    private final String publisherName;

    /**
     * Constructs a PublisherData object.
     *
     * @param ISBN              the ISBN of the publication
     * @param publicationFormat the publication format of the publication
     * @param publishedYear     the year the publication was published
     * @param publisherName     the name of the publisher
     */
    public PublisherData(String ISBN, String publicationFormat, int publishedYear, String publisherName) {
        this.ISBN = ISBN;
        this.publicationFormat = publicationFormat;
        this.publishedYear = publishedYear;
        this.publisherName = publisherName;
    }

    /**
     * Returns the ISBN of the publication.
     *
     * @return the ISBN of the publication
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * Returns the publication format of the publication.
     *
     * @return the publication format of the publication
     */
    public String getPublicationFormat() {
        return publicationFormat;
    }

    /**
     * Returns the year the publication was published.
     *
     * @return the year the publication was published
     */
    public int getPublishedYear() {
        return publishedYear;
    }

    /**
     * Returns the name of the publisher.
     *
     * @return the name of the publisher
     */
    public String getPublisherName() {
        return publisherName;
    }

    /**
     * Prints the data of the publisher in a formatted table.
     */
    @Override
    public void printData() {
        // Intentionally left empty
    }
}
