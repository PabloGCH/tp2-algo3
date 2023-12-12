package edu.fiuba.algo3.modelo.game;

public interface GameObserver {
    public void update(String currentPlayerName, boolean playerCanPlay, int gameTurn);
}
