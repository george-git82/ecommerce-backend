package com.abhishek.ecommercebackend;

import com.abhishek.ecommercebackend.products.Product;
import com.abhishek.ecommercebackend.products.ProductService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * This class populates Derby DB with data from Products.json on application
 * start-up
 */
@Component
public class AddProducts {
    @Autowired
    ProductService productService;

    @EventListener(ApplicationReadyEvent.class)
    public void populateDataOnStartup() {
        System.out.println("Read from json and write to database -- start");
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Product>> typeReference = new TypeReference<List<Product>>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream("/Products.json");
        try {
            List<Product> products = mapper.readValue(inputStream, typeReference);
            productService.addAllProducts(products);
            System.out.println("Products Saved !!!");
            System.out.println("Read from json and write to database -- end");
        } catch (IOException e) {
            System.out.println("Unable to save Products: " + e.getMessage());
        }
        // Test DB has data - fetch from DB
        // System.out.println("All products: " + productService.getAllProduct());
    }
}
