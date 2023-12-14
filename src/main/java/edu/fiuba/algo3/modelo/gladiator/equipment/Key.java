package edu.fiuba.algo3.modelo.gladiator.equipment;

import edu.fiuba.algo3.modelo.gladiator.state.*;

public class Key implements Equipment{
    public Equipment upgrade() {
        System.out.println("maximum equipment");
        return new Key();
    }
    public int receiveAttack(int energy){
        System.out.println("does not lose energy");
        return energy;
    }
    public State win(State state) {
        return new Winner();
    }
    public String showName(){
        return ("key");
    }
}