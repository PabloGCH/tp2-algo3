package edu.fiuba.algo3.modelo.gladiator.state;

import edu.fiuba.algo3.modelo.game.ActiveGame;
import edu.fiuba.algo3.modelo.game.GameState;
import edu.fiuba.algo3.modelo.game.TurnDecider;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.position.Position;
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
    public GameState isWinner(String name) {
        return new ActiveGame();
    }
    public void decideIfPlaysAgain(TurnDecider turnDecider) {
        turnDecider.finishTurn();
    }
    public void tryToWin(Gladiator aGladiator, Position middlePosition) {
        aGladiator.positionate(middlePosition);
    }
    public int updateTurn(int turn){
        turn++;
        return turn;
    }
    public String showState(){
        return "Active";
    }
    public int energyFromState(int energy){
        return energy;
    }
    public boolean canPlay() {
        return false;
    }
}