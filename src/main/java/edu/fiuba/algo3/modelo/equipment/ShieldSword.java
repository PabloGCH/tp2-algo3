package edu.fiuba.algo3.modelo.equipment;

import edu.fiuba.algo3.modelo.energy.Energy;

public class ShieldSword implements Equipment{

    public Equipment Upgrade() {
        return new Key();
    }

    public Energy receiveAttack(Energy energy){
        return energy.substract(new Energy(2));
    }
}
