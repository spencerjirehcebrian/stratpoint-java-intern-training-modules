package com.miniproject.three.services;

import java.util.Date;
import java.util.List;

import com.miniproject.three.entity.Product;
import com.miniproject.three.entity.cart.Cart;
import com.miniproject.three.entity.cart.CartHistory;

/**
 * Interface for cart services.
 */
public interface ICartService {

    /**
     * Adds a history record to the cart's history.
     *
     * @param date   the date of the transaction
     * @param isPaid whether the transaction is paid
     */
    void addHistory(Date date, boolean isPaid);

    /**
     * Adds a product to the cart with the specified quantity.
     *
     * @param product       the product to be added
     * @param inputQuantity the quantity of the product
     */
    void addProductToCart(Product product, int inputQuantity);

    /**
     * Calculates the total price of the products in the cart.
     *
     * @param cart the cart containing the products
     * @return the total price
     */
    double calculateTotalPrice(Cart cart);

    /**
     * Removes a product from the cart.
     *
     * @param productId the ID of the product to be removed
     */
    void removeProductFromCart(String productId);

    /**
     * Clears all products from the cart.
     */
    void clearCart();

    /**
     * Checks out the cart, adding the current state to history and clearing the
     * cart.
     */
    void checkout();

    /**
     * Edits the quantity of a product in the cart.
     *
     * @param productId the ID of the product
     * @param quantity  the new quantity
     */
    void editProductQuantity(String productId, int quantity);

    /**
     * Gets the current cart.
     *
     * @return the cart
     */
    Cart getCart();

    /**
     * Gets the history of the cart.
     *
     * @return a list of cart history records
     */
    List<CartHistory> getCartHistory();
}