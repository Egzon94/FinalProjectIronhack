package com.activity.tradingnotes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TradeRequest {
    private String stockSymbol;
    private int quantity;
    private double price;
    private Long userId;
}