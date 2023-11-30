package edu.fiuba.algo3.modelo.equipment;

public class Armor implements Equipment{
    public Equipment upgrade() {
        return new ShieldSword();
    }
    public int receiveAttack(int energy){
        return (energy - 10);
    }
    public boolean complete(){
        return false;
    }
}
