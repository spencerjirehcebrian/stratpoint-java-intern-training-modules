package com.miniproject.two;

/**
 * Class representing the data of a publisher.
 */
class PublisherData implements DataInterface {
    /**
     * The ISBN of the publication.
     */
    private String ISBN;

    /**
     * The publication format of the publication.
     */
    private String publicationFormat;

    /**
     * The year the publication was published.
     */
    private int publishedYear;

    /**
     * The name of the publisher.
     */
    private String publisherName;

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

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setPublicationFormat(String publicationFormat) {
        this.publicationFormat = publicationFormat;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public void setPublisherName(String publisherName) {
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
