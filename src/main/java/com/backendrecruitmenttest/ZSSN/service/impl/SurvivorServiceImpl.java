package com.backendrecruitmenttest.ZSSN.service.impl;

import com.backendrecruitmenttest.ZSSN.entity.Survivor;
import com.backendrecruitmenttest.ZSSN.repository.SurvivorRepository;
import com.backendrecruitmenttest.ZSSN.service.SurvivorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class SurvivorServiceImpl implements SurvivorService {

    @Autowired
    private SurvivorRepository survivorRepository;

    @Override
    public Survivor updateSurvivorLocation(Survivor survivor) {

        return survivorRepository.save(survivor);
    }

    @Override
    public Survivor survivorInfected(int survivorId) {
        Survivor survivor = new Survivor()
                .setId(survivorId)
                .setInfected(true);

        return survivorRepository.save(survivor);
    }

}
