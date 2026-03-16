package com.csd.sports.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Player {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String position;
    private String sport; 
    private int matchesPlayed;
    private int stat1; 
    private int stat2; 

    public Player() {}

    public Player(String name, String position, String sport, int matchesPlayed, int stat1, int stat2) {
        this.name = name;
        this.position = position;
        this.sport = sport;
        this.matchesPlayed = matchesPlayed;
        this.stat1 = stat1;
        this.stat2 = stat2;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
    public String getSport() { return sport; }
    public void setSport(String sport) { this.sport = sport; }
    public int getMatchesPlayed() { return matchesPlayed; }
    public void setMatchesPlayed(int matchesPlayed) { this.matchesPlayed = matchesPlayed; }
    public int getStat1() { return stat1; }
    public void setStat1(int stat1) { this.stat1 = stat1; }
    public int getStat2() { return stat2; }
    public void setStat2(int stat2) { this.stat2 = stat2; }
}