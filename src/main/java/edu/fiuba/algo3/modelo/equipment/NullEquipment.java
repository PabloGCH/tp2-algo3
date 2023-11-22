package edu.fiuba.algo3.modelo.equipment;

import edu.fiuba.algo3.modelo.energy.Energy;

public class NullEquipment implements Equipment {

    public Equipment upgrade() {
        return new Helmet();
    }

    public Energy receiveAttack(Energy energy){
        return energy.substract(new Energy(20));
    }
}
