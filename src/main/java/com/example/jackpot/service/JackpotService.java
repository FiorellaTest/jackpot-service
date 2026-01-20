package com.example.jackpot.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.jackpot.model.Jackpot;
import com.example.jackpot.model.JackpotWin;
import com.example.jackpot.repository.JackpotRepository;
import com.example.jackpot.repository.JackpotWinRepository;

@Service
public class JackpotService {
	
	private final JackpotRepository repository;
	private final JackpotWinRepository winRepository;
	
	public JackpotService (JackpotRepository repository,
			JackpotWinRepository winRepository) {
		this.repository = repository;
		this.winRepository = winRepository;
	}
	
	public Jackpot getJackpot() {
        return repository.findAll()
                .stream()
                .findFirst()
                .orElseGet(() -> repository.save(new Jackpot(0)));
    }
	
	@Transactional
	public Jackpot contribute(double amount) {
		if(amount <= 0) {
			throw new IllegalArgumentException("Amount must be positive");
		}
		
		Jackpot jackpot = getJackpot();
		jackpot.setAmount(jackpot.getAmount() + amount);
		return repository.save(jackpot);
	}
	
	@Transactional
	public double win() {
		Jackpot jackpot = getJackpot();
		
		if (jackpot.getAmount() <= 0) {
	        throw new IllegalStateException("Jackpot is empty");
	    }
		
		double wonAmount = jackpot.getAmount();
		
		winRepository.save(new JackpotWin(wonAmount));
		
		jackpot.setAmount(0);
		repository.save(jackpot);
		
		return wonAmount;
	}
	
	public List<JackpotWin> getHistory() {
	    return winRepository.findAll();
	}

}
