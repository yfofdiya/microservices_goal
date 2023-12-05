package com.simform.controller;

import com.simform.entity.Product;
import com.simform.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository ProductRepository;

    @PostConstruct
    public void initProductsTable() {
        ProductRepository.saveAll(Stream.of(
                        new Product("mobile", "electronics", "white", 20000),
                        new Product("T-Shirt", "clothes", "black", 999),
                        new Product("Jeans", "clothes", "blue", 1999),
                        new Product("Laptop", "electronics", "gray", 50000),
                        new Product("digital watch", "electronics", "black", 2500),
                        new Product("Fan", "electronics", "black", 50000)
                ).
                collect(Collectors.toList()));
    }

    @GetMapping
    public List<Product> getProducts() {
        return ProductRepository.findAll();
    }

    @GetMapping("/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return ProductRepository.findByCategory(category);
    }
}
