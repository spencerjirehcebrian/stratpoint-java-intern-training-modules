
package com.miniproject.three.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.miniproject.three.entity.Product;
import com.miniproject.three.entity.cart.Cart;
import com.miniproject.three.entity.cart.CartHistory;
import com.miniproject.three.entity.products.BookProduct;
import com.miniproject.three.entity.products.ClothingProduct;
import com.miniproject.three.entity.products.ElectronicProduct;
import com.miniproject.three.entity.products.FoodProduct;
import com.miniproject.three.entity.products.FurnitureProduct;
import com.miniproject.three.services.IUserInterfaceService;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Implementation of the IUserInterfaceService interface.
 */
public class UserInterfaceServiceImpl implements IUserInterfaceService {

        private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
        private static final String ANSI_RESET = "\u001B[0m";
        private static final String ANSI_YELLOW = "\u001B[33m";
        private static final String ANSI_CYAN = "\u001B[36m";
        private static final String ANSI_GREEN = "\u001B[32m";
        // private static final String ANSI_RED = "\u001B[31m";

        private final ProductServiceImpl productService;
        private final CartServiceImpl cartService;

        /**
         * Constructs a new UserInterfaceServiceImpl with the specified services.
         *
         * @param productService the product service implementation
         * @param cartService    the cart service implementation
         */
        public UserInterfaceServiceImpl(ProductServiceImpl productService, CartServiceImpl cartService) {
                this.cartService = cartService;
                this.productService = productService;
                logger.info("UserInterfaceServiceImpl initialized.");
                logger.info("CartServiceImpl initialized.");
        }

        /**
         * Prints the details of a product.
         *
         * @param id       the ID of the product or cart
         * @param isCartId a boolean indicating whether the ID is a cart ID or a product
         *                 ID
         * @throws IllegalArgumentException if the product or cart is not found
         */
        @Override
        public void printData(String id, boolean isCartId) {
                Product product;
                if (isCartId) {
                        product = cartService.getCart().getProducts().get(id);
                        if (product == null) {
                                throw new IllegalArgumentException("Cart with ID " + id + " not found.");
                                // System.out.println("Product with cart ID " + id + " not found in the cart.");
                                // return;
                        }
                } else {
                        product = productService.getProductById(id);
                        if (product == null) {
                                throw new IllegalArgumentException("Product with ID " + id + " not found.");
                                // System.out.println("Product with ID " + id + " not found.");
                                // return;
                        }
                }

                String format = "\t\t\t| %-20s | %-40s |\n";
                System.out.println(
                                ANSI_CYAN + "\n\t\t\t+----------------------+------------------------------------------+"
                                                + ANSI_RESET);

                System.out.printf(ANSI_GREEN + "\t\t\t| %-63s |\n" + ANSI_RESET, "PRODUCT DETAILS");
                System.out.println(
                                ANSI_CYAN + "\t\t\t+----------------------+------------------------------------------+"
                                                + ANSI_RESET);

                System.out.printf(ANSI_GREEN + format + ANSI_RESET, "Field", "Value");
                System.out.println(
                                ANSI_CYAN + "\t\t\t+----------------------+------------------------------------------+"
                                                + ANSI_RESET);

                if (product.getCartId() != null) {

                        System.out.printf(ANSI_YELLOW + format + ANSI_RESET, "Cart ID", product.getCartId());
                }
                System.out.printf(ANSI_YELLOW + format + ANSI_RESET, "Product ID", product.getId());
                System.out.printf(ANSI_YELLOW + format + ANSI_RESET, "Name", product.getName());
                System.out.printf(ANSI_YELLOW + format + ANSI_RESET, "Base Price", product.getBasePrice());
                System.out.printf(ANSI_YELLOW + format + ANSI_RESET, "Category", product.getCategory());

                if (isCartId) {
                        System.out.printf(ANSI_YELLOW + format + ANSI_RESET, "Quantity", product.getQuantity());
                        System.out.printf(ANSI_YELLOW + format + ANSI_RESET, "Total Price",
                                        product.getBasePrice() * product.getQuantity());
                }

                if (product instanceof ElectronicProduct) {
                        ElectronicProduct electronicProduct = (ElectronicProduct) product;
                        System.out.printf(ANSI_YELLOW + format + ANSI_RESET, "Warranty",
                                        electronicProduct.getWarranty());
                } else if (product instanceof ClothingProduct) {
                        ClothingProduct clothingProduct = (ClothingProduct) product;
                        System.out.printf(ANSI_YELLOW + format + ANSI_RESET, "Size", clothingProduct.getSize());
                        System.out.printf(ANSI_YELLOW + format + ANSI_RESET, "Color", clothingProduct.getColor());
                } else if (product instanceof FoodProduct) {
                        FoodProduct foodProduct = (FoodProduct) product;
                        System.out.printf(ANSI_YELLOW + format + ANSI_RESET, "Expiration Date",
                                        foodProduct.getExpirationDate());
                } else if (product instanceof BookProduct) {
                        BookProduct bookProduct = (BookProduct) product;
                        System.out.printf(ANSI_YELLOW + format + ANSI_RESET, "Author", bookProduct.getAuthor());
                } else if (product instanceof FurnitureProduct) {
                        FurnitureProduct furnitureProduct = (FurnitureProduct) product;
                        System.out.printf(ANSI_YELLOW + format + ANSI_RESET, "Material",
                                        furnitureProduct.getMaterial());
                }

                System.out.println(
                                ANSI_CYAN + "\t\t\t+----------------------+------------------------------------------+"
                                                + ANSI_RESET);
                logger.info("Product details printed.");
        }

