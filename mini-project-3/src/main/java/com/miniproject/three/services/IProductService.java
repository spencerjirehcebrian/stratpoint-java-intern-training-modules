package com.miniproject.three.services;

import java.util.List;

import com.miniproject.three.entity.Product;

/**
 * Interface for product services.
 */
public interface IProductService {

    /**
     * Creates a new product.
     * 
     * @param product The product to create.
     */
    void createProduct(Product product);

    /**
     * Gets all products.
     * 
     * @return A list of all products.
     */
    List<Product> getAllProducts();

    /**
     * Gets a product by its ID.
     * 
     * @param id The ID of the product.
     * @return The product with the specified ID.
     */
    Product getProductById(String id);
}
