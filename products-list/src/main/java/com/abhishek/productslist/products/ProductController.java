package com.abhishek.productslist.products;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.abhishek.productslist.model.Inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("api")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        log.info("Inside getAllProducts method of ProductController");

        List<Product> allProducts = productService.getAllProduct();

        List<String> allIds = allProducts.stream().map(product -> {
            return product.getId();
        }).collect(Collectors.toList());

        // try {
        // Inventory[] inventory = restTemplate
        // .postForEntity("http://localhost:8082/api/inventory", allIds,
        // Inventory[].class).getBody();
        // allProducts = addProductsQty(allProducts, inventory);
        // } catch (Exception e) {
        // System.out.println("ERROR: " + e.getMessage());
        // throw e;
        // }

        try {
            Inventory[] inventory = restTemplate
                    .postForEntity("http://PRODUCTS-INVENTORY/api/inventory", allIds, Inventory[].class).getBody();
            allProducts = addProductsQty(allProducts, inventory);
        } catch (ResourceAccessException e) {
            log.error("/api/inventory : refused connection.");
            // throw new RuntimeException("/api/inventory : refused connection.");
            allProducts = addProductsQty(allProducts, null);
        }

        return allProducts;
    }

    private List<Product> addProductsQty(List<Product> allProducts, Inventory[] inventory) {
        log.info("Inside addProductsQty method of ProductController");

        if (inventory == null) {
            // set qty on products
            allProducts.forEach(ele -> {
                ele.setQty("ERROR: Unable to fetch inventory data");
            });
        } else {

            // Convert inventory to map
            Map<String, Integer> mInventory = new HashMap<>();
            for (Inventory e : inventory) {
                mInventory.put(e.getId(), Integer.parseInt(e.getQty()));
            }

            // set qty on products
            allProducts.forEach(ele -> {
                ele.setQty("" + mInventory.get(ele.getId()));
            });
        }

        return allProducts;
    }
}
