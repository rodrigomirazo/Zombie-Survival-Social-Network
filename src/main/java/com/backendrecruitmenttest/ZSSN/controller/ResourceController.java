package com.backendrecruitmenttest.ZSSN.controller;

import com.backendrecruitmenttest.ZSSN.dto.SurvivorDto;
import com.backendrecruitmenttest.ZSSN.dto.SurvivorItemTradeDto;
import com.backendrecruitmenttest.ZSSN.service.TradeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "Allow survivors to register their resources trades", notes = "You probably need backup")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved")
    })
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
