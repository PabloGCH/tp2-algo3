package edu.fiuba.algo3.modelo.game;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.Square;
import java.util.ArrayList;

public class FinishedByTurns implements GameState {
    public GameState nextTurn(ArrayList<Gladiator> gladiators, ArrayList<Square> path, int diceResult) {
        return this;
    }
    public boolean Finalized(){
        return true;
    }
    public boolean result(ArrayList<String> gladiators){
        return false;
    }
    public int turnEnded(int gladiatorTurn, ArrayList<Gladiator> gladiators){
        return gladiatorTurn;
    }
    public void entryOfTheGladiatorToTheFirstSquare(ArrayList<Gladiator> gladiators, ArrayList<Square> path){ }
    @Override
    public void updateScreen(GameEndController controller) {
        controller.showLossScreen();
    }
    public GameState defeat(){
        return this;
    }
}