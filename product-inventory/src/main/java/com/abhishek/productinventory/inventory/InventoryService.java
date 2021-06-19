package com.abhishek.productinventory.inventory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;

    public List<Inventory> getAllInventory() {
        List<Inventory> allInventory = new ArrayList<>();
        inventoryRepository.findAll().forEach(allInventory::add);
        return allInventory;
    }

    public Inventory getQtyById(String id) {
        return inventoryRepository.findById(id).get();
    }

    public List<Inventory> getQtyByIds(List<String> id) {
        List<Inventory> qtyByIds = new ArrayList<>();
        inventoryRepository.findAllById(id).forEach(qtyByIds::add);
        return qtyByIds;
    }

    public void saveAllinventory(List<Inventory> inventoryList) {
        inventoryRepository.saveAll(inventoryList);
    }
}
