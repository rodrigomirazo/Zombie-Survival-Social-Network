package com.backendrecruitmenttest.ZSSN.controller;

import com.backendrecruitmenttest.ZSSN.service.InfectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/infection")
public class InfectionController {

    @Autowired
    private InfectionService infectionService;

    /**
     * Set survivor as infected
     * @return
     */
    @PutMapping("/assessment/{infectedSurvivorId}/{survivorWitnessId}")
    public String infectionAssessment(
            @PathVariable int infectedSurvivorId,
            @PathVariable int survivorWitnessId
    ) {
        boolean infectionFlagEnabled = infectionService.infectionAssessment(infectedSurvivorId, survivorWitnessId);

        if(infectionFlagEnabled) {
            return "Survivor has been Reported As Infected";
        }
        return "Survivor NOT Infected yet";
    }
}
