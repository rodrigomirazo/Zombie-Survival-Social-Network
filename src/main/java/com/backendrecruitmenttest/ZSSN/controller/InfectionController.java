package com.backendrecruitmenttest.ZSSN.controller;

import com.backendrecruitmenttest.ZSSN.service.InfectionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiOperation(value = "Allows survivors to report if an specific survivor is infected", notes = "You'd better trust others to survive")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved")
    })
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
