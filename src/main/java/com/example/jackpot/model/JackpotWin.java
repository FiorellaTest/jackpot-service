package com.example.jackpot.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
public class JackpotWin {

    @Id
    @GeneratedValue
    private Long id;

    private double amount;

    private LocalDateTime timestamp;

    public JackpotWin() {}

    public JackpotWin(double amount) {
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
