package edu.fiuba.algo3.modelo.gladiator.state;

import edu.fiuba.algo3.modelo.game.FinishedByWinning;
import edu.fiuba.algo3.modelo.game.GameState;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.Position;

public class Winner extends State{
    @Override
    public GameState isWinner() {
        return new FinishedByWinning();
    }
    @Override
    public void tryToWin(Gladiator aGladiator, Position middlePosition) {

    }
}
