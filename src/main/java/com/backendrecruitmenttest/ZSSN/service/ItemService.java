package com.backendrecruitmenttest.ZSSN.service;

import com.backendrecruitmenttest.ZSSN.entity.InventoryItem;
import com.backendrecruitmenttest.ZSSN.entity.SurvivorInventoryItem;

import java.util.List;

public interface ItemService {

    List<InventoryItem> getAll();

    List<InventoryItem> getItems(List<Integer> itemIds);

    InventoryItem getItemsByName(String itemName);

    public List<InventoryItem> getItemsByNames(List<String> itemName);

    List<SurvivorInventoryItem> getSurvivorInventoryItems(List<Integer> survItemIds);

    SurvivorInventoryItem updateSurvivorResourcesQuantity(SurvivorInventoryItem survivorInventoryItem);

    SurvivorInventoryItem insertSurvivorResourcesQuantity(SurvivorInventoryItem survivorInventoryItem);
}
