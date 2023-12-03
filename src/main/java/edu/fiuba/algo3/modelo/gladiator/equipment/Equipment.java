package edu.fiuba.algo3.modelo.gladiator.equipment;


import edu.fiuba.algo3.modelo.gladiator.state.State;

public interface Equipment {
    public Equipment upgrade();
    public int receiveAttack(int energyPoints);
    public boolean complete();
    State win(State state);
}
