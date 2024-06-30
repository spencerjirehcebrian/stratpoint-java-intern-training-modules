package com.miniproject.three.entity;

public abstract class Product {
    private String id;
    private String cartId;
    private String name;
    private double basePrice;
    private Category category;
    private int quantity;

    public Product(String id, String name, double basePrice, Category category, int quantity) {
        this.id = id;
        this.name = name;
        this.basePrice = basePrice;
        this.category = category;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract Product copy();

}