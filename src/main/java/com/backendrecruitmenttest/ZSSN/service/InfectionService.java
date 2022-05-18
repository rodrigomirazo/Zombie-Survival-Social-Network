package com.backendrecruitmenttest.ZSSN.service;

import org.springframework.web.bind.annotation.PathVariable;

public interface InfectionService {
    boolean infectionAssessment(int infectedSurvivorId, int survivorWitnessId);
}
