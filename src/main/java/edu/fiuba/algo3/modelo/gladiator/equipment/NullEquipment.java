package edu.fiuba.algo3.modelo.gladiator.equipment;


public class NullEquipment implements Equipment {
    private static final int DAMAGE_NULL_EQUIPMENT = 20;
    public Equipment upgrade() {
        return new Helmet();
    }

    public int receiveAttack(int energy){
        return (energy - DAMAGE_NULL_EQUIPMENT);
    }

    public boolean complete(){
        return false;
    }
}
