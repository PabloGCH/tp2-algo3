package edu.fiuba.algo3.modelo.gladiator.equipment;


public class Armor implements Equipment{
    private static final int DAMAGE_ARMOR = 10;
    public Equipment upgrade() {
        return new ShieldSword();
    }
    public int receiveAttack(int energy){
        return (energy - DAMAGE_ARMOR);
    }
    public boolean complete(){
        return false;
    }
}
