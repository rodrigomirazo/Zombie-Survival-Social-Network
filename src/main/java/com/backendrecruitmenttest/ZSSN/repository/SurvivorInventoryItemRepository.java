package com.backendrecruitmenttest.ZSSN.repository;

import com.backendrecruitmenttest.ZSSN.entity.SurvivorInventoryItem;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SurvivorInventoryItemRepository extends CrudRepository<SurvivorInventoryItem, Integer> {

    @Query("SELECT s FROM SurvivorInventoryItem s")
    List<SurvivorInventoryItem> getSurvivorInventoryItemsById();

    @Transactional
    @Modifying
    @Query("update SurvivorInventoryItem s set " +
            " s.quantity = :quantity " +
            " where s.id = :id")
    void updateSurvivorInventoryItemQuantity(
            @Param("id") int id,
            @Param("quantity") int quantity
            );

}
