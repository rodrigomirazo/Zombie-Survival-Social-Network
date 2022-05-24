package com.backendrecruitmenttest.ZSSN.service.impl;

import com.backendrecruitmenttest.ZSSN.dto.ResourceAverage;
import com.backendrecruitmenttest.ZSSN.dto.SurvivorDto;
import com.backendrecruitmenttest.ZSSN.dto.SurvivorPointsLost;
import com.backendrecruitmenttest.ZSSN.entity.InventoryItem;
import com.backendrecruitmenttest.ZSSN.service.ItemService;
import com.backendrecruitmenttest.ZSSN.service.ReportService;
import com.backendrecruitmenttest.ZSSN.service.SurvivorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private SurvivorService survivorService;

    @Autowired
    private ItemService itemService;

    @Override
    public List<ResourceAverage> amountOfEachResource() {

        List<ResourceAverage> resourceAverages = new ArrayList<>();

        List<SurvivorDto> survivorDtos = survivorService.get();
        List<InventoryItem> inventoryItems = itemService.getAll();

        AtomicReference<String> resourceAmount = new AtomicReference<>("");

        inventoryItems.stream().forEach(inventoryItem -> {

            ResourceAverage resourceAverage = new ResourceAverage();
            resourceAverage.setResourceName(inventoryItem.getItemQualifier());

            String resourceName = inventoryItem.getItemQualifier();
            AtomicReference<Integer> resourceCounter = new AtomicReference<>(0);

            survivorDtos.stream()
                .forEach(survivorDto -> {
                    resourceCounter.updateAndGet(v -> v + survivorDto.getResources().stream()
                            .map(resource -> resource.getQuantity())
                            .reduce(0, (a, b) -> a + b));
                });

            resourceAverage.setResourceName(resourceName);
            resourceAverage.setAverage(resourceCounter.get());

            resourceAverages.add(resourceAverage);
        });

        double totalResources = resourceAverages
                .stream()
                .map(resource -> resource.getAverage())
                .reduce(0.0, (a, b) -> a + b);

        return resourceAverages
                .stream()
                .map(resourceAverage ->
                        new ResourceAverage()
                                .setResourceName(resourceAverage.getResourceName())
                                .setAverage(resourceAverage.getAverage() / totalResources * 100) )
                .collect(Collectors.toList());
    }

    @Override
    public List<SurvivorPointsLost> pointsLostDueInfectedSurvivor() {

        List<SurvivorPointsLost> survivorPointsLost = new ArrayList<>();
        List<SurvivorDto> survivorDtos = survivorService.get();

        survivorDtos.stream()
                .forEach(survivorDto -> {

                    Integer pointsLost =
                    survivorDto.getResources().stream()
                            .map(resource -> resource.getQuantity() * resource.getPoints())
                            .reduce(0, (a, b) -> a + b);

                    survivorPointsLost.add(
                            new SurvivorPointsLost()
                                    .setSurvivorName(survivorDto.getName())
                                    .setPointsLost(pointsLost)
                    );
                });

        return survivorPointsLost;
    }
}
