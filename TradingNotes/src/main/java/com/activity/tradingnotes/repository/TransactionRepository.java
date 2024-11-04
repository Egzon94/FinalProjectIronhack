package com.activity.tradingnotes.repository;

import com.activity.tradingnotes.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions, Long> {
    List<Transactions> findByPortfolioId(Long portfolioId);

}