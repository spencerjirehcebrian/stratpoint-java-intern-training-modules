package com.miniproject.three;

import com.miniproject.three.entity.products.BookProduct;
import com.miniproject.three.entity.products.ClothingProduct;
import com.miniproject.three.entity.products.ElectronicProduct;
import com.miniproject.three.entity.products.FoodProduct;
import com.miniproject.three.entity.products.FurnitureProduct;

import java.util.Scanner;

import com.miniproject.three.entity.Product;
import com.miniproject.three.services.impl.CartServiceImpl;
import com.miniproject.three.services.impl.ProductServiceImpl;
import com.miniproject.three.services.impl.UserInterfaceServiceImpl;

/**
 * The Main class is the entry point of the application.
 * It initializes the services and sets up the initial product catalog and cart.
 */
public class Main {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";

    /**
     * The main method of the application. It initializes the services, sets up the
     * initial product catalog and cart,
     * and enters the main loop for user interaction.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CartServiceImpl cartService = new CartServiceImpl();

        ProductServiceImpl productService = new ProductServiceImpl();

        UserInterfaceServiceImpl userInterface = new UserInterfaceServiceImpl(productService, cartService);

        Scanner mainScanner = new Scanner(System.in);

        Product phone = new ElectronicProduct("1001", "Smartphone", 699.99,
                "24 months warranty", 1);
        Product shirt = new ClothingProduct("2002", "T-Shirt", 19.99, "L", "Blue", 1);
        Product apple = new FoodProduct("3003", "Apple", 0.99, "2023-12-31", 1);
        Product book = new BookProduct("4004", "Java Programming", 49.99, "Author Name", 1);
        Product table = new FurnitureProduct("5005", "Dining Table", 299.99, "Wood", 1);

        productService.createProduct(phone);
        productService.createProduct(shirt);
        productService.createProduct(apple);
        productService.createProduct(book);
        productService.createProduct(table);

        cartService.addProductToCart(productService.getProductById("1001"), 1);
        cartService.addProductToCart(productService.getProductById("2002"), 1);
        cartService.addProductToCart(productService.getProductById("3003"), 1);
        cartService.addProductToCart(productService.getProductById("4004"), 1);
        cartService.addProductToCart(productService.getProductById("5005"), 1);

        // cartService.checkout();
        printWelcomeMessage();
        boolean mainLoop = true;
        String currentMenu = "productList";
        String currentId = "";
        while (mainLoop) {
            try {
                if (currentMenu.equals("productList")) {
                    userInterface.printTable(productService.getAllProducts());
                } else if (currentMenu.equals("cart")) {
                    userInterface.printCart();
                } else if (currentMenu.equals("history")) {
                    userInterface.printCartHistory(cartService.getCartHistory());
                } else if (currentMenu.equals("productAdd")) {
                    userInterface.printData(currentId, false);
                } else if (currentMenu.equals("cartModify")) {
                    userInterface.printData(currentId, true);
                }
                printMainMenu(currentMenu, currentId);
                String action = mainScanner.nextLine();

                switch (currentMenu) {

                    case "cart":
                        switch (action) {
                            case "1":
                                currentMenu = "productList";
                                break;
                            case "2":
                                currentMenu = "history";
                                break;
                            case "3":
                                currentMenu = "checkout";
                                break;
                            case "4":
                                cartService.clearCart();
                                break;
                            case "5":
                                System.out.println(ANSI_YELLOW
                                        + "\n\t\tThank you for using the E-Commerce Cart System. Goodbye!\n\n"
                                        + ANSI_RESET);
                                mainScanner.close();
                                return;
                            default:
                                int id = Integer.parseInt(action);
                                if (id >= 1000 && id <= 9999) {
                                    currentId = action;
                                    currentMenu = "cartModify";
                                } else {
                                    currentMenu = "productList";
                                    throw new IllegalArgumentException(
                                            "Invalid input. Please enter a valid number.");
                                }

                                break;
                        }
                        break;

                    case "history":
                        switch (action) {
                            case "1":
                                currentMenu = "productList";
                                break;
                            case "2":
                                currentMenu = "cart";
                                break;
                            case "3":
                                System.out.println(ANSI_YELLOW
                                        + "\n\t\tThank you for using the E-Commerce Cart System. Goodbye!\n\n"
                                        + ANSI_RESET);
                                mainScanner.close();
                                return;
                            default:

                                currentMenu = "productList";
                                throw new IllegalArgumentException(
                                        "Invalid input. Please enter a valid number.");
                        }
                        break;

                    case "productList":
                        switch (action) {
                            case "1":
                                currentMenu = "cart";
                                break;
                            case "2":
                                currentMenu = "history";
                                break;
                            case "3":
                                System.out.println(ANSI_YELLOW
                                        + "\n\t\tThank you for using the E-Commerce Cart System. Goodbye!\n\n"
                                        + ANSI_RESET);
                                mainScanner.close();
                                return;
                            default:
                                int id = Integer.parseInt(action);
                                if (id >= 1000 && id <= 9999) {
                                    currentId = action;
                                    currentMenu = "productAdd";
                                } else {
                                    currentMenu = "productList";
                                    throw new IllegalArgumentException(
                                            "Invalid ID. Please enter a number between 1000 and 9999.");
                                }

                                break;
                        }
                        break;

                    case "productAdd":
                        switch (action) {
                            case "1":
                                int inputQuantity = queryQuestion(mainScanner);
                                cartService.addProductToCart(productService.getProductById(currentId),
                                        inputQuantity);
                                System.out.println(
                                        ANSI_GREEN + "\n\t\t" + inputQuantity
                                                + "x "
                                                + productService.getProductById(currentId).getName()
                                                + " added to cart." + ANSI_RESET);
                                promptContinue();
                                currentMenu = "productList";
                                break;
                            case "2":
                                currentMenu = "productList";
                                break;
                            default:
                                currentMenu = "productAdd";
                                throw new NumberFormatException(
                                        "Invalid input. Please enter a valid number.");
                        }
                        break;

                    case "cartModify":
                        switch (action) {
                            case "1":
                                int inputQuantity = queryQuestion(mainScanner);
                                cartService.editProductQuantity(currentId,
                                        inputQuantity);
                                System.out.println(
                                        ANSI_GREEN + "\n\t\tCart Updated"
                                                + ANSI_RESET);
                                promptContinue();
                                currentMenu = "cart";
                                break;
                            case "2":
                                cartService.removeProductFromCart(currentId);
                                System.out.println(
                                        ANSI_GREEN + "\n\t\t"
                                                + "Cart Updated" + ANSI_RESET);
                                currentMenu = "cart";
                                promptContinue();

                                break;

                            case "3":
                                currentMenu = "cart";
                                break;
                            default:
                                currentMenu = "cartModify";
                                throw new NumberFormatException(
                                        "Invalid input. Please enter a valid number.");
                        }
                        break;

                    case "checkout":
                        switch (action) {
                            case "1":
                                cartService.checkout();
                                System.out.println(
                                        ANSI_GREEN + "\n\t\t" + "Checkout Successful" + ANSI_RESET);
                                promptContinue();
                                currentMenu = "productList";
                                break;
                            case "2":
                                currentMenu = "cart";
                                break;
                            default:
                                currentMenu = "checkout";
                                throw new NumberFormatException(
                                        "Invalid input. Please enter a valid number.");
                        }
                        break;

                    default:
                        currentMenu = "productList";
                        System.out.println(ANSI_RED + "\n\t\tInvalid menu state." + ANSI_RESET);
                        break;

                }

            } catch (NumberFormatException e) {
                System.out.println(
                        ANSI_RED + "\n\t\t" + "Invalid Input: Please enter a number" + ANSI_RESET);
                promptContinue();
            } catch (IllegalArgumentException e) {
                if (currentMenu.equals("cartModify")) {
                    currentMenu = "cart";
                } else {
                    currentMenu = "productList";
                }
                System.out.println(
                        ANSI_RED + "\n\t\t" + e.getMessage() + ANSI_RESET);
                promptContinue();
            } catch (Exception e) {
                System.out.println(
                        ANSI_RED + "\n\t\t" + e.getMessage() + ANSI_RESET);
                promptContinue();
            }
        }

    }

    /**
     * Prints a welcome message for the E-Commerce Cart System.
     */
    static void printWelcomeMessage() {
        System.out.println(ANSI_GREEN
                + "\n\t\t-------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\tWelcome to this E-Commerce Cart System");
        System.out.println(
                "\t\t-------------------------------------------------------------------------------------------"
                        + ANSI_RESET);
    }

