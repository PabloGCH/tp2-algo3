package edu.fiuba.algo3.modelo.equipment;

import edu.fiuba.algo3.modelo.energy.Energy;

public class Armor implements Equipment{
    public Equipment Upgrade() {
        return new ShieldSword();
    }
    public Energy energyConsumptionByFight(Energy energy){
        AnimalFightWithArmor calculator = new AnimalFightWithArmor();
        return energy.calculate(calculator);
    }
}
