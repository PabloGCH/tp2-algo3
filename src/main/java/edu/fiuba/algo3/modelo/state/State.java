package edu.fiuba.algo3.modelo.state;

import edu.fiuba.algo3.modelo.energy.Energy;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;

import edu.fiuba.algo3.modelo.squares.*;

public interface State {
    public int move(int diceResult);

    public State update(Energy energy);

    public void runEffect(Effect effect, Gladiator gladiator);
}
