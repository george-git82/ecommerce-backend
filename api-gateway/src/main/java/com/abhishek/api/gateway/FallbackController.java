package com.abhishek.api.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/productListServiceFallback")
    public String productListServiceFallback() {
        return "PRODUCTS-LIST Service is taking longer than Expected. Please try again later. ";
    }

    @GetMapping("/productInventoryServiceFallback")
    public String productInventoryServiceFallback() {
        return "PRODUCTS-INVENTORY Service is taking longer than Expected. Please try again later. ";
    }
}
