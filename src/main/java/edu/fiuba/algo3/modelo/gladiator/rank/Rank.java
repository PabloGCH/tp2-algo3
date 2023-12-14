package edu.fiuba.algo3.modelo.gladiator.rank;

public interface Rank {
    int energyFromExperience(int amount);
    Rank ascent();
    String showRank();
}