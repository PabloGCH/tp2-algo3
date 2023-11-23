package edu.fiuba.algo3.modelo.state;

import edu.fiuba.algo3.modelo.energy.Energy;

public class Injured implements State{
    private int shift;
    private final int TURNS_TO_BE_INJURED = 1;

    public Injured(){
        this.shift = 0;
    }

    public int move(){
        return 0;
    }

    public State update(Energy energy){
        if (shift == TURNS_TO_BE_INJURED ) {
            return new Active();
        }
        shift++;
        return this;
    }
}
