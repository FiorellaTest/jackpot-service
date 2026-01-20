package com.example.jackpot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.jackpot.model.JackpotWin;

public interface JackpotWinRepository extends JpaRepository<JackpotWin, Long> {
	
}
