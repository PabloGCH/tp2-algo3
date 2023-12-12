package edu.fiuba.algo3.modelo.game;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.Square;

import java.util.ArrayList;

public class FinishedByWinning implements GameState {
    private String winner;
    public FinishedByWinning(String name) {
        this.winner = name;
    }
    public GameState nextTurn(ArrayList<Gladiator> gladiators, ArrayList<Square> path, int diceResult) {
        this.winner = gladiators.get(0).getName();
        return this;
    }

    public boolean Finalized(){
        return true;
    }

    public boolean result(ArrayList<Gladiator> gladiators){
        this.winner = gladiators.get(0).getName();
        return true;
    }

    public int turnEnded(int gladiatorTurn, ArrayList<Gladiator> gladiators){
        return gladiatorTurn;
    }

    public void entryOfTheGladiatorToTheFirstSquare(ArrayList<Gladiator> gladiators, ArrayList<Square> path){
    }

    @Override
    public void updateScreen(GameEndController controller) {
        controller.showVictoryScreen(winner);
    }
}
