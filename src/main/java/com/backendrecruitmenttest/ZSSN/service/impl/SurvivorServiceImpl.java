package com.backendrecruitmenttest.ZSSN.service.impl;

import com.backendrecruitmenttest.ZSSN.dto.SurvivorDto;
import com.backendrecruitmenttest.ZSSN.entity.Survivor;
import com.backendrecruitmenttest.ZSSN.entity.SurvivorInventoryItem;
import com.backendrecruitmenttest.ZSSN.mapper.SurvivorMapper;
import com.backendrecruitmenttest.ZSSN.mapper.SurvivorResourcesMapper;
import com.backendrecruitmenttest.ZSSN.repository.SurvivorInventoryItemRepository;
import com.backendrecruitmenttest.ZSSN.repository.SurvivorRepository;
import com.backendrecruitmenttest.ZSSN.service.ItemService;
import com.backendrecruitmenttest.ZSSN.service.SurvivorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SurvivorServiceImpl implements SurvivorService {

    @Autowired
    private SurvivorRepository survivorRepository;

    @Autowired
    private SurvivorInventoryItemRepository survivorInventoryItemRepo;

    @Autowired
    private SurvivorMapper survivorMapper;

    @Autowired
    private SurvivorResourcesMapper survivorResourcesMapper;

    @Autowired
    private ItemService itemService;

    @Override
    public SurvivorDto add(SurvivorDto survivorDto) {

        // Add Survivor
        Survivor survivorEntity = survivorMapper.toEntity(survivorDto);
        Survivor survivorSaved = survivorRepository.save(survivorEntity);

        //mapper
        SurvivorDto survivorDto1 = getById(survivorSaved.getId());

        return survivorDto1;
    }

    @Override
    public Survivor updateSurvivorLocation(int survivorId, double latitude, double longitude) {
        Survivor survivor = new Survivor();
        survivor.setId(survivorId);
        survivor.setLatitude(latitude);
        survivor.setLongitude(longitude);

        return survivorRepository.save(survivor);
    }

    @Override
    public void infectSurvivor(int survivorId) {
        Survivor survivor = new Survivor()
                .setId(survivorId)
                .setInfected(true);

        survivorRepository.save(survivor);
    }

    @Override
    public List<SurvivorDto> get() {
        Iterable<Survivor> survivors = survivorRepository.findAll();
        List<Survivor> survivorList = (List<Survivor>) survivors;

        return survivorList
                .stream()
                .map(survivor -> survivorMapper.toDto(survivor))
                .collect(Collectors.toList());
    }

    @Override
    public SurvivorDto getById(Long survivorId) {
        Optional<Survivor> survivors = survivorRepository.findById( survivorId);
        Survivor survivorResult = survivors.get();

        return survivorMapper.toDto(survivorResult);
    }

    @Override
    public SurvivorInventoryItem insertSurvivorResource(SurvivorInventoryItem survivorInventoryItem) {
        return null;
    }

}
