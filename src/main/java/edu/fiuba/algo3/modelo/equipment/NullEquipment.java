package edu.fiuba.algo3.modelo.equipment;

import edu.fiuba.algo3.modelo.energy.Energy;

public class NullEquipment implements Equipment {

    public Equipment Upgrade() {
        return new Helmet();
    }

    public Energy energyConsumptionByFight(Energy energyPoints){
        return energyPoints;
    }
}