        /**
         * Prints a table of items (products or cart).
         *
         * @param items The list of items to print.
         */
        @Override
        public void printTable(List<?> items) {
                if (items.isEmpty()) {
                        throw new IllegalArgumentException("No items to display.");
                        // System.out.println("No items to display.");
                        // return;
                }

                Object firstItem = items.get(0);
                if (firstItem instanceof Product) {
                        printProductHeader();
                        for (Object item : items) {
                                printProductRow((Product) item);
                        }
                        printProductFooter();
                } else if (firstItem instanceof Cart) {
                        printCart();
                } else {
                        throw new IllegalArgumentException("Unsupported item type.");
                        // System.out.println("Unsupported item type.");
                }
                logger.info("Table printed.");
        }

        /**
         * Prints the header for the product listing.
         *
         */
        public void printProductHeader() {
                String format = "\t\t\t| %-5s | %-20s | %-10s | %-15s |\n";
                System.out.println(
                                ANSI_CYAN + "\n\t\t\t+-------+----------------------+------------+-----------------+"
                                                + ANSI_RESET);
                System.out.printf(ANSI_GREEN + "\t\t\t| %-59s |\n" + ANSI_RESET, "PRODUCT LISTING");
                System.out.println(
                                ANSI_CYAN + "\t\t\t+-------+----------------------+------------+-----------------+"
                                                + ANSI_RESET);
                System.out.printf(ANSI_GREEN + format + ANSI_RESET, "ID", "Name", "Base Price", "Category");
                System.out.println(
                                ANSI_CYAN + "\t\t\t+-------+----------------------+------------+-----------------+"
                                                + ANSI_RESET);

        }

        /**
         * Prints a row of product information to the console.
         *
         * @param product the product object containing the information to be printed
         */
        public void printProductRow(Product product) {
                String format = "\t\t\t| %-5s | %-20s | %-10.2f | %-15s |\n";
                System.out.printf(ANSI_YELLOW + format + ANSI_RESET, product.getId(), truncate(product.getName(), 20),
                                product.getBasePrice(),
                                product.getCategory());
        }

        /**
         * Prints the footer for the product listing.
         *
         */
        public void printProductFooter() {
                System.out.println(
                                ANSI_CYAN + "\t\t\t+-------+----------------------+------------+-----------------+"
                                                + ANSI_RESET);
        }

        /**
         * Prints the contents of the shopping cart.
         *
         * @throws IllegalArgumentException if the cart is empty
         */
        @Override
        public void printCart() {
                List<Product> products = new ArrayList<>(cartService.getCart().getProducts().values());
                if (products.isEmpty()) {
                        throw new IllegalArgumentException("Cart is empty.");
                        // System.out.println("Cart is empty.");
                } else {
                        printCartHeader();
                        for (Product product : products) {
                                printCartRow(product);
                        }
                        printCartFooter();
                        printCartRowFinal(cartService.getCart());
                        printCartFooter();
                }
                logger.info("Cart printed.");
        }

        /**
         * Prints the header for the shopping cart.
         */
        public void printCartHeader() {
                String format = "\t\t\t| %-10s | %-12s | %-20s | %-10s | %-15s | %-10s | %-15s |\n";
                System.out.println(
                                ANSI_CYAN + "\n\t\t\t+------------+--------------+----------------------+------------+-----------------+------------+-----------------+"
                                                + ANSI_RESET);
                System.out.printf(ANSI_GREEN + "\t\t\t| %-110s |\n" + ANSI_RESET, "CART");

                System.out.println(
                                ANSI_CYAN + "\t\t\t+------------+--------------+----------------------+------------+-----------------+------------+-----------------+"
                                                + ANSI_RESET);
                System.out.printf(ANSI_GREEN + format + ANSI_RESET, "Cart ID", "Product ID", "Name", "Base Price",
                                "Category",
                                "Quantity", "Total Price");
                System.out.println(
                                ANSI_CYAN + "\t\t\t+------------+--------------+----------------------+------------+-----------------+------------+-----------------+"
                                                + ANSI_RESET);
        }

