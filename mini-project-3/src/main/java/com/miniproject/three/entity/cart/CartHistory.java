package com.miniproject.three.entity.cart;

import java.util.Date;

public class CartHistory {
    private Date date;
    private boolean isPaid;
    private Cart cart;

    public CartHistory(Date date, boolean isPaid, Cart cart) {
        this.date = date;
        this.isPaid = isPaid;
        this.cart = cart;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}