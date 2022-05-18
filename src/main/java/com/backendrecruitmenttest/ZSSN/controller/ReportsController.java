package com.backendrecruitmenttest.ZSSN.controller;

import com.backendrecruitmenttest.ZSSN.dto.SurvivorDto;
import com.backendrecruitmenttest.ZSSN.entity.InventoryItem;
import com.backendrecruitmenttest.ZSSN.service.ItemService;
import com.backendrecruitmenttest.ZSSN.service.SurvivorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Controller
@ResponseBody
@RequestMapping("/reports")
public class ReportsController {

    @Autowired
    private SurvivorService survivorService;

    @Autowired
    private ItemService itemService;

    @GetMapping("/percentageOfInfectedSurvivors")
    public String infected() {
        List<SurvivorDto> survivorDtos = survivorService.get();

        List<SurvivorDto> survivorsinfected =
        survivorDtos.stream()
                .filter(survivorDto -> survivorDto.isInfected() == true)
                .collect(Collectors.toList());

        double percentage = survivorsinfected.size() / survivorDtos.size() * 100;

        return "Percentage of infected survivors: " + percentage;
    }

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

    @GetMapping("/amountOfEachResource")
    public AtomicReference<String> amountOfEachResource() {


        List<SurvivorDto> survivorDtos = survivorService.get();
        List<InventoryItem> inventoryItems = itemService.getAll();

        AtomicReference<String> resourceAmount = new AtomicReference<>("");

        inventoryItems.stream().forEach(inventoryItem -> {

            resourceAmount.set(resourceAmount + inventoryItem.getItemQualifier() + " => \n");

            survivorDtos.stream()
                    .forEach(survivorDto -> {

                        survivorDto.getResources()
                                .stream().filter(resources -> resources.getName().equalsIgnoreCase(inventoryItem.getItemQualifier()))
                                .collect(Collectors.toList());
                    });
        });

        return resourceAmount;
    }

}
