package edu.fiuba.algo3.modelo.equipment;

import edu.fiuba.algo3.modelo.energy.Energy;

public class Armor implements Equipment{
    public Equipment Upgrade() {
        return new ShieldSword();
    }
    public Energy receiveAttack(Energy energy){
        return energy.substract(new Energy(10));
    }
}
