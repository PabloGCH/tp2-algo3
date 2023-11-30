package edu.fiuba.algo3.modelo.equipment;

public class Helmet implements Equipment{
    public Equipment upgrade() {
        return new Armor();
    }

    public int receiveAttack(int energy){
        return (energy - 15);
    }

    public boolean complete(){
        return false;
    }
}
