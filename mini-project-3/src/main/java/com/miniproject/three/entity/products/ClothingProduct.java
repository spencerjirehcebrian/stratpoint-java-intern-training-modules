package com.miniproject.three.entity.products;

import com.miniproject.three.entity.Category;
import com.miniproject.three.entity.Product;

public class ClothingProduct extends Product {
    private String size;
    private String color;

    public ClothingProduct(String id, String name, double price, String size, String color, int quantity) {
        super(id, name, price, Category.CLOTHING, quantity);
        this.size = size;
        this.color = color;
    }

    // Getters and Setters
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public ClothingProduct copy() {
        return new ClothingProduct(this.getId(), this.getName(), this.getBasePrice(), this.size, this.color,
                this.getQuantity());
    }
}
