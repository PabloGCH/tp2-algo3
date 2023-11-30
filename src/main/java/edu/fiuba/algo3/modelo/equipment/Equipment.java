package edu.fiuba.algo3.modelo.equipment;

public interface Equipment {
    public Equipment upgrade();
    public int receiveAttack(int energy);
    public boolean complete();
}
