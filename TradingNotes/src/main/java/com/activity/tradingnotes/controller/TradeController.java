package com.activity.tradingnotes.controller;

import com.activity.tradingnotes.model.Portfolio;
import com.activity.tradingnotes.model.Trade;
import com.activity.tradingnotes.model.User;
import com.activity.tradingnotes.repository.TradeRepository;
import com.activity.tradingnotes.repository.UserRepository;
import com.activity.tradingnotes.service.TradeService;
import com.activity.tradingnotes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/trades")
public class TradeController {

    @Autowired
    private TradeService tradeService;
    @Autowired
    TradeRepository tradeRepository;

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping()
    public ResponseEntity<Trade> createTrade(@RequestBody Trade tradeRequest, Principal principal) {
        User user = userService.findByUsername(principal.getName());

        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Portfolio portfolio = user.getPortfolios().get(0);
        if (portfolio == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }


        Trade trade = new Trade();
        trade.setStockSymbol(tradeRequest.getStockSymbol());
        trade.setQuantity(tradeRequest.getQuantity());
        trade.setPrice(tradeRequest.getPrice());
        trade.setUser(user);
        trade.setPortfolio(portfolio);


        Trade savedTrade = tradeRepository.save(trade);
        return new ResponseEntity<>(savedTrade, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Trade>> getTrades(Principal principal) {
        User user = userService.findByUsername(principal.getName());


        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        List<Trade> trades = tradeRepository.findByUser(user);
        return ResponseEntity.ok(trades);
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
