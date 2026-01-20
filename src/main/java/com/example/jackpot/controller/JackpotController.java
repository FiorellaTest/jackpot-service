package com.example.jackpot.controller;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.jackpot.dto.JackpotResponse;
import com.example.jackpot.dto.JackpotWinResponse;
import com.example.jackpot.model.Jackpot;
import com.example.jackpot.model.JackpotWin;
import com.example.jackpot.service.JackpotService;

@RestController
@RequestMapping("/jackpot")
public class JackpotController {
	private final JackpotService service;
	
	public JackpotController(JackpotService service) {
		this.service = service;
	}
	
	//READ-ONLY: current jackpot state
	@GetMapping
	public JackpotResponse getJackpot() {
        return new JackpotResponse(
                service.getJackpot().getAmount()
        );
    }
	
	//STATE-CHANGING: win jackpot
	@PostMapping("/contribute")
    public JackpotResponse contribute(@RequestParam double amount) {
		return new JackpotResponse(
		        service.contribute(amount).getAmount()
		);
	}
	
	//STATE-CHANGING: win jackpot
	@PostMapping("/win")
    public String win() {
        double wonAmount = service.win();
        return "Jackpot won: " + wonAmount;
    }
	
	//READ-ONLY: audit history
	@GetMapping("/history")
	public List<JackpotWinResponse> history() {
		List<JackpotWin> wins = service.getHistory();
		
	    return wins.stream()
	    		.map(win -> new JackpotWinResponse(
	    				win.getAmount(),
	    				win.getTimestamp()
	    		))
	    		.toList();
	}
	
}
