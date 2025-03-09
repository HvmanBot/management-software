// Entity and domain models
package com.managementsoftware;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


/**
 * The Item entity represents an item in the inventory.
 * It is annotated with @Entity to indicate it's a JPA entity.
 */
@Entity
public class Item {

    /**
     * The unique identifier for each item record.
     * @Id marks this field as the primary key in the database table.
     * @GeneratedValue automatically generates values for new records.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the item, e.g., 'Laptop', 'Smartphone', etc.
     */
    private String name;

    /**
     * The quantity in stock for this particular item.
     */
    private int quantity;

    /**
     * Default constructor (required by JPA).
     */
    public Item() {
    }

    /**
     * Parameterized constructor for easy instantiation.
     * @param name     The name of the item.
     * @param quantity The quantity in stock.
     */
    public Item(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    // --- Getters and Setters ---

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}