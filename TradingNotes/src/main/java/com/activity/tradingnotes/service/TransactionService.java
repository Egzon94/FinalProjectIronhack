package com.activity.tradingnotes.service;

import com.activity.tradingnotes.model.Transactions;
import com.activity.tradingnotes.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transactions> findAll() {
        return transactionRepository.findAll();
    }

    public Transactions findById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    public Transactions save(Transactions transaction) {
        return transactionRepository.save(transaction);
    }
}
