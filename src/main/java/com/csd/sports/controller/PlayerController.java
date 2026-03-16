package com.csd.sports.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csd.sports.model.Player;
import com.csd.sports.repository.PlayerRepository;

@RestController
@RequestMapping("/api/team")
@CrossOrigin(origins = "*") // Allows the frontend to communicate with the backend
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    // 1. Display Team
    @GetMapping
    public List<Player> getTeam() {
        return playerRepository.findAll();
    }

    // 2. Add Players
    @PostMapping("/add")
    public Player addPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }

    // 3. Update Player Stats
    @PutMapping("/update/{id}")
    public Player updateStats(@PathVariable Long id, @RequestBody Player updatedStats) {
        return playerRepository.findById(id)
                .map(player -> {
                    player.setMatchesPlayed(updatedStats.getMatchesPlayed());
                    player.setStat1(updatedStats.getStat1());
                    player.setStat2(updatedStats.getStat2());
                    return playerRepository.save(player);
                })
                .orElseGet(() -> {
                    updatedStats.setId(id);
                    return playerRepository.save(updatedStats);
                });
    }
    
    @DeleteMapping("/delete/{id}")
    public void deletePlayer(@PathVariable Long id) {
        playerRepository.deleteById(id);
    }
}