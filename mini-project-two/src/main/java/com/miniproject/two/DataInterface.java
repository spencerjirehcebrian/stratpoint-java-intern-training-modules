package com.miniproject.two;

/**
 * This interface provides methods to print various parts of a data structure
 * including
 * the header, rows, and footer. Implementing classes are expected to provide
 * the
 * actual details of how these parts should be printed.
 */
public interface DataInterface {

    /**
     * Prints the data of the implementing class.
     *
     * This method is meant to output the data in a specific format such as a table.
     * The exact format and contents depend on the implementing class.
     *
     * @return void
     */
    void printData();

    /**
     * Prints the header for the data structure.
     *
     * This method is intended to print the header section, which usually consists
     * of column names or other relevant headings. The format of the header is
     * determined by the implementing class.
     *
     * @return void
     */
    void printHeader();

    /**
     * Prints a row of data.
     *
     * This method is responsible for printing a single row of data. The contents
     * and formatting of the row depend on the implementing class.
     *
     * @return void
     */
    void printRow();

    /**
     * Prints the footer for the data structure.
     *
     * This method is intended to print the footer section, which could include
     * summary information or any other relevant details. The format of the footer
     * is determined by the implementing class.
     *
     * @return void
     */
    void printFooter();

}
