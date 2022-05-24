package com.backendrecruitmenttest.ZSSN.dto;

public class ResourceAverage {

    private String resourceName;
    private double average;

    public String getResourceName() {
        return resourceName;
    }

    public ResourceAverage setResourceName(String resourceName) {
        this.resourceName = resourceName;
        return this;
    }

    public double getAverage() {
        return average;
    }

    public ResourceAverage setAverage(double average) {
        this.average = average;
        return this;
    }
}
