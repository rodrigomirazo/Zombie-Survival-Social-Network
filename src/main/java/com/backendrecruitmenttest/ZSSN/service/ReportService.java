package com.backendrecruitmenttest.ZSSN.service;

import com.backendrecruitmenttest.ZSSN.dto.ResourceAverage;
import com.backendrecruitmenttest.ZSSN.dto.SurvivorPointsLost;

import java.util.List;

public interface ReportService {

    List<ResourceAverage> amountOfEachResource();

    List<SurvivorPointsLost> pointsLostDueInfectedSurvivor();
}
