package edu.fiuba.algo3.modelo.gladiator.equipment;

public class Helmet implements Equipment{
    private static final int DAMAGE_HELMET = 15;
    public Equipment upgrade() {
        return new Armor();
    }

    public int receiveAttack(int energy){
        return (energy - DAMAGE_HELMET);
    }

    public boolean complete(){
        return false;
    }
}
