package edu.fiuba.algo3.modelo.points;

public class Points {
    private int amount;

    public Points(int amount) {
        this.amount = amount;
    }

    public Points addEnergyPoints(Points points) {
        return this;
    }
    
    public Points substractEnergyPoints(Points points) {
        return this;
    }

    public int getAmount() {
        return this.amount;
    }
}
