package edu.fiuba.algo3.modelo.gladiator.equipment;

import edu.fiuba.algo3.modelo.gladiator.state.*;

public class NullEquipment implements Equipment {
    private static final int DAMAGE_NULL_EQUIPMENT = 20;
    public Equipment upgrade() {
        System.out.println("your equipment has evolved to Helmet");
        return new Helmet();
    }
    public int receiveAttack(int energy){
        System.out.println("lose " + DAMAGE_NULL_EQUIPMENT + " energy points");
        return (energy - DAMAGE_NULL_EQUIPMENT);
    }
    public State win(State state) {
        return state;
    }
    public String showName(){
        return ("Without equipment");
    }
}