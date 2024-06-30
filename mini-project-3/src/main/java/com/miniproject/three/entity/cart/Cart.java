package com.miniproject.three.entity.cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.miniproject.three.entity.Product;

/**
 * Represents a shopping cart containing products.
 */
public class Cart {
    private HashMap<String, Product> products;
    private List<CartHistory> history;

    /**
     * Constructs a new Cart with an empty list of products and history.
     */
    public Cart() {
        this.products = new HashMap<>();
        this.history = new ArrayList<>();
    }

    /**
     * Gets the products in the cart.
     *
     * @return a hashmap of products in the cart, where the key is the product ID
     *         and the value is the product
     */
    public HashMap<String, Product> getProducts() {
        return products;
    }

    /**
     * Adds a product to the cart. The product is assigned a random cart ID.
     *
     * @param product the product to be added to the cart
     */
    public void addProduct(Product product) {
        Random random = new Random();
        int randomNumber = random.nextInt(9000) + 1000;
        String cartId = String.valueOf(randomNumber);
        Product copiedProduct = product.copy();
        copiedProduct.setCartId(cartId);
        this.products.put(copiedProduct.getCartId(), copiedProduct);
    }

    /**
     * Removes a product from the cart.
     *
     * @param productId the ID of the product to be removed
     */
    public void removeProduct(String productId) {
        this.products.remove(productId);
    }

    /**
     * Adds a history record to the cart's history.
     *
     * @param cartHistory the history record to be added
     */
    public void addHistory(CartHistory cartHistory) {
        this.history.add(cartHistory);
    }

    /**
     * Gets the history of the cart.
     *
     * @return a list of history records for the cart
     */
    public List<CartHistory> getHistory() {
        return history;
    }
}
