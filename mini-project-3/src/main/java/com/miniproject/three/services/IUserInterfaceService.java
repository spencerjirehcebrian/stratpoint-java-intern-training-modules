package com.miniproject.three.services;

import java.util.List;

public interface IUserInterfaceService {

    /**
     * Prints detailed information about a product.
     * 
     * @param id       The ID of the product.
     * @param isCartId Whether the ID is a cart ID or not.
     */
    void printData(String id, boolean isCartId);

    /**
     * Prints a table of items (products or price modifiers).
     * 
     * @param items The list of items to print.
     */
    void printTable(List<?> items);

    /**
     * Prints the current state of the cart.
     */
    void printCart();
}