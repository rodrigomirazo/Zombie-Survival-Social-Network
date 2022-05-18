package com.backendrecruitmenttest.ZSSN.mapper;

import com.backendrecruitmenttest.ZSSN.dto.SurvivorDto;
import com.backendrecruitmenttest.ZSSN.entity.Survivor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SurvivorMapper {

    @Autowired
    private SurvivorResourcesMapper survivorResourcesMapper;

    public SurvivorDto toDto(Survivor survivor) {
        SurvivorDto survivorDto = new SurvivorDto();
        survivorDto.setId(survivor.getId());
        survivorDto.setName(survivor.getName());
        survivorDto.setAge(survivor.getAge());
        survivorDto.setGender(survivor.getGender());
        survivorDto.setLatitude(survivor.getLatitude());
        survivorDto.setLongitude(survivor.getLongitude());
        survivorDto.setInfected(survivor.isInfected());

        survivorDto.setResources(
            survivorResourcesMapper.toDtoList(survivor.getInventoryItem())
        );

        return survivorDto;
    }

    public Survivor toEntity(SurvivorDto survivorDto) {

        Survivor survivor = new Survivor();
        survivor.setId(survivorDto.getId());
        survivor.setName(survivorDto.getName());
        survivor.setAge(survivorDto.getAge());
        survivor.setGender(survivorDto.getGender());
        survivor.setLatitude(survivorDto.getLatitude());
        survivor.setLongitude(survivorDto.getLongitude());
        survivor.setInfected(survivorDto.isInfected());

        survivor.setInventoryItem(
                survivorResourcesMapper.toEntityList(survivorDto.getResources(), survivor)
        );

        return survivor;
    }
}
