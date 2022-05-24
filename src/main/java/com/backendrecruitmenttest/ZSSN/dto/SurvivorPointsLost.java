package com.backendrecruitmenttest.ZSSN.dto;

public class SurvivorPointsLost {

    private String survivorName;
    private int pointsLost;

    public String getSurvivorName() {
        return survivorName;
    }

    public SurvivorPointsLost setSurvivorName(String survivorName) {
        this.survivorName = survivorName;
        return this;
    }

    public int getPointsLost() {
        return pointsLost;
    }

    public SurvivorPointsLost setPointsLost(int pointsLost) {
        this.pointsLost = pointsLost;
        return this;
    }
}
