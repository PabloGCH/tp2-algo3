package edu.fiuba.algo3.modelo.gladiator.state;

import edu.fiuba.algo3.modelo.squares.*;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;

public class Tired extends State{
    @Override
    public State update(int energy){
        if (energy > 0) {
            return new Active();
        }
        return this;
    }

    public String showState(){
        String state = "Tired";
        return state;
    }
}
