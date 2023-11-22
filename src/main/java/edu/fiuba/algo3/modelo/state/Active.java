package edu.fiuba.algo3.modelo.state;

import edu.fiuba.algo3.modelo.energy.Energy;

import edu.fiuba.algo3.modelo.Dice;

public class Active implements State{
    private Dice dice;

    public Active(){
        this.dice = new Dice();
    }

    public int move(){
        return this.dice.throwDice();
    }
    
    public State update(Energy energy){
        if (energy.getPoints() <= 0) {
            return new Tired();
        }
        return this;
    }
}
