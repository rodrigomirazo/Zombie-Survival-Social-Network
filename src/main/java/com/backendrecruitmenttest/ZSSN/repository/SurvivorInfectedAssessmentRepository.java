package com.backendrecruitmenttest.ZSSN.repository;

import com.backendrecruitmenttest.ZSSN.entity.SurvivorInfectedAssessment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SurvivorInfectedAssessmentRepository extends CrudRepository<SurvivorInfectedAssessment, Integer> {

    @Query("SELECT count(distinct survivorWitnessId) FROM SurvivorInfectedAssessment " +
            "where survivorInfectedId = ?1")
    long countBySurvivorInfectedId(int survivorInfectedId);
}
