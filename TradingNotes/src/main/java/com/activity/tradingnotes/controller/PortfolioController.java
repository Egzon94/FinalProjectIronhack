package com.activity.tradingnotes.controller;

import com.activity.tradingnotes.model.Portfolio;
import com.activity.tradingnotes.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolios")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @GetMapping
    public ResponseEntity<List<Portfolio>> getAllPortfolios() {
        List<Portfolio> portfolios = portfolioService.findAll();
        return ResponseEntity.ok(portfolios);
    }

    @PostMapping
    public ResponseEntity<Portfolio> createPortfolio(@RequestBody Portfolio portfolio) {
        Portfolio savedPortfolio = portfolioService.save(portfolio);
        return new ResponseEntity<>(savedPortfolio, HttpStatus.CREATED);
    }

}

