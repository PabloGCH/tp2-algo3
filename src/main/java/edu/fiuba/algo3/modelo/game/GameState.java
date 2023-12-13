package edu.fiuba.algo3.modelo.game;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.Square;
import java.util.ArrayList;

public interface GameState {
    GameState nextTurn(ArrayList<Gladiator> gladiators, ArrayList<Square> path, int diceResult);
    boolean Finalized();
    boolean result(ArrayList<String> gladiators);
    int turnEnded(int gladiatorTurn, ArrayList<Gladiator> gladiators);
    void entryOfTheGladiatorToTheFirstSquare(ArrayList<Gladiator> gladiators, ArrayList<Square> path);
    void updateScreen(GameEndController controller);
    GameState defeat();
}