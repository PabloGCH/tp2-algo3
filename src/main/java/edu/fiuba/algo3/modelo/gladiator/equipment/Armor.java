package edu.fiuba.algo3.modelo.gladiator.equipment;

import edu.fiuba.algo3.modelo.gladiator.state.*;

public class Armor implements Equipment{
    private static final int DAMAGE_ARMOR = 10;
    public Equipment upgrade() {
        System.out.println("your equipment has evolved to Shield and Sword");
        return new ShieldSword();
    }
    public int receiveAttack(int energy){
        System.out.println("lose " + DAMAGE_ARMOR + " energy points");
        return (energy - DAMAGE_ARMOR);
    }
    public State win(State state) {
        return state;
    }
    public String showName(){
        return ("armor");
    }
}