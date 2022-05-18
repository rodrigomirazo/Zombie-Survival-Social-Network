package com.backendrecruitmenttest.ZSSN.component;

import com.backendrecruitmenttest.ZSSN.entity.Survivor;
import com.backendrecruitmenttest.ZSSN.repository.SurvivorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

import static com.backendrecruitmenttest.ZSSN.component.Constants.GENDER_FEMALE;
import static com.backendrecruitmenttest.ZSSN.component.Constants.GENDER_MALE;

@Component
public class SurvivorComponent {

    @Autowired
    private SurvivorRepository survivorRepository;

    public List<Survivor> generatePopulation() {

        List<Survivor> survivors = new ArrayList<>();
        survivors.add(
                new Survivor()
                        .setName("Miguel Salas")
                        .setAge(35)
                        .setGender(GENDER_MALE)
                        .setLatitude(40.4637)
                        .setLongitude(3.7492)
                        .setInfected(false)
        );

        survivors.add(
                new Survivor()
                        .setName("Rodrigo Mirazo")
                        .setAge(30)
                        .setGender(GENDER_MALE)
                        .setLatitude(423.6345)
                        .setLongitude(102.5528)
                        .setInfected(false)
        );

        survivors.add(
                new Survivor()
                        .setName("Tania Romero")
                        .setAge(31)
                        .setGender(GENDER_FEMALE)
                        .setLatitude(423.6345)
                        .setLongitude(102.5528)
                        .setInfected(false)
        );

        survivorRepository.saveAll(survivors);

        return survivors;
    }
}
