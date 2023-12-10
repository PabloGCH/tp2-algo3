package edu.fiuba.algo3.modelo.gladiator.state;

import edu.fiuba.algo3.modelo.squares.*;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;

public class Injured extends State{
    private int shift;
    private final int TURNS_TO_BE_INJURED = 1;

    public Injured(){
        this.shift = 0;
    }
    @Override
    public State update(int energy){
        if (shift == TURNS_TO_BE_INJURED) {
            return new Active();
        }
        shift++;
        return this;
    }

    public String showState(){
        String state = "Injured";
        return state;
    }
}
