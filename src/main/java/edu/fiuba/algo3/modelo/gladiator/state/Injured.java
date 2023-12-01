package edu.fiuba.algo3.modelo.gladiator.state;

import edu.fiuba.algo3.modelo.RandomResult.DiceFactory;
import edu.fiuba.algo3.modelo.RandomResult.RandomResult;
import edu.fiuba.algo3.modelo.squares.*;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;

public class Injured implements State{
    private int shift;
    private final int TURNS_TO_BE_INJURED = 1;

    public Injured(){
        this.shift = 0;
    }

    public int move(int diceResult){
        return 0;
    }

    public State update(int energy){
        if (shift == TURNS_TO_BE_INJURED) {
            return new Active();
        }
        shift++;
        return this;
    }

    public void runEffect(Effect effect, Gladiator gladiator){
        
    }

    public State fracture(){
        return this;
    }
}
