package com.backendrecruitmenttest.ZSSN.controller;

import com.backendrecruitmenttest.ZSSN.dto.SurvivorDto;
import com.backendrecruitmenttest.ZSSN.dto.SurvivorItemTradeDto;
import com.backendrecruitmenttest.ZSSN.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private TradeService tradeService;

    @PutMapping("/trade")
    public String tradeItems(
            @RequestBody SurvivorItemTradeDto survivorItemTrade) {

        boolean tradeSuccessFull =
        tradeService.tradeItems(survivorItemTrade);

        if(tradeSuccessFull) {
            return "Items Trade Successfully";
        }
        return "Items were not able to be Traded";
    }

}
