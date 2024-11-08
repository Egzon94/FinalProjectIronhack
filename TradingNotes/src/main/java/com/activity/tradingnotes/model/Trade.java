package com.activity.tradingnotes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String stockSymbol;
    private int quantity;
    private double price;

    @ManyToOne // Assuming a many-to-one relationship with User
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne // Assuming a many-to-one relationship with Portfolio
    @JoinColumn(name = "portfolio_id")
    @JsonIgnore
    private Portfolio portfolio;
}
