package edu.fiuba.algo3.modelo.state;

import edu.fiuba.algo3.modelo.energy.Energy;

public class Active implements State{
    public int move(){
        return 1;
    }
    public State update(Energy energy){
        return this;
    }
}
