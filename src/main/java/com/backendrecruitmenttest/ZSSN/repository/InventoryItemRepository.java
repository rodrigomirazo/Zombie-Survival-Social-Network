package com.backendrecruitmenttest.ZSSN.repository;

import com.backendrecruitmenttest.ZSSN.entity.InventoryItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InventoryItemRepository extends CrudRepository<InventoryItem, Integer> {

    InventoryItem getByItemQualifier(String itemQualifier);

    List<InventoryItem> getByItemQualifierIn(List<String> itemQualifiers);
}
