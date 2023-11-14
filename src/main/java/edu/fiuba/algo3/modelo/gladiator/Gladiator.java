package edu.fiuba.algo3.modelo.gladiator;
import edu.fiuba.algo3.modelo.energy.Energy;
import edu.fiuba.algo3.modelo.equipment.NullEquipment;


public class Gladiator {
    private interface Equipment {}
    private Energy energy;
    private Equipment equipment;

    public Gladiator() {
        this.energy = new Energy(20);
        //this.equipment = new NullEquipment();
    }
    
    public void increaseEnergyByRank() {}
    public void drinkWine(int cupsOfWineAmount) {}
    public void eat() {}
    public void fightWithBeast() {}
    public Energy getEnergy() {
        return this.energy;
    }
    public Equipment getEquipment() {
        return this.equipment;
    }

}
