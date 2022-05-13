package com.backendrecruitmenttest.ZSSN.entity;

import javax.persistence.*;

@Entity
@Table(name = "inventory_item")
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String itemQualifier;
    @Column
    private int points;

    public int getId() {
        return id;
    }

    public InventoryItem setId(int id) {
        this.id = id;
        return this;
    }

    public String getItemQualifier() {
        return itemQualifier;
    }

    public InventoryItem setItemQualifier(String itemQualifier) {
        this.itemQualifier = itemQualifier;
        return this;
    }

    public int getPoints() {
        return points;
    }

    public InventoryItem setPoints(int points) {
        this.points = points;
        return this;
    }

    @Override
    public String toString() {
        return "InventoryItem{" +
                "id=" + id +
                ", itemQualifier='" + itemQualifier + '\'' +
                ", points=" + points +
                '}';
    }
}
