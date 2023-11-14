package edu.fiuba.algo3.modelo.gladiator;
import edu.fiuba.algo3.modelo.points.Points;
import edu.fiuba.algo3.modelo.rank.Rank;

public class Gladiator {
    private interface EnergyCalculator {
        Energy calculate(Energy energy);
    }

    private interface Energy {
        Energy calculate(EnergyCalculator calculator);
        Energy spendEnergyByWineConsumption(int cupsOfWine);
    }

    private Energy energy;

    private Rank rank;

    public Gladiator() {
        this.rank = new Rank();
    }
    
    public void move() {
        
    }

    public void increaseEnergyByRank() {}
    public void drinkWine(int cupsOfWineAmount) {}

    public void eat() {
        Points point = new Points(15);
        Energy newEnergy = new Energy(point);

        this.energy.calculate(newEnergy);
    }

    public void Evolution(){
        rank.ascent();
    }

    public void fightWithBeast() {}
}
