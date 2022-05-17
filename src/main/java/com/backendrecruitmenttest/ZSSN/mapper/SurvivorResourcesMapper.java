package com.backendrecruitmenttest.ZSSN.mapper;

import com.backendrecruitmenttest.ZSSN.dto.Resources;
import com.backendrecruitmenttest.ZSSN.dto.SurvivorDto;
import com.backendrecruitmenttest.ZSSN.entity.InventoryItem;
import com.backendrecruitmenttest.ZSSN.entity.Survivor;
import com.backendrecruitmenttest.ZSSN.entity.SurvivorInventoryItem;
import com.backendrecruitmenttest.ZSSN.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SurvivorResourcesMapper {

    @Autowired
    private ItemService itemService;

    public SurvivorResourcesMapper() {
    }

    public List<SurvivorInventoryItem> toEntityList(List<Resources> resources, Survivor survivor) {
        List<SurvivorInventoryItem> survivorInventoryItems =
        resources.stream().map(resources1 -> toEntity(resources1, survivor)).collect(Collectors.toList());

        return survivorInventoryItems;
    }

    public List<Resources> toDtoList(List<SurvivorInventoryItem> survivorInventoryItems) {
        List<Resources> resources =
                survivorInventoryItems.stream().map(inventoryItem -> toDto(inventoryItem)).collect(Collectors.toList());

        return resources;
    }

    public SurvivorInventoryItem toEntity(Resources resources, Survivor survivor){

        SurvivorInventoryItem survivorInventoryItem = new SurvivorInventoryItem();
        survivorInventoryItem.setQuantity(resources.getQuantity());
        survivorInventoryItem.setSurvivor(survivor);
        survivorInventoryItem.setInventoryItem(new InventoryItem().setId(resources.getId()));

        return survivorInventoryItem;
    }

    public Resources toDto(SurvivorInventoryItem survivorInventoryItem) {

        Resources resources = new Resources();
        resources.setId(survivorInventoryItem.getId());
        resources.setName(survivorInventoryItem.getInventoryItem().getItemQualifier());
        resources.setPoints(survivorInventoryItem.getQuantity());
        resources.setQuantity(survivorInventoryItem.getQuantity());

        return resources;
    }
}
