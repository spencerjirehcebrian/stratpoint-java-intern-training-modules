package com.miniproject.three.entity.products;

import com.miniproject.three.entity.Category;
import com.miniproject.three.entity.Product;

/**
 * Represents a clothing product in the system.
 */
public class ClothingProduct extends Product {
    private String size;
    private String color;

    /**
     * Constructs a new ClothingProduct with the specified details.
     *
     * @param id       the unique identifier for the clothing product
     * @param name     the name of the clothing product
     * @param price    the price of the clothing product
     * @param size     the size of the clothing product
     * @param color    the color of the clothing product
     * @param quantity the quantity of the clothing product available
     */
    public ClothingProduct(String id, String name, double price, String size, String color, int quantity) {
        super(id, name, price, Category.CLOTHING, quantity);
        this.size = size;
        this.color = color;
    }

    /**
     * Gets the size of the clothing product.
     *
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * Sets the size of the clothing product.
     *
     * @param size the size
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Gets the color of the clothing product.
     *
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color of the clothing product.
     *
     * @param color the color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Creates a copy of the clothing product.
     *
     * @return a new ClothingProduct instance that is a copy of the current product
     */
    @Override
    public ClothingProduct copy() {
        return new ClothingProduct(this.getId(), this.getName(), this.getBasePrice(), this.size, this.color,
                this.getQuantity());
    }
}
