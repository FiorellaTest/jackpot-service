package com.example.jackpot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.jackpot.model.Jackpot;

public interface JackpotRepository extends JpaRepository<Jackpot, Long> {

}
