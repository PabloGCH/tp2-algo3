package edu.fiuba.algo3.modelo.gladiator;
import edu.fiuba.algo3.modelo.energy.Energy;

import edu.fiuba.algo3.modelo.equipment.Equipment;
import edu.fiuba.algo3.modelo.equipment.NullEquipment;



public class Gladiator {
    private Energy energy;
    private Equipment equipment;

    public Gladiator() {
        this.energy = new Energy(0);
        this.equipment = new NullEquipment();
    }
    
    public void increaseEnergyByRank() {}
    public void drinkWine(int cupsOfWineAmount) {}
    public void eat() {
        this.energy = this.energy.add(new Energy(15));
    }
    public void fightWithBeast() {}
    public Energy getEnergy() {
        return this.energy;
    }
    public Equipment getEquipment() {
        return this.equipment;
    }

}
