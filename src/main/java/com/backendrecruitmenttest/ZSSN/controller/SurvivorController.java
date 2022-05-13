package com.backendrecruitmenttest.ZSSN.controller;

import com.backendrecruitmenttest.ZSSN.component.SurvivorComponent;
import com.backendrecruitmenttest.ZSSN.entity.Survivor;
import com.backendrecruitmenttest.ZSSN.service.SurvivorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/survivor")
public class SurvivorController {

    @Autowired
    private SurvivorService survivorService;

    @Autowired
    private SurvivorComponent survivorComponent;

    @PostMapping("/populate")
    public List<Survivor> generatePopulation() {
        return survivorComponent.generatePopulation();
    }

    @PostMapping()
    @ResponseBody
    public Survivor save(@RequestBody Survivor survivor) {
        return survivorService.add(survivor);
    }

    @PutMapping("/updateLocation/{survivorId}/{latitude}/{longitude}")
    public Survivor updateLocation(
            @PathVariable int survivorId,
            @PathVariable double latitude,
            @PathVariable double longitude
    ) {
        return survivorService.updateSurvivorLocation(survivorId, latitude, longitude);
    }

    /**
     * Set survivor as infected
     * @return
     */
    @PostMapping("/infectSurvivor/{survivorId}")
    public String infectSurvivor(
            @PathVariable int survivorId
    ) {
        survivorService.infectSurvivor(survivorId);
        return "Survivor Successfully Infected";
    }

}
