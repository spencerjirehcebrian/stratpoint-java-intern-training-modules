package com.miniproject.three.entity.cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.miniproject.three.entity.Product;

public class Cart {
    private HashMap<String, Product> products;
    private List<CartHistory> history;

    public Cart() {
        this.products = new HashMap<>();
        this.history = new ArrayList<>();
    }

    public HashMap<String, Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        Random random = new Random();
        int randomNumber = random.nextInt(9000) + 1000;
        String cartId = String.valueOf(randomNumber);
        Product copiedProduct = product.copy();
        copiedProduct.setCartId(cartId);
        this.products.put(copiedProduct.getCartId(), copiedProduct);
    }

    public void removeProduct(String productId) {
        this.products.remove(productId);
    }

    public void addHistory(CartHistory cartHistory) {
        this.history.add(cartHistory);
    }

    public List<CartHistory> getHistory() {
        return history;
    }

}