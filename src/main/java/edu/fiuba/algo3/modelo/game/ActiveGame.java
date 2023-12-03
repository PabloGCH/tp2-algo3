package edu.fiuba.algo3.modelo.game;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.Square;

import java.util.ArrayList;

public class ActiveGame implements GameState {
    private final int NEXT_GLADIATOR_TO_PLAY = 0;
    public GameState nextTurn(ArrayList<Gladiator> gladiators, ArrayList<Square> path, int diceResult) {
        Gladiator currentGladiator = gladiators.get(NEXT_GLADIATOR_TO_PLAY);
        int gladiatorPosition = currentGladiator.move(path.size(), diceResult);
        Square currentSquare = path.get(gladiatorPosition);
        currentSquare.affect(currentGladiator);
        currentGladiator.decideIfPlaysAgain(new TurnDecider(gladiators));
        return currentGladiator.won();
    };

    public boolean Finalized(){
        return false;
    }

    public boolean result(ArrayList<Gladiator> gladiators){
        System.out.println("Todos Perdieron");
        System.out.println("Mejor suerte la proxima");
        return false;
    }
}
