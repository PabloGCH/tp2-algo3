package edu.fiuba.algo3.modelo.energy;

public class Energy {
    private interface EnergyCalculator {
        Energy calculate(Energy energy);
    }
    private interface Points {}
    private Points points;
    public Energy calculate(EnergyCalculator calculator) {
        return this;
    }
    public Energy spendEnergyByWineConsumption(int cupsOfWine) {
        return this;
    }
    Energy(Points points) {
        this.points = points;
    }
}
