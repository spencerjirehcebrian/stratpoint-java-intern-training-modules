package com.miniproject.three.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.miniproject.three.entity.Product;
import com.miniproject.three.services.IProductService;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class ProductServiceImpl implements IProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
    private List<Product> products;

    public ProductServiceImpl() {
        this.products = new ArrayList<>();
        logger.info("ProductServiceImpl initialized.");
    }

    @Override
    public void createProduct(Product product) {
        products.add(product);
        logger.info("Product " + product.getName() + " created and added to the product list.");
    }

    @Override
    public List<Product> getAllProducts() {
        logger.info("All products retrieved.");
        return products;
    }

    @Override
    public Product getProductById(String id) {
        logger.info("Product with ID " + id + " retrieved.");
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
