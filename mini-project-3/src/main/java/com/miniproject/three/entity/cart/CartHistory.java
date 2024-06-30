package com.miniproject.three.entity.cart;

import java.util.Date;

/**
 * Represents the history of a cart transaction.
 */
public class CartHistory {
    private Date date;
    private boolean isPaid;
    private Cart cart;

    /**
     * Constructs a new CartHistory with the specified details.
     *
     * @param date   the date of the transaction
     * @param isPaid whether the transaction is paid
     * @param cart   the cart associated with the transaction
     */
    public CartHistory(Date date, boolean isPaid, Cart cart) {
        this.date = date;
        this.isPaid = isPaid;
        this.cart = cart;
    }

    /**
     * Gets the date of the transaction.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Checks if the transaction is paid.
     *
     * @return true if the transaction is paid, false otherwise
     */
    public boolean isPaid() {
        return isPaid;
    }

    /**
     * Gets the cart associated with the transaction.
     *
     * @return the cart
     */
    public Cart getCart() {
        return cart;
    }
}
