package com.miniproject.three;

import com.miniproject.three.entity.Product;
import com.miniproject.three.entity.products.ElectronicProduct;
import com.miniproject.three.entity.products.ClothingProduct;
import com.miniproject.three.entity.products.FoodProduct;
import com.miniproject.three.entity.products.BookProduct;
import com.miniproject.three.entity.products.FurnitureProduct;
import com.miniproject.three.services.IProductService;
import com.miniproject.three.services.impl.ProductServiceImpl;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ProductServiceImplTest {

    private IProductService productService;

    @Before
    public void setUp() {
        productService = new ProductServiceImpl();

        Product phone = new ElectronicProduct("1001", "Smartphone", 699.99, "24 months warranty", 1);
        Product shirt = new ClothingProduct("2002", "T-Shirt", 19.99, "L", "Blue", 1);
        Product apple = new FoodProduct("3003", "Apple", 0.99, "2023-12-31", 1);
        Product book = new BookProduct("4004", "Java Programming", 49.99, "Author Name", 1);
        Product table = new FurnitureProduct("5005", "Dining Table", 299.99, "Wood", 1);

        productService.createProduct(phone);
        productService.createProduct(shirt);
        productService.createProduct(apple);
        productService.createProduct(book);
        productService.createProduct(table);
    }

    @Test
    public void testCreateProduct() {
        Product newProduct = new ElectronicProduct("6006", "Laptop", 999.99, "12 months warranty", 1);
        productService.createProduct(newProduct);
        List<Product> products = productService.getAllProducts();
        assertEquals(6, products.size());
        assertEquals("Laptop", products.get(5).getName());
    }

    @Test
    public void testGetAllProducts() {
        List<Product> products = productService.getAllProducts();
        assertEquals(5, products.size());
    }

    @Test
    public void testGetProductById() {
        Product foundProduct = productService.getProductById("1001");
        assertNotNull(foundProduct);
        assertEquals("Smartphone", foundProduct.getName());
    }

    @Test
    public void testGetProductByIdNotFound() {
        Product foundProduct = productService.getProductById("9999");
        assertNull(foundProduct);
    }
}
