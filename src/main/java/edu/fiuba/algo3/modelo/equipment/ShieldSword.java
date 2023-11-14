package edu.fiuba.algo3.modelo.equipment;

import edu.fiuba.algo3.modelo.energy.Energy;

public class ShieldSword implements Equipment{

    public Equipment Upgrade() {
        return new Key();
    }

    public Energy energyConsumptionByFight(Energy energyPoints){
        AnimalFightWithSwordShield calculator = new AnimalFightWithSwordShield();
        return energy.calculate(calculator);
    }
}
