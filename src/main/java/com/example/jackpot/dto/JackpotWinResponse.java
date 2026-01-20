package com.example.jackpot.dto;

import java.time.LocalDateTime;

public class JackpotWinResponse {

    private double amount;
    private LocalDateTime timestamp;

    public JackpotWinResponse(double amount, LocalDateTime timestamp) {
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
