package edu.fiuba.algo3.modelo.Rank;

import edu.fiuba.algo3.modelo.energy.Energy;

public interface Stage {

    public Energy energyFromExperience(Energy cantidad);

    public void ascent();

    void setRank(Rank rank);
}
