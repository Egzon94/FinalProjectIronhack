package com.activity.tradingnotes.controller;

import com.activity.tradingnotes.model.Portfolio;
import com.activity.tradingnotes.model.Trade;
import com.activity.tradingnotes.model.User;
import com.activity.tradingnotes.repository.TradeRepository;
import com.activity.tradingnotes.repository.UserRepository;
import com.activity.tradingnotes.service.TradeService;
import com.activity.tradingnotes.service.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;




@RestController
@RequestMapping("/api/trades")
public class TradeController {

    @Getter
    @Autowired
    private TradeService tradeService;


    @Autowired
    TradeRepository tradeRepository;

    @Autowired
    private UserService userService;
//    @Autowired
//    private UserRepository userRepository;

//    private Trade trade;

@PostMapping
public ResponseEntity<Trade> createTrade(@RequestBody Trade trade) {
    Trade savedTrade = tradeService.save(trade);
    return new ResponseEntity<>(savedTrade, HttpStatus.CREATED);

}



    @GetMapping
    public ResponseEntity<List<Trade>> getAllTrades() {
    List<Trade> trades = tradeService.findAll();
    return new ResponseEntity<>(trades, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Trade>> getTradesByUserId(@PathVariable Long userId) {
        List<Trade> trades = tradeRepository.findByUserId(userId);

        if (trades.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(trades);
    }

}

