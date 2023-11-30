package edu.fiuba.algo3.modelo.state;

import edu.fiuba.algo3.modelo.RandomResult.RandomResult;
import edu.fiuba.algo3.modelo.energy.Energy;
import edu.fiuba.algo3.modelo.squares.*;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;


public class Active implements State{
    private RandomResult randomResult;

    public Active(RandomResult newRandomResult){
        this.randomResult = newRandomResult;
    }

    public int move(){
        return this.randomResult.throwNumber();
    }
    
    public State update(Energy energy){
        if (energy.getPoints() <= 0) {
            return new Tired();
        }
        return this;
    }

    public void runEffect(Effect effect, Gladiator gladiator){
        effect.affect(gladiator);
    }
}
