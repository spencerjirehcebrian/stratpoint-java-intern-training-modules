package com.miniproject.three.entity.products;

import com.miniproject.three.entity.Category;
import com.miniproject.three.entity.Product;

/**
 * Represents a book product in the system.
 */
public class BookProduct extends Product {
    private String author;

    /**
     * Constructs a new BookProduct with the specified details.
     *
     * @param id       the unique identifier for the book product
     * @param name     the name of the book product
     * @param price    the price of the book product
     * @param author   the author of the book product
     * @param quantity the quantity of the book product available
     */
    public BookProduct(String id, String name, double price, String author, int quantity) {
        super(id, name, price, Category.BOOKS, quantity);
        this.author = author;
    }

    /**
     * Gets the author of the book product.
     *
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author of the book product.
     *
     * @param author the author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Creates a copy of the book product.
     *
     * @return a new BookProduct instance that is a copy of the current product
     */
    @Override
    public BookProduct copy() {
        return new BookProduct(this.getId(), this.getName(), this.getBasePrice(), this.author, this.getQuantity());
    }
}
