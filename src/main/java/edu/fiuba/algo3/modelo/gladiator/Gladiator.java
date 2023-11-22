package edu.fiuba.algo3.modelo.gladiator;
import edu.fiuba.algo3.modelo.equipment.Equipment;
import edu.fiuba.algo3.modelo.energy.Energy;
import edu.fiuba.algo3.modelo.rank.Rank;
import edu.fiuba.algo3.modelo.rank.Rookie;
import edu.fiuba.algo3.modelo.equipment.NullEquipment;
import edu.fiuba.algo3.modelo.state.State;
import edu.fiuba.algo3.modelo.state.Tired;

public class Gladiator {
    private String name;
    private State state;
    private Energy energy;
    private Equipment equipment;
    private Rank rank;

    public Gladiator() {

        this.energy = new Energy(0);
        this.equipment = new NullEquipment();
        this.rank = new Rookie();
        this.state = new Tired();
    }
    
    public int turn() {;
        update();
        return  state.move();
    }
    
    public void drinkWine(int cupsOfWineAmount) {
        Energy newEnergy = new Energy(cupsOfWineAmount * 4);
        this.energy = this.energy.substract(newEnergy);
    }

    private void update(){
        this.rank = this.rank.ascent();
        this.energy = this.rank.energyFromExperience(this.energy);
        this.state = this.state.update();
    }

    public void eat() {
        this.energy = this.energy.add(new Energy(15));
    }

    public void fightWithBeast() {
        this.energy = this.equipment.receiveAttack(this.energy);
    }

    public Energy getEnergy() {
        return this.energy;
    }
    public Equipment getEquipment() {
        return this.equipment;
    }
    public void setInitialEnergy(Energy energy) {
        this.energy = this.energy.add(energy);
    }

    public void upgrade(){
        this.equipment = this.equipment.upgrade();
    }

}
