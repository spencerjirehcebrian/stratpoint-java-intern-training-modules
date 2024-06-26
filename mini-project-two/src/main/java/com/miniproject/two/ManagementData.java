package com.miniproject.two;

/**
 * ManagementData class represents the management data of a book in the library.
 * It contains information such as the Dewey decimal classification,
 * availability, and
 * the user who borrowed the book.
 */
class ManagementData implements DataInterface {
    /**
     * The Dewey decimal classification of the book.
     */
    private String deweyDecimal;

    /**
     * Indicates whether the book is available or not.
     */
    private boolean isAvailable;

    /**
     * The username of the user who borrowed the book.
     */
    private String borrowedByUserName;

    /**
     * Constructs a ManagementData object with the provided parameters.
     *
     * @param deweyDecimal       the Dewey decimal classification of the book
     * @param isAvailable        whether the book is available or not
     * @param borrowedByUserName the username of the user who borrowed the book
     */
    public ManagementData(String deweyDecimal, boolean isAvailable, String borrowedByUserName) {
        this.deweyDecimal = deweyDecimal;
        this.isAvailable = isAvailable;
        this.borrowedByUserName = borrowedByUserName;
    }

    /**
     * Returns the Dewey decimal classification of the book.
     *
     * @return the Dewey decimal classification of the book
     */
    public String getDeweyDecimal() {
        return deweyDecimal;
    }

    /**
     * Returns whether the book is available or not.
     *
     * @return whether the book is available or not
     */
    public boolean isAvailable() {
        return isAvailable;
    }

    /**
     * Sets whether the book is available or not.
     *
     * @param available whether the book is available or not
     */
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    /**
     * Returns the username of the user who borrowed the book.
     *
     * @return the username of the user who borrowed the book
     */
    public String getBorrowedByUserName() {
        return borrowedByUserName;
    }

    /**
     * Sets the username of the user who borrowed the book.
     *
     * @param borrowedByUserName the username of the user who borrowed the book
     */
    public void setBorrowedByUserName(String borrowedByUserName) {
        this.borrowedByUserName = borrowedByUserName;
    }

    public void setDeweyDecimal(String deweyDecimal) {
        this.deweyDecimal = deweyDecimal;
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
