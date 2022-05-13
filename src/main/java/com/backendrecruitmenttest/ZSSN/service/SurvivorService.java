package com.backendrecruitmenttest.ZSSN.service;

import com.backendrecruitmenttest.ZSSN.entity.Survivor;

public interface SurvivorService {

    /**
     * @return survivor Entity
     * @apiNote Update location
     */
    Survivor updateSurvivorLocation(int survivorId, double latitude, double longitude);

    /**
     * Add survivors
     *
     * @param survivor
     * @return
     */
    Survivor add(Survivor survivor);

    void infectSurvivor(int survivorId);

    void infectionAssessment(int survivorInfectedId, int survivorWitnessId);
}
