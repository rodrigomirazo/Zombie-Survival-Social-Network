package com.backendrecruitmenttest.ZSSN.service.impl;

import com.backendrecruitmenttest.ZSSN.entity.SurvivorInfectedAssessment;
import com.backendrecruitmenttest.ZSSN.repository.SurvivorInfectedAssessmentRepository;
import com.backendrecruitmenttest.ZSSN.service.InfectionService;
import com.backendrecruitmenttest.ZSSN.service.SurvivorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfectionServiceImpl implements InfectionService {

    @Autowired
    private SurvivorInfectedAssessmentRepository infectedRepository;

    @Autowired
    private SurvivorService survivorService;

    /**
     * 1. Save Infection report
     * 2. Count Reported infection cases
     * 3. Flag condition, if greater than 3, then Infected flag is Enabled
     * 4. else not Infected flag is NOT Enabled
     *
     * @param infectedSurvivorId
     * @param survivorWitnessId
     */
    @Override
    public boolean infectionAssessment(int infectedSurvivorId, int survivorWitnessId) {

        // 1
        SurvivorInfectedAssessment infectedAssessment = new SurvivorInfectedAssessment();
        infectedAssessment.setSurvivorInfectedId(infectedSurvivorId);
        infectedAssessment.setSurvivorWitnessId(survivorWitnessId);
        infectedRepository.save(infectedAssessment);

        // 2
        long reports = infectedRepository.countBySurvivorInfectedId(infectedSurvivorId);

        // 3
        if(reports >= 3) {
            survivorService.infectSurvivor(infectedSurvivorId);
            return true;
        }

        // 4
        return false;
    }
}
