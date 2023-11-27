package edu.fiuba.algo3.modelo.equipment;

import edu.fiuba.algo3.modelo.energy.Energy;

public interface Equipment {
    public Equipment upgrade();
    public Energy receiveAttack(Energy energyPoints);
    public boolean complete();
}
