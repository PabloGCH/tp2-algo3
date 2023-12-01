package edu.fiuba.algo3.modelo.state;

import edu.fiuba.algo3.modelo.RandomResult.RandomResult;
import edu.fiuba.algo3.modelo.squares.*;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;


public class Active implements State{
    private RandomResult randomResult;

    public Active(){}

    public int move(int diceResult){
        return diceResult;
    }
    
    public State update(int energy){
        if (energy <= 0) {
            return new Tired();
        }
        return this;
    }

    public void runEffect(Effect effect, Gladiator gladiator){
        effect.affect(gladiator);
    }

    public State fracture(){
        return (new Injured());
    }
}
