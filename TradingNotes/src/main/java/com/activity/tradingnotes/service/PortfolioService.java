package com.activity.tradingnotes.service;

import com.activity.tradingnotes.model.Portfolio;
import com.activity.tradingnotes.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    public List<Portfolio> findAll() {
        return portfolioRepository.findAll();
    }

    public Portfolio findById(Long id) {
        return portfolioRepository.findById(id).orElse(null);
    }

    public Portfolio save(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }
}

