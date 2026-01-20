package com.example.jackpot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Jackpot {

    @Id
    @GeneratedValue
    private Long id;

    private double amount;

    public Jackpot() {}

    public Jackpot(double amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
