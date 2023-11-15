package edu.fiuba.algo3.modelo.energy;

public class Energy {
    private int points;

    public Energy add(Energy energy) {
        return new Energy(this.getPoints() + energy.getPoints());
    }

    public Energy substract(Energy energy) {
        return new Energy(this.getPoints() - energy.getPoints());
    }

    public Energy(int pointsAmount) {
        this.points = pointsAmount;
    }

    public int getPoints() {
        return this.points;
    }
}
