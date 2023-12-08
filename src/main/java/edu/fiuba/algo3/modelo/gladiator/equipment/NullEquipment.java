package edu.fiuba.algo3.modelo.gladiator.equipment;


import edu.fiuba.algo3.modelo.gladiator.state.*;

public class NullEquipment implements Equipment {
    private static final int DAMAGE_NULL_EQUIPMENT = 20;
    public Equipment upgrade() {
        return new Helmet();
    }

    public int receiveAttack(int energy){
        return (energy - DAMAGE_NULL_EQUIPMENT);
    }

    public State win(State state) {
        return state;
    }
}
