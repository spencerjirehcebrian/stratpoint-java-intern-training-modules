package com.miniproject.three.services.impl;

import com.miniproject.three.entity.cart.Cart;
import com.miniproject.three.entity.cart.CartHistory;
import com.miniproject.three.entity.products.BookProduct;
import com.miniproject.three.entity.products.ClothingProduct;
import com.miniproject.three.entity.products.ElectronicProduct;
import com.miniproject.three.entity.products.FoodProduct;
import com.miniproject.three.entity.products.FurnitureProduct;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import com.miniproject.three.entity.Product;
import com.miniproject.three.services.ICartService;

public class CartServiceImpl implements ICartService {
    private static final Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);

    private Cart cart;

    // Constructor
    public CartServiceImpl() {
        this.cart = new Cart();
        logger.info("CartServiceImpl initialized.");
    }

    public void addHistory(Date date, boolean isPaid) {
        Function<Cart, Cart> deepCopyCart = original -> {
            Cart copy = new Cart();
            List<Product> products = new ArrayList<>(original.getProducts().values());
            for (Product product : products) {
                if (product instanceof BookProduct) {
                    BookProduct copyProduct = (BookProduct) product;
                    copy.addProduct(
                            new BookProduct(copyProduct.getId(), copyProduct.getName(), copyProduct.getBasePrice(),
                                    copyProduct.getAuthor(), copyProduct.getQuantity()));
                } else if (product instanceof ClothingProduct) {
                    ClothingProduct copyProduct = (ClothingProduct) product;
                    copy.addProduct(
                            new ClothingProduct(copyProduct.getId(), copyProduct.getName(), copyProduct.getBasePrice(),
                                    copyProduct.getSize(), copyProduct.getColor(), copyProduct.getQuantity()));
                } else if (product instanceof ElectronicProduct) {
                    ElectronicProduct copyProduct = (ElectronicProduct) product;
                    copy.addProduct(
                            new ElectronicProduct(copyProduct.getId(), copyProduct.getName(),
                                    copyProduct.getBasePrice(),
                                    copyProduct.getWarranty(), copyProduct.getQuantity()));
                } else if (product instanceof FoodProduct) {

                    FoodProduct copyProduct = (FoodProduct) product;
                    copy.addProduct(
                            new FoodProduct(copyProduct.getId(), copyProduct.getName(), copyProduct.getBasePrice(),
                                    copyProduct.getExpirationDate(), copyProduct.getQuantity()));
                } else if (product instanceof FurnitureProduct) {

                    FurnitureProduct copyProduct = (FurnitureProduct) product;
                    copy.addProduct(
                            new FurnitureProduct(copyProduct.getId(), copyProduct.getName(), copyProduct.getBasePrice(),
                                    copyProduct.getMaterial(), copyProduct.getQuantity()));
                } else {
                    throw new IllegalArgumentException("Invalid product type: " + product.getClass().getName());
                }

            }
            return copy;
        };

        CartHistory history = new CartHistory(date, isPaid, deepCopyCart.apply(cart));
        cart.addHistory(history);
        logger.info("History added: " + (isPaid ? "Paid" : "Not Paid") + " on " + date);
    }

    @Override
    public void addProductToCart(Product product, int inputQuantity) {
        if (product instanceof BookProduct) {
            BookProduct copyProduct = (BookProduct) product;
            cart.addProduct(
                    new BookProduct(copyProduct.getId(), copyProduct.getName(), copyProduct.getBasePrice(),
                            copyProduct.getAuthor(), inputQuantity));
        } else if (product instanceof ClothingProduct) {
            ClothingProduct copyProduct = (ClothingProduct) product;
            cart.addProduct(
                    new ClothingProduct(copyProduct.getId(), copyProduct.getName(), copyProduct.getBasePrice(),
                            copyProduct.getSize(), copyProduct.getColor(), inputQuantity));
        } else if (product instanceof ElectronicProduct) {
            ElectronicProduct copyProduct = (ElectronicProduct) product;
            cart.addProduct(
                    new ElectronicProduct(copyProduct.getId(), copyProduct.getName(),
                            copyProduct.getBasePrice(),
                            copyProduct.getWarranty(), inputQuantity));
        } else if (product instanceof FoodProduct) {
            FoodProduct copyProduct = (FoodProduct) product;
            cart.addProduct(
                    new FoodProduct(copyProduct.getId(), copyProduct.getName(), copyProduct.getBasePrice(),
                            copyProduct.getExpirationDate(), inputQuantity));
        } else if (product instanceof FurnitureProduct) {

            FurnitureProduct copyProduct = (FurnitureProduct) product;
            cart.addProduct(
                    new FurnitureProduct(copyProduct.getId(), copyProduct.getName(), copyProduct.getBasePrice(),
                            copyProduct.getMaterial(), inputQuantity));
        } else {
            throw new IllegalArgumentException("Invalid product type: " + product.getClass().getName());
        }
        logger.info(product.getName() + " added to the cart.");
    }

    @Override
    public double calculateTotalPrice(Cart cart) {
        double totalPrice = cart.getProducts().values().stream()
                .mapToDouble(product -> product.getBasePrice() * product.getQuantity())
                .sum();
        logger.info("Total price of the cart calculated: " + totalPrice);
        return totalPrice;
    }

    @Override
    public void removeProductFromCart(String productId) {
        if (cart.getProducts().containsKey(productId)) {
            logger.info(cart.getProducts().get(productId).getName() + " removed from the cart.");
            cart.removeProduct(productId);
        } else {
            throw new IllegalArgumentException("Product with ID " + productId + " not found in the cart.");
        }
    }

    @Override
    public void clearCart() {
        cart.getProducts().clear();
        logger.info("Cart cleared.");
    }

    @Override
    public void checkout() {
        addHistory(new Date(), true);
        clearCart();
        logger.info("Cart checked out.");
    }

    @Override
    public void editProductQuantity(String productId, int quantity) {
        if (cart.getProducts().containsKey(productId)) {
            Product product = cart.getProducts().get(productId);
            product.setQuantity(quantity);
            logger.info("Quantity of " + product.getName() + " updated to " + quantity);
        } else {
            throw new IllegalArgumentException("Product with ID " + productId + " not found in the cart.");
        }
    }

    public Cart getCart() {
        logger.info("Cart retrieved.");
        return cart;
    }

    public List<CartHistory> getCartHistory() {
        logger.info("Cart history retrieved.");
        return cart.getHistory();
    }

}