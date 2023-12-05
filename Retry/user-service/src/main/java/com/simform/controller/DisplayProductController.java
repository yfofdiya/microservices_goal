package com.simform.controller;

import com.simform.dto.ProductDTO;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/display-products")
public class DisplayProductController {

    @Autowired
    private RestTemplate restTemplate;

    public static final String USER_SERVICE = "userService";
    private static final String BASE_URL = "http://localhost:9191/products";

    private int attempt = 1;

    @GetMapping
//    @CircuitBreaker(name = USER_SERVICE, fallbackMethod = "getAllAvailableProducts")
    @Retry(name = USER_SERVICE, fallbackMethod = "getAllAvailableProducts")
    public List<ProductDTO> displayProducts(@RequestParam("category") String category) {
        String url = category == null ? BASE_URL : BASE_URL + "/" + category;
        System.out.println("retry method called " + attempt++ + " times " + " at " + new Date());
        return restTemplate.getForObject(url, ArrayList.class);
    }

    public List<ProductDTO> getAllAvailableProducts(Exception e) {
        return Stream.of(
                new ProductDTO(119, "LED TV", "electronics", "white", 45000),
                new ProductDTO(345, "Headset", "electronics", "black", 7000),
                new ProductDTO(475, "Sound bar", "electronics", "black", 13000),
                new ProductDTO(574, "Puma Shoes", "foot wear", "black & white", 4600),
                new ProductDTO(678, "Vegetable chopper", "kitchen", "blue", 999),
                new ProductDTO(532, "Oven Gloves", "kitchen", "gray", 745)
        ).collect(Collectors.toList());
    }
}
