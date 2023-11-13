package edu.fiuba.algo3.modelo.equipment;

import edu.fiuba.algo3.modelo.energy.Energy;
public class Helmet implements Equipment{
    public Equipment Upgrade() {
        return new Armor();
    }

    public Energy energyConsumptionByFight(Energy energyPoints){
        return energyPoints;
    }
}
