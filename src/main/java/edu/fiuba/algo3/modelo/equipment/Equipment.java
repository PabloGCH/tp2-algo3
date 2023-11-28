package edu.fiuba.algo3.modelo.equipment;

import edu.fiuba.algo3.modelo.energy.Energy;

public interface Equipment {
    Equipment upgrade();
    Energy receiveAttack(Energy energyPoints);
    boolean worthy();
}
