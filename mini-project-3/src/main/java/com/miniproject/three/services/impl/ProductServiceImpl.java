package com.miniproject.three.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.miniproject.three.entity.Product;
import com.miniproject.three.services.IProductService;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Implementation of the IProductService interface.
 */
public class ProductServiceImpl implements IProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
    private List<Product> products;

    /**
     * Constructs a new ProductServiceImpl and initializes the product list.
     */
    public ProductServiceImpl() {
        this.products = new ArrayList<>();
        logger.info("ProductServiceImpl initialized.");
    }

    /**
     * Creates a new product and adds it to the product list.
     *
     * @param product The product to be created and added.
     */
    @Override
    public void createProduct(Product product) {
        products.add(product);
        logger.info("Product " + product.getName() + " created and added to the product list.");
    }

    /**
     * Retrieves all products.
     *
     * @return A list of all products.
     */
    @Override
    public List<Product> getAllProducts() {
        logger.info("All products retrieved.");
        return products;
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param id The ID of the product to be retrieved.
     * @return The product with the specified ID, or null if no such product exists.
     */
    @Override
    public Product getProductById(String id) {
        logger.info("Product with ID " + id + " retrieved.");
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
