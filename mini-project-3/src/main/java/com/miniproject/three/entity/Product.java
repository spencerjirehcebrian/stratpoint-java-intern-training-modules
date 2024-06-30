package com.miniproject.three.entity;

/**
 * Abstract class representing a product in the system.
 */
public abstract class Product {
    private String id;
    private String cartId;
    private String name;
    private double basePrice;
    private Category category;
    private int quantity;

    /**
     * Constructs a new Product with the specified details.
     *
     * @param id        the unique identifier for the product
     * @param name      the name of the product
     * @param basePrice the base price of the product
     * @param category  the category to which the product belongs
     * @param quantity  the quantity of the product available
     */
    public Product(String id, String name, double basePrice, Category category, int quantity) {
        this.id = id;
        this.name = name;
        this.basePrice = basePrice;
        this.category = category;
        this.quantity = quantity;
    }

    /**
     * Gets the unique identifier for the product.
     *
     * @return the product ID
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the product.
     *
     * @param id the product ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the cart identifier associated with the product.
     *
     * @return the cart ID
     */
    public String getCartId() {
        return cartId;
    }

    /**
     * Sets the cart identifier associated with the product.
     *
     * @param cartId the cart ID
     */
    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    /**
     * Gets the name of the product.
     *
     * @return the product name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product.
     *
     * @param name the product name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the base price of the product.
     *
     * @return the base price
     */
    public double getBasePrice() {
        return basePrice;
    }

    /**
     * Sets the base price of the product.
     *
     * @param basePrice the base price
     */
    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    /**
     * Gets the category of the product.
     *
     * @return the product category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Sets the category of the product.
     *
     * @param category the product category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Gets the quantity of the product available.
     *
     * @return the product quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the product available.
     *
     * @param quantity the product quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Creates a copy of the product.
     *
     * @return a new product instance that is a copy of the current product
     */
    public abstract Product copy();
}
