package com.abhishek.productinventory.inventory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;

    public List<Inventory> getAllInventory() {
        log.info("Inside getAllInventory method of InventoryService");

        List<Inventory> allInventory = new ArrayList<>();
        inventoryRepository.findAll().forEach(allInventory::add);
        return allInventory;
    }

    public Inventory getQtyById(String id) {
        log.info("Inside getQtyById method of InventoryService");

        return inventoryRepository.findById(id).get();
    }

    public List<Inventory> getQtyByIds(List<String> id) {
        log.info("Inside getQtyByIds method of InventoryService");
        
        List<Inventory> qtyByIds = new ArrayList<>();
        inventoryRepository.findAllById(id).forEach(qtyByIds::add);
        return qtyByIds;
    }

    public void saveAllinventory(List<Inventory> inventoryList) {
        log.info("Inside saveAllinventory method of InventoryService");

        inventoryRepository.saveAll(inventoryList);
    }
}
