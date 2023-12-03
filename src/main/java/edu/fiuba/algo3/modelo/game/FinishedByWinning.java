package edu.fiuba.algo3.modelo.game;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.Square;

import java.util.ArrayList;

public class FinishedByWinning implements GameState {
    public GameState nextTurn(ArrayList<Gladiator> gladiators, ArrayList<Square> path, int diceResult) {
        return this;
    }

}
