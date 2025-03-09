// Business logic layer
package com.managementsoftware;

import com.managementsoftware.Item;
import com.managementsoftware.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * The ItemService class encapsulates business logic for Item management.
 * It communicates with the ItemRepository to perform CRUD operations.
 */
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    /**
     * Using constructor injection ensures the ItemRepository is available
     * and can be easily mocked for testing.
     */
    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    /**
     * Retrieve all items from the database.
     * @return A list of Item objects.
     */
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    /**
     * Create or update an Item in the database.
     * @param item The Item to be saved.
     * @return The saved Item object (with any auto-generated fields, like ID).
     */
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    /**
     * Retrieve a single Item by its ID.
     * @param id The ID of the Item.
     * @return An Optional containing the found Item, or empty if not found.
     */
    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    /**
     * Delete an Item by its ID.
     * @param id The ID of the Item to delete.
     */
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}