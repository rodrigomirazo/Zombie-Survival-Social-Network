package com.backendrecruitmenttest.ZSSN.service.impl;

import com.backendrecruitmenttest.ZSSN.entity.InventoryItem;
import com.backendrecruitmenttest.ZSSN.repository.InventoryItemRepository;
import com.backendrecruitmenttest.ZSSN.repository.SurvivorInventoryItemRepository;
import com.backendrecruitmenttest.ZSSN.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
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
}