    /**
     * Method to query the user for a product quantity using the provided Scanner
     * input.
     *
     * @param scanner the Scanner object used to read user input
     * @return the quantity of the product entered by the user
     */
    static int queryQuestion(Scanner scanner) {
        while (true) {
            System.out.print("\t\tEnter Product Quantity: ");
            String input = scanner.nextLine();
            try {
                int quantity = Integer.parseInt(input);
                if (quantity < 0) {
                    System.out.println("\t\tPlease enter a non-negative integer.");
                } else {
                    return quantity;
                }
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED + " \n\t\tInvalid input. Please enter a valid integer.\n" + ANSI_RESET);
            }
        }
    }

    /**
     * Prints the main menu options based on the current menu context and ID.
     *
     * @param currentMenu the current menu being displayed
     * @param currentId   the current ID related to the menu
     */
    static void printMainMenu(String currentMenu, String currentId) {
        System.out.println(ANSI_YELLOW + "\n\t\tPlease select an option:" + ANSI_RESET);

        if (currentMenu == "cart") {
            System.out.println(ANSI_CYAN + "\t\t[1] Product Listing");
            System.out.println("\t\t[2] View Cart History");
            System.out.println("\t\t[3] Checkout");
            System.out.println("\t\t[4] Clear Cart");
            System.out.println("\t\t[5] Exit");
            System.out.println("\t\t[-Cart ID-] Modify Product in Cart" + ANSI_RESET);
        } else if (currentMenu == "history") {
            System.out.println(ANSI_CYAN + "\t\t[1] Product Listing");
            System.out.println("\t\t[2] View Cart");
            System.out.println("\t\t[3] Exit" + ANSI_RESET);

        } else if (currentMenu == "productList") {
            System.out.println(ANSI_CYAN + "\t\t[1] View Cart");
            System.out.println("\t\t[2] Veiw Cart History");
            System.out.println("\t\t[3] Exit");
            System.out.println("\t\t[-Product ID-] Veiw Product" + ANSI_RESET);
        } else if (currentMenu == "productAdd") {
            System.out.println(ANSI_CYAN + "\t\t[1] Add to Cart");
            System.out.println("\t\t[2] Back" + ANSI_RESET);
        } else if (currentMenu == "cartModify") {
            System.out.println(ANSI_CYAN + "\t\t[1] Modify Quantity");
            System.out.println("\t\t[2] Remove from Cart");
            System.out.println("\t\t[3] Back" + ANSI_RESET);
        } else if (currentMenu == "checkout") {
            System.out.println(ANSI_CYAN + "\t\t[1] Confirm Checkout");
            System.out.println("\t\t[2] Cancel" + ANSI_RESET);
        }
        System.out.print("\t\tEnter Action Number: ");
    }

    /**
     * Prompts the user to press any key to continue and waits for user input.
     *
     * @throws Exception if there is an error reading from the input stream
     */
    static void promptContinue() {
        System.out.print(ANSI_YELLOW + "\n\t\tPress any key to continue..." + ANSI_RESET);
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
