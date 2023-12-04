package edu.fiuba.algo3.modelo.gladiator.state;

import edu.fiuba.algo3.modelo.game.ActiveGame;
import edu.fiuba.algo3.modelo.game.FinishedByWinning;
import edu.fiuba.algo3.modelo.game.GameState;
import edu.fiuba.algo3.modelo.game.TurnDecider;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;

import edu.fiuba.algo3.modelo.squares.*;

public abstract class State {
    public int move(int diceResult){
        return 0;
    }

    public State update(int energy){
        return this;
    }
    public void runEffect(Effect effect, Gladiator gladiator){}

    public State fracture(){
        return this;
    }
    public State getIntoBacchanalia(Gladiator aGladiator){
        return this;
    }
    public GameState isWinner() {
        return new FinishedByWinning();
    }

    public void decideIfPlaysAgain(TurnDecider turnDecider) {
    }

    public void tryToWin(Gladiator aGladiator, Position middlePosition) {
        aGladiator.positionate(middlePosition);
    }
}