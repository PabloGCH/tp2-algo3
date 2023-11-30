package edu.fiuba.algo3.modelo.state;

import edu.fiuba.algo3.modelo.RandomResult.DiceFactory;
import edu.fiuba.algo3.modelo.RandomResult.RandomResult;
import edu.fiuba.algo3.modelo.squares.*;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;

public class Tired implements State{
    public int move(){
        return 0;
    }
    public State update(int energy){
        if (energy > 0) {
            var diceFactory = new DiceFactory();
            RandomResult dice = diceFactory.createRandomGenerator();
            return new Active(dice);
        }
        return this;
    }

    public void runEffect(Effect effect, Gladiator gladiator){

    }

    public State fracture(){
        return (new Injured());
    }
}
