package com.backendrecruitmenttest.ZSSN.service.impl;

import com.backendrecruitmenttest.ZSSN.entity.InventoryItem;
import com.backendrecruitmenttest.ZSSN.entity.SurvivorInventoryItem;
import com.backendrecruitmenttest.ZSSN.repository.InventoryItemRepository;
import com.backendrecruitmenttest.ZSSN.repository.SurvivorInventoryItemRepository;
import com.backendrecruitmenttest.ZSSN.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private SurvivorInventoryItemRepository survivorInventoryItemRepo;

    @Autowired
    private InventoryItemRepository inventoryItemRepository;

    public List<InventoryItem> getAll() {

        List<InventoryItem> inventoryItems =
                (List<InventoryItem>) inventoryItemRepository.findAll();

        return inventoryItems;
    }

    @Override
    public List<InventoryItem> getItems(List<Integer> itemIds) {
        List<InventoryItem> inventoryItems =
                (List<InventoryItem>) inventoryItemRepository.findAllById(itemIds);

        return inventoryItems;
    }

    @Override
    public InventoryItem getItemsByName(String itemName) {
        InventoryItem inventoryItems = inventoryItemRepository.getByItemQualifier(itemName);
        return inventoryItems;
    }

    @Override
    public List<InventoryItem> getItemsByNames(List<String> itemName) {
        List<InventoryItem> inventoryItems = inventoryItemRepository.getByItemQualifierIn(itemName);
        return inventoryItems;
    }

    @Override
    public List<SurvivorInventoryItem> getSurvivorInventoryItems(List<Integer> survItemIds) {
        return
                (List<SurvivorInventoryItem>) survivorInventoryItemRepo.findAllById(survItemIds);
    }

    @Override
    public SurvivorInventoryItem updateSurvivorResourcesQuantity(SurvivorInventoryItem survivorInventoryItem) {

        //SurvivorInventoryItem inventoryItem =
        survivorInventoryItemRepo.updateSurvivorInventoryItemQuantity(
                survivorInventoryItem.getId(),
                survivorInventoryItem.getQuantity()
                );

        return null;
    }

}
