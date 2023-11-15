package edu.fiuba.algo3.modelo.rank;

import edu.fiuba.algo3.modelo.energy.Energy;

public interface Rank {
    //attributes
    
    //methods

    public Energy energyFromExperience(Energy amount);

    public Rank ascent();

}
