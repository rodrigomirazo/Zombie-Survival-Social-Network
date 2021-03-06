package com.backendrecruitmenttest.ZSSN.service;

import com.backendrecruitmenttest.ZSSN.dto.SurvivorDto;
import com.backendrecruitmenttest.ZSSN.entity.InventoryItem;
import com.backendrecruitmenttest.ZSSN.entity.Survivor;
import com.backendrecruitmenttest.ZSSN.entity.SurvivorInventoryItem;

import java.util.List;

public interface SurvivorService {

    /**
     * @return survivor Entity
     * @apiNote Update location
     */
    Survivor updateSurvivorLocation(int survivorId, double latitude, double longitude);

    /**
     * Add survivors
     *
     * @param survivor
     * @return
     */
    SurvivorDto add(SurvivorDto survivor);

    void infectSurvivor(int survivorId);

    List<SurvivorDto> get();

    SurvivorDto getById(Long survivorId);

    SurvivorInventoryItem insertSurvivorResource(SurvivorInventoryItem survivorInventoryItem);
}
