package edu.fiuba.algo3.modelo.gladiator.equipment;

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
}
