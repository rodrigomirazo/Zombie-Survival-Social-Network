package com.backendrecruitmenttest.ZSSN.mapper;

import com.backendrecruitmenttest.ZSSN.dto.Resources;
import com.backendrecruitmenttest.ZSSN.dto.SurvivorDto;
import com.backendrecruitmenttest.ZSSN.entity.InventoryItem;
import com.backendrecruitmenttest.ZSSN.entity.Survivor;
import com.backendrecruitmenttest.ZSSN.entity.SurvivorInventoryItem;
import com.backendrecruitmenttest.ZSSN.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SurvivorResourcesMapper {

    @Autowired
    private ItemService itemService;

    private List<InventoryItem> inventoryItems;

    public SurvivorResourcesMapper() {
    }

    public List<SurvivorInventoryItem> toEntityList(List<Resources> resources, Survivor survivor) {
        inventoryItems = itemService.getAll();
        List<SurvivorInventoryItem> survivorInventoryItems =
        resources.stream().map(resources1 -> toEntity(resources1, survivor)).collect(Collectors.toList());

        return survivorInventoryItems;
    }

    public List<Resources> toDtoList(List<SurvivorInventoryItem> survivorInventoryItems) {
        inventoryItems = itemService.getAll();
        List<Resources> resources =
                survivorInventoryItems.stream().map(inventoryItem -> toDto(inventoryItem)).collect(Collectors.toList());

        return resources;
    }

    public SurvivorInventoryItem toEntity(Resources resources, Survivor survivor){

        List<InventoryItem> inventoryItemsFilter =
        inventoryItems.stream().filter(inventoryItem ->
                    inventoryItem.getItemQualifier().equalsIgnoreCase(resources.getName())
        ).collect(Collectors.toList());

        SurvivorInventoryItem survivorInventoryItem = new SurvivorInventoryItem();
        survivorInventoryItem.setQuantity(resources.getQuantity());
        survivorInventoryItem.setSurvivor(survivor);

        try {
            survivorInventoryItem.setInventoryItem(inventoryItemsFilter.get(0));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid Item");
        }


        return survivorInventoryItem;
    }

    public Resources toDto(SurvivorInventoryItem survivorInventoryItem) {

        List<InventoryItem> inventoryItemsFilter =
                inventoryItems.stream().filter(inventoryItem ->
                        inventoryItem.getItemQualifier().equalsIgnoreCase(survivorInventoryItem.getInventoryItem().getItemQualifier())
                ).collect(Collectors.toList());

        Resources resources = new Resources();
        resources.setId(survivorInventoryItem.getId());
        resources.setName(inventoryItemsFilter.get(0).getItemQualifier());
        resources.setPoints(survivorInventoryItem.getQuantity());
        resources.setQuantity(survivorInventoryItem.getQuantity());

        return resources;
    }
}
