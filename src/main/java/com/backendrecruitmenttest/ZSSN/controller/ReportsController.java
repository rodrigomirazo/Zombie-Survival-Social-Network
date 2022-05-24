package com.backendrecruitmenttest.ZSSN.controller;

import com.backendrecruitmenttest.ZSSN.dto.ResourceAverage;
import com.backendrecruitmenttest.ZSSN.dto.SurvivorDto;
import com.backendrecruitmenttest.ZSSN.dto.SurvivorPointsLost;
import com.backendrecruitmenttest.ZSSN.entity.InventoryItem;
import com.backendrecruitmenttest.ZSSN.service.ItemService;
import com.backendrecruitmenttest.ZSSN.service.ReportService;
import com.backendrecruitmenttest.ZSSN.service.SurvivorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
/*
@Controller
@ResponseBody
@RequestMapping("/reports")
*/
@RestController("/reports")
public class ReportsController {

    @Autowired
    private SurvivorService survivorService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private ReportService reportService;

    @ApiOperation(value = "Obtain percentage of infected Survivors", notes = "The death of one man is a tragedy, The Death of millions is a statistic - Joseph Stalin")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved")
    })
    @GetMapping(value = "/percentageOfInfectedSurvivors")
    public String infected() {
        List<SurvivorDto> survivorDtos = survivorService.get();

        List<SurvivorDto> survivorsinfected =
        survivorDtos.stream()
                .filter(survivorDto -> survivorDto.isInfected() == true)
                .collect(Collectors.toList());

        double percentage = survivorsinfected.size() / survivorDtos.size() * 100;

        return "Percentage of infected survivors: " + percentage;
    }

    @ApiOperation(value = "Obtain percentage of NOT infected Survivors", notes = "For those who deserve to be called Survivors, Stay Strong!")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved")
    })
    @GetMapping("/percentageOfNONInfectedSurvivors")
    public String nonInfected() {
        List<SurvivorDto> survivorDtos = survivorService.get();

        List<SurvivorDto> survivorsinfected =
                survivorDtos.stream()
                        .filter(survivorDto -> survivorDto.isInfected() == false)
                        .collect(Collectors.toList());

        double percentage = survivorsinfected.size() / survivorDtos.size() * 100;

        return "Percentage of infected survivors: " + percentage;
    }

    @ApiOperation(value = "Obtain amount of each item based on current collection of items", notes = "Because you ask for it, statistics always help, specially in zombie land")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved")
    })
    @GetMapping("/amountOfEachResource")
    public List<ResourceAverage> amountOfEachResource() {

        List<ResourceAverage> resourceAverages = reportService.amountOfEachResource();

        return resourceAverages;
    }

    @ApiOperation(value = "Obtain the quantity of points lost", notes = "Dumb survivors will cause the Zombie land to lost everything we have build!")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved")
    })
    @GetMapping("/pointsLostDueInfectedSurvivor")
    public List<SurvivorPointsLost> pointsLostDueInfectedSurvivor() {

        List<SurvivorPointsLost> survivorPointsLosts = reportService.pointsLostDueInfectedSurvivor();

        return survivorPointsLosts;
    }

}
