package com.miniproject.three;

import com.miniproject.three.entity.Product;
import com.miniproject.three.entity.products.*;
import com.miniproject.three.entity.cart.Cart;
import com.miniproject.three.entity.cart.CartHistory;
import com.miniproject.three.services.ICartService;
import com.miniproject.three.services.impl.CartServiceImpl;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CartServiceImplTest {

    private ICartService cartService;
    private Product phone;
    private Product shirt;
    private Product apple;
    private Product book;
    private Product table;

    @Before
    public void setUp() {
        cartService = new CartServiceImpl();
        phone = new ElectronicProduct("1001", "Smartphone", 699.99, "24 months warranty", 1);
        shirt = new ClothingProduct("2002", "T-Shirt", 19.99, "L", "Blue", 1);
        apple = new FoodProduct("3003", "Apple", 0.99, "2023-12-31", 1);
        book = new BookProduct("4004", "Java Programming", 49.99, "Author Name", 1);
        table = new FurnitureProduct("5005", "Dining Table", 299.99, "Wood", 1);
    }

    @Test
    public void testAddProductToCart() {
        cartService.addProductToCart(phone, 1);
        Cart cart = cartService.getCart();
        assertEquals(1, cart.getProducts().size());
        String cartId = cart.getProducts().entrySet().iterator().next().getKey();
        assertEquals(phone.getName(), cart.getProducts().get(cartId).getName());
    }

    @Test
    public void testRemoveProductFromCart() {
        cartService.addProductToCart(phone, 1);
        Cart cart = cartService.getCart();
        String cartId = cart.getProducts().entrySet().iterator().next().getKey();
        cartService.removeProductFromCart(cartId);
        assertEquals(0, cart.getProducts().size());
        assertNull(cart.getProducts().get(cartId)); // Ensure the product is removed
    }

    @Test
    public void testEditProductQuantity() {
        cartService.addProductToCart(phone, 1);
        Cart cart = cartService.getCart();
        String cartId = cart.getProducts().entrySet().iterator().next().getKey();
        cartService.editProductQuantity(cartId, 5);
        assertEquals(5, cart.getProducts().get(cartId).getQuantity());
    }

    @Test
    public void testCalculateTotalPrice() {
        cartService.addProductToCart(phone, 1);
        cartService.addProductToCart(shirt, 2);
        Cart cart = cartService.getCart();
        double totalPrice = cartService.calculateTotalPrice(cart);
        assertEquals(739.97, totalPrice, 0.001);
    }

    @Test
    public void testClearCart() {
        cartService.addProductToCart(phone, 1);
        cartService.addProductToCart(shirt, 2);
        cartService.clearCart();
        Cart cart = cartService.getCart();
        assertEquals(0, cart.getProducts().size());
    }

    @Test
    public void testCheckout() {
        cartService.addProductToCart(phone, 1);
        cartService.checkout();
        Cart cart = cartService.getCart();
        assertEquals(0, cart.getProducts().size());
        List<CartHistory> history = cartService.getCartHistory();
        assertEquals(1, history.size());
        assertTrue(history.get(0).isPaid());
    }

    @Test
    public void testGetCart() {
        cartService.addProductToCart(phone, 1);
        Cart cart = cartService.getCart();
        assertNotNull(cart);
    }

    @Test
    public void testGetCartHistory() {
        cartService.addProductToCart(phone, 1);
        cartService.checkout();
        List<CartHistory> history = cartService.getCartHistory();
        assertEquals(1, history.size());
    }
}
