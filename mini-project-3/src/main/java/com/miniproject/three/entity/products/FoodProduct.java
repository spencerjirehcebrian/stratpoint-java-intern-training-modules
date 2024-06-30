package com.miniproject.three.entity.products;

import com.miniproject.three.entity.Category;
import com.miniproject.three.entity.Product;

/**
 * Represents a food product in the system.
 */
public class FoodProduct extends Product {
    private String expirationDate;

    /**
     * Constructs a new FoodProduct with the specified details.
     *
     * @param id             the unique identifier for the food product
     * @param name           the name of the food product
     * @param price          the price of the food product
     * @param expirationDate the expiration date of the food product
     * @param quantity       the quantity of the food product available
     */
    public FoodProduct(String id, String name, double price, String expirationDate, int quantity) {
        super(id, name, price, Category.FOOD, quantity);
        this.expirationDate = expirationDate;
    }

    /**
     * Gets the expiration date of the food product.
     *
     * @return the expiration date
     */
    public String getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets the expiration date of the food product.
     *
     * @param expirationDate the expiration date
     */
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * Creates a copy of the food product.
     *
     * @return a new FoodProduct instance that is a copy of the current product
     */
    @Override
    public FoodProduct copy() {
        return new FoodProduct(this.getId(), this.getName(), this.getBasePrice(), this.expirationDate,
                this.getQuantity());
    }
}
