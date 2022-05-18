package com.backendrecruitmenttest.ZSSN.service;

import com.backendrecruitmenttest.ZSSN.dto.SurvivorDto;
import com.backendrecruitmenttest.ZSSN.dto.SurvivorItemTradeDto;
import org.springframework.web.bind.annotation.RequestBody;

public interface TradeService {

    boolean tradeItems(SurvivorItemTradeDto survivorItemTradeDto);
}
