package com.backendrecruitmenttest.ZSSN.service.impl;

import com.backendrecruitmenttest.ZSSN.dto.Resources;
import com.backendrecruitmenttest.ZSSN.dto.SurvivorDto;
import com.backendrecruitmenttest.ZSSN.dto.SurvivorItemTradeDto;
import com.backendrecruitmenttest.ZSSN.entity.InventoryItem;
import com.backendrecruitmenttest.ZSSN.entity.Survivor;
import com.backendrecruitmenttest.ZSSN.entity.SurvivorInventoryItem;
import com.backendrecruitmenttest.ZSSN.mapper.SurvivorResourcesMapper;
import com.backendrecruitmenttest.ZSSN.service.ItemService;
import com.backendrecruitmenttest.ZSSN.service.SurvivorService;
import com.backendrecruitmenttest.ZSSN.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    private ItemService itemService;

    @Autowired
    private SurvivorService survivorService;

    @Autowired
    private SurvivorResourcesMapper survivorResourcesMapper;

    @Override
    public boolean tradeItems(
            SurvivorItemTradeDto survivorItemTrade) {

        //Get Resources by Survivor
        SurvivorDto primarySurvivorItems = survivorService.getById(survivorItemTrade.getPrimarySurvivorId());
        SurvivorDto secondarySurvivorItems = survivorService.getById(survivorItemTrade.getSecondarySurvivorId());

        //Filter Resources
        List<Resources> primaryResources =
        primarySurvivorItems.getResources().stream()
                .filter(resources ->
                        survivorItemTrade.getPrimaryItems().contains(resources.getName())
                ).collect(Collectors.toList());

        List<Resources> secondaryResources =
                secondarySurvivorItems.getResources().stream()
                        .filter(resources ->
                                survivorItemTrade.getSecondaryItems().contains(resources.getName())
                        ).collect(Collectors.toList());

        //Analyse if Trade is fare
        boolean ableToTrade = areItemsAbleToTrade(primaryResources, secondaryResources);

        if(!ableToTrade) {
            return false;
        }
        //Proceed Update
        List<InventoryItem> primaryInventoryItem = itemService.getItemsByNames(
                survivorItemTrade.getSecondaryItems()
        );

        List<InventoryItem> secondaryInventoryItem = itemService.getItemsByNames(
                survivorItemTrade.getSecondaryItems()
        );

        // Add Item to Primary Survivor
        // Iterate Secondary Items to be added to Primary Survivor
        secondaryResources.stream().forEach(secondaryResource -> {

            if(itemExistAtSurvivor(primarySurvivorItems, secondaryResource)) {
                // Update
                itemService.updateSurvivorResourcesQuantity(
                        survivorResourcesMapper.setUpSurvivorInventoryItem(secondaryResource, secondaryResource.getQuantity() - 1)
                );
            } else {
                // Insert
                int itemId = getItemId(secondaryInventoryItem, secondaryResource.getName());
                itemService.insertSurvivorResourcesQuantity(
                        survivorResourcesMapper.setUpSurvivorInventoryItem((int) primarySurvivorItems.getId(), secondaryResource, itemId, 1)
                );
            }
        });

        // Add Item to Primary Survivor
        // Iterate Secondary Items to be added to Primary Survivor
        primaryResources.stream().forEach(primaryResource -> {

            if(itemExistAtSurvivor(secondarySurvivorItems, primaryResource)) {
                // Update
                itemService.updateSurvivorResourcesQuantity(
                        survivorResourcesMapper.setUpSurvivorInventoryItem(primaryResource, primaryResource.getQuantity() + 1)
                );
            }
        });

        return true;
    }

    private boolean itemExistAtSurvivor(SurvivorDto survivorDto, Resources secondaryResource) {
        List<Resources> resourcesExist =
        survivorDto
                .getResources()
                .stream()
                .filter(resources -> resources.getName().equalsIgnoreCase(secondaryResource.getName()))
                .collect(Collectors.toList());

        if (resourcesExist.isEmpty()) {
            return false;
        }
        return true;
    }

    private int getItemId(List<InventoryItem> secondaryInventoryItem, String itemName) {
        return
        secondaryInventoryItem
                .stream()
                .filter(inventoryItem -> inventoryItem.getItemQualifier().equalsIgnoreCase(itemName))
                .collect(Collectors.toList())
                .get(0)
                .getId();
    }

    private boolean areItemsAbleToTrade(
            List<Resources> primaryItems,
            List<Resources> secondaryItems) {

        Integer primarySum = primaryItems.stream()
                .map(resource -> resource.getPoints())
                .reduce(0, (a, b) -> a + b);

        Integer secondarySum = secondaryItems.stream()
                .map(resource -> resource.getPoints())
                .reduce(0, (a, b) -> a + b);

        if(primarySum.intValue() == secondarySum.intValue()) {
            return true;
        }
        return false;
    }
}
