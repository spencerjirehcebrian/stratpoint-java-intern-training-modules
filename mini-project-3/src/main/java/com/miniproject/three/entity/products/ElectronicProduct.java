package com.miniproject.three.entity.products;

import com.miniproject.three.entity.Category;
import com.miniproject.three.entity.Product;

/**
 * Represents an electronic product in the system.
 */
public class ElectronicProduct extends Product {
    private String warranty;

    /**
     * Constructs a new ElectronicProduct with the specified details.
     *
     * @param id       the unique identifier for the electronic product
     * @param name     the name of the electronic product
     * @param price    the price of the electronic product
     * @param warranty the warranty period of the electronic product
     * @param quantity the quantity of the electronic product available
     */
    public ElectronicProduct(String id, String name, double price, String warranty, int quantity) {
        super(id, name, price, Category.ELECTRONICS, quantity);
        this.warranty = warranty;
    }

    /**
     * Gets the warranty period of the electronic product.
     *
     * @return the warranty period
     */
    public String getWarranty() {
        return warranty;
    }

    /**
     * Sets the warranty period of the electronic product.
     *
     * @param warranty the warranty period
     */
    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    /**
     * Creates a copy of the electronic product.
     *
     * @return a new ElectronicProduct instance that is a copy of the current
     *         product
     */
    public ElectronicProduct copy() {
        return new ElectronicProduct(this.getId(), this.getName(), this.getBasePrice(), this.warranty,
                this.getQuantity());
    }
}
