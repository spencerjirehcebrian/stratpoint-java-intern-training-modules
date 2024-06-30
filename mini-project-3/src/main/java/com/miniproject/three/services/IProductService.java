package com.miniproject.three.services;

import java.util.List;

import com.miniproject.three.entity.Product;

public interface IProductService {
    void createProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(String id);
}
