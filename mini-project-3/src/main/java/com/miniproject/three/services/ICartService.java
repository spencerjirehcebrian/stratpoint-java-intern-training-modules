package com.miniproject.three.services;

import java.util.Date;
import java.util.List;

import com.miniproject.three.entity.Product;
import com.miniproject.three.entity.cart.Cart;
import com.miniproject.three.entity.cart.CartHistory;

public interface ICartService {

    void addHistory(Date date, boolean isPaid);

    void addProductToCart(Product product, int inputQuantity);

    double calculateTotalPrice(Cart cart);

    void removeProductFromCart(String productId);

    void clearCart();

    void checkout();

    void editProductQuantity(String productId, int quantity);

    Cart getCart();

    List<CartHistory> getCartHistory();

}
