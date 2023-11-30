package edu.fiuba.algo3.modelo.equipment;

public class ShieldSword implements Equipment{

    public Equipment upgrade() {
        return new Key();
    }

    public int receiveAttack(int energy){
        return (energy - 2);
    }

    public boolean complete(){
        return false;
    }
}
