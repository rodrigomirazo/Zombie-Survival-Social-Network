package com.backendrecruitmenttest.ZSSN.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "survivor")
public class Survivor {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "gender")
    private String gender;
    @Column(name = "latitude")
    private double latitude;
    @Column(name = "longitude")
    private double longitude;
    @Column(name = "infected")
    private boolean infected;
    @OneToMany(mappedBy = "survivor")
    private List<SurvivorInventoryItem> inventoryItem;

    public long getId() {
        return id;
    }

    public Survivor setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Survivor setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Survivor setAge(int age) {
        this.age = age;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Survivor setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public double getLatitude() {
        return latitude;
    }

    public Survivor setLatitude(double latitude) {
        this.latitude = latitude;
        return this;
    }

    public double getLongitude() {
        return longitude;
    }

    public Survivor setLongitude(double longitude) {
        this.longitude = longitude;
        return this;
    }

    public boolean isInfected() {
        return infected;
    }

    public Survivor setInfected(boolean infected) {
        this.infected = infected;
        return this;
    }

    public List<SurvivorInventoryItem> getInventoryItem() {
        return inventoryItem;
    }

    public Survivor setInventoryItem(List<SurvivorInventoryItem> inventoryItem) {
        this.inventoryItem = inventoryItem;
        return this;
    }

    @Override
    public String toString() {
        return "Survivor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", infected=" + infected +
                '}';
    }
}
