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

/**
 * Implementation of the ICartService interface.
 */
public class CartServiceImpl implements ICartService {
    private static final Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);

    private Cart cart;

    /**
     * Constructs a new CartServiceImpl and initializes the cart.
     */
    public CartServiceImpl() {
        this.cart = new Cart();
        logger.info("CartServiceImpl initialized.");
    }

    /**
     * Adds a history record to the cart's history.
     *
     * @param date   the date of the transaction
     * @param isPaid whether the transaction is paid
     */
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

    /**
     * Adds a product to the cart with the specified quantity.
     *
     * @param product       the product to be added
     * @param inputQuantity the quantity of the product
     */
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

    /**
     * Calculates the total price of the products in the given cart.
     *
     * @param cart the cart containing the products
     * @return the total price of the products in the cart
     */
    @Override
    public double calculateTotalPrice(Cart cart) {
        double totalPrice = cart.getProducts().values().stream()
                .mapToDouble(product -> product.getBasePrice() * product.getQuantity())
                .sum();
        logger.info("Total price of the cart calculated: " + totalPrice);
        return totalPrice;
    }

    /**
     * Removes a product from the cart.
     *
     * @param productId the ID of the product to be removed
     * @throws IllegalArgumentException if the product with the given ID is not
     *                                  found in the cart
     */
    @Override
    public void removeProductFromCart(String productId) {
        if (cart.getProducts().containsKey(productId)) {
            logger.info(cart.getProducts().get(productId).getName() + " removed from the cart.");
            cart.removeProduct(productId);
        } else {
            throw new IllegalArgumentException("Product with ID " + productId + " not found in the cart.");
        }
    }

    /**
     * Removes all products from cart.
     */
    @Override
    public void clearCart() {
        cart.getProducts().clear();
        logger.info("Cart cleared.");
    }

    /**
     * Checks out the cart by adding a new history record with the current date and
     * a flag indicating that the cart is paid.
     * Clears the cart.
     */
    @Override
    public void checkout() {
        addHistory(new Date(), true);
        clearCart();
        logger.info("Cart checked out.");
    }

    /**
     * Updates the quantity of a product in the cart.
     *
     * @param productId the ID of the product to update
     * @param quantity  the new quantity of the product
     */
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

    /**
     * Retrieves the current cart.
     *
     * @return the current cart
     */
    public Cart getCart() {
        logger.info("Cart retrieved.");
        return cart;
    }

    /**
     * Retrieves the cart history.
     *
     * @return a list of CartHistory objects representing the history of the cart
     */
    public List<CartHistory> getCartHistory() {
        logger.info("Cart history retrieved.");
        return cart.getHistory();
    }

}