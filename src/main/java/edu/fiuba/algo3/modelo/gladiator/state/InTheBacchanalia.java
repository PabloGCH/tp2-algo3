package edu.fiuba.algo3.modelo.gladiator.state;

import edu.fiuba.algo3.modelo.game.TurnDecider;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.Effect;

public class InTheBacchanalia extends State {
    private final Gladiator affectedGladiator;
    private final int TIRED_GLADIATOR = 0, WAIT_TIME = 1;
    private int times = 0;
    public InTheBacchanalia(Gladiator aGladiator) {
        this.affectedGladiator = aGladiator;
    }
    @Override
    public int move(int diceResult) {
        this.affectedGladiator.drinkWine(diceResult);
        return 0;
    }
    public void runEffect(Effect effect, Gladiator gladiator) {
        if (this.times == WAIT_TIME) {
            affectedGladiator.refreshState();
        }
        this.times++;
    }
    @Override
    public State update(int energy) {
        if ((energy <= TIRED_GLADIATOR) && (this.times == WAIT_TIME)){
            System.out.println("Are you tired");
            return new Tired();
        }else if ((energy > TIRED_GLADIATOR) && (this.times == WAIT_TIME)) {
            System.out.println("You recover from drunk");
            return new Active();
        }
        return this;
    }
    @Override
    public void decideIfPlaysAgain(TurnDecider turnDecider) {
    }
    @Override
    public int updateTurn(int turn){
        return turn;
    }
    public String showState(){
        return "In The Bacchanalia";
    }
    public boolean canPlay() {
        return true;
    }
}