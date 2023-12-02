package edu.fiuba.algo3.modelo.gladiator.state;

import edu.fiuba.algo3.modelo.squares.*;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;


public class Active implements State{

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
