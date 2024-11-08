package com.activity.tradingnotes.service;

import com.activity.tradingnotes.model.Trade;
import com.activity.tradingnotes.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeService {

    @Autowired
    private TradeRepository tradeRepository;

//    public Trade createTrade(Trade trade) {
//        return tradeRepository.save(trade); // Create a new trade
//    }
//
//    public Trade save(Trade trade) {
//        return tradeRepository.save(trade); // Save the trade
//    }

    public List<Trade> findAll() {
        return tradeRepository.findAll();
    }

    public Trade save(Trade trade) {
        return tradeRepository.save(trade);

    }
}
