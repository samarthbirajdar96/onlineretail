package com.example.InventoryService.Service;


import com.example.InventoryService.Model.Inventory;
import com.example.InventoryService.Repo.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    // Add a new inventory entry
    public Inventory addInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    // Delete inventory by ID
    public void deleteInventory(Long id) {
        inventoryRepository.deleteById(id);
    }

    // Update inventory details
    public Inventory updateInventory(Long id, Inventory inventoryDetails) {
        Inventory inventory = getInventory(id);
        inventory.setProductId(inventoryDetails.getProductId());
        inventory.setQuantity(inventoryDetails.getQuantity());
        return inventoryRepository.save(inventory);
    }

    // Get inventory by ID
    public Inventory getInventory(Long id) {
        Optional<Inventory> inventory = inventoryRepository.findById(id);
        return inventory.orElseThrow(() -> new RuntimeException("Inventory not found"));
    }
}
