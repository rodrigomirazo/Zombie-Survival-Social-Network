package com.backendrecruitmenttest.ZSSN.dto;

import java.util.List;

public class SurvivorItemTradeDto {
    private long primarySurvivorId;
    private List<String> primaryItems;
    private long secondarySurvivorId;
    private List<String> secondaryItems;

    public long getPrimarySurvivorId() {
        return primarySurvivorId;
    }

    public SurvivorItemTradeDto setPrimarySurvivorId(long primarySurvivorId) {
        this.primarySurvivorId = primarySurvivorId;
        return this;
    }

    public List<String> getPrimaryItems() {
        return primaryItems;
    }

    public SurvivorItemTradeDto setPrimaryItems(List<String> primaryItems) {
        this.primaryItems = primaryItems;
        return this;
    }

    public long getSecondarySurvivorId() {
        return secondarySurvivorId;
    }

    public SurvivorItemTradeDto setSecondarySurvivorId(long secondarySurvivorId) {
        this.secondarySurvivorId = secondarySurvivorId;
        return this;
    }

    public List<String> getSecondaryItems() {
        return secondaryItems;
    }

    public SurvivorItemTradeDto setSecondaryItems(List<String> secondaryItems) {
        this.secondaryItems = secondaryItems;
        return this;
    }
}
