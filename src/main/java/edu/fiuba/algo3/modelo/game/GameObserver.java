package edu.fiuba.algo3.modelo.game;

public interface GameObserver {
    void update(String currentPlayerName, boolean playerCanPlay, int gameTurn);
}