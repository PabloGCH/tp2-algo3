package edu.fiuba.algo3.modelo.gladiator.equipment;

import edu.fiuba.algo3.modelo.gladiator.state.State;

public class ShieldSword implements Equipment{

    private static final int DAMAGE_SWORD = 2;
    public Equipment upgrade() {
        return new Key();
    }

    public int receiveAttack(int energy){
        return (energy - DAMAGE_SWORD);
    }

    public boolean complete(){
        return false;
    }
    public State win(State state) {
        return state;
    }
}
