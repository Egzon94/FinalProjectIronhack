package com.activity.tradingnotes.service;

import com.activity.tradingnotes.model.Trade;
import com.activity.tradingnotes.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TradeService {

    @Autowired
    private TradeRepository tradeRepository;

    public Trade createTrade(Trade trade) {
        return tradeRepository.save(trade);
    }
}
