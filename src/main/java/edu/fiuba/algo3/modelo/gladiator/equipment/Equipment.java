package edu.fiuba.algo3.modelo.gladiator.equipment;


public interface Equipment {
    public Equipment upgrade();
    public int receiveAttack(int energyPoints);
    public boolean complete();
}
