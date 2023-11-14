package edu.fiuba.algo3.modelo.gladiator;

public class Gladiator {
    private interface EnergyCalculator {
        Energy calculate(Energy energy);
    }

    private interface Energy {
        Energy calculate(EnergyCalculator calculator);
        Energy spendEnergyByWineConsumption(int cupsOfWine);
    }

    private Energy energy;

    public Gladiator() {

    }
    
    public void increaseEnergyByRank() {}
    public void drinkWine(int cupsOfWineAmount) {}
    public void eat() {}
    public void fightWithBeast() {}
}
