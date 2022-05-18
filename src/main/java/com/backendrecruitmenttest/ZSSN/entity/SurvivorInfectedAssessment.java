package com.backendrecruitmenttest.ZSSN.entity;

import javax.persistence.*;

@Entity
@Table(name = "survivor_infected_assessment")
public class SurvivorInfectedAssessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int survivorInfectedId;
    @Column
    private int survivorWitnessId;

    public int getId() {
        return id;
    }

    public SurvivorInfectedAssessment setId(int id) {
        this.id = id;
        return this;
    }

    public int getSurvivorInfectedId() {
        return survivorInfectedId;
    }

    public SurvivorInfectedAssessment setSurvivorInfectedId(int survivorInfectedId) {
        this.survivorInfectedId = survivorInfectedId;
        return this;
    }

    public int getSurvivorWitnessId() {
        return survivorWitnessId;
    }

    public SurvivorInfectedAssessment setSurvivorWitnessId(int survivorWitnessId) {
        this.survivorWitnessId = survivorWitnessId;
        return this;
    }

    @Override
    public String toString() {
        return "SurvivorInfectedAssessment{" +
                "id=" + id +
                ", survivorInfectedId=" + survivorInfectedId +
                ", survivorWitnessId=" + survivorWitnessId +
                '}';
    }
}
