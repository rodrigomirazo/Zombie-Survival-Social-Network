package com.backendrecruitmenttest.ZSSN.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "survivor_inventory_item")
public class SurvivorInventoryItem {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private InventoryItem inventoryItem;

    @Column(name = "quantity")
    private int quantity;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    @JsonIgnore
    private Survivor survivor;

    public int getId() {
        return id;
    }

    public SurvivorInventoryItem setId(int id) {
        this.id = id;
        return this;
    }

    public InventoryItem getInventoryItem() {
        return inventoryItem;
    }

    public SurvivorInventoryItem setInventoryItem(InventoryItem inventoryItem) {
        this.inventoryItem = inventoryItem;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public SurvivorInventoryItem setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public Survivor getSurvivor() {
        return survivor;
    }

    public SurvivorInventoryItem setSurvivor(Survivor survivor) {
        this.survivor = survivor;
        return this;
    }

    @Override
    public String toString() {
        return "SurvivorInventoryItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}
