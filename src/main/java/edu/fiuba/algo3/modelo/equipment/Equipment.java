package edu.fiuba.algo3.modelo.equipment;

import edu.fiuba.algo3.modelo.energy.Energy;

public interface Equipment {
    Equipment Upgrade();
    Energy energyConsumptionByFight(Energy energyPoints);
}
