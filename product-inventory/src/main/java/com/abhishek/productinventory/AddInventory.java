package com.abhishek.productinventory;

import com.abhishek.productinventory.inventory.InventoryService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.abhishek.productinventory.inventory.Inventory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * This class populates Derby DB with data from Inventory.json on application
 * start-up
 */
@Component
public class AddInventory {
    @Autowired
    InventoryService inventoryService;

    @EventListener(ApplicationReadyEvent.class)
    public void populateDataOnStartup() {
        System.out.println("Read from json and write to database -- start");
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Inventory>> typeReference = new TypeReference<List<Inventory>>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream("/Inventory.json");
        try {
            List<Inventory> inventoryList = mapper.readValue(inputStream, typeReference);
            inventoryService.saveAllinventory(inventoryList);
            System.out.println("Inventory Saved !!!");
            System.out.println("Read from json and write to database -- end");
        } catch (IOException e) {
            System.out.println("Unable to save Products: " + e.getMessage());
        }
        // Test DB has data - fetch from DB
        // System.out.println("All inventory: " + inventoryService.getAllInventory());
    }
}
