package edu.fiuba.algo3.modelo.rank;

import edu.fiuba.algo3.modelo.energy.Energy;

public interface Stage {

    public Energy energyFromExperience(Energy cantidad);

    public void ascent();

    void setRank(Rank rank);
}
