package com.backendrecruitmenttest.ZSSN.entity;

import javax.persistence.*;

@Entity
@Table(name = "survivor")
public class Survivor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private int age;
    @Column
    private String gender;
    @Column
    private double latitude;
    @Column
    private double longitude;
    @Column
    private boolean infected;

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

    @Override
    public String toString() {
        return "Survivor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
