package edu.fiuba.algo3.modelo.gladiator;
import edu.fiuba.algo3.modelo.equipment.Equipment;
import edu.fiuba.algo3.modelo.energy.Energy;
import edu.fiuba.algo3.modelo.rank.Rank;
import edu.fiuba.algo3.modelo.rank.Rookie;
import edu.fiuba.algo3.modelo.equipment.NullEquipment;

public class Gladiator {
    private String name;
    private Energy energy;
    private Equipment equipment;
    private Rank rank;

    public Gladiator() {

        this.energy = new Energy(0);
        this.equipment = new NullEquipment();
        this.rank = new Rookie();
    }
    
    public void move() {
        evolution();
        seniority();
    }
    
    public void drinkWine(int cupsOfWineAmount) {}

    private void evolution(){
        this.rank = this.rank.ascent();
    }

    private void seniority(){
        this.energy = this.rank.energyFromExperience(this.energy);
    }

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
    public void setInitialEnergy(Energy energy) {
        this.energy = this.energy.add(energy);
    }

}
