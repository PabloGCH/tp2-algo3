package edu.fiuba.algo3.modelo.energy;

public class Energy {
    private Points points;

    Energy(Points points) {
        this.points = points;
    }

    private interface EnergyCalculator {
        Energy calculate(Energy energy);
    }
    private interface Points {}

    public Energy calculate(EnergyCalculator calculator) {
        return this;
    }
    public Energy spendEnergyByWineConsumption(int cupsOfWine) {
        return this;
    }

}
