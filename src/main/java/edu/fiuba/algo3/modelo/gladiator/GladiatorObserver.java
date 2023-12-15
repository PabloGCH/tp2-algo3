package edu.fiuba.algo3.modelo.gladiator;

public interface GladiatorObserver {
    void update(int row, int column, int energy, String equipment, String name, String rank, String state);
}