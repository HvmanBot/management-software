// Database access interfaces
package com.managementsoftware;

import com.managementsoftware.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The ItemRepository interface handles data access operations for the Item entity.
 * By extending JpaRepository, we automatically get CRUD methods (e.g., save, findAll, findById, deleteById).
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    // You can add custom query methods here if needed, for example:
    // List<Item> findByName(String name);
}