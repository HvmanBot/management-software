// REST API controllers
package com.managementsoftware.controller;

import com.managementsoftware.Item;
import com.managementsoftware.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * The ItemController exposes REST endpoints for Item operations.
 * It delegates business logic to the ItemService.
 */
@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    /**
     * Constructor injection for the ItemService dependency.
     */
    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    /**
     * Retrieve all items.
     * @return A list of all Items in the database.
     */
    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    /**
     * Create a new item.
     * @param item The item to be created.
     * @return The created item.
     */
    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemService.saveItem(item);
    }

    /**
     * Retrieve a single item by ID.
     * @param id The ID of the item to retrieve.
     * @return The requested item, or 404 if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        Optional<Item> item = itemService.getItemById(id);
        return item.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Update an existing item.
     * @param id The ID of the item to update.
     * @param item The updated item data.
     * @return The updated item, or 404 if not found.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item item) {
        // Optionally, check if the item exists before updating
        if (!itemService.getItemById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        item.setId(id); // Ensure we're updating the correct record
        Item updatedItem = itemService.saveItem(item);
        return ResponseEntity.ok(updatedItem);
    }

    /**
     * Delete an item by ID.
     * @param id The ID of the item to delete.
     * @return HTTP 204 (No Content) if successful, or 404 if not found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        if (!itemService.getItemById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}