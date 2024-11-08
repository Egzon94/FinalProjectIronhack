package com.activity.tradingnotes.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String transactionType;

    private double amount;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "trade_id")
    private Trade trade;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user;


}


