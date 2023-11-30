package edu.fiuba.algo3.modelo.equipment;

public class Key implements Equipment{
    public Equipment upgrade() {
        return new Key();
    }

    public int receiveAttack(int energy){
        return energy;
    }

    public boolean complete(){
        return true;
    }
}
