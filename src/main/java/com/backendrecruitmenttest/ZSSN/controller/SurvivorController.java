package com.backendrecruitmenttest.ZSSN.controller;

import com.backendrecruitmenttest.ZSSN.component.SurvivorComponent;
import com.backendrecruitmenttest.ZSSN.dto.SurvivorDto;
import com.backendrecruitmenttest.ZSSN.entity.Survivor;
import com.backendrecruitmenttest.ZSSN.service.SurvivorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/survivor")
public class SurvivorController {

    @Autowired
    private SurvivorService survivorService;

    @Autowired
    private SurvivorComponent survivorComponent;

    @ApiOperation(value = "Populate the Zombie land with Survivors", notes = "recommended to begin the action!!!!")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved")
    })
    @PostMapping("/populate")
    public List<Survivor> generatePopulation() {
        return survivorComponent.generatePopulation();
    }

    @ApiOperation(value = "Create Survivor")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved")
    })
    @PostMapping()
    @ResponseBody
    public SurvivorDto save(@RequestBody SurvivorDto survivor) {
        return survivorService.add(survivor);
    }

    @ApiOperation(value = "Update survivor location", notes = "you may not choose this option, someone can betray you, or not?")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved")
    })
    @PutMapping("/updateLocation/{survivorId}/{latitude}/{longitude}")
    public Survivor updateLocation(
            @PathVariable int survivorId,
            @PathVariable double latitude,
            @PathVariable double longitude
    ) {
        return survivorService.updateSurvivorLocation(survivorId, latitude, longitude);
    }

    /**
     * Set survivor as infected
     * @return
     */
    @ApiOperation(value = "Go ahead and infect someone, without any witness", notes = "Have no mercy")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved")
    })
    @PostMapping("/infectSurvivor/{survivorId}")
    public String infectSurvivor(
            @PathVariable int survivorId
    ) {
        survivorService.infectSurvivor(survivorId);
        return "Survivor Successfully Infected";
    }

    @ApiOperation(value = "Obtain every member without restriction", notes = "With Great power comes... greate responsability")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved")
    })
    @GetMapping()
    public List<SurvivorDto> getAll() {
        return survivorService.get();
    }

}
