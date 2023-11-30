package edu.fiuba.algo3.modelo.equipment;

public class NullEquipment implements Equipment {
    public Equipment upgrade() {
        return new Helmet();
    }

    public int receiveAttack(int energy){
        return (energy - 20);
    }

    public boolean complete(){
        return false;
    }
}
