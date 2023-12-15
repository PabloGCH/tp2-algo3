package edu.fiuba.algo3.modelo.gladiator.equipment;

import edu.fiuba.algo3.modelo.gladiator.state.*;

public class ShieldSword implements Equipment{
    private static final int DAMAGE_SWORD = 2;
    public Equipment upgrade() {
        System.out.println("your equipment has evolved to Key");
        return new Key();
    }
    public int receiveAttack(int energy){
        System.out.println("lose " + DAMAGE_SWORD + " energy points");
        return (energy - DAMAGE_SWORD);
    }
    public State win(State state) {
        return state;
    }
    public String showName(){
        return ("shield-and-sword");
    }
}