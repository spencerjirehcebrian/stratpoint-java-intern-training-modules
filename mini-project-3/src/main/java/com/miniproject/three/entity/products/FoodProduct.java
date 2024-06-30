package com.miniproject.three.entity.products;

import com.miniproject.three.entity.Category;
import com.miniproject.three.entity.Product;

public class FoodProduct extends Product {
    private String expirationDate;

    public FoodProduct(String id, String name, double price, String expirationDate, int quantity) {
        super(id, name, price, Category.FOOD, quantity);
        this.expirationDate = expirationDate;
    }

    // Getters and Setters
    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public FoodProduct copy() {
        return new FoodProduct(this.getId(), this.getName(), this.getBasePrice(), this.expirationDate,
                this.getQuantity());
    }
}
