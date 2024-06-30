# Mini-Project 3: E-commerce Cart System (Basic Version)

1. [Overview](#overview)
2. [Features](#features)
3. [System Architecture](#system-architecture)
4. [Class Descriptions](#class-descriptions)
5. [Data Model](#data-model)
6. [Interfaces](#interfaces)
7. [Algorithms and Data Structures](#algorithms-and-data-structures)
8. [Input Validation](#input-validation)
9. [Error Handling](#error-handling)
10. [Performance Considerations](#performance-considerations)
11. [Testing](#testing)
12. [Usage](#testing)

## Overview

This project is a basic implementation of an e-commerce cart system. It consists of various classes that represent products, a cart, and services to manage these entities. The system supports adding products to the cart, viewing the cart, and checking out.

## Features

- Add products to the cart
- View cart contents
- Checkout
- View cart history
- Manage product quantities in cart
- Remove products from cart
- Automatically calculate prices of a cart

## System Architecture

The system follows a modular architecture with the following key components:

1. **User Interface Layer** (`Main.java`):

   - The entry point of the application where user interactions are handled.

2. **Business Logic Layer**:

   - Contains the service implementations that handle the core logic of the application.
     - `CartServiceImpl.java`
     - `ProductServiceImpl.java`
     - `UserInterfaceServiceImpl.java`

3. **Data Model Layer**:

   - Represents the core data structures and entities used in the system.
     - `Product.java`
     - `Category.java`
     - `Cart.java`
     - `CartHistory.java`
     - Product subclasses such as `BookProduct.java`, `ClothingProduct.java`, `ElectronicProduct.java`, `FoodProduct.java`, and `FurnitureProduct.java`

4. **Interface Layer**:

   - Defines the interfaces for the services used in the application.
     - `ICartService.java`
     - `IProductService.java`
     - `IUserInterfaceService.java`

5. **Utility Classes**:
   - Helper classes that provide additional functionality used by other components.
   - For example, `RandomIdGenerator` (if such a utility class exists).

## Class Descriptions

### Product.java

Abstract class representing a product in the system.

- Fields: `id`, `cartId`, `name`, `basePrice`, `category`, `quantity`
- Methods: `getId()`, `setId(String id)`, `getCartId()`, `setCartId(String cartId)`, `getName()`, `setName(String name)`, `getBasePrice()`, `setBasePrice(double basePrice)`, `getCategory()`, `setCategory(Category category)`, `getQuantity()`, `setQuantity(int quantity)`, `copy()`

### Category.java

Enum representing different categories of products.

- Categories: `ELECTRONICS`, `CLOTHING`, `FOOD`, `BOOKS`, `FURNITURE`

### Cart.java

Represents a shopping cart containing products.

- Fields: `products`, `history`
- Methods: `getProducts()`, `addProduct(Product product)`, `removeProduct(String productId)`, `addHistory(CartHistory cartHistory)`, `getHistory()`

### CartHistory.java

Represents the history of a cart transaction.

- Fields: `date`, `isPaid`, `cart`
- Methods: `getDate()`, `isPaid()`, `getCart()`

### Product Types

#### BookProduct.java

Represents a book product.

- Additional Field: `author`
- Methods: `getAuthor()`, `setAuthor(String author)`, `copy()`

#### ClothingProduct.java

Represents a clothing product.

- Additional Fields: `size`, `color`
- Methods: `getSize()`, `setSize(String size)`, `getColor()`, `setColor(String color)`, `copy()`

#### ElectronicProduct.java

Represents an electronic product.

- Additional Field: `warranty`
- Methods: `getWarranty()`, `setWarranty(String warranty)`, `copy()`

#### FoodProduct.java

Represents a food product.

- Additional Field: `expirationDate`
- Methods: `getExpirationDate()`, `setExpirationDate(String expirationDate)`, `copy()`

#### FurnitureProduct.java

Represents a furniture product.

- Additional Field: `material`
- Methods: `getMaterial()`, `setMaterial(String material)`, `copy()`

## Data Model

The data model consists of the following entities:

- Product
- Category
- Cart
- CartHistory
- Specific product types such as BookProduct, ClothingProduct, ElectronicProduct, FoodProduct, and FurnitureProduct

## Interfaces

### ICartService.java

Interface for cart services.

- Methods Include: `addHistory(Date date, boolean isPaid)`, `addProductToCart(Product product, int inputQuantity)`, `calculateTotalPrice(Cart cart)`, `removeProductFromCart(String productId)`, `clearCart()`, `checkout()`, `editProductQuantity(String productId, int quantity)`, `getCart()`, `getCartHistory()`

### IProductService.java

Interface for product services.

- Methods Include: `createProduct(Product product)`, `getAllProducts()`, `getProductById(String id)`

### IUserInterfaceService.java

Interface for user interface services.

- Methods Include: `printData(String id, boolean isCartId)`, `printTable(List<?> items)`, `printCart()`

## Algorithms and Data Structures

- **Data Structures**: HashMap, ArrayList
- **Algorithms**: Basic search and filter operations on collections

## Input Validation

Input validation is performed to ensure:

- Product quantities are positive and do not exceed available stock
- Valid product IDs and cart IDs are used

## Error Handling

Error handling includes:

- Throwing `IllegalArgumentException` for invalid inputs
- Throwing `NumberFormatEcxeption` for non-numeric inputs
- Logging warnings and errors using SLF4J

## Performance Considerations

- Efficient lookups using HashMap for products in the cart
- Stream operations for filtering and mapping collections

## Testing

The testing suite for the E-Commerce Cart System application focuses on ensuring the robustness and correctness of the main functionalities through comprehensive unit tests. Using JUnit 4 and Mockito, we created detailed tests for key components, including the `Main` class, `UserInterfaceServiceImpl`, `CartServiceImpl`, and `ProductServiceImpl`. These tests cover various scenarios such as menu navigation, product addition, cart operations, and user input validation. By simulating user interactions and verifying console outputs, we ensured that each method behaves as expected under different conditions. This rigorous testing approach helps maintain high code quality and reliability, ensuring a seamless user experience.

## Usage

To run the application, execute the `Main` class. This initializes the services, creates a few sample products, and adds them to the cart. The user can then interact with the system via the console.

```bash
maven clean install
maven exec:java
```
