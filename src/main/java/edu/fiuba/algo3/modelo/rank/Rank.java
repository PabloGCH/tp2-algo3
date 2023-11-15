package edu.fiuba.algo3.modelo.rank;

import edu.fiuba.algo3.modelo.energy.Energy;

public abstract class Rank {
    //attributes
    protected int shift;
    //methods

    public Energy energyFromExperience(Energy amount){

        return amount;
    }

    public Rank ascent(){
        return this;
    }

}
