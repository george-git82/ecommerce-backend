package com.abhishek.productinventory.inventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("api")
@Slf4j
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @RequestMapping(value = "/inventory/{prdId}", method = RequestMethod.GET)
    public Inventory getInventoryById(@PathVariable("prdId") String prdId) {
        log.info("Inside getInventoryById method of InventoryController");

        return inventoryService.getQtyById(prdId);
    }

    @RequestMapping(value = "/inventory", method = RequestMethod.GET)
    public List<Inventory> getAllInventory() {
        log.info("Inside getAllInventory method of InventoryController");

        return inventoryService.getAllInventory();
    }

    @RequestMapping(value = "/inventory", method = RequestMethod.POST)
    public List<Inventory> getQtyByPrdIds(@RequestBody List<String> ids) {
        log.info("Inside getQtyByPrdIds method of InventoryController");

        return inventoryService.getQtyByIds(ids);
    }
}
