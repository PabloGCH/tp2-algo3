package edu.fiuba.algo3.modelo.energy;
import edu.fiuba.algo3.modelo.points.Points;

public class Energy {
    private interface EnergyCalculator {
        Energy calculate(Energy energy);
    }

    private Points points;

    public Energy calculate(EnergyCalculator calculator) {
        return this;
    }
  
    public Energy spendEnergyByWineConsumption(int cupsOfWine) {
        return this;
    }
  
    public Energy(int pointsAmount) {
        this.points = new Points(pointsAmount);
    }

    public Points getPoints() {
        return this.points;
    }
}
