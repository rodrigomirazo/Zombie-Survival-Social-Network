package com.backendrecruitmenttest.ZSSN.dto;

public class Resources {
    private int id;
    private String name;
    private int points;
    private int quantity;

    public int getId() {
        return id;
    }

    public Resources setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Resources setName(String name) {
        this.name = name;
        return this;
    }

    public int getPoints() {
        return points;
    }

    public Resources setPoints(int points) {
        this.points = points;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public Resources setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
}
