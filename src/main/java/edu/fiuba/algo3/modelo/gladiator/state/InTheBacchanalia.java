package edu.fiuba.algo3.modelo.gladiator.state;

import edu.fiuba.algo3.modelo.game.TurnDecider;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.Bacchanalia;
import edu.fiuba.algo3.modelo.squares.Effect;

public class InTheBacchanalia extends State {
    private Gladiator affectedGladiator;
    private final int TIRED_GLADIATOR = 0;
    public InTheBacchanalia(Gladiator aGladiator) {
        this.affectedGladiator = aGladiator;
    }
    @Override
    public int move(int diceResult) {
        this.affectedGladiator.drinkWine(diceResult);
        return 0;
    }

    public void runEffect(Bacchanalia effect, Gladiator gladiator) {
        System.out.println("entro en bacchanalia");
        affectedGladiator.refreshState();
    }

    @Override
    public State update(int energy) {
        if (energy <= TIRED_GLADIATOR) {
            return new Tired();
        }
        return new Active();
    }
    @Override
    public void decideIfPlaysAgain(TurnDecider turnDecider) {
    }

    @Override
    public int updateTurn(int turn){
        return turn;
    }
}
