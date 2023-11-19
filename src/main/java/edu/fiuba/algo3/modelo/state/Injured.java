package edu.fiuba.algo3.modelo.state;

import edu.fiuba.algo3.modelo.energy.Energy;

public class Injured implements State{
    public int move(){
        return 0;
    }

    public State update(Energy energy){
        return new Active();
    }
}
