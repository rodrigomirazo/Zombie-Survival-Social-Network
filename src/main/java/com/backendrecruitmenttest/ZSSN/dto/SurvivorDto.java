package com.backendrecruitmenttest.ZSSN.dto;

import javax.persistence.Column;
import java.util.List;

public class SurvivorDto {

    private long id;
    private String name;
    private int age;
    private String gender;
    private double latitude;
    private double longitude;
    private boolean infected;
    private List<Resources> resources;

    public long getId() {
        return id;
    }

    public SurvivorDto setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SurvivorDto setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public SurvivorDto setAge(int age) {
        this.age = age;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public SurvivorDto setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public double getLatitude() {
        return latitude;
    }

    public SurvivorDto setLatitude(double latitude) {
        this.latitude = latitude;
        return this;
    }

    public double getLongitude() {
        return longitude;
    }

    public SurvivorDto setLongitude(double longitude) {
        this.longitude = longitude;
        return this;
    }

    public boolean isInfected() {
        return infected;
    }

    public SurvivorDto setInfected(boolean infected) {
        this.infected = infected;
        return this;
    }

    public List<Resources> getResources() {
        return resources;
    }

    public SurvivorDto setResources(List<Resources> resources) {
        this.resources = resources;
        return this;
    }
}
