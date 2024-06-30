package com.miniproject.three.entity.products;

import com.miniproject.three.entity.Category;
import com.miniproject.three.entity.Product;

public class FurnitureProduct extends Product {
    private String material;

    public FurnitureProduct(String id, String name, double price, String material, int quantity) {
        super(id, name, price, Category.FURNITURE, quantity);
        this.material = material;
    }

    // Getters and Setters
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public FurnitureProduct copy() {
        return new FurnitureProduct(this.getId(), this.getName(), this.getBasePrice(), this.material,
                this.getQuantity());
    }
}