        /**
         * Prints a row in the shopping cart with the specified product.
         *
         * @param product the product to be printed in the cart row
         */
        private void printCartRow(Product product) {
                String format = "\t\t\t| %-10s | %-12s | %-20s | %-10.2f | %-15s | %-10d | %-15.2f |\n";
                System.out.printf(ANSI_YELLOW + format + ANSI_RESET, product.getCartId(), truncate(product.getId(), 10),
                                truncate(product.getName(), 20),
                                product.getBasePrice(),
                                product.getCategory(), product.getQuantity(),
                                product.getBasePrice() * product.getQuantity());

        }

        /**
         * Prints the final row of the cart with the total price.
         *
         * @param cart the cart for which the final row is printed
         */
        private void printCartRowFinal(Cart cart) {
                String format = "\t\t\t| %-10s   %-12s   %-20s   %-10s   %-15s   %-10s | %-15.2f |\n";
                System.out.printf(ANSI_YELLOW + format + ANSI_RESET, "", "",
                                "",
                                "",
                                "", "", cartService.calculateTotalPrice(cart));
        }

        /**
         * Prints the footer for the cart listing.
         */
        public void printCartFooter() {
                System.out.println(
                                ANSI_CYAN + "\t\t\t+------------+--------------+----------------------+------------+-----------------+------------+-----------------+"
                                                + ANSI_RESET);
        }

        /**
         * Truncates a string to a specified length by removing characters from the
         * middle and adding an ellipsis.
         *
         * @param value  the string to be truncated
         * @param length the desired length of the truncated string
         * @return the truncated string, or the original string if it is already shorter
         *         than or equal to the desired length
         */
        private String truncate(String value, int length) {
                if (value.length() > length) {
                        return value.substring(0, length - 3) + "...";
                }
                return value;
        }

        /**
         * Prints the cart history including paid status, date, products, and total
         * price.
         *
         * @param cartHistories the list of cart histories to be printed
         */
        public void printCartHistory(List<CartHistory> cartHistories) {
                if (cartHistories.isEmpty()) {
                        throw new IllegalArgumentException("Cart history is empty.");
                        // System.out.println("No cart history to display.");
                        // return;
                }
                System.out.println(
                                ANSI_CYAN + "\n\t\t\t+----------------------+------------------------------------------+"
                                                + ANSI_RESET);
                System.out.printf(ANSI_GREEN + "\t\t\t| %-63s |\n" + ANSI_RESET, "CART HISTORY");
                System.out.println(
                                ANSI_CYAN + "\t\t\t+----------------------+------------------------------------------+"
                                                + ANSI_RESET);

                String format = "\t\t\t| %-20s | %-40s |\n";
                for (CartHistory cartHistory : cartHistories) {
                        System.out.println(
                                        ANSI_CYAN + "\n\t\t\t+----------------------+------------------------------------------+"
                                                        + ANSI_RESET);
                        System.out.printf(ANSI_GREEN + format + ANSI_RESET, "Paid", "Date");
                        System.out.println(
                                        ANSI_CYAN + "\t\t\t+----------------------+------------------------------------------+"
                                                        + ANSI_RESET);
                        System.out.printf(ANSI_YELLOW + format + ANSI_RESET, cartHistory.isPaid() ? "Yes" : "No",
                                        cartHistory.getDate());
                        List<Product> products = new ArrayList<>(cartHistory.getCart().getProducts().values());
                        System.out.println(
                                        ANSI_CYAN + "\t\t\t+------------+--------------+----------------------+------------+-----------------+------------+-----------------+"
                                                        + ANSI_RESET);
                        String formatHeader = "\t\t\t| %-10s | %-12s | %-20s | %-10s | %-15s | %-10s | %-15s |\n";
                        System.out.printf(ANSI_GREEN + formatHeader + ANSI_RESET, "Cart ID", "Product ID", "Name",
                                        "Base Price",
                                        "Category",
                                        "Quantity", "Total Price");
                        System.out.println(
                                        ANSI_CYAN + "\t\t\t+------------+--------------+----------------------+------------+-----------------+------------+-----------------+"
                                                        + ANSI_RESET);
                        for (Product product : products) {
                                printCartRow(product);
                        }
                        printCartFooter();
                        printCartRowFinal(cartHistory.getCart());
                        printCartFooter();
                }
                logger.info("Cart history printed.");
        }

}