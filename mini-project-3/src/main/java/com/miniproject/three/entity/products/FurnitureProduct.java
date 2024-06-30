package com.miniproject.three.entity.products;

import com.miniproject.three.entity.Category;
import com.miniproject.three.entity.Product;

/**
 * Represents a furniture product in the system.
 */
public class FurnitureProduct extends Product {
    private String material;

    /**
     * Constructs a new FurnitureProduct with the specified details.
     *
     * @param id       the unique identifier for the furniture product
     * @param name     the name of the furniture product
     * @param price    the price of the furniture product
     * @param material the material of the furniture product
     * @param quantity the quantity of the furniture product available
     */
    public FurnitureProduct(String id, String name, double price, String material, int quantity) {
        super(id, name, price, Category.FURNITURE, quantity);
        this.material = material;
    }

    /**
     * Gets the material of the furniture product.
     *
     * @return the material
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Sets the material of the furniture product.
     *
     * @param material the material
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * Creates a copy of the furniture product.
     *
     * @return a new FurnitureProduct instance that is a copy of the current product
     */
    public FurnitureProduct copy() {
        return new FurnitureProduct(this.getId(), this.getName(), this.getBasePrice(), this.material,
                this.getQuantity());
    }
}
