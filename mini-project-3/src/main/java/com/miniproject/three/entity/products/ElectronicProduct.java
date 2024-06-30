package com.miniproject.three.entity.products;

import com.miniproject.three.entity.Category;
import com.miniproject.three.entity.Product;

public class ElectronicProduct extends Product {
    private String warranty;

    public ElectronicProduct(String id, String name, double price, String warranty, int quantity) {
        super(id, name, price, Category.ELECTRONICS, quantity);
        this.warranty = warranty;
    }

    // Getters and Setters
    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public ElectronicProduct copy() {
        return new ElectronicProduct(this.getId(), this.getName(), this.getBasePrice(), this.warranty,
                this.getQuantity());
    }
}
