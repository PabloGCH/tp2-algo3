package edu.fiuba.algo3.modelo.game;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.Square;

import java.util.ArrayList;

public class FinishedByWinning implements GameState {
    public GameState nextTurn(ArrayList<Gladiator> gladiators, ArrayList<Square> path, int diceResult, int gladiatorTurn) {
        return this;
    }

    public boolean Finalized(){
        return true;
    }

    public boolean result(ArrayList<Gladiator> gladiators){
        System.out.println("Felicidades" + gladiators.get(0).getName() + "ganaste");
        return true;
    }

    public int turnEnded(int gladiatorTurn, ArrayList<Gladiator> gladiators){
        return gladiatorTurn;
    }
}
