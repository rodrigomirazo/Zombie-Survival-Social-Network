package com.backendrecruitmenttest.ZSSN.service;

import com.backendrecruitmenttest.ZSSN.entity.Survivor;

public interface SurvivorService {

    /**
     * @apiNote Update location
     * @return survivor Entity
     */
    Survivor updateSurvivorLocation(Survivor survivor);

    /**
     * Turn on Infected Status on Survivor
     * @param survivorId
     * @return
     */
    Survivor survivorInfected(int survivorId);
}
