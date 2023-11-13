package edu.fiuba.algo3.modelo.equipment;

import edu.fiuba.algo3.modelo.energy.Energy;

public class Key implements Equipment{
    public Equipment Upgrade() {
        return new Key();
    }

    public Energy energyConsumptionByFight(Energy energyPoints){
        return energyPoints;
    }
}
