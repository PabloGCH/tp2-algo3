package edu.fiuba.algo3.modelo.state;

import edu.fiuba.algo3.modelo.energy.Energy;

public class Tired implements State{
    public int move(){
        return 0;
    }
    public State update(Energy energy){
        if(energy.getPoints() > 0) {
            return new Active();
        }
        return this;
    }
}
