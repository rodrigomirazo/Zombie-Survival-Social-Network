package com.backendrecruitmenttest.ZSSN.entity;

import javax.persistence.*;

@Entity
@Table(name = "survivor_inventory_item")
public class SurvivorInventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int itemId;
    @Column
    private int quantity;

    public int getId() {
        return id;
    }

    public SurvivorInventoryItem setId(int id) {
        this.id = id;
        return this;
    }

    public int getItemId() {
        return itemId;
    }

    public SurvivorInventoryItem setItemId(int itemId) {
        this.itemId = itemId;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public SurvivorInventoryItem setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
}
