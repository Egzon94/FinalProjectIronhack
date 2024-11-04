package com.activity.tradingnotes.repository;

import com.activity.tradingnotes.model.Trade;
import com.activity.tradingnotes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {
    List<Trade> findByUserUsername(String username);
    List<Trade> findByUser(User user);
    List<Trade> findByUserId(Long userId);
}
