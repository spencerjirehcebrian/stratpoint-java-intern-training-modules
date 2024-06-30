package com.miniproject.three.entity.products;

import com.miniproject.three.entity.Category;
import com.miniproject.three.entity.Product;

public class BookProduct extends Product {
    private String author;

    public BookProduct(String id, String name, double price, String author, int quantity) {
        super(id, name, price, Category.BOOKS, quantity);

        this.author = author;
    }

    // Getters and Setters
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public BookProduct copy() {
        return new BookProduct(this.getId(), this.getName(), this.getBasePrice(), this.author, this.getQuantity());
    }

}
