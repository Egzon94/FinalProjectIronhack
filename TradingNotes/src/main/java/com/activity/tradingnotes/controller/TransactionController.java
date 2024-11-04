package com.activity.tradingnotes.controller;

import com.activity.tradingnotes.model.Transactions;
import com.activity.tradingnotes.repository.TransactionRepository;
import com.activity.tradingnotes.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    TransactionRepository transactionRepository;
    @GetMapping
    public ResponseEntity<List<Transactions>> getAllTransactions() {
        List<Transactions> transactions = transactionService.findAll();
        return ResponseEntity.ok(transactions);
    }
    @GetMapping("/transactions")
    public ResponseEntity<List<Transactions>> getTransactionsByPortfolioId(@RequestParam Long portfolioId) {
        System.out.println("Searching for transactions for portfolio ID: " + portfolioId);
        List<Transactions> transactions = transactionRepository.findByPortfolioId(portfolioId);

        if (transactions.isEmpty()) {
            System.out.println("No transactions found for portfolio ID: " + portfolioId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        System.out.println("Transactions found: " + transactions);
        return ResponseEntity.ok(transactions);
    }



    @PostMapping
    public ResponseEntity<Transactions> createTransaction(@RequestBody Transactions transaction) {
        Transactions savedTransaction = transactionService.save(transaction);
        return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
    }

}